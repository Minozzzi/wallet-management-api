CREATE TABLE IF NOT EXISTS account (
  id varchar(255) NOT NULL,
  created_at timestamp NOT NULL,
  updated_at timestamp NOT NULL,
  banking_code varchar(255) NULL,
  description varchar(255) NULL,
  include_in_dashboard bool NULL,
  type int4 NULL,
  created_by varchar(255) NULL,

  CONSTRAINT fk_account_user FOREIGN KEY (created_by) REFERENCES public._user(id),

  CONSTRAINT "account_pkey" PRIMARY KEY (id)
);

