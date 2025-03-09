-- FIXME: write sql query that creates article and tag tables

-- create tables
-- article table
CREATE TABLE article (

                         id BIGINT AUTO_INCREMENT NOT NULL,
                         title VARCHAR(100) NOT NULL,
                         content TEXT NOT NULL,
                         CONSTRAINT article_pk PRIMARY KEY(id)
);

-- tag
CREATE TABLE tag
(
    id BIGINT AUTO_INCREMENT NOT NULL,
    article_id BIGINT NOT NULL,
    tag VARCHAR(50) NOT NULL,
    CONSTRAINT tag_pk PRIMARY KEY(id),
    CONSTRAINT tag_article_fk FOREIGN KEY (article_id) REFERENCES article(id)

);