import { Component } from '@angular/core';
import { OrganiseService } from '../organise.service';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent {
  bookItems: any;
  emailId:any;
  eventName:any;
  amount:any;
  noMembers:any;
  newAmount=0;
  constructor(private service: OrganiseService) {
    this.bookItems = service.getbookItems();
    this.emailId = localStorage.getItem("emailId");
    this.eventName = localStorage.getItem("eventName");

   this.noMembers= localStorage.getItem("noMembers");
   console.log(this.noMembers); 
   
   }

  deleteCartItem(wcatering: any) {
    const i = this.bookItems.findIndex((element: any) => {
      return element.name == wcatering.name;
    });

    this.bookItems.splice(i, 1);
  }
 
calculateFoodCost(item: any) {
  if (item.name === 'Catering') {
    this.bookItems.price = item.price * this.noMembers;
    this.newAmount=item.price;
  }
}


calculateTotalCost() {
  this.amount = 0;

  for (const item of this.bookItems) {
    this.amount += item.price;
  }
  return  this.amount;
}
}

