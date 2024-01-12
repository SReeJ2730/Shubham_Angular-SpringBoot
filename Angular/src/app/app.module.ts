import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HeaderComponent } from './header/header.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { EventComponent } from './event/event.component';
import { AboutComponent } from './about/about.component';
import { HomeComponent } from './home/home.component';
import { BlogsComponent } from './blogs/blogs.component';
import { OurservicesComponent } from './ourservices/ourservices.component';
import { MeComponent } from './me/me.component';
import { LogoutComponent } from './logout/logout.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';
import { WeddingosComponent } from './weddingos/weddingos.component';
import { CorporateComponent } from './corporate/corporate.component';
import { PartiesComponent } from './parties/parties.component';
import { SocialLoginModule, GoogleLoginProvider, SocialAuthServiceConfig } from 'angularx-social-login';
import { PartiesevComponent } from './partiesev/partiesev.component';
import { CorporateevComponent } from './corporateev/corporateev.component';
import { PartiesservComponent } from './partiesserv/partiesserv.component';
import { WedeventComponent } from './wedevent/wedevent.component';
import { BwedComponent } from './bwed/bwed.component';
import { ForgetPassComponent } from './forgotpassword/forgotpassword.component';
import { BookComponent } from './book/book.component';
import { ResetPasswordComponent } from './reset-password/reset-password.component';
import { ShowbookedComponent } from './showbooked/showbooked.component';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HeaderComponent,
    EventComponent,
    AboutComponent,
    HomeComponent,
    BlogsComponent,
    OurservicesComponent,
    MeComponent,
    LogoutComponent,
    WeddingosComponent,
    CorporateComponent,
    PartiesComponent,
    PartiesevComponent,
    CorporateevComponent,
    PartiesservComponent,
    WedeventComponent,
    BwedComponent,
    ForgetPassComponent,
   BookComponent,
   ResetPasswordComponent,
   ShowbookedComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    RouterModule,
    HttpClientModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot(),  // Add BrowserAnimationsModule to enable Angular Material animations
    SocialLoginModule,
    ReactiveFormsModule
  ],
  providers: [
    {
      provide: 'SocialAuthServiceConfig',
      useValue: {
        autoLogin: false,
        providers: [
          {
            id: GoogleLoginProvider.PROVIDER_ID,
            provider: new GoogleLoginProvider('506796628471-vqf0ve3e4jlk6rtce9s3rdkuu7rs005j.apps.googleusercontent.com')
          },
        ],
      } as SocialAuthServiceConfig,
    },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
