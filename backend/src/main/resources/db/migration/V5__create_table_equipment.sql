CREATE TABLE TB_EQUIPMENT (
    id uuid PRIMARY KEY NOT NULL,
    description VARCHAR(150) NOT NULL,
    brand VARCHAR(50) NOT NULL,
    model VARCHAR(50) NOT NULL,
    sn VARCHAR(30),
    is_active BOOLEAN DEFAULT TRUE NOT NULL,
    created_at TIMESTAMP NOT NULL,
    status_id uuid,
    equipment_category_id uuid,
    updated_at TIMESTAMP,

    CONSTRAINT fk_status FOREIGN KEY(status_id)
        REFERENCES TB_STATUS_EQUIPMENT(id),


    CONSTRAINT fk_category FOREIGN KEY(equipment_category_id)
        REFERENCES TB_EQUIPMENT_CATEGORY(id)
);