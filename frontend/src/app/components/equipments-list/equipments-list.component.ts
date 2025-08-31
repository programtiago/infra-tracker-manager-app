import { Component } from '@angular/core';
import { Equipment } from '../../model/equipment';
import { EquipmentService } from '../../services/equipment.service';

@Component({
  selector: 'app-equipments-list',
  templateUrl: './equipments-list.component.html',
  styleUrl: './equipments-list.component.scss'
})
export class EquipmentsListComponent {

  displayedColumns = ['description', 'brand', 'model', 'sn', 'isActive', 'createdAt', 'statusEquipment']

  equipments: Equipment[] = []

  constructor(private equipmentService: EquipmentService){
    this.equipmentService.getAll().subscribe((res) => {
      this.equipments = res;
      console.log(res)
    })
  }
}
