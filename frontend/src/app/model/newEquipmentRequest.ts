export interface NewEquipmentRequest {
    id: string;
    brand: string;
    model: string;
    sn: string;
    isActive: boolean;
    createdAt: Date;
    equipment_category_id: string;
    equipment_status_id: string;
    updatedAt: Date;
}