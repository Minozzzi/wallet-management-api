CREATE TABLE IF NOT EXISTS transaction (
  id varchar(255) NOT NULL,
  created_at timestamp NOT NULL,
  updated_at timestamp NOT NULL,
  amount float8 NULL,
  amount_paid float8 NULL,
  description varchar(255) NULL,
  due_date timestamp NULL,
  payment_date timestamp NULL,
  type int4 NULL,
  created_by varchar(255) NULL,
  account_id varchar(255) NULL,
  category_id varchar(255) NULL,

  CONSTRAINT fk_transaction_account FOREIGN KEY (account_id) REFERENCES account(id),
  CONSTRAINT fk_transaction_category FOREIGN KEY (category_id) REFERENCES category(id),
  CONSTRAINT fk_transaction_user FOREIGN KEY (created_by) REFERENCES _user(id),

  CONSTRAINT "transaction_pkey" PRIMARY KEY (id)
);

