DROP TABLE IF EXISTS xdevice
CREATE TABLE xdevice (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(40) NOT NULL,
    description VARCHAR(255) NOT NULL,
    hcpoffice_name VARCHAR(40) NOT NULL,
    CONSTRAINT fk_hcpoffice
    FOREIGN KEY (hcpoffice_name)
            REFERENCES hcpoffice(name)
            ON UPDATE CASCADE
            ON DELETE CASCADE
);

DROP TABLE IF EXISTS hcpoffice
CREATE TABLE hcpoffice(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(40) NOT NULL,
    description VARCHAR(255) NOT NULL,
);