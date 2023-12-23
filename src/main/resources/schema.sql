CREATE TABLE IF NOT EXISTS "userstorage"
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    mail     VARCHAR(255),
    password VARCHAR(255),
    NG_flag  INT,
    NG_date  DATE,
    UNIQUE (mail),
    UNIQUE (password)
);
