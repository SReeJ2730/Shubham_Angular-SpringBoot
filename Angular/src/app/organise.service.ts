import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import axios from 'axios';

@Injectable({
  providedIn: 'root'
})
export class OrganiseService {
 
  

  isUserLogged: boolean;

  //Dependency Injection for HTTPClient
  loginStatus: Subject<any>;
  emailId: any;

  constructor(private http: HttpClient) {
    this.isUserLogged = false;
    this.loginStatus = new Subject();
    this.bookItems = [];
  }

  getLoginStatus() {
    return this.loginStatus.asObservable();
  }
  setUserLoggedIn() {
    this.isUserLogged = true;
    this.loginStatus.next(true);
  }
  setUserLoggedOut() {
    this.isUserLogged = false;
    this.loginStatus.next(false);
  }
  getCountries(): any {
    return this.http.get('https://restcountries.com/v3.1/all');
  }

  getCustomers(): any {
    return this.http.get('http://localhost:8085/getCustomers');
  }
  
  getCustomerByName(cName: any): any {
    return this.http.get('http://localhost:8085/getCustomerByName/' + cName);
  }

  customerRegister(customer: any) {
    return this.http.post('registerCustomer', customer);
  }
  getEvents(): any {
    return this.http.get('http://localhost:8085/getEvents');
  }

  cLogin(customer: any) {
    return this.http.get('cLogin/' + customer.emailId + "/" + customer.password).toPromise();
  }


  registerEvent(event:any){
    return this.http.post('registerEvent',event);
  }

  updateCust(customer: any) {
    return this.http.put('updateCustomer', customer);
  }

  deleteCust(customer: any) {
    return this.http.delete('deleteCustomerByName/' + customer.firstName+'/'+customer.lastName);
  }

  getWcaterings(): any {
    return this.http.get(' http://localhost:8085/getWcaterings');
  }

  getWdecorations(): any {
    return this.http.get(' http://localhost:8085/getWdecorations');
  }
  getWphotographys(): any {
    return this.http.get(' http://localhost:8085/getWphotographys');
  }
  getWmakeups(): any {
    return this.http.get(' http://localhost:8085/getWmakeups');
  }
  getWmusics(): any {
    return this.http.get(' http://localhost:8085/getWmusics');
  }

  getPmusics(): any {
    return this.http.get(' http://localhost:8085/getPmusics');
  }
  getPcaterings(): any {
    return this.http.get(' http://localhost:8085/getPcaterings');
  }
  getPdecorations(): any {
    return this.http.get(' http://localhost:8085/getWmusics');
  }
  getPphotographys(): any {
    return this.http.get(' http://localhost:8085/getPphotographys');
  }

  getCcaterings(): any {
    return this.http.get(' http://localhost:8085/getCcaterings');
  }
  getCdecorations(): any {
    return this.http.get(' http://localhost:8085/getCdecorations');
  }
  getCdrinks(): any {
    return this.http.get(' http://localhost:8085/getCdrinks');
  }

  findByemailId(customer:any) {
    return this.http.get(' http://localhost:8085/findByemailId/'+customer);
  }

  findById(id:any) {
    return this.http.get(' http://localhost:8085/findById/'+id);
  }
  listOfBookings(){
    return this.http.get('http://localhost:8085/listOfBookings');
  }

  bookItems: any;

 

  addToCart(wcatering: any) {
    this.bookItems.push(wcatering);
  }
  getbookItems(): any {
    return this.bookItems;
  }
  

 getServices(): any {
    return this.http.get('http://localhost:8085/getServices');
  }

 
  getUserLoggedStatus(): boolean {
    return this.isUserLogged;
  }

forgetOtp(emailId: any) {
  return this.http.post("getEmailOtp", emailId);
}

otpVerify(emailId: any, otp: any) {
  return this.http.put("validateEmailOtp/" + emailId + "/" + otp, null);
}

resetpassword(emailid:any,password:any){
  return this.http.put("passwordReset/"+emailid+","+ password,null);
}
 
registerBooking(event:any){
  return this.http.post('/registerBooking',event);
}
   
getBookingByEmailId(emailId:any){
  return this.http.get('http://localhost:8085/getBookingByEmailId/'+emailId);
}
getBookingsByOrder(){
  return this.http.get('http://localhost:8085/getBookingsByOrder');
}

getBookingsByOrderemail(emailId:any){
  return this.http.get('http://localhost:8085/getBookingsByOrderemail/'+emailId);
}
 }

