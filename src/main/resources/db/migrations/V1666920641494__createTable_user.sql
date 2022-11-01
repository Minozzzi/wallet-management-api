CREATE TABLE IF NOT EXISTS _user (
  id varchar(255) NOT NULL,
  created_at timestamp NOT NULL,
  updated_at timestamp NOT NULL,
  created_by varchar(255) NULL,
  name varchar(255) NULL,
  password varchar(255) NULL,
  username varchar(255) NULL,

  CONSTRAINT "_user_pkey" PRIMARY KEY (id)
);


ALTER TABLE _user ADD CONSTRAINT "fk_user_user" FOREIGN KEY (created_by) REFERENCES _user(id);
