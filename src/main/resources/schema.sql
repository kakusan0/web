CREATE TABLE IF NOT EXISTS userstorage
(
    id       INT not null AUTO_INCREMENT,
    mail     VARCHAR(255),
    username VARCHAR(255),
    pw       VARCHAR(255),
    NG_flag  BOOLEAN,
    NG_date  DATETIME,
    PRIMARY KEY (id),
    UNIQUE (mail),
    UNIQUE (username)
);
