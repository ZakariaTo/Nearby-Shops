import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardService implements CanActivate{

  constructor(private auth:AuthService, private router:Router) { }
  canActivate(){
    if(this.auth.isloggedIn()) return true;
    this.router.navigate(['/signin']);
    return false;
  }
}
