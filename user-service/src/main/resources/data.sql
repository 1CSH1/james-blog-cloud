DELETE FROM user;
INSERT INTO user VALUES (0, unix_timestamp(now()), unix_timestamp(now()), 'james.csh@example.com', 'James', 'CSH', 'user');