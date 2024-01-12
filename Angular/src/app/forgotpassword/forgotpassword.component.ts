import { Component} from '@angular/core';
import { Router } from '@angular/router';
import { OrganiseService } from '../organise.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-forget-pass',
  templateUrl: './forgotpassword.component.html',
  styleUrls: ['./forgotpassword.component.css']
})
export class ForgetPassComponent {

  emailId: string = '';
  Otp: string = '';
  otp: any
  verify:any;



  constructor(private router: Router, private service: OrganiseService, private toaster: ToastrService) {

  }

 

  forgetOtp(emailId: String) {
    console.log(emailId);
    this.service.forgetOtp(emailId).subscribe((data: any) => {

      console.log();
      
      this.otp = data;
      
    if(this.otp != null){
      this.toaster.success("otp sent");
    }
    else{
      this.toaster.error("Wrong emaild");
    }

    });

  }
  forgetpass(emailId: string, otp: string) {
    console.log(emailId, otp);
    
    localStorage.setItem("emailId", emailId);
    this.service.otpVerify(emailId,otp).subscribe((data:any)=>{
      console.log(data);
      this.verify = data;
      if(this.verify != null){
        this.router.navigate(['resetpassword']);
      }else{
        this.toaster.error("Wrong OTP");
      }
  
    });
    
  }
}