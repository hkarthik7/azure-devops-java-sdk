import itertools
from venv import create
from bs4 import BeautifulSoup
import requests
import json
import os


class ScrapeVsTsDocument(object):
    '''
    Helper class to scrape the Azure DevOps API document and create definition files.
    Edit the settings.json file in the root folder and update the value for url.
    The script will automatically create the definitions files from the result.
    This is not a replaceable solution of any kind, please verify and edit the
    definition files before working on the project. This is to help the developer(s)
    and contributor(s) of azure-devops-java-sdk project to speed up working on
    adding the functionality.
    '''
    __id__ = 'definitions'
    __comment__ = 'uri-parameters'

    def __init__(self, url: str) -> None:
        self._url = url

    @property
    def get_response(self):
        return requests.get(self._url)

    @property
    def get_page_content(self) -> str:
        return requests.get(self._url).text

    @property
    def _soup_object(self) -> BeautifulSoup:
        return BeautifulSoup(self.get_page_content, 'html.parser')

    def get_definitions(self, soup: BeautifulSoup) -> dict:
        result: dict = {}
        types_to_create: dict = {}

        # Get main definition
        root = soup.find(id=self.__id__)
        # Get the types to be created
        definitions = soup.find('table', class_='nameValue')

        if definitions is not None:

            for p in itertools.zip_longest(definitions.find_all('a'), definitions.find_all('p')):
                if p[0] is None:
                    key = 'None'
                else:
                    key = p[0].get_text()
                if p[1] is None:
                    value = 'None'
                else:
                    value = p[1].get_text()

                types_to_create[key] = value

            result[root.get_text()] = types_to_create

            return result

    def get_comments(self, soup: BeautifulSoup) -> dict:
        result: dict = {}
        types_to_create: dict = {}

        # Get main definition
        root = soup.find(id=self.__comment__)
        # Get the types to be created
        definitions = soup.find('table', class_='parameters')

        if definitions is not None:

            for p in itertools.zip_longest(definitions.find_all('div'), definitions.find_all('p')):
                if p[0] is None:
                    key = 'None'
                else:
                    key = p[0].get_text()
                if p[1] is None:
                    value = 'None'
                else:
                    value = p[1].get_text()

                types_to_create[key] = value

            result[root.get_text()] = types_to_create

        return result

    def get_index(self, value: str):
        return self.get_page_content.find(value)

# #########################################
#           SCRIPT EXECUTION BLOCK        #
# #########################################


def read(fname):
    with open(os.path.join(os.path.dirname(__file__), fname)) as f:
        return f.read()


def capitalize(word: str):
    w = ''
    for i, e in enumerate(word):
        if i == 0:
            w += word[i].title()
        else:
            w += word[i]
    return w


def create_getter(name: str, type_value: str):
    val = f"public {capitalize(type_value)} get{capitalize(name)}() {{ return {name}; }}"
    return val


def create_setter(name: str, type_value: str):
    val = f"public void set{capitalize(name)}({capitalize(type_value)} {name}) {{ this.{name} = {name}; }}"
    return val


_url: str = json.loads(read('settings.json'))['url']
package_name = f'package org.azd.{_url.split("/")[-3]}.types;'
notes = '''
/**
----------------------------------------------------------
    GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/
'''
import_statements = '''
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
'''

sub_type_collector = []
d_value = {}

prev = 0
last_val = 0

scrape = ScrapeVsTsDocument(_url)
response = scrape.get_response

value_result = scrape.get_definitions(scrape._soup_object)
comments = scrape.get_comments(scrape._soup_object)['URI Parameters']


if value_result is not None:

    for definition in value_result['Definitions']:
        if definition == list(value_result['Definitions'])[-1]:
            last_val = scrape.get_index(
                str(scrape._soup_object.find(id=definition.lower())))
        current_val = scrape.get_index(
            str(scrape._soup_object.find(id=definition.lower())))

        if current_val == last_val:
            sub_type_collector.append(f"{last_val}:")
        if prev != 0:
            sub_type_collector.append(f"{prev}:{current_val}")

        prev = current_val

    for sub_set in sub_type_collector:
        sub_type = sub_set.split(':')
        if sub_type[1] == '':
            def_value = response.text[int(sub_type[0]):]
        else:
            def_value = response.text[int(sub_type[0]):int(sub_type[1])]
        s = BeautifulSoup(def_value, 'html.parser')

        table = s.find_all('table', {'class': 'parameters definitions'})
        type_name = s.find('h3').get_text()

        sub_types_array = []
        for t in table:
            th = t.find_all('th')
            for row in t.find_all('tr'):
                td = row.find_all('td')
                if (len(td) != 0):
                    temp = {
                        th[0].get_text().strip(): td[0].get_text().strip(),
                        th[1].get_text().strip(): td[1].get_text().strip(),
                        th[2].get_text().strip(): td[2].get_text().strip()
                    }
                    sub_types_array.append(temp)
                    d_value[type_name] = sub_types_array

    value_result['SubDefinitions'] = d_value

    for key in value_result['SubDefinitions'].keys():
        try:
            if not os.path.isdir("types"):
                os.mkdir("types")

            f = open(f"types/{key}.java", 'w+')
            f.write(f"{package_name}")
            f.write(f"\n{notes.strip()}")
            f.write(f"\n{import_statements}")
            f.write(f"\n/**\n * {value_result['Definitions'][key]} \n**/")
            f.write("\n@JsonIgnoreProperties(ignoreUnknown = true)")
            f.write(f"\npublic class {key} {{\n")

            for v in value_result['SubDefinitions'].get(key):
                if v['Description'] != '':
                    f.write(f"\t/**\n \t* {v['Description']} \n\t**/")

                f.write(f'\n\t@JsonProperty("{v["Name"]}")\n')
                f.write(f"\tprivate {capitalize(str(v['Type']))} {v['Name']};\n")

            for v in value_result['SubDefinitions'].get(key):
                f.write(f"\n\t{create_getter(v['Name'], str(v['Type']))}\n")
                f.write(f"\n\t{create_setter(v['Name'], str(v['Type']))}\n")

            f.write("}")
        finally:
            f.close()

else:
    print("[INFO]: Couldn't find any definitions.")


if comments is not None:

    try:
        f = open(f"types/comments.txt", 'w+')
        f.write(
            f"/**\n * {scrape._soup_object.find_all('p')[2].get_text()} \n")
        for key in comments:
            if ((key != 'organization') and (key != 'project')):
                f.write(f"\n * {key} {comments.get(key)}")
        f.write("\n **/")
    finally:
        f.close()

else:
    print("[INFO]: Couldn't find any comments.")
