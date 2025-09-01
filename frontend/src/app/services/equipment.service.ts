import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Equipment } from '../model/equipment';
import { Observable } from 'rxjs';
import { StatusEquipment } from '../model/status-equipment';
import { EquipmentType } from '../model/equipmentType.';

const API_URL = '/api'

@Injectable({
  providedIn: 'root'
})
export class EquipmentService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<Equipment[]> {
    return this.http.get<Equipment[]>(`${API_URL}/equipments`)
  }

  getStatusDescription(id: string): Observable<StatusEquipment>{
    return this.http.get<StatusEquipment>(`${API_URL}/status/${id}`)
  }

  getEquipmentCategories(): Observable<EquipmentType[]> {
    return this.http.get<EquipmentType[]>(`${API_URL}/equipment-types`)
  }
}
