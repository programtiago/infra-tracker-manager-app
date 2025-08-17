INSERT INTO TB_EMPLOYEE (
    id,
    first_name,
    last_name,
    email,
    worker_no,
    birthday_date,
    phone_number,
    function,
    created_at,
    updated_at,
    building_id
)
VALUES
('a9595535-294a-4b28-b214-006c5e537813', 'João', 'Silva', 'joao.silva@example.pt', '85300', '1985-03-12', '+351912345678', 'Housing', CURRENT_TIMESTAMP, null, '077f5047-593d-4cd3-89af-ce0cda21df4e'),
('227590f4-df0a-4889-9550-ce09507645d2', 'Maria', 'Fernandes', 'maria.fernandes@example.pt', '85301', '1990-07-21', '+351913456789', 'Packaging', CURRENT_TIMESTAMP, null, '1af28204-5295-46bd-bafa-3252ee91d37a'),
('2a1dc3e6-6dc5-4d81-82b5-bfb53930f203', 'Pedro', 'Costa', 'pedro.costa@example.pt', '85302', '1988-11-30', '+351914567890', 'Testing', CURRENT_TIMESTAMP, null, '077f5047-593d-4cd3-89af-ce0cda21df4e'),
('5d880eef-1f10-4c7f-a689-8406bc72ab34', 'Ana', 'Martins', 'ana.martins@example.pt', '85303', '1992-04-15', '+351915678901', 'Warehouse', CURRENT_TIMESTAMP, null, '7d6d7829-c0e7-414b-94b9-462b12cc7a98'),
('f68c89e2-93f2-4631-a491-c20abff0db24', 'Tiago', 'Rodrigues', 'tiago.rodrigues@example.pt', '85304', '1987-09-09', '+351916789012', 'Packaging', CURRENT_TIMESTAMP, null, '1af28204-5295-46bd-bafa-3252ee91d37a'),
('c4e8c65c-dfb3-49ac-b311-30ede204a2b8', 'Sofia', 'Pereira', 'sofia.pereira@example.pt', '85305', '1991-01-25', '+351917890123', 'Packaging', CURRENT_TIMESTAMP, null, '7d6d7829-c0e7-414b-94b9-462b12cc7a98'),
('ad5134a4-9b29-40d3-9871-e1b434affd31', 'Ricardo', 'Almeida', 'ricardo.almeida@example.pt', '85306', '1983-06-17', '+351918901234', 'Housing', CURRENT_TIMESTAMP, null, '1af28204-5295-46bd-bafa-3252ee91d37a'),
('c5f4d926-607b-42ff-a7d8-91d60b862f1d', 'Inês', 'Gonçalves', 'ines.goncalves@example.pt', '85307', '1995-10-05', '+351919012345', 'Packaging', CURRENT_TIMESTAMP, null, '1af28204-5295-46bd-bafa-3252ee91d37a'),
('703803e6-941b-4173-9bf1-9fae4fd718ab', 'Bruno', 'Sousa', 'bruno.sousa@example.pt', '85308', '1989-12-19', '+351910123456', 'Housing', CURRENT_TIMESTAMP, null, '7d6d7829-c0e7-414b-94b9-462b12cc7a98'),
('337585f6-6938-4f8f-9f44-7d3aa3f67b3b', 'Carla', 'Moura', 'carla.moura@example.pt', '85309', '1993-08-08', '+351911234567', 'Testing', CURRENT_TIMESTAMP, null, '077f5047-593d-4cd3-89af-ce0cda21df4e');