CREATE TABLE product (
    id_product    VARCHAR(36)         NOT NULL,
    name          VARCHAR(256)        NOT NULL,
    category      VARCHAR(256)        NOT NULL,
    description   VARCHAR(512)        NULL,
    price         DOUBLE PRECISION    NOT NULL,
    creation   TIMESTAMP           NOT NULL,
    update     TIMESTAMP           NOT NULL,
    CONSTRAINT pk_product PRIMARY KEY (id_product)
);