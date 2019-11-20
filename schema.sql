SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS hcpoffice;
CREATE TABLE hcpoffice(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(40) NOT NULL,
    description VARCHAR(255) NOT NULL
)ENGINE=InnoDB;

DROP TABLE IF EXISTS xdevice;
CREATE TABLE xdevice (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(40) NOT NULL,
    description VARCHAR(255) NOT NULL,
    hcpoffice_id INT,
    CONSTRAINT fk_hcpoffice FOREIGN KEY (hcpoffice_id)
            REFERENCES hcpoffice(id)
            ON UPDATE CASCADE
            ON DELETE CASCADE
)ENGINE=InnoDB;