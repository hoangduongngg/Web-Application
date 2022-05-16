SET SQL_SAFE_UPDATES = 0;
delete from product;
INSERT INTO product (id, description, price) VALUES ('1', ' Product 1', 14.956);
INSERT INTO product (id, description, price) VALUES ('2', ' Product 2', 12.95);
SET SQL_SAFE_UPDATES = 1;