CREATE TABLE TB_EMPLOYEE (
    id uuid PRIMARY KEY NOT NULL,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(20) NOT NULL,
    email VARCHAR(100),
    worker_no VARCHAR(4) UNIQUE NOT NULL,
    birthday_date VARCHAR(10) NOT NULL,
    phone_number VARCHAR(20) NOT NULL,
    function VARCHAR(50) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP
);