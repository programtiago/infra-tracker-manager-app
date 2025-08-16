CREATE TABLE TB_OPERATION_BUILDING (
    id uuid PRIMARY KEY NOT NULL,
    operation_id uuid NOT NULL,
    building_id uuid NOT NULL,
    assigned_at TIMESTAMP NOT NULL,
    UNIQUE (operation_id, building_id),
    FOREIGN KEY (operation_id) REFERENCES TB_OPERATION(id),
    FOREIGN KEY (building_id) REFERENCES TB_BUILDING(id)
);