const TEMPLATE_STRING = "`";
const INITIAL_TEMPLATE_STRING = "${";

export const createTableScriptTemplate = `import fs from "fs";
import chalk from "chalk";

type DDLColumns = {
  name: string;
  type: string;
  isNull: boolean;
  isPKey: boolean;
}[];

const tablename = "{{tablename}}";
const filename = "{{filename}}";
const columns: DDLColumns = [];

const addPKey = (columnName: string): string =>
  ${TEMPLATE_STRING}CONSTRAINT "${INITIAL_TEMPLATE_STRING}tablename}_pkey" PRIMARY KEY (${INITIAL_TEMPLATE_STRING}columnName})${TEMPLATE_STRING};

const convertToSql = (): string => {
  return ${TEMPLATE_STRING}CREATE TABLE ${INITIAL_TEMPLATE_STRING}tablename} (
      ${INITIAL_TEMPLATE_STRING}columns.map(
        (column) =>
          ${TEMPLATE_STRING}${INITIAL_TEMPLATE_STRING}column.name} ${INITIAL_TEMPLATE_STRING}column.type} ${INITIAL_TEMPLATE_STRING}
            column.isNull ? "NULL" : "NOT NULL"
          },\n${TEMPLATE_STRING}
      )}

      ${INITIAL_TEMPLATE_STRING}columns.find((column) => column.isPKey && addPKey(column.name))}
    );
    ${TEMPLATE_STRING};
};

const execute = () => {
  // fill columns with .push

  const SQL = convertToSql();

  const path = '../db/migrations/' + filename.replace(".ts", ".sql");

  fs.writeFile(path, SQL, (err) => {
    if (err) return console.error(err);

    console.log(chalk.blue("File .sql written successfully"));
  });
};

execute()

`;
