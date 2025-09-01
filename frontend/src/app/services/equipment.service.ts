import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Equipment } from '../model/equipment';
import { Observable } from 'rxjs';
import { StatusEquipment } from '../model/status-equipment';
import { EquipmentType } from '../model/equipmentType.';
import { NewEquipmentRequest } from '../model/newEquipmentRequest';

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

  createEquipment(request: NewEquipmentRequest): Observable<Equipment>{
    return this.http.post<Equipment>(`${API_URL}/equipments/new`, request);
  }

  findById(id: string): Observable<Equipment>{
    return this.http.get<Equipment>(`${API_URL}/equipments/${id}`)
  }

  updateEquipment(id: string, request: NewEquipmentRequest){
    return this.http.put<NewEquipmentRequest>(`${API_URL}/equipments/${id}`, request)
  }
}
