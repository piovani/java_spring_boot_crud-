ALTER TABLE products ADD COLUMN active BOOLEAN;
UPDATE products SET active = true;