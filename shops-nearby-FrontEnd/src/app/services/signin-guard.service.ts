import { CanActivate, Router } from '@angular/router';
import { AuthService } from './auth.service';
import { Injectable } from '@angular/core';

@Injectable()
export class SigninGuard implements CanActivate{
    constructor(private auth:AuthService,private route:Router){}
    canActivate(){
        if(!this.auth.isloggedIn()) return true;
        this.route.navigate(['/listShops']);
        return false;
    }
}