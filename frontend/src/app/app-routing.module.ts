import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EquipmentsListComponent } from './components/equipments-list/equipments-list.component';

const routes: Routes = [
  { path: 'equipments', component: EquipmentsListComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
