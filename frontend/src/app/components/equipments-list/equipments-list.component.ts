import { Component } from '@angular/core';
import { Equipment } from '../../model/equipment';

@Component({
  selector: 'app-equipments-list',
  templateUrl: './equipments-list.component.html',
  styleUrl: './equipments-list.component.scss'
})
export class EquipmentsListComponent {

  displayedColumns = ['description', 'brand', 'model', 'sn', 'isActive', 'createdAt', 'statusEquipment']

  equipments: Equipment[] = [
    { 
      description: "Laptop HP EliteBook", 
      brand: 'HP',
      model: 'EliteBook 840 G7',
      sn: 'SN123456',
      isActive: true,
      createdAt: "2025-08-22T10:00:00",
      statusEquipment: "Available"
    },
    {
      description: "Dell Monitor",
      brand: "Dell",
      model: "P2419H",
      sn: "SN654321",
      isActive: false,
      createdAt: "2024-12-15T09:30:00",
      statusEquipment: "In Warranty"
    }
  ]
}
