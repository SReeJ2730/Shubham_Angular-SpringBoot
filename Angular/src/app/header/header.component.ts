import { Component, OnInit } from '@angular/core';
import { OrganiseService } from '../organise.service';
import { Router } from '@angular/router'; 

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  loginStatus: any;
  showServicesDropdown: boolean = false;
   showeventDropdown:boolean=false;
   bookItems: any;

  
  toggleServicesDropdown() {
    this.showServicesDropdown = !this.showServicesDropdown;
  }
  toggleeventDropdown() {
    this.showeventDropdown = this.showeventDropdown;
  }

  constructor(private service: OrganiseService,private router: Router ) {
    this.bookItems = service.bookItems;
  }

  ngOnInit() {
    this.service.getLoginStatus().subscribe((data: any) => {
      this.loginStatus = data;
    });
  }
  navigateTo(serviceCategory: string) {
    this.router.navigate([serviceCategory]);
  }

}