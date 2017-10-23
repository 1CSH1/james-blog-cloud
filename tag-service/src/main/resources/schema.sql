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