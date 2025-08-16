CREATE TABLE TB_LOCATION_EMPLOYEE (
    id uuid PRIMARY KEY NOT NULL,
    location_id uuid NOT NULL,
    employee_id uuid NOT NULL,
    assigned_at TIMESTAMP NOT NULL,
    UNIQUE (employee_id, location_id),
    FOREIGN KEY (location_id) REFERENCES TB_LOCATION(id),
    FOREIGN KEY (employee_id) REFERENCES TB_EMPLOYEE(id)
);