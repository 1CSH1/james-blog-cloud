-- 分类数据库

DROP TABLE IF EXISTS category;
CREATE TABLE category
(
  id                BIGINT(20) AUTO_INCREMENT PRIMARY KEY NOT NULL,
  name              VARCHAR(255) NOT NULL ,
  created_time      BIGINT(40) NOT NULL ,
  modified_time     BIGINT(40) NOT NULL
) CHARSET = UTF8;

-- 文章和分类关系表
DROP TABLE IF EXISTS article_category_rel;
CREATE TABLE article_category_rel
(
  id                BIGINT(20) AUTO_INCREMENT PRIMARY KEY NOT NULL,
  category_id       BIGINT(20) NOT NULL,
  article_id        BIGINT(20) NOT NULL,
  created_time      BIGINT(40) NOT NULL,
  modified_time     BIGINT(40) NOT NULL
) CHARSET = UTF8;
