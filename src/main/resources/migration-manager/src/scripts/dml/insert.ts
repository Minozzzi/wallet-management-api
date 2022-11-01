const TEMPLATE_STRING = "`";
const INITIAL_TEMPLATE_STRING = "${";

export const insertScriptTemplate = `import fs from "fs";
import chalk from "chalk";
import { faker } from "@faker-js/faker/locale/en";

const tablename = "{{tablename}}";
const filename = "{{filename}}";
const columns: string[] = [];
const values: string[][] = Array.from(
  { length: Number(faker.random.numeric(2)) }
);

const convertToSql = (): string => {
  return ${TEMPLATE_STRING}INSERT INTO ${INITIAL_TEMPLATE_STRING}tablename} (${INITIAL_TEMPLATE_STRING}columns.join(", ")}) \\nVALUES\\n${INITIAL_TEMPLATE_STRING}values
    .map((value) => ${TEMPLATE_STRING}  (${INITIAL_TEMPLATE_STRING}value.join(", ")})${TEMPLATE_STRING})
    .join(",\\n")}${TEMPLATE_STRING};
};

const execute = () => {
  // fill columns with .push

  // fill values with .push

  const SQL = convertToSql();

  const path = '../db/migrations/' + filename.replace(".ts", ".sql");

  fs.writeFile(path, SQL, (err) => {
    if (err) return console.error(err);

    console.log(chalk.blue("File .sql written successfully"));
  });
};

execute()

`;
