import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { OrganiseService } from '../organise.service';
import { ToastrService } from 'ngx-toastr';
import { SocialAuthService, SocialUser } from 'angularx-social-login';
import { GoogleLoginProvider } from 'angularx-social-login';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  employees: any;
  employee: any;
  captchaText: any;

  constructor(private router: Router, private service: OrganiseService, private toastr: ToastrService,private socialAuthService: SocialAuthService) {
    
      this.refreshCaptcha();
    }
    refreshCaptcha() {
      this.captchaText = this.generateRandomCaptcha(); 
    }
  
    generateRandomCaptcha() {
      const characters = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
      let result = '';
      const length = 6; 
      for (let i = 0; i < length; i++) {
        result += characters.charAt(Math.floor(Math.random() * characters.length));
      }
      return result;
    }
  
  
    async validateLogin1(loginForm: any) {
      if (loginForm.captcha !== this.captchaText) {
        this.toastr.error("CAPTCHA is incorrect");
        return;
      }
  }

  async validateLogin(loginForm: any) {
    console.log(loginForm);

    localStorage.setItem("emailId", loginForm.emailId);

    if (loginForm.emailId == "Bhargavi" && loginForm.password == "Bhargavi") {
      this.service.setUserLoggedIn();
      this.router.navigate(['showbooked']);
    } else {
      await this.service.cLogin(loginForm).then((data: any) => {
        console.log(data);
        this.employee = data;
      });

      if (this.employee != null) {
        this.service.setUserLoggedIn();
        this.router.navigate(['event']);
      }
    }
  }

  showSignUp() {
    this.router.navigate(['register']);
  }
  signInWithGoogle(): void {
    this.socialAuthService.signIn(GoogleLoginProvider.PROVIDER_ID)
      .then((user: SocialUser) => {
       
        console.log(user);
      })
      .catch(error => {
        
        console.error(error);
      });
  }
}
