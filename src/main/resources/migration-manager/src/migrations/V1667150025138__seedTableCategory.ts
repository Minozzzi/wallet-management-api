import fs from "fs";
import chalk from "chalk";
import { faker } from "@faker-js/faker/locale/en";

const tablename = "category";
const filename = "V1667150025138__seedTableCategory.ts";
const columns: string[] = [];
const values: string[][] = Array.from(
  { length: Number(faker.random.numeric(2)) },
  () => [
    `'${faker.datatype.uuid()}'`,
    `'${faker.lorem.word()}'`,
    `'d4934ad0-6c95-42c5-9bfb-2f51e3653cec'`,
    "NOW()",
    "NOW()",
  ]
);

const convertToSql = (): string => {
  return `INSERT INTO ${tablename} (${columns.join(", ")}) \nVALUES\n${values
    .map((value) => `  (${value.join(", ")})`)
    .join(",\n")}`;
};

const execute = () => {
  // fill columns with .push
  columns.push("id", "name", "created_by", "created_at", "updated_at");

  // fill values with .push

  const SQL = convertToSql();

  const path = "../db/migrations/" + filename.replace(".ts", ".sql");

  fs.writeFile(path, SQL, (err) => {
    if (err) return console.error(err);

    console.log(chalk.blue("File .sql written successfully"));
  });
};

execute();

