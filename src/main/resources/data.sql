CREATE TABLE IF NOT EXISTS Dog (
    id INT PRIMARY KEY auto_increment,
    name VARCHAR(255),
    breed VARCHAR(255),
    origin VARCHAR(255)
);

INSERT INTO Dog (id, name, breed, origin) VALUES (1, 'Fluffy', 'Pomeranian', 'Mountain View, CA');
INSERT INTO Dog (id, name, breed, origin) VALUES (2, 'Spot', 'Pit Bull', 'Austin, TX');
INSERT INTO Dog (id, name, breed, origin) VALUES (3, 'Ginger', 'Cocker Spaniel', 'Kansas City, KS');
INSERT INTO Dog (id, name, breed, origin) VALUES (4, 'Lady', 'Direwolf', 'The North');
INSERT INTO Dog (id, name, breed, origin) VALUES (5, 'Sasha', 'Husky', 'Buffalo, NY');