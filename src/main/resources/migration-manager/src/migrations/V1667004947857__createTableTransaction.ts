import fs from "fs";
import chalk from "chalk";

type DDLColumns = {
  name: string;
  type: string;
  isNull: boolean;
  isPKey: boolean;
}[];

const tablename = "transaction";
const filename = "V1667004947857__createTableTransaction.ts";
const columns: DDLColumns = [];
const fkConstraints: string[] = [];
const fkConstraintString =
  "CONSTRAINT {{fk_name}} FOREIGN KEY ({{fk_field}}) REFERENCES {{fk_referenced_table}}({{fk_pk_referenced_table}})";

const addPKey = (columnName: string): string =>
  `CONSTRAINT "${tablename}_pkey" PRIMARY KEY (${columnName})`;

const convertToSql = (): string => {
  return `CREATE TABLE IF NOT EXISTS ${tablename} (
  ${columns
    .map(
      (column) =>
        `${column.name} ${column.type} ${column.isNull ? "NULL" : "NOT NULL"},`
    )
    .join("\n  ")}

  ${
    !!fkConstraints.length
      ? fkConstraints.map((constraint) => `${constraint},`).join("\n  ")
      : ""
  }

  ${addPKey(columns.filter((column) => column.isPKey)[0].name)}
);

`;
};

const execute = () => {
  // fill columns with .push
  columns.push(
    {
      name: "id",
      isNull: false,
      isPKey: true,
      type: "varchar(255)",
    },
    {
      name: "created_at",
      isNull: false,
      isPKey: false,
      type: "timestamp",
    },
    {
      name: "updated_at",
      isNull: false,
      isPKey: false,
      type: "timestamp",
    },
    {
      name: "amount",
      isNull: true,
      isPKey: false,
      type: "float8",
    },
    {
      name: "amount_paid",
      isNull: true,
      isPKey: false,
      type: "float8",
    },
    {
      name: "description",
      isNull: true,
      isPKey: false,
      type: "varchar(255)",
    },
    {
      name: "due_date",
      isNull: true,
      isPKey: false,
      type: "timestamp",
    },
    {
      name: "payment_date",
      isNull: true,
      isPKey: false,
      type: "timestamp",
    },
    {
      name: "type",
      isNull: true,
      isPKey: false,
      type: "int4",
    },
    {
      name: "created_by",
      isNull: true,
      isPKey: false,
      type: "varchar(255)",
    },
    {
      name: "account_id",
      isNull: true,
      isPKey: false,
      type: "varchar(255)",
    },
    {
      name: "category_id",
      isNull: true,
      isPKey: false,
      type: "varchar(255)",
    }
  );

  // fill fkConstraints with .push
  fkConstraints.push(
    fkConstraintString
      .replace("{{fk_name}}", "fk_transaction_account")
      .replace("{{fk_field}}", "account_id")
      .replace("{{fk_referenced_table}}", "account")
      .replace("{{fk_pk_referenced_table}}", "id"),
    fkConstraintString
      .replace("{{fk_name}}", "fk_transaction_category")
      .replace("{{fk_field}}", "category_id")
      .replace("{{fk_referenced_table}}", "category")
      .replace("{{fk_pk_referenced_table}}", "id"),
    fkConstraintString
      .replace("{{fk_name}}", "fk_transaction_user")
      .replace("{{fk_field}}", "created_by")
      .replace("{{fk_referenced_table}}", "_user")
      .replace("{{fk_pk_referenced_table}}", "id")
  );

  const SQL = convertToSql();

  const path = "../db/migrations/" + filename.replace(".ts", ".sql");

  fs.writeFile(path, SQL, (err) => {
    if (err) return console.error(err);

    console.log(chalk.blue("File .sql written successfully"));
  });
};

execute();
