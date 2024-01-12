import { Component } from '@angular/core';
import { OrganiseService } from '../organise.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-corporateev',
  templateUrl: './corporateev.component.html',
  styleUrls: ['./corporateev.component.css']
})
export class CorporateevComponent {
  catering : any;
  decoration:any;
  drinks:any;
  


  constructor(private router: Router, private service: OrganiseService) {

  }
  ngOnInit() {
    this.service.getCcaterings().subscribe((empData: any) => {
      this.catering = empData;
      console.log(empData);
    });
      this.service.getCdecorations().subscribe((empData: any) => {
        this.decoration = empData;
        console.log(empData);    
      });
        this.service.getCdrinks().subscribe((empData: any) => {
          this.drinks = empData;
          console.log(empData);
        });
         }  

         addToCart(product: any) {
          this.service.addToCart(product);
        }
  


}

