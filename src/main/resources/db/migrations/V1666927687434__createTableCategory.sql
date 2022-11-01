CREATE TABLE IF NOT EXISTS category (
  id varchar(255) NOT NULL,
  created_at timestamp NOT NULL,
  updated_at timestamp NOT NULL,
  name varchar(255) NULL,
  created_by varchar(255) NULL,

  CONSTRAINT fk_category_user FOREIGN KEY (created_by) REFERENCES public._user(id),

  CONSTRAINT "category_pkey" PRIMARY KEY (id)
);

