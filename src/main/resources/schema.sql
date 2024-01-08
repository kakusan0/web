/*
テーブル削除
*/
drop table IF EXISTS oldpostmaster;

drop view IF EXISTS postmaster;

drop table IF EXISTS prefecture;

drop table IF EXISTS userstorage;

/*

*/
CREATE TABLE IF NOT EXISTS oldpostmaster
(
    PostCode            VARCHAR(255),
    prefecturesKANA     VARCHAR(255),
    municipalitiesKANA  VARCHAR(255),
    TownAreaKANA        VARCHAR(255),
    prefecturesKANZI    VARCHAR(255),
    municipalitiesKANZI VARCHAR(255),
    TownAreaKANZI       VARCHAR(255)
);
SET PERSIST local_infile= 1;
/*
utf_ken_all.csv　ファイルインポート
*/
LOAD DATA local INFILE 'C:/Users/gmaki/Documents/web/src/main/resources/utf_ken_all.csv'
    INTO table oldpostmaster FIELDS TERMINATED BY
        ',' ENCLOSED BY
        '"' LINES TERMINATED BY
        '\n' IGNORE 1 LINES;

/*
ビュー作成
*/
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
from oldpostmaster a;

/*
都道府県テーブル
*/
CREATE TABLE IF NOT EXISTS prefecture
(
    prefectureCode int AUTO_INCREMENT,
    prefectures    VARCHAR(255),
    PRIMARY KEY (prefectureCode)
);

insert
into prefecture(prefectures)
select DISTINCT b.prefecturesKANZI
from oldpostmaster b;

/*
都道府県コードカラム追加　oldpostmasterテーブルに
*/
alter table oldpostmaster
    add column prefectureCode int first;

update oldpostmaster c
    left join prefecture d
    on c.prefecturesKANZI = d.prefectures
set c.prefectureCode = d.prefectureCode
where c.prefecturesKANZI = d.prefectures;

CREATE TABLE `userstorage`
(
    `id`       int NOT NULL AUTO_INCREMENT,
    `email`    varchar(255) DEFAULT NULL,
    `username` varchar(255) DEFAULT NULL,
    `password` varchar(255) DEFAULT NULL,
    `NG_flag`  tinyint(1)   DEFAULT NULL,
    `NG_date`  datetime     DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `email` (`email`),
    UNIQUE KEY `username` (`username`)
);
