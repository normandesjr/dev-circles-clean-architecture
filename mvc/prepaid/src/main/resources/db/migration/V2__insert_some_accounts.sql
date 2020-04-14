INSERT INTO account VALUES ('1111');
INSERT INTO account VALUES ('2222');
INSERT INTO account VALUES ('3333');

INSERT INTO account_activity (account_number, amount, timestamp) VALUES ('1111', 10.0, now());
INSERT INTO account_activity (account_number, amount, timestamp) VALUES ('1111', 20.0, now());
INSERT INTO account_activity (account_number, amount, timestamp) VALUES ('1111', 10.0, now());

INSERT INTO account_activity (account_number, amount, timestamp) VALUES ('2222', 10.0, now());

INSERT INTO account_activity (account_number, amount, timestamp) VALUES ('3333', 30.0, now());
