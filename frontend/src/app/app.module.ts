import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { SharedModule } from './shared/shared.module';
import { ToolbarComponent } from './components/toolbar/toolbar.component';
import { EquipmentsListComponent } from './components/equipments-list/equipments-list.component';
import { provideHttpClient, withInterceptors } from '@angular/common/http';
import { EquipmentFormComponent } from './components/equipment-form/equipment-form.component';
import { errorInterceptor } from './core/interceptors/error.interceptor';

@NgModule({
  declarations: [
    AppComponent,
    ToolbarComponent,
    EquipmentsListComponent,
    EquipmentFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    SharedModule
  ],
  providers: [
    provideAnimationsAsync(),
    provideHttpClient(
      withInterceptors([errorInterceptor])
    )
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
