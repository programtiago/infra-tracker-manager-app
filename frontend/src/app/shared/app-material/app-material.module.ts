import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatTableModule } from '@angular/material/table';
import {MatTooltipModule} from '@angular/material/tooltip';


@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    MatCardModule,
    MatTableModule,
    MatTooltipModule
  ],
  exports: [
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    MatCardModule,
    MatTableModule,
    MatTooltipModule
  ]
})
export class AppMaterialModule { }
