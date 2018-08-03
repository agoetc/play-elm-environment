# todo schema

# --- !Ups
CREATE TABLE todo(
  id serial,
  title text NOT NULL,
  text text NOT NULL,
  status boolean NOT NULL
);

# --- !Downs
DROP TABLE IF EXISTS todo;
