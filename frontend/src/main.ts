import { bootstrapApplication } from '@angular/platform-browser';
import {
  provideRouter,
  withRouterConfig,
  withEnabledBlockingInitialNavigation   // 🔥 ADD THIS
} from '@angular/router';
import { provideHttpClient } from '@angular/common/http';

import { AppComponent } from './app/app';
import { routes } from './app/app.routes';

bootstrapApplication(AppComponent, {
  providers: [
    provideRouter(
      routes,
      withEnabledBlockingInitialNavigation(), // 🔥 MAIN FIX
      withRouterConfig({
        onSameUrlNavigation: 'reload'
      })
    ),
    provideHttpClient()
  ]
}).catch(err => console.error(err));
