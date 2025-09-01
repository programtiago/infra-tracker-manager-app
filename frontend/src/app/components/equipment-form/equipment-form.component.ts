import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-equipment-form',
  templateUrl: './equipment-form.component.html',
  styleUrl: './equipment-form.component.scss'
})
export class EquipmentFormComponent {

  newEquipmentForm!: FormGroup;

  constructor(private fb: FormBuilder){}

}
