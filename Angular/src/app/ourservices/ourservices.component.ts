import { Component } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-ourservices',
  templateUrl: './ourservices.component.html',
  styleUrls: ['./ourservices.component.css']
})
export class OurservicesComponent {
  selectedService: string | undefined;

  constructor(private router: Router) {}

  navigateToService() {
    if (this.selectedService) {
      this.router.navigate([this.selectedService]);
    }
  }

}
