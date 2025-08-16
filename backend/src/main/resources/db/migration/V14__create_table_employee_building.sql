CREATE TABLE TB_EMPLOYEE_BUILDING (
    id uuid PRIMARY KEY NOT NULL,
    employee_id uuid NOT NULL,
    building_id uuid NOT NULL,
    assigned_at TIMESTAMP NOT NULL,
    UNIQUE (employee_id, building_id),
    FOREIGN KEY (employee_id) REFERENCES TB_EMPLOYEE(id),
    FOREIGN KEY (building_id) REFERENCES TB_BUILDING(id)
);