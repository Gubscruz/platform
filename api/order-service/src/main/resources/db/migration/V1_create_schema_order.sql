CREATE SCHEMA IF NOT EXISTS "order";

CREATE TABLE "order".orders (
    id_order VARCHAR(36) NOT NULL,
    date TIMESTAMP NOT NULL,
    total DECIMAL(10,2) NOT NULL,
    id_user VARCHAR(36) NOT NULL,
    CONSTRAINT pk_orders PRIMARY KEY (id_order)
);

CREATE TABLE "order".item (
    id_item VARCHAR(36) NOT NULL,
    id_order VARCHAR(36) NOT NULL,
    id_product VARCHAR(36) NOT NULL,
    quantity INT NOT NULL,
    item_price DECIMAL(10,2) NOT NULL,
    CONSTRAINT pk_item PRIMARY KEY (id_item),
    CONSTRAINT fk_item_order FOREIGN KEY (id_order) REFERENCES "order".orders(id_order)
);