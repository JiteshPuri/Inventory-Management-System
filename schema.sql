create database inventory_db;
use inventory_db;

CREATE TABLE Medication (
    medication_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    description TEXT,
    price DECIMAL(10, 2),
    quantity_in_stock INT
);

CREATE TABLE Supplier (
    supplier_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100),
    phone_number VARCHAR(15),
    address TEXT
);

CREATE TABLE Inventory (
    inventory_id INT PRIMARY KEY AUTO_INCREMENT,
    medication_id INT,
    supplier_id INT,
    quantity_received INT,
    date_received DATE,
    FOREIGN KEY (medication_id) REFERENCES Medication(medication_id),
    FOREIGN KEY (supplier_id) REFERENCES Supplier(supplier_id)
);
