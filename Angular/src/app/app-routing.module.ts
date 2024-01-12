import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { AboutComponent } from './about/about.component';
import { OurservicesComponent } from './ourservices/ourservices.component';
import { BlogsComponent } from './blogs/blogs.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { EventComponent } from './event/event.component';
import { LogoutComponent } from './logout/logout.component';
import { authGuard } from './auth.guard';
import { WeddingosComponent } from './weddingos/weddingos.component';
import { PartiesComponent } from './parties/parties.component';
import { CorporateComponent } from './corporate/corporate.component';
import { WedeventComponent } from './wedevent/wedevent.component';
import {BwedComponent } from './bwed/bwed.component';
import { PartiesevComponent } from './partiesev/partiesev.component';
import { CorporateevComponent } from './corporateev/corporateev.component';
import { BookComponent } from './book/book.component';
import { ResetPasswordComponent } from './reset-password/reset-password.component';
import { ForgetPassComponent } from './forgotpassword/forgotpassword.component';
import { PartiesservComponent } from './partiesserv/partiesserv.component';
import { ShowbookedComponent } from './showbooked/showbooked.component';


const routes: Routes = [
  {path:"",           component:HomeComponent},
  {path:"#",component:WeddingosComponent},
  {path:"home",            component:HomeComponent},
  {path:"login",       component:LoginComponent},
  {path:"register",    component:RegisterComponent},
  {path:"about",    component:AboutComponent},
  {path:"ourservices",    component:OurservicesComponent},
  {path:"blogs",    component:BlogsComponent},
  {path:"header",    component:HeaderComponent},
  {path:"event",    canActivate:[authGuard], component:EventComponent},
  {path:"logout",    canActivate:[authGuard], component:LogoutComponent},
  {path:"weddingos",    component:WeddingosComponent},
  {path:"parties",    component:PartiesComponent},
  {path:"corporate",    component:CorporateComponent},
  {path:"bwed",    canActivate:[authGuard], component:BwedComponent},
  {path:"wedevent",    canActivate:[authGuard], component:WedeventComponent},
  {path:"forgotpassword",   component:ForgetPassComponent},
  {path:"book",    canActivate:[authGuard], component:BookComponent},
  {path:"partiesev",    canActivate:[authGuard], component:PartiesevComponent},
  {path:"corporateev",    canActivate:[authGuard], component:CorporateevComponent},
  {path:"reset-password",   component:ResetPasswordComponent},
  {path:"login/forgotpassword",component:ForgetPassComponent  },
  {path:"partiesserv",component:PartiesservComponent },
  {path:"login/forgotpassword/resetpassword",component:ResetPasswordComponent},
  {path:"resetpassword", component:ResetPasswordComponent},
  {path:"showbooked",component:ShowbookedComponent}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }