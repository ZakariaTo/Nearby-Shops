import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { FormValidators } from './form.validators';
import { AuthService } from '../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

 

  form = new FormGroup({
    fullName : new FormControl('',Validators.required),
    username : new FormControl('',[
      Validators.required,
      Validators.minLength(5),
    ],
    FormValidators.isunique(this.auth)
    ),
    email : new FormControl('',[
      Validators.required,
      Validators.email
    ]),
    password : new FormGroup({
      originalPassword :  new FormControl('',[ 
        Validators.required,
        Validators.minLength(8),
      ]),
      confirmPassword :  new FormControl('',[ 
        Validators.required,
        FormValidators.matchPasswod
      ])
    })
  });
  constructor(private auth:AuthService, private router:Router) { }

  ngOnInit() {
  }
  signup(credentials){
    console.log(credentials);
    let user = {
      fullName : credentials.fullName,
      userName : credentials.username,
      email: credentials.email,
      password: credentials.password.originalPassword
    }
    console.log('user'+user.userName);
    this.auth.signup(user).subscribe(result => { 
      if (result){
      alert('signup succed');
      this.router.navigate(['signin']);

      }
      else  
      alert('there is a problem with the signup');
    });
  }
  get username(){
    return this.form.get('username');
  }
  get password(){
    return this.form.get('password.originalPassword')
  }
  get confirmPassword(){
    return this.form.get('password.confirmPassword')
  }
  get email(){
    return this.form.get('email')
  }
  get fullName(){
    return this.form.get('fullName');
  }
}
