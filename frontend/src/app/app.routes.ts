import { Routes } from '@angular/router';

export const routes: Routes = [

  // ✅ DEFAULT → HOME
  { path: '', redirectTo: 'home', pathMatch: 'full' },

  {
    path: 'home',
    loadComponent: () =>
      import('./home/home').then(m => m.Home)
  },

  {
    path: 'appointments',
    loadComponent: () =>
      import('./appointment/appointment')
        .then(m => m.AppointmentComponent)
  },

  {
    path: 'patients',
    loadComponent: () =>
      import('./admindash/admindash')
        .then(m => m.Admindash)
  },

  {
    path: 'create-appointment',
    loadComponent: () =>
      import('./create-appointment/create-appointment')
        .then(m => m.CreateAppointment)
  },

  // ❌ wrong URL → HOME
  { path: '**', redirectTo: 'home' }
];
