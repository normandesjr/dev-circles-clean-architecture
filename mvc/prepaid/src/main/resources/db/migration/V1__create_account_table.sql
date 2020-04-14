CREATE TABLE account (
  number VARCHAR(20) NOT NULL PRIMARY KEY
);

CREATE TABLE account_activity (
  id SERIAL NOT NULL PRIMARY KEY,
  account_number VARCHAR NOT NULL,
  amount DECIMAL(10,2) NOT NULL,
  timestamp TIMESTAMP NOT NULL
);
