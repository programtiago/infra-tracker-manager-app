import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { EquipmentType } from '../../model/equipmentType.';
import { EquipmentService } from '../../services/equipment.service';
import { NewEquipmentRequest } from '../../model/newEquipmentRequest';
import { formatDate, Location } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-equipment-form',
  templateUrl: './equipment-form.component.html',
  styleUrl: './equipment-form.component.scss'
})
export class EquipmentFormComponent implements OnInit{

  equipmentForm!: FormGroup;
  equipmentCategories: EquipmentType[] = []

  isEditMode = false;
  equipmentId: string | null = null;

  constructor(private fb: FormBuilder, 
              private equipmentService: EquipmentService, 
              private router: Router, 
              private snackbar: MatSnackBar,
              private location: Location,
              private route: ActivatedRoute){}

  ngOnInit(): void {
    this.equipmentId = this.route.snapshot.paramMap.get('id');
    this.isEditMode = !!this.equipmentId;

    this.initializeForm();

    if (this.isEditMode && this.equipmentId){
      this.loadEquipment(this.equipmentId)
    }

    this.equipmentService.getEquipmentCategories().subscribe((res) => {
      this.equipmentCategories = res;
    })
  }

  onSave(){
    if (!this.isEditMode){
      const request: NewEquipmentRequest = {
      ...this.equipmentForm.value,
      createdAt: formatDate(this.equipmentForm.value.createdAt, "yyyy-MM-dd HH:mm:ss", 'en-US')
    }

    console.log("Date", request.createdAt)

      if (this.equipmentForm.valid){
        this.equipmentService.createEquipment(request).subscribe((res) => {
          if (res.id != null){
            this.snackbar.open(`Equipment created sucessfully with S/N: ${res.sn} `, '', {
              duration: 5000,
              horizontalPosition: 'right',
              verticalPosition: 'top'
            })
            console.log('Equipment created sucessfully ! ', request)
            console.log('Data of Equipment created', res)
            this.router.navigateByUrl('/equipments');
          }
        })
      }
    }else{
      if (this.equipmentId){
        this.equipmentService.updateEquipment(this.equipmentId, this.equipmentForm.value).subscribe((res) => {
          if (res.id != null){
            console.log('Data update sucessfully', res)
            this.router.navigateByUrl('/equipments');
            this.snackbar.open(`Equipment updated sucessfully with S/N: ${res.sn} `, '', {
              duration: 5000,
              horizontalPosition: 'right',
              verticalPosition: 'top'
            })
          }
        })
      }
    }
  }

  onCancel(){
    this.location.back();
  }

  initializeForm(){
    this.equipmentForm = this.fb.group({
      id: [''],
      description: ['', [Validators.required, Validators.minLength(10), Validators.maxLength(150)]],
      brand: ['', [Validators.required, Validators.minLength(4), Validators.maxLength(50)]],
      model: ['', [Validators.required, Validators.minLength(5), Validators.maxLength(50)]],
      sn: ['', [Validators.required, Validators.minLength(4), Validators.maxLength(30)]],
      equipment_category_id: ['', Validators.required],
      createdAt: [],
      status_id: [''],
      updatedAt: ['']
    })
  }

  loadEquipment(id: string){
    this.equipmentService.findById(id).subscribe(equipment => {
      this.equipmentForm.patchValue({
        description: equipment.description,
        brand: equipment.brand,
        model: equipment.model,
        sn: equipment.sn,
        equipment_category_id: equipment.equipment_category_id,
        status_id: equipment.statusEquipment?.id || '',
        createdAt: equipment.createdAt,
        updatedAt: equipment.updatedAt
      })
    });
  }
}
