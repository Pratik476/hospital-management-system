import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AppointmentModel } from '../models/appointment';
import { AppointmentService } from '../appointment.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-appointment',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './create-appointment.html',
  styleUrls: ['./create-appointment.css'],
})
export class CreateAppointment {

  appointment: AppointmentModel = new AppointmentModel();

  constructor(
    private appointmentservice: AppointmentService,
    private router: Router
  ) {}

  save() {
    this.appointmentservice
      .createAppointment(this.appointment)
      .subscribe({
        next: data => {
          console.log(data);
          this.goToAppointment();
        },
        error: err => console.error(err)
      });
  }

  onSubmit() {
    this.save();
  }

  goToAppointment() {
  this.router.navigate(['/appointments']); // ✔️ correct
}

}
