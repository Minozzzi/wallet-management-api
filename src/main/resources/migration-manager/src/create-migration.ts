#!/usr/bin/env node
import chalk from "chalk";
import clear from "clear";
import figlet from "figlet";
import fs from "fs";
import inquirer from "inquirer";
import * as templatesScripts from "./scripts";

type ScriptsProps = {
  [key in "DDL" | "DML"]: string;
};

clear();

const scriptsProps: ScriptsProps = {
  DDL: templatesScripts.createTableScriptTemplate,
  DML: templatesScripts.insertScriptTemplate,
};

const getUserOptions = async (): Promise<{
  filename: string;
  commandType: "DDL" | "DML";
  tableName: string;
}> => {
  const answers = await inquirer.prompt([
    {
      name: "filename",
      message: "Migration file name:",
      type: "input",
      validate: async (input) => {
        if (!input) return "Invalid filename";
        return true;
      },
    },
    {
      name: "tableName",
      message: "Table name:",
      type: "input",
      validate: async (input) => {
        if (!input) return "Invalid filename";
        return true;
      },
    },
    {
      name: "commandType",
      message: "Migration command type",
      type: "list",
      choices: ["DML", "DDL"],
    },
  ]);

  return {
    ...answers,
  };
};

const { filename, tableName, commandType } = await getUserOptions();
const migrationFilename = `V${new Date().getTime()}__${filename}.ts`;

const baseMigrationSetup = scriptsProps[commandType]
  .replace("{{tablename}}", tableName)
  .replace("{{filename}}", migrationFilename);

console.log(
  chalk.blue(figlet.textSync("MIGRATION-CLI", { horizontalLayout: "full" }))
);

fs.writeFile(
  `./src/migrations/${migrationFilename}`,
  baseMigrationSetup,
  (err) => {
    if (err) return console.error(err);

    console.log(chalk.blue("Creating your ts migration\n"));

    console.log(chalk.blue("File .ts written successfully"));
  }
);
