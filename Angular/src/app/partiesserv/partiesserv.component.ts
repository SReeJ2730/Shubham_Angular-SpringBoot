import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OrganiseService } from '../organise.service';

@Component({
  selector: 'app-partiesserv',
  templateUrl: './partiesserv.component.html',
  styleUrls: ['./partiesserv.component.css']
})
export class PartiesservComponent implements OnInit {
  catering : any;
  decoration:any;
  photography:any;
  music:any;

  constructor(private router: Router, private service: OrganiseService) {
  }
  ngOnInit() {
    this.service.getPcaterings().subscribe((empData: any) => {
      this.catering = empData;
      console.log(empData);
    });
      this.service.getPdecorations().subscribe((empData: any) => {
        this.decoration = empData;
        console.log(empData);    
      });
        this.service.getPphotographys().subscribe((empData: any) => {
          this.photography = empData;
          console.log(empData);
        });
            this.service.getPmusics().subscribe((empData: any) => {
              this.music = empData;
              console.log(empData);

      });}  

      addToCart(product: any) {
        this.service.addToCart(product);
      }

}
