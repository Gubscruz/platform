CREATE TABLE store_order.orders (
    id_order   VARCHAR(36)    NOT NULL PRIMARY KEY,
    date       TIMESTAMP      NOT NULL,
    total      DECIMAL(10,2)  NOT NULL,
    id_user    VARCHAR(36)    NOT NULL
);

CREATE TABLE store_order.item (
    id_item    VARCHAR(36)    NOT NULL PRIMARY KEY,
    id_order   VARCHAR(36)    NOT NULL,
    id_product VARCHAR(36)    NOT NULL,
    quantity   INT            NOT NULL,
    item_price DECIMAL(10,2)  NOT NULL,
    CONSTRAINT fk_item_order FOREIGN KEY (id_order)
        REFERENCES store_order.orders(id_order)
);