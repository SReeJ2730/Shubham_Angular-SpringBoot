import { Injectable, inject } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivateFn, RouterStateSnapshot } from '@angular/router';
import { OrganiseService } from './organise.service';




export const authGuard: CanActivateFn = (route, state) => {
  //Dependency Injection
  let service = inject(OrganiseService);
  return service.getUserLoggedStatus();
};
