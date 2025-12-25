import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PatientService } from '../patient.service';
import { Patients } from '../patients';

@Component({
  selector: 'app-admindash',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './admindash.html',
  styleUrls: ['./admindash.css']
})
export class Admindash implements OnInit {

  patients: Patients[] = [];

  constructor(private patientService: PatientService) {}

  ngOnInit(): void {
    this.loadPatients();
  }

  loadPatients(): void {
    this.patientService.getPatientList().subscribe({
      next: data => {
        console.log('PATIENTS API 👉', data);
        this.patients = data;
      },
      error: err => console.error('PATIENT API ERROR ❌', err)
    });
  }
}
