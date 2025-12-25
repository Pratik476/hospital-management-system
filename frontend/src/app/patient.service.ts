import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Patients } from './patients';

@Injectable({
  providedIn: 'root'
})
export class PatientService {

  private baseUrl = 'http://localhost:5050/api/v1';

  constructor(private http: HttpClient) {}

  getPatientList(): Observable<Patients[]> {
    return this.http.get<Patients[]>(this.baseUrl);
  }
}
