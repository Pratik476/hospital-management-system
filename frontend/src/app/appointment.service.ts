import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AppointmentModel } from './models/appointment';

@Injectable({
  providedIn: 'root'
})
export class AppointmentService {

  private baseUrl = 'http://localhost:5050/api/v2/appointments';

  constructor(private http: HttpClient) {}

  // GET ALL
  getAllAppointments(): Observable<AppointmentModel[]> {
    return this.http.get<AppointmentModel[]>(this.baseUrl );
  }

  // CREATE
  createAppointment(app: AppointmentModel): Observable<AppointmentModel> {
    return this.http.post<AppointmentModel>(this.baseUrl , app);
  }

   // ✅ DELETE appointment
  deleteAppointment(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`);
  }
}
