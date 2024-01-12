import { Component, OnInit } from '@angular/core';
import { OrganiseService } from '../organise.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-showbooked',
  templateUrl: './showbooked.component.html',
  styleUrls: ['./showbooked.component.css']
})
export class ShowbookedComponent implements OnInit {
  events: any;
  showbooked: any;
  eventlist: any;
  customerList: any;
  mergeData: any;
  customer:any
  eventId:any;
  data1:any;
  constructor(private service: OrganiseService, private router: Router) {
    this.showbooked = {
      "name": "",
      "emailId": "",
      "eventName": "",
      "location": "",
      "date": "",
    }
  }

  ngOnInit() {
    this.service.getCustomers().subscribe((customerData: any) => {
      this.customerList = customerData;
      console.log(this.customerList);
    });

    this.service.getEvents().subscribe((eventData: any) => {
      this.eventlist = eventData;
      console.log(this.eventlist);
      this.eventlist.forEach((event:any) => {
        let eventId = event.customer.id;
        console.log(eventId);
        this.service.findById(eventId).subscribe((eventData: any) => {
          this.customer = eventData;
          console.log(this.customer);
          console.log(event);

          this.showbooked.name=this.customer.firstName;
          this.showbooked.emailId=this.customer.emailId;
          this.showbooked.eventName=event.eventName;
          this.showbooked.location=event.location;
          this.showbooked.date=event.date.toString();
          console.log(this.showbooked);
          this.service.registerBooking(this.showbooked).subscribe((data: any) => {
            this.data1 = data;
            console.log(data);      
          });
        });

        
      });
    });
    console.log(this.data1);
    

   


    
    for(let event of this.eventlist){
      const eventId = event.customer.id;
      console.log(event.customer.id);
      
     
     
      
  }

  


  this.service.listOfBookings().subscribe((customerData: any) => {
    this.customerList = customerData;
    console.log(this.customerList);
  });
  }
 
  
}
