--liquibase formatted sql

--changeset ganesh:1
CREATE TABLE book (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    author VARCHAR(100) NOT NULL,
    isbn VARCHAR(50) NOT NULL
);

--rollback DROP TABLE book;