import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EquipmentsListComponent } from './components/equipments-list/equipments-list.component';
import { EquipmentFormComponent } from './components/equipment-form/equipment-form.component';

const routes: Routes = [
  { path: 'equipments', component: EquipmentsListComponent },
  { path: 'new-equipment', component: EquipmentFormComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
