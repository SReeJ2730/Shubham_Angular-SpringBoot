import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { OrganiseService } from '../organise.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent {

  constructor(private router: Router, private service: OrganiseService,private toastr: ToastrService) {
    this.service.setUserLoggedOut();

    router.navigate(['login']);
    this.toastr.success('Logout Success!','');
  }

}