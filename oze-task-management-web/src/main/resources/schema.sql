DROP SCHEMA IF EXISTS OZE CASCADE;

-- create schema
CREATE SCHEMA IF NOT EXISTS OZE;

-- create tables

-- users table
CREATE TABLE OZE.USERS
(
    USER_ID UUID NOT NULL,
    FIRST_NAME VARCHAR(30) NOT NULL,
    LAST_NAME VARCHAR(30) NOT NULL,
    EMAIL VARCHAR(100) NOT NULL UNIQUE,
    PASSWORD VARCHAR(250) NOT NULL,
    CREATE_USER VARCHAR(50) DEFAULT CURRENT_USER,
    CREATE_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    LAST_UPDATE_USER VARCHAR(50) DEFAULT CURRENT_USER,
    LAST_UPDATE_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT USER_PK PRIMARY KEY (USER_ID)
);

CREATE INDEX IDX_USERS_EMAIL ON OZE.USERS(EMAIL);

-- task type
CREATE TABLE OZE.TASK_TYPE
(
    TASK_TYPE_ID VARCHAR(20) NOT NULL,
    DESCRIPTION VARCHAR(250),
    CREATE_USER VARCHAR(50) DEFAULT CURRENT_USER,
    CREATE_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    LAST_UPDATE_USER VARCHAR(50) DEFAULT CURRENT_USER,
    LAST_UPDATE_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT TASK_TYPE_PK PRIMARY KEY (TASK_TYPE_ID)
);


-- task
CREATE TABLE OZE.TASK
(
    TASK_ID UUID NOT NULL,
    TITLE VARCHAR(50) NOT NULL,
    DESCRIPTION VARCHAR(250),
    STATUS VARCHAR(20),
    TASK_TYPE_ID VARCHAR(20) NOT NULL,
    TASK_DATE DATE DEFAULT CURRENT_DATE,
    COMPLETION_DATE DATE,
    CREATE_USER VARCHAR(50) DEFAULT CURRENT_USER,
    CREATE_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    LAST_UPDATE_USER VARCHAR(50) DEFAULT current_user,
    LAST_UPDATE_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT TASK_PK PRIMARY KEY (TASK_ID),
    CONSTRAINT TASK_TASK_TYPE_FK FOREIGN KEY (TASK_TYPE_ID) REFERENCES TASK_TYPE(TASK_TYPE_ID)
);


-- comments for a task
CREATE TABLE OZE.TASK_COMMENT
(
    TASK_COMMENT_ID UUID NOT NULL,
    TASK_ID UUID NOT NULL,
    COMMENT VARCHAR(250) NOT NULL DEFAULT '',
    CREATE_USER VARCHAR(50) DEFAULT CURRENT_USER,
    CREATE_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    LAST_UPDATE_USER VARCHAR(50) DEFAULT current_user,
    LAST_UPDATE_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT TASK_COMMENT_PK PRIMARY KEY (TASK_COMMENT_ID),
    CONSTRAINT TASK_COMMENT_TASK_FK FOREIGN KEY (TASK_ID) REFERENCES TASK(TASK_ID)
);