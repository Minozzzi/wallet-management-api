const TEMPLATE_STRING = "`";
const INITIAL_TEMPLATE_STRING = "${";
const JOIN_LINES = `\\n  `;

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
const fkConstraints: string[] = []
const fkConstraintString = 'CONSTRAINT {{fk_name}} FOREIGN KEY ({{fk_field}}) REFERENCES {{fk_referenced_table}}({{fk_pk_referenced_table}})'

const addPKey = (columnName: string): string =>
  ${TEMPLATE_STRING}CONSTRAINT "${INITIAL_TEMPLATE_STRING}tablename}_pkey" PRIMARY KEY (${INITIAL_TEMPLATE_STRING}columnName})${TEMPLATE_STRING};

const convertToSql = (): string => {
  return ${TEMPLATE_STRING}CREATE TABLE IF NOT EXISTS ${INITIAL_TEMPLATE_STRING}tablename} (
  ${INITIAL_TEMPLATE_STRING}columns.map(
    (column) =>
    ${TEMPLATE_STRING}${INITIAL_TEMPLATE_STRING}column.name} ${INITIAL_TEMPLATE_STRING}column.type} ${INITIAL_TEMPLATE_STRING}column.isNull ? "NULL" : "NOT NULL"},${TEMPLATE_STRING}
  ).join("${JOIN_LINES}")}

  ${INITIAL_TEMPLATE_STRING}!!fkConstraints.length ? fkConstraints.map(
    (constraint) => ${TEMPLATE_STRING}${INITIAL_TEMPLATE_STRING}constraint},${TEMPLATE_STRING}
  ).join("${JOIN_LINES}") : ""}

  ${INITIAL_TEMPLATE_STRING}addPKey(columns.filter((column) => column.isPKey)[0].name)}
);

${TEMPLATE_STRING};
};

const execute = () => {
  // fill columns with .push

  // fill fk constraints with .push and fk constraint base string

  const SQL = convertToSql();

  const path = '../db/migrations/' + filename.replace(".ts", ".sql");

  fs.writeFile(path, SQL, (err) => {
    if (err) return console.error(err);

    console.log(chalk.blue("File .sql written successfully"));
  });
};

execute()

`;
