CREATE TABLE IF NOT EXISTS userstorage
(
    id       INT not null AUTO_INCREMENT,
    mail     VARCHAR(255) not null ,
    password VARCHAR(255) not null ,
    NG_flag  boolean,
    NG_date  DATETIME,
    PRIMARY KEY (id),
    UNIQUE (mail),
    UNIQUE (password)
);
