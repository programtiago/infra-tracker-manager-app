import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { EquipmentType } from '../../model/equipmentType.';
import { EquipmentService } from '../../services/equipment.service';

@Component({
  selector: 'app-equipment-form',
  templateUrl: './equipment-form.component.html',
  styleUrl: './equipment-form.component.scss'
})
export class EquipmentFormComponent implements OnInit{

  newEquipmentForm!: FormGroup;
  equipmentCategories: EquipmentType[] = []

  constructor(private fb: FormBuilder, private equipmentService: EquipmentService){}

  ngOnInit(): void {
    this.newEquipmentForm = this.fb.group({
      description: ['', [Validators.required, Validators.minLength(10), Validators.maxLength(150)]],
      brand: ['', [Validators.required, Validators.minLength(4), Validators.maxLength(50)]],
      model: ['', [Validators.required, Validators.minLength(5), Validators.maxLength(50)]],
      sn: ['', Validators.required, [Validators.minLength(4), Validators.maxLength(30)]],
      equipmentCategory: ['', Validators.required],
      createdAt: [new Date(), Validators.required]
    })

    this.equipmentService.getEquipmentCategories().subscribe((res) => {
      this.equipmentCategories = res;
    })
  }
}
