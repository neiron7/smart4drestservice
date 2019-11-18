INSERT INTO hcpoffice(name, description)
VALUES
    ('Office_1', 'first office'),
    ('Office_2', 'second office');

INSERT INTO xdevice(name, description, hcpoffice_id)
VALUES
    ('Device_1', 'first device', 1),
    ('Device_2', 'second device', 2),
    ('Device_3', 'third device', 2);