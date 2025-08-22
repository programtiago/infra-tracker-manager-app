CREATE TABLE TB_LOCATION (
    id uuid PRIMARY KEY NOT NULL,
    name VARCHAR(30) NOT NULL,
    is_active BOOLEAN DEFAULT TRUE,
    is_available BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP NOT NULL,
    building_id uuid NOT NULL,
    FOREIGN KEY (building_id) REFERENCES TB_BUILDING(id)
);