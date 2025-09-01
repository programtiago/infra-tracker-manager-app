import { EquipmentType } from "./equipmentType.";
import { StatusEquipment } from "./status-equipment";

export interface Equipment {
  id: string;
  description: string;
  brand: string;
  model: string;
  sn: string;
  isActive: boolean;
  createdAt: string;
  statusEquipment: StatusEquipment;
  equipment_category_id: EquipmentType;
  updatedAt: Date
}