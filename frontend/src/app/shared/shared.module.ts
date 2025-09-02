import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AppMaterialModule } from './app-material/app-material.module';
import { DialogErrorComponent } from './components/dialog-error/dialog-error.component';

@NgModule({
  declarations: [
    DialogErrorComponent
  ],
  imports: [
    CommonModule,
    AppMaterialModule
  ],
  exports: [
    AppMaterialModule
  ]
})
export class SharedModule { }
