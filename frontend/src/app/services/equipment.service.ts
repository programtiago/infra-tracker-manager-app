import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Equipment } from '../model/equipment';
import { Observable } from 'rxjs';

const API_URL = '/api'

@Injectable({
  providedIn: 'root'
})
export class EquipmentService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<Equipment[]> {
    return this.http.get<Equipment[]>(`${API_URL}/equipments`)
  }
}
