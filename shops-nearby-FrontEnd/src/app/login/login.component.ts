import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { User } from '../models/user';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  invalidLogin: boolean; 
  theuser :User;
  isLoaded : boolean =false;

  constructor(
    private router: Router, 
    private authService: AuthService,
    private route:ActivatedRoute) { }

  signIn(credentials) {
     this.authService.login(credentials)
      .subscribe(result => { 
         if (result){
         this.router.navigate(['/listShops'])
         }
       }, 
       (err) => {
          this.invalidLogin = true;
       }
    );
  }
  user(){
  //  this.authService.currentUser().subscribe(response=>{
  //    this.theuser = response;
  //    this.isLoaded = true;
  //  }
  //  )

  this.theuser=this.authService.currentUser;
  this.isLoaded = true;
  }

}
