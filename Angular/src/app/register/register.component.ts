import { Component, OnInit } from '@angular/core';
import { OrganiseService } from '../organise.service';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  customer: any;
  coutriesList: any;

  constructor(private router: Router, private service: OrganiseService,private toastr: ToastrService) {
    this.customer = {
      "firstName": "",
      "lastName":"",
      "gender": "",
      "dob":"",
      "country": "",
      "address":"",
      "emailId": "",
      "password": "",
      "phoneNo":""
      }
  }

  ngOnInit(){
    this.service.getCountries().subscribe((countriesData: any) => { this.coutriesList = countriesData; });
  }

  customerRegister(regForm: any) {

    console.log(regForm);

    this.customer.firstName = regForm.firstName;
    this.customer.lastName = regForm.lastName;
    this.customer.gender = regForm.gender;
    this.customer.dob = regForm.dob;
    this.customer.country = regForm.country;
    this.customer.emailId = regForm.emailId;
    this.customer.password = regForm.password;
    this.customer.phoneNo = regForm.phoneNo;

    this.service.customerRegister(this.customer).subscribe((data: any) => {
      console.log(data);      
    });

    this.router.navigate(['login']);
  
  }

}
