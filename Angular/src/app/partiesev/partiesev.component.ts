import { Component } from '@angular/core';

@Component({
  selector: 'app-partiesev',
  templateUrl: './partiesev.component.html',
  styleUrls: ['./partiesev.component.css']
})
export class PartiesevComponent {
  catering : any;
  decoration:any;
  photography:any;
  makeup:any;
  music:any;



  constructor() {
  

        this.catering =[
      { name:"Basic",   price:150.00, description:"Limited Food and any Special item", imgsrc:"assets/Images/img1.jpg"},
      { name:"Standard", price:250.00, description:"Limited food and two Special items", imgsrc:"assets/Images/img2.jpg"},
      { name:"Premium", price:350.00, description:"Limited food and two Special items", imgsrc:"assets/Images/img3.jpg"}]

      this.decoration= [
        { name:"Basic", price:10000, description:"Limited Decoration", imgsrc:"assets/Images/img4.jpg"},
      { name:"Standard", price:250.00, description:"Limited food and two Special items", imgsrc:"assets/Images/img5.jpg"},
      { name:"Premium", price:250.00, description:"Limited food and two Special items", imgsrc:"assets/Images/img6.jpg"}]

      this.photography= [
      { name:"Basic", price:250.00, description:"Limited food and two Special items", imgsrc:"assets/Images/img7.jpg"},
      { name:"Standard", price:250.00, description:"Limited food and two Special items", imgsrc:"assets/Images/img9.jpg"},
      { name:"Premium", price:250.00, description:"Limited food and two Special items", imgsrc:"assets/Images/img8.jpg"}]

      this.makeup= [
      { name:"Basic", price:250.00, description:"Limited food and two Special items", imgsrc:"assets/Images/img10.jpg"},
      { name:"Standard", price:250.00, description:"Limited food and two Special items", imgsrc:"assets/Images/img11.jpg"},
      { name:"Premium", price:250.00, description:"Limited food and two Special items", imgsrc:"assets/Images/img12.jpg"}]

      this.music= [
      { name:"Basic", price:250.00, description:"Limited food and two Special items", imgsrc:"assets/Images/img14.jpg"},
      { name:"Standard", price:250.00, description:"Limited food and two Special items", imgsrc:"assets/Images/img13.jpg"},
      { name:"Premium",  price:350.00, description:"Unlimited food with special sweet", imgsrc:"assets/Images/img15.jpg"}]
    
  }
}

