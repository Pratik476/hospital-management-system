import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AppointmentService } from '../appointment.service';
import { AppointmentModel } from '../models/appointment';

@Component({
  selector: 'app-appointment',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './appointment.html',
  styleUrls: ['./appointment.css']
})
export class AppointmentComponent implements OnInit {

  appointments: AppointmentModel[] = [];
  loading = false;

  constructor(
    private service: AppointmentService,
    private cdr: ChangeDetectorRef   // 🔥 ADD THIS
  ) {}

  ngOnInit(): void {
    this.loadAppointments();
  }

  loadAppointments(): void {
    this.loading = true;

    this.service.getAllAppointments().subscribe({
      next: (data) => {
        this.appointments = data ?? [];
        this.loading = false;

        this.cdr.detectChanges(); // 🔥 MAIN FIX
      },
      error: () => {
        this.appointments = [];
        this.loading = false;
        this.cdr.detectChanges(); // 🔥
      }
    });
  }

  deleteAppointment(id: number) {
    if (!confirm('Delete this appointment?')) return;

    this.service.deleteAppointment(id).subscribe(() => {
      this.loadAppointments();
    });
  }
}
