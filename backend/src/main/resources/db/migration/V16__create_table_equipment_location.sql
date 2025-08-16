CREATE TABLE TB_EQUIPMENT_LOCATION (
    id uuid PRIMARY KEY NOT NULL,
    equipment_id uuid NOT NULL,
    location_id uuid NOT NULL,
    assigned_at TIMESTAMP NOT NULL,
    UNIQUE (equipment_id, location_id),
    FOREIGN KEY (equipment_id) REFERENCES TB_EQUIPMENT(id),
    FOREIGN KEY (location_id) REFERENCES TB_LOCATION(id)
);