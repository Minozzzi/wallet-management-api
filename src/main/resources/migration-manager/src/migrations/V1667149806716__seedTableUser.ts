import fs from "fs";
import chalk from "chalk";
import { faker } from "@faker-js/faker/locale/en";
import bcrypt from "bcrypt";

const tablename = "_user";
const filename = "V1667149806716__seedTableUser.ts";
const columns: string[] = [];
const values: string[][] = Array.from(
  { length: Number(faker.random.numeric(2)) },
  () => [
    `'${faker.datatype.uuid()}'`,
    `'${faker.name.fullName()}'`,
    `'${faker.internet.userName()}'`,
    `'${bcrypt.hashSync(faker.internet.password(), 12)}'`,
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
  columns.push(
    "id",
    "name",
    "username",
    "password",
    "created_at",
    "updated_at"
  );

  const plainTextAdminPassword = "Admin1!@#2";
  const hashedAdminPassword = bcrypt.hashSync(plainTextAdminPassword, 12);

  // fill values with .push
  values.push([
    `'d4934ad0-6c95-42c5-9bfb-2f51e3653cec'`,
    `'Admin'`,
    `'admin'`,
    `'${hashedAdminPassword}'`,
    "NOW()",
    "NOW()",
  ]);

  const SQL = convertToSql();

  const path = "../db/migrations/" + filename.replace(".ts", ".sql");

  fs.writeFile(path, SQL, (err) => {
    if (err) return console.error(err);

    console.log(chalk.blue("File .sql written successfully"));
  });
};

execute();

