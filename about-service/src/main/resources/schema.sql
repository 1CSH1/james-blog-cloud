-- 分类数据库

DROP TABLE IF EXISTS about;
CREATE TABLE about
(
  id                BIGINT(20) AUTO_INCREMENT PRIMARY KEY NOT NULL,
  content           TEXT NOT NULL ,
  is_use            INT ,
  created_time      BIGINT(40) NOT NULL ,
  modified_time     BIGINT(40) NOT NULL
) CHARSET = UTF8;

