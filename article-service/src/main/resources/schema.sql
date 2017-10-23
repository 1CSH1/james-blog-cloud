-- article 数据库

DROP TABLE IF EXISTS article;
CREATE TABLE article
(
  id                BIGINT(20) AUTO_INCREMENT PRIMARY KEY NOT NULL,
  title             VARCHAR(255) NOT NULL,
  subtitle          VARCHAR(255),
  author            VARCHAR(255) NOT NULL,
  content           TEXT NOT NULL ,
  read_number       INT NOT NULL ,
  comment_number    INT NOT NULL ,
  is_top            BOOLEAN NOT NULL ,
  created_time      BIGINT(40) NOT NULL ,
  modified_time     BIGINT(40) NOT NULL
) CHARSET = UTF8;