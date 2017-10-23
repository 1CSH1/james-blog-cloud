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