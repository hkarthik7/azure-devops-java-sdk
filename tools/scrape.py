from enum import Enum
import itertools
from venv import create
from bs4 import BeautifulSoup
import requests
import json
import os


# This is an incomplete list of ids
# TODO: Add specifics if required


class DocumentId(Enum):
    DEFINITIONS = 'definitions'
    EXAMPLES = 'examples'
    COMMENT = 'uri-parameters'
    RESPONSE = 'response'
    ATTRIBUTE = 'table'
    DEFINITIONS_CLASS = 'table'
    COMMENTS_CLASS = 'parameters'
    RESPONSE_TYPE_CLASS = 'parameters definitions'
    TAG_PARA = 'p'
    TAG_A = 'a'
    TAG_DIV = 'div'


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

    def __init__(self, url: str) -> None:
        self._url = url

    def get_response(self) -> requests.Response:
        return requests.get(self._url)

    @property
    def get_page_content(self) -> str:
        return requests.get(self._url).text

    @property
    def _soup_object(self) -> BeautifulSoup:
        return BeautifulSoup(self.get_page_content, 'html.parser')

    def get_soup_object(self, content: str) -> BeautifulSoup:
        self.content = content
        return BeautifulSoup(self.content, 'html.parser')

    def get_url_response(self, url: str) -> requests.Response:
        self.url = url
        return requests.get(self.url)

    def strip_content(self, content: str, start_value: str, end_value: str, additional_value=4) -> BeautifulSoup:
        self.content = content
        self.start_value = start_value
        self.end_value = end_value

        start_index = self.get_index(self.start_value)
        end_index = self.get_index(self.end_value)
        result_content = content.replace(
            content[start_index:end_index - additional_value], '')

        return self.get_soup_object(result_content)

    def get_attributes(self, soup: BeautifulSoup, id: str, name: str, class_name: str, tags: list) -> dict:
        self.soup = soup
        self.id = id
        self.name = name
        self.class_name = class_name
        self.tags = tags

        result: dict = {}
        types_to_create: dict = {}

        # Get main definition
        root = soup.find(id=self.id)
        # Get the types to be created
        definitions = self.soup.find(self.name, class_=self.class_name)

        if definitions is not None:

            for p in itertools.zip_longest(definitions.find_all(self.tags[0]), definitions.find_all(self.tags[1])):
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

    def get_definitions(self) -> dict:
        res = self.strip_content(self.get_response().text, f'id="{DocumentId.EXAMPLES.value}"',
                                 f'id="{DocumentId.DEFINITIONS.value}"')
        if res != None:
            return self.get_attributes(
                res, DocumentId.DEFINITIONS.value, DocumentId.ATTRIBUTE.value,
                DocumentId.DEFINITIONS_CLASS.value, [DocumentId.TAG_A.value, DocumentId.TAG_PARA.value])
        else:
            return self.get_attributes(
                self._soup_object, DocumentId.DEFINITIONS.value, DocumentId.ATTRIBUTE.value,
                DocumentId.DEFINITIONS_CLASS.value, [DocumentId.TAG_A.value, DocumentId.TAG_PARA.value])

    def get_comments(self) -> dict:
        res = self.strip_content(self.get_response().text, f'id="{DocumentId.EXAMPLES.value}"',
                                 f'id="{DocumentId.DEFINITIONS.value}"')
        if res != None:
            return self.get_attributes(
                res, DocumentId.COMMENT.value, DocumentId.ATTRIBUTE.value,
                DocumentId.COMMENTS_CLASS.value, [DocumentId.TAG_DIV.value, DocumentId.TAG_PARA.value])
        else:
            return self.get_attributes(
                self._soup_object, DocumentId.COMMENT.value, DocumentId.ATTRIBUTE.value,
                DocumentId.COMMENTS_CLASS.value, [DocumentId.TAG_DIV.value, DocumentId.TAG_PARA.value])

    def get_response_type(self) -> dict:
        res = self.strip_content(self.get_response().text, f'id="{DocumentId.EXAMPLES.value}"',
                                 f'id="{DocumentId.DEFINITIONS.value}"')
        if res != None:
            return self.get_attributes(
                res, DocumentId.RESPONSE.value, DocumentId.ATTRIBUTE.value,
                DocumentId.RESPONSE_TYPE_CLASS.value, [DocumentId.TAG_A.value, DocumentId.TAG_PARA.value])
        else:
            return self.get_attributes(
                self._soup_object, DocumentId.RESPONSE.value, DocumentId.ATTRIBUTE.value,
                DocumentId.RESPONSE_TYPE_CLASS.value, [DocumentId.TAG_A.value, DocumentId.TAG_PARA.value])

    def get_index(self, value: str) -> int:
        return self.get_page_content.find(value)


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
    if '[]' in type_value and type_value != 'string[]':
        type_value = f"List<{type_value.strip('[]')}>"
    if str(v['Type']) != 'boolean':
        type_value = capitalize(type_value)
    val = f"public {type_value} get{capitalize(name)}() {{ return {name}; }}"
    return val


def create_setter(name: str, type_value: str):
    if '[]' in type_value and type_value != 'string[]':
        type_value = f"List<{type_value.strip('[]')}>"
    if str(v['Type']) != 'boolean':
        type_value = capitalize(type_value)
    val = f"public void set{capitalize(name)}({type_value} {name}) {{ this.{name} = {name}; }}"
    return val


_url: str = json.loads(read('settings.json'))['url']
comment_only: bool = json.loads(read('settings.json'))['commentOnly']
package_name = f'package org.azd.{_url.split("/")[-3]}.types;'
notes: str = json.loads(read('settings.json'))['properties']['notes']
import_statements: str = json.loads(read('settings.json'))[
    'properties']['imports']

sub_type_collector = []
d_value = {}

prev = 0
last_val = 0

if __name__ == "__main__":

    if not os.path.isdir("types"):
        os.mkdir("types")

    scrape = ScrapeVsTsDocument(_url)
    response = scrape.get_response()

    value_result = scrape.get_definitions()
    comments = scrape.get_comments()['URI Parameters']
    res_type = scrape.get_response_type()['Responses']

    if value_result is not None and not comment_only:

        for definition in value_result['Definitions']:
            if definition == list(value_result['Definitions'])[-1]:
                last_val = scrape.get_index(
                    str(scrape._soup_object.find(id=definition.lower())))
            current_val = scrape.get_index(
                str(scrape._soup_object.find(id=definition.lower())))

            if (current_val == last_val):
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
            s = scrape.get_soup_object(def_value)

            table = s.find_all(DocumentId.ATTRIBUTE.value, {
                               'class': DocumentId.RESPONSE_TYPE_CLASS.value})
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
                f = open(f"types/{key}.java", 'w+', encoding='utf-8')
                f.write(f"{package_name}")
                f.write(f"\n{notes.strip()}")
                f.write(f"\n{import_statements}")
                f.write(f"\n/**\n * {value_result['Definitions'][key]} \n**/")
                f.write("\n@JsonIgnoreProperties(ignoreUnknown = true)")
                f.write(
                    f"\npublic class {key} extends SerializableEntity {{\n")

                for v in value_result['SubDefinitions'].get(key):
                    if '[]' in str(v['Type']) and str(v['Type']) != 'string[]':
                        new_type_val = f"List<{capitalize(str(v['Type']).strip('[]'))}>"
                    else:
                        if str(v['Type']) != 'boolean':
                            new_type_val = capitalize(str(v['Type']))
                        else:
                            new_type_val = str(v['Type'])

                    if v['Description'] != '':
                        f.write(f"\t/**\n \t* {v['Description']} \n\t**/")

                    f.write(f'\n\t@JsonProperty("{v["Name"]}")\n')
                    f.write(f"\tprivate {new_type_val} {v['Name']};\n")

                for v in value_result['SubDefinitions'].get(key):
                    f.write(
                        f"\n\t{create_getter(v['Name'], str(v['Type']))}\n")
                    f.write(
                        f"\n\t{create_setter(v['Name'], str(v['Type']))}\n")

                f.write("\n}")

            finally:
                f.close()

    else:
        if not comment_only:
            print("[INFO]: Couldn't find any definitions.")

    if comments is not None:

        try:
            f = open(f"types/comments.txt", 'w+', encoding='utf-8')
            f.write(
                f"/**\n * {scrape._soup_object.find_all(DocumentId.TAG_PARA.value)[2].get_text()} \n")
            f.write(f" *")
            for key in comments:
                if ((key != 'organization') and (key != 'project') and (key != 'api-version')):
                    f.write(f"\n * @param {key} {comments.get(key)}")
            if res_type:
                for k in res_type:
                    f.write(f"\n * @return {k} Object {{@link {k}}}")
            f.write("\n * @throws AzDException Default Api Exception handler.")
            f.write("\n**/")
        finally:
            f.close()

    else:
        print("[INFO]: Couldn't find any comments.")
