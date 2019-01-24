import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Shop } from '../models/shop';
import {map} from 'rxjs/operators';
import { AuthService } from './auth.service';


@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor(private http:HttpClient) {}

  getShops():Observable<Shop[]>{
    // const headers = new HttpHeaders({'Authorization':'Bearer '+localStorage.getItem('token')}); ,{headers: headers}
    return this.http.get<Shop[]>(AuthService.host+'shops');
  }
  getPreferredShops(){
    return this.http.get<Shop[]>(AuthService.host+'prefshops');
  }

  likeShop(idShop){
    return this.http.get(AuthService.host+'likeShop/'+idShop);
  }
  removeShop(idShop){
    return this.http.delete(AuthService.host+'removePrefered/'+idShop);
  }
}
