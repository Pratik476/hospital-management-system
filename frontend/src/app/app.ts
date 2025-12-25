import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterOutlet, RouterLink } from '@angular/router';


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    RouterOutlet,
    RouterLink        // 🔥 THIS WAS MISSING
  ],
  templateUrl: './app.html',
  styleUrls: ['./app.css']
})
export class AppComponent {


 
}

