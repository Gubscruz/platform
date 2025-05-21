CREATE TABLE order.item (
    id_item       VARCHAR(36)         NOT NULL,
    id_order      VARCHAR(36)         NOT NULL,
    quantity      INT                 NOT NULL,
    id_product    VARCHAR(36)         NOT NULL,
    item_price   DECIMAL(10, 2)     NOT NULL,
    CONSTRAINT pk_item PRIMARY KEY (id_item),
    CONSTRAINT fk_product FOREIGN KEY (id_product) REFERENCES product(id_product)
    CONSTRAINT fk_order FOREIGN KEY (id_order) REFERENCES order(id_order)
);
