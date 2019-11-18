INSERT INTO hcpoffice(name, description)
VALUES
    ('Office_1', 'first office'),
    ('Office_2', 'second office');

INSERT INTO xdevice(name, description)
VALUES
    ('Device_1', 'first device', 'Office_1'),
    ('Device_2', 'second device', 'Office_1'),
    ('Device_3', 'third device', 'Office_2');