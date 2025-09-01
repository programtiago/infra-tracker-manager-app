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
  updatedAt: Date
}