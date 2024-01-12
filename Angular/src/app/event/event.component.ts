import { Component, OnInit } from '@angular/core';
import { OrganiseService } from '../organise.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-event',
  templateUrl: './event.component.html',
  styleUrls: ['./event.component.css']
})
export class EventComponent implements OnInit {

  event: any;
  emailId:any;
  eventName:any;
  customerList:any;
  cust:any;
  constructor(private router: Router, private service: OrganiseService) {
    this.event = {
      "eventName":"",
      "location":"",
      "noMembers":0,
       "date":"",
       "customer": {"id":""}
      }
   

      this.emailId = localStorage.getItem("emailId");

    }
  ngOnInit() {
    this.service.getCustomers().subscribe((departmentData: any) => {
      this.customerList = departmentData;
      console.log(this.customerList);
    
      
    });
  }
  registerEvent(eventForm: any) {

    console.log(eventForm);
   console.log(eventForm.emailId);
    this.service.findByemailId(eventForm.emailId).subscribe((data:any)=>{
         this.cust=data;      
      
         console.log(this.cust);
    });


    this.event.eventName = eventForm.eventName;
    this.event.location = eventForm.location;
    this.event.noMembers = eventForm.noMembers;
    this.event.date = eventForm.date;
    this.event.customer.id = this.cust.id;
    console.log(eventForm.id);


    this.service.registerEvent(this.event).subscribe((data: any) => {
      console.log(data);      
    });
   
    localStorage.setItem("eventName", eventForm.eventName);
    localStorage.setItem("noMembers", eventForm.noMembers.toString());
    
}
navigateToEvent(selectedEvent: string) {
  if (selectedEvent === 'Wedding') {
    this.router.navigate(['bwed']); 
  } else if (selectedEvent === 'Parties') {
    this.router.navigate(['partiesserv']);}
  else if (selectedEvent === 'Corporate Event') {
    this.router.navigate(['corporateev']); }
}
addToCart(val:any) {
  console.log("calling cart");
  console.log(val,"vv")
  this.service.addToCart(val);
  }


}