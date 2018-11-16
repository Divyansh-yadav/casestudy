import { Component, OnInit, NgZone } from '@angular/core';
import { CartService } from '../cart.service';
import { Cart } from './cart';
import { CustomerService } from '../customer.service';
import { Router } from '@angular/router';
import { Product } from '../customer/product';
import { Http, RequestOptions, Headers } from '@angular/http';
import {ToasterService, ToasterConfig} from 'angular2-toaster';


@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  constructor(private cartService: CartService, private customerService: CustomerService, private route: Router, private http: Http,private toasterService: ToasterService) { }
  cart: Cart;
  carts: Cart;
  plusQuantityNumber: number;
  minusQuantityNumber: number;
  total_quantity = 0;
  total_weight = 0.0;
  userName:string;
na = false;
produc :any;


  ngOnInit() {
    this.userName=localStorage.getItem("userName");
    this.plusQuantityNumber = 1;
    this.minusQuantityNumber = 1;
    if (localStorage.getItem('currentUser')) {
      this.getcartbyuser();
      this.getcartvalue();
    }
    else {
      this.route.navigate(['/'])
    }
  }

  getcartbyuser() {
    this.cartService.getcartbyuser().subscribe(
      data => {
        console.log(data);
        this.cart = data.json();
        for (let c in this.cart) {
          this.total_quantity = this.total_quantity + parseInt(this.cart[c].quantity)
          this.total_weight = this.total_weight + parseInt(this.cart[c].product["weight"]) * parseInt(this.cart[c].quantity)
        }
        console.log(this.total_quantity)
        console.log(this.total_weight)
      }

    )
  }

checkcart(){
  this.cartService.checkcart().subscribe(res=>{
   
    if(res.json()[0]==undefined){
      this.route.navigate(['/adddetails'])
    }
    else{
      this.na=true;
this.produc = res.json();
    }
  })
}
  getcartvalue() {
    this.cartService.getcartvalue().subscribe(
      data => {
        this.carts = data.json();

        console.log(data);
      }

    )
  }

  removefromcart(cartid: string) {

    this.cartService.removefromcart(cartid).subscribe(
      res => {
        this.toasterService.pop('success', 'cart updated  !', '');
        location.reload();

      },
      err => {
        console.log(err.message);
      }
    )
    this.ngOnInit();
  }
  logout() {
    this.customerService.logout();
  }

  increaseQuantity(temp: number, cart: Cart) {
    console.log("I am here")
    console.log(cart.cartId)
    console.log( this.total_weight + temp * parseInt(this.cart[0].product["weight"]))
    if (this.total_quantity + 1 < 11 && this.total_weight +  parseInt(this.cart[0].product["weight"]) <= 25000) {
      this.cart.quantity = temp + 1;
      console.log(this.cart.quantity);
      this.cartService.updateQuantity(this.cart.quantity, cart.cartId).subscribe(
        res => {
          
          location.reload();
          this.toasterService.pop('success', 'cart updated  !', '');
        },
        err => {
          console.log(err.message);
        }
      )
    }
    else {
      this.toastQuantityUnavailableNotification();
    }

  }

  decreaseQuantity(temp: number, cartId: String) {
    if (temp == 1) {
      this.toastZeroQuantityNotification();
    }
    else {
      this.cart.quantity = temp - 1;
      console.log(this.cart.quantity);
      this.cartService.updateQuantity(this.cart.quantity, cartId).subscribe(
        res => {
         
          location.reload();
          this.toasterService.pop('success', 'cart updated  !', '');
        },
        err => {
          console.log(err.message);
        }
      )
    }

  }


  toastZeroQuantityNotification() {    
    this.toasterService.pop('warning', 'Quantity can not be zero !', '');
  }

  toastQuantityUnavailableNotification() {
    this.toasterService.pop('error', 'cart limit exceeded ', '');
  }
}
