import { Component } from '@angular/core';
import { Equipment } from '../../model/equipment';
import { EquipmentService } from '../../services/equipment.service';

@Component({
  selector: 'app-equipments-list',
  templateUrl: './equipments-list.component.html',
  styleUrl: './equipments-list.component.scss'
})
export class EquipmentsListComponent {

  displayedColumns = ['description', 'brand', 'model', 'sn', 'createdAt', 'statusEquipment']

  statusDescriptions: { [key: string]: string } = {}
  statusDescription: string = 'Loading...';

  equipments: Equipment[] = []

  constructor(private equipmentService: EquipmentService){
    this.equipmentService.getAll().subscribe((res) => {
      this.equipments = res;
    })
  }

  getStatusDescription(id: string): string{
    if (this.statusDescriptions[id]){
      return this.statusDescriptions[id];
    }

    this.statusDescriptions[id] = 'Loading...';

    this.equipmentService.getStatusDescription(id).subscribe((res) => {
      this.statusDescriptions[id] = res.description;
      },
      (error) => {
        this.statusDescriptions[id] = 'Uknown';
      }
    );

    return this.statusDescriptions[id];
  }
}
