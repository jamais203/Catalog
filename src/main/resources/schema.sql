DROP TABLE IF EXISTS product;

CREATE TABLE product(
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    price NUMBER(10) NOT NULL,
    description VARCHAR(300)
);

