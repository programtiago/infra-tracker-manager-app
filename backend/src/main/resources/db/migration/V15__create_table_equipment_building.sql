CREATE TABLE TB_EQUIPMENT_BUILDING (
    id uuid PRIMARY KEY NOT NULL,
    equipment_id uuid NOT NULL,
    building_id uuid NOT NULL,
    assigned_at TIMESTAMP NOT NULL,
    UNIQUE (equipment_id, building_id),
    FOREIGN KEY (equipment_id) REFERENCES TB_EQUIPMENT(id),
    FOREIGN KEY (building_id) REFERENCES TB_BUILDING(id)
);