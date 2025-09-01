import { Component, OnInit } from '@angular/core';
import { Equipment } from '../../model/equipment';
import { EquipmentService } from '../../services/equipment.service';

@Component({
  selector: 'app-equipments-list',
  templateUrl: './equipments-list.component.html',
  styleUrl: './equipments-list.component.scss'
})
export class EquipmentsListComponent implements OnInit{

  displayedColumns = ['description', 'brand', 'model', 'sn', 'createdAt', 'statusEquipment']

  statusDescriptions: { [key: string]: string } = {}
  statusDescription: string = 'Loading...';

  equipments: Equipment[] = []

  constructor(private equipmentService: EquipmentService){
    this.equipmentService.getAll().subscribe((res) => {
      this.equipments = res;
    })
  }

  ngOnInit(): void {
    this.equipments.forEach(equipment => {
      this.getStatusDescription(equipment.statusEquipment.id.toString())
    })
  }

  getStatusDescription(id: string): string{
    if (this.statusDescriptions[id]) {
      return this.statusDescriptions[id];
  }

  this.statusDescriptions[id] = 'Loading...';

  this.equipmentService.getStatusDescription(id).subscribe(
    (res) => this.statusDescriptions[id] = res.description,
    (err) => this.statusDescriptions[id] = 'Unknown'
  );

  return this.statusDescriptions[id];
  }

  getStatusColor(description: string): string {
    switch (description){
      case 'Available':
        return 'green'
      case 'Allocated':
        return 'red'
      case 'For Warranty':
        return 'orange'
      case 'Damaged':
        return 'red'  
      case 'For Scrapping':
        return 'red'     
      default:
        return 'grey'    
    }
  }
}
