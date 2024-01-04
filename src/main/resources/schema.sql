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

CREATE TABLE IF NOT EXISTS postmaster
(
    NationalLocalGovernmentCode INT not null,
    oldPostalCode               VARCHAR(255),
    PostCode                    VARCHAR(255),
    prefecturesKANA             VARCHAR(255),
    municipalitiesKANA          VARCHAR(255),
    TownAreaKANA                VARCHAR(255),
    prefecturesKANZI            VARCHAR(255),
    municipalitiesKANZI         VARCHAR(255),
    TownAreaKANZI               VARCHAR(255)
);
