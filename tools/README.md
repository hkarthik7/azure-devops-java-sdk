# CREATE DEFINITION OR TYPE FILES FOR THE PACKAGE AUTOMATICALLY

The script `scrape.py` will help to create type/definition files for the API that you want to wrap. This is the best
effort to create the files based on definitions in the documentation. Once the files are created, please review it and
edit it accordingly. Note that only classes will be created and any `Enum`s will have to be edited from the created
file.

## How to run

You should've **python** version `3.x` installed in your system to run the script. Please download it from the
[official documentation](https://www.python.org/downloads/).

- Make sure that you are in the root of the folder, i.e., `tools`.
- Update the value of url in `settings.json` file. This should be the Azure DevOps documentation URL.
- Once the `settings.json` is updated with url, run the script.

```
C:\> python -m scrape
# or
C:\> python3 scrape
```

- Create comments for the method you create. If you only want to generate comments make `commentOnly` to `true`.

```json
{
  "name": "Setting file for scraping the Azure DevOps API document and create definition files based on that.",
  "version": 1.0,
  "url": "https://docs.microsoft.com/en-us/rest/api/azure/devops/build/attachments/list?view=azure-devops-rest-7.1",
  "commentOnly": false
}
```

This will create a folder called `types` if not exists and places all the files under it. You can then move the files to
respective *types* folder under the *package* and edit it.
