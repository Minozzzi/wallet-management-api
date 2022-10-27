import fs from "fs";

const baseMigrationManagerPath = process.cwd();

const flyWayMigrationsPath = `${process.cwd()}/../db/migrations`;

const flyWayMigrations = fs
  .readdirSync(flyWayMigrationsPath)
  .map((file) => file.replace(".sql", ""));

export const migrations = fs
  .readdirSync(`${baseMigrationManagerPath}/src/migrations`)
  .filter((file) => file !== "index.ts")
  .map((file) => file.replace(".ts", ""))
  .filter((file) => !flyWayMigrations.includes(file));
