import { Injectable } from '@angular/core';
import {map, catchError} from 'rxjs/operators'
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JwtHelperService } from '@auth0/angular-jwt';

@Injectable()
export class AuthService {

  static host='http://localhost:8080/';
  constructor(private http:HttpClient ) {}

  login(credentials): Observable<any>{
    console.log(JSON.stringify(credentials));
    return this.http.post<any>(AuthService.host+'api/auth/signin',
    JSON.stringify(credentials)).pipe(
      map(response=>{
        if(response && response.token){
          localStorage.setItem('token',response.token);
          return true;
        }
      })
      ,catchError(e => {
          if (e.status === 401) {
              return Observable.throw('Unauthorized');
          }
      })
    )
    }
    get currentUser(){
      let token=localStorage.getItem('token');
      if(!token)
        return false;
        return new JwtHelperService().decodeToken(token);
    }
    isloggedIn(){
      let token=localStorage.getItem('token');
        if(!token)
          return false;
        return !new JwtHelperService().isTokenExpired(token);
    }
    validateUsername(username):Observable<any>{
      return this.http.post(AuthService.host+'api/auth/validateusername',username);
    }
    signup(credentials){
      return this.http.post(AuthService.host+'api/auth/signup',credentials)
      .pipe(
        map(response=>{
            if(response)
            return true;
            return false;
        })
      )
    }
    logout(){
      localStorage.removeItem('token');
      return true;
    }
}
