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
        res = self.strip_content(self.get_page_content, f'id="{DocumentId.EXAMPLES.value}"',
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
        res = self.strip_content(self.get_page_content, f'id="{DocumentId.EXAMPLES.value}"',
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
        res = self.strip_content(self.get_page_content, f'id="{DocumentId.EXAMPLES.value}"',
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
    java_type = type_value
    if '[]' in java_type and java_type != 'string[]':
        java_type = f"List<{capitalize(java_type.strip('[]'))}>"
    elif java_type != 'boolean':
        java_type = capitalize(java_type)
    val = f"public {java_type} get{capitalize(name)}() {{ return {name}; }}"
    return val


def create_setter(name: str, type_value: str):
    java_type = type_value
    if '[]' in java_type and java_type != 'string[]':
        java_type = f"List<{capitalize(java_type.strip('[]'))}>"
    elif java_type != 'boolean':
        java_type = capitalize(java_type)
    val = f"public void set{capitalize(name)}({java_type} {name}) {{ this.{name} = {name}; }}"
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
        soup = scrape._soup_object
        # Find the Definitions section
        definitions_h2 = soup.find(lambda tag: tag.name == "h2" and (tag.get("id") == "definitions" or "Definitions" in tag.text))
        if definitions_h2:
            # The next table after the Definitions h2 contains the list of definitions
            definitions_table = definitions_h2.find_next("table")
            if definitions_table:
                for row in definitions_table.find_all("tr")[1:]:  # skip header
                    cols = row.find_all("td")
                    if len(cols) >= 1:
                        link = cols[0].find("a")
                        if link and link.has_attr("href"):
                            anchor = link["href"].lstrip("#")
                            class_name = link.text.replace("\u200b", "").replace("\n", "").replace(" ", "")
                            class_desc = cols[1].get_text(strip=True) if len(cols) > 1 else ""
                            # Find the heading with id=anchor (could be h3, h4, etc.)
                            class_heading = soup.find(lambda tag: tag.name in ["h3", "h4", "h2"] and tag.get("id") == anchor)
                            if not class_heading:
                                print(f"[WARNING]: Heading for definition '{class_name}' (anchor '{anchor}') not found. Using anchor as class name.")
                            # Find the .metadata div after the heading
                            metadata = None
                            if class_heading:
                                next_tag = class_heading.find_next_sibling()
                                while next_tag and (getattr(next_tag, 'name', None) != 'div' or 'metadata' not in next_tag.get('class', [])):
                                    next_tag = next_tag.find_next_sibling()
                                metadata = next_tag
                            # Determine type: Object or Enumeration
                            type_kind = None
                            if metadata:
                                type_kind = metadata.get_text(strip=True)
                            # Find the next table after metadata (fields or enum values)
                            fields_table = None
                            if metadata:
                                fields_table = metadata.find_next_sibling("table")
                            elif class_heading:
                                # fallback: look for table after heading
                                fields_table = class_heading.find_next("table")
                            # Parse fields or enum values
                            fields = []
                            enum_values = []
                            if type_kind and "Enumeration" in type_kind:
                                # Enumeration: parse values
                                if fields_table:
                                    for frow in fields_table.find_all("tr")[1:]:
                                        fcols = frow.find_all("td")
                                        if len(fcols) >= 1:
                                            value = fcols[0].get_text(strip=True)
                                            desc = fcols[1].get_text(strip=True) if len(fcols) > 1 else ""
                                            enum_values.append((value, desc))
                                # Write Java enum
                                try:
                                    with open(f"types/{class_name}.java", 'w+', encoding='utf-8') as f:
                                        f.write(f"{package_name}\n")
                                        f.write(f"\n{notes.strip()}\n")
                                        f.write(f"\n{import_statements}\n")
                                        f.write(f"\n/**\n * {class_desc}\n**/\n")
                                        f.write(f"public enum {class_name} {{\n")
                                        for idx, (val, desc) in enumerate(enum_values):
                                            if desc:
                                                f.write(f"\t/** {desc} */\n")
                                            f.write(f"\t{val}{',' if idx < len(enum_values)-1 else ''}\n")
                                        if not enum_values:
                                            f.write("\n")
                                        f.write("}\n")
                                except Exception as e:
                                    print(f"[ERROR]: Failed to write enum {class_name}: {e}")
                            else:
                                # Object: parse fields
                                if fields_table:
                                    for frow in fields_table.find_all("tr")[1:]:
                                        fcols = frow.find_all("td")
                                        if len(fcols) >= 3:
                                            field_name = fcols[0].get_text(strip=True)
                                            field_type = fcols[1].get_text(strip=True)
                                            field_desc = fcols[2].get_text(strip=True)
                                            fields.append((field_name, field_type, field_desc))
                                # Write Java class
                                try:
                                    with open(f"types/{class_name}.java", 'w+', encoding='utf-8') as f:
                                        f.write(f"{package_name}\n")
                                        f.write(f"\n{notes.strip()}\n")
                                        f.write(f"\n{import_statements}\n")
                                        f.write(f"\n/**\n * {class_desc}\n**/\n")
                                        f.write("@JsonIgnoreProperties(ignoreUnknown = true)\n")
                                        f.write(f"public class {class_name} extends SerializableEntity {{\n")
                                        for field_name, field_type, field_desc in fields:
                                            java_type = field_type
                                            if '[]' in java_type and java_type != 'string[]':
                                                java_type = f"List<{capitalize(java_type.strip('[]'))}>"
                                            elif java_type != 'boolean':
                                                java_type = capitalize(java_type)
                                            if field_desc:
                                                f.write(f"\t/**\n \t* {field_desc} \n\t**/\n")
                                            f.write(f'\t@JsonProperty("{field_name}")\n')
                                            f.write(f"\tprivate {java_type} {field_name};\n")
                                        for field_name, field_type, _ in fields:
                                            f.write(f"\n\tpublic {capitalize(field_type)} get{capitalize(field_name)}() {{ return {field_name}; }}\n")
                                            f.write(f"\n\tpublic void set{capitalize(field_name)}({capitalize(field_type)} {field_name}) {{ this.{field_name} = {field_name}; }}\n")
                                        if not fields:
                                            f.write("\n")
                                        f.write("}\n")
                                except Exception as e:
                                    print(f"[ERROR]: Failed to write class {class_name}: {e}")
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
