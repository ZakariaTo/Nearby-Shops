import { Component, OnInit } from '@angular/core';
import { DataService } from '../services/data.service';
import { Shop } from '../models/shop';

@Component({
  selector: 'app-prefshops',
  templateUrl: './prefshops.component.html',
  styleUrls: ['./prefshops.component.css']
})
export class PrefshopsComponent implements OnInit {

  shops: Shop[];
  ispreferred;
  shopsIsEmpty:boolean;
  constructor(private service:DataService) { }

  ngOnInit() {
    this.service.getPreferredShops().subscribe(
      shops=> {
        if(shops.length>0){
          this.shops=shops;
        }else{
          this.shopsIsEmpty=true;
        }
      }
    );
    this.ispreferred =true;
  }
  onRemoveShop(idShop){
    this.service.removeShop(idShop).subscribe(res=>{
      if(res){
        alert('shops removed from the list of preferred');
        this.ngOnInit();
      }     
    });
    
  }
 
}
