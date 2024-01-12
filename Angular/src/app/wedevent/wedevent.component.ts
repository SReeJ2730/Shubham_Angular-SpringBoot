import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OrganiseService } from '../organise.service';

@Component({
  selector: 'app-wedevent',
  templateUrl: './wedevent.component.html',
  styleUrls: ['./wedevent.component.css']
})
export class WedeventComponent  implements OnInit{
  constructor(private router: Router, private service: OrganiseService){
  }
  ngOnInit(): void {
    
  }
showbwed(){
  this.router.navigate(['bwed']);
}
showswed(){
  this.router.navigate(['swed']);
}
showpwed(){
  this.router.navigate(['pwed']);
}
}
