import { Component, Input, Output,EventEmitter  } from '@angular/core';
import { Shop } from '../models/shop';

@Component({
  selector: 'shop-card',
  templateUrl: './shop-card.component.html',
  styleUrls: ['./shop-card.component.css']
})
export class ShopCardComponent {

  @Input('shop') shop:Shop;
  @Input('preferedshop') isPreferedShopCard:boolean=false;
  @Output('like') onLike = new EventEmitter();
  @Output('dislike') onDislike = new EventEmitter();
  @Output('Remove') onRemove =new EventEmitter();
  constructor() { }

  onLikeShop(idShop){
    this.onLike.emit(idShop);
  }
  onDislikeShop(idShop){
    this.onDislike.emit(idShop);
  }
  onRemoveShop(idShop){
    this.onRemove.emit(idShop);
  }

}
