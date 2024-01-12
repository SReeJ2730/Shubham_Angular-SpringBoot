import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OrganiseService } from '../organise.service';
@Component({
  selector: 'app-bwed',
  templateUrl: './bwed.component.html',
  styleUrls: ['./bwed.component.css']
})
export class BwedComponent implements OnInit {

  catering : any;
  decoration:any;
  photography:any;
  makeup:any;
  music:any;



  constructor(private router: Router, private service: OrganiseService) {

  }
  ngOnInit() {
    this.service.getWcaterings().subscribe((empData: any) => {
      this.catering = empData;
      console.log(empData);
    });

      this.service.getWdecorations().subscribe((empData: any) => {
        this.decoration = empData;
        console.log(empData);    
      });

        this.service.getWphotographys().subscribe((empData: any) => {
          this.photography = empData;
          console.log(empData);
        });

          this.service.getWmakeups().subscribe((empData: any) => {
            this.makeup = empData;
            console.log(empData);
          });
          
            this.service.getWmusics().subscribe((empData: any) => {
              this.music = empData;
              console.log(empData);

      });}  

      addToCart(product: any) {
        this.service.addToCart(product);
      }

}