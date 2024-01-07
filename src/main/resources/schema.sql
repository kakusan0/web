CREATE TABLE IF NOT EXISTS userstorage
(
    id       INT not null AUTO_INCREMENT,
    email    VARCHAR(255),
    username VARCHAR(255),
    password VARCHAR(255),
    NG_flag  BOOLEAN,
    NG_date  DATETIME,
    PRIMARY KEY (id),
    UNIQUE (email),
    UNIQUE (username)
);

drop view postmaster;

create view postmaster
            (
             LeftPostCode, RightPostCode, prefecturesKANZI, municipalitiesKANZI, TownAreaKANZI
                )
as
select SUBSTRING(a.PostCode, 1, 3)
     , IF(
            LENGTH(a.PostCode) > 6
    , SUBSTRING(a.PostCode, 4, 7)
    , SUBSTRING(a.PostCode, 4, 6)
       )
     , a.prefecturesKANZI
     , a.municipalitiesKANZI
     , a.TownAreaKANZI
from temppostmaster a;

TRUNCATE TABLE temppostmaster;

drop table temppostmaster;

CREATE TABLE IF NOT EXISTS temppostmaster
(
    PostCode            VARCHAR(255),
    prefecturesKANA     VARCHAR(255),
    municipalitiesKANA  VARCHAR(255),
    TownAreaKANA        VARCHAR(255),
    prefecturesKANZI    VARCHAR(255),
    municipalitiesKANZI VARCHAR(255),
    TownAreaKANZI       VARCHAR(255)
);
