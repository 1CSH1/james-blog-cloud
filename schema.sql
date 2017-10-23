-- article 数据库

DROP TABLE IF EXISTS article;
CREATE TABLE article
(
  id        BIGINT(20) AUTO_INCREMENT PRIMARY KEY NOT NULL,
  title             VARCHAR(255) NOT NULL,
  subtitle          VARCHAR(255),
  author            VARCHAR(255) NOT NULL,
  content           TEXT NOT NULL ,
  read_number       INT NOT NULL ,
  comment_number    INT NOT NULL ,
  is_top            BOOLEAN NOT NULL ,
  created_time      BIGINT(40) NOT NULL ,
  modified_time     BIGINT(40) NOT NULL
);


-- 分类数据库

DROP TABLE IF EXISTS category;
CREATE TABLE category
(
  id                BIGINT(20) AUTO_INCREMENT PRIMARY KEY NOT NULL,
  name              VARCHAR(255) NOT NULL ,
  created_time      BIGINT(40) NOT NULL ,
  modified_time     BIGINT(40) NOT NULL
);

-- 文章和分类关系表
DROP TABLE IF EXISTS article_category_rel;
CREATE TABLE article_category_rel
(
  id                BIGINT(20) AUTO_INCREMENT PRIMARY KEY NOT NULL,
  category_id       BIGINT(20) NOT NULL,
  article_id        BIGINT(20) NOT NULL,
  created_time      BIGINT(40) NOT NULL,
  modified_time     BIGINT(40) NOT NULL
);


DROP TABLE IF EXISTS comment;
CREATE TABLE comment
(
  id                BIGINT(20) AUTO_INCREMENT PRIMARY KEY NOT NULL,
  name              VARCHAR(255) NOT NULL ,
  content           VARCHAR(255) NOT NULL ,
  email             VARCHAR(255) ,
  status            INT NOT NULL ,
  article_id        BIGINT(20) NOT NULL ,
  p_id              BIGINT(20) NOT NULL ,
  created_time      BIGINT(40) NOT NULL ,
  modified_time     BIGINT(40) NOT NULL
);

DROP TABLE IF EXISTS tag;
CREATE TABLE tag
(
  id            BIGINT(20) AUTO_INCREMENT PRIMARY KEY NOT NULL,
  name          VARCHAR(255) NOT NULL ,
  created_time      BIGINT(40) NOT NULL ,
  modified_time     BIGINT(40) NOT NULL
);

DROP TABLE IF EXISTS article_tag_rel;
CREATE TABLE article_tag_rel
(
  id            BIGINT(20) AUTO_INCREMENT PRIMARY KEY NOT NULL ,
  article_id    BIGINT(20) NOT NULL ,
  tag_id        BIGINT(20) NOT NULL ,
  created_time      BIGINT(40) NOT NULL ,
  modified_time     BIGINT(40) NOT NULL
);



