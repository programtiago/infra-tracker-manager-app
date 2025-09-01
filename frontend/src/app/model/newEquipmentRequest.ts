export interface NewEquipmentRequest {
    id: string;
    brand: string;
    model: string;
    sn: string;
    isActive: boolean;
    createdAt: Date;
    equipment_category_id: string;
    updatedAt: Date;
}