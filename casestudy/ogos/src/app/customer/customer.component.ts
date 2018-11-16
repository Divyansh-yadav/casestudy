import { Component, OnInit } from '@angular/core';
import { ProductServiceService } from './product-service.service'
import { ProductCategory } from './product-category';
import { Product } from './product';
import { CustomerService } from '../customer.service'
import { Router } from '@angular/router';
import { Observable, from } from 'rxjs';
import { CartService } from '../cart.service';
import { Cart } from './cart';
import {ToasterModule, ToasterService, ToasterConfig} from 'angular2-toaster';
@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
  size: number;
  public config1: ToasterConfig = 
  new ToasterConfig({      
      tapToDismiss: true, 
      timeout: 1590
  });
  constructor(private productServiceService: ProductServiceService, 
    private customerService: CustomerService, private route: Router,private cartService: CartService,private toasterService: ToasterService) { }
 pc: ProductCategory;
 product: Product;
 userName:string;
 cart: Cart;
 categoryName:string;
 total_quantity = 0;
 total_weight = 0.0;
  ngOnInit() {
    this.userName=localStorage.getItem("userName");
    if (localStorage.getItem('currentUser')) {
      this.getProductCategory();
      this.getcartbyuser();
    }
    else {
      this.route.navigate(['/'])
    }
  }

  getProductCategory() {
    this.productServiceService.getProductCategory()
      .subscribe(
        data => {
          console.log(data)
          this.pc = data.json();
        }

      )
  }
  
  getProductByCategory(event) {
    let target = event.target || event.srcElement || event.currentTarget;
    let idAttr = target.attributes.id;
    let value = idAttr.nodeValue;
    this.categoryName=event.target.attributes.value.nodeValue;
    console.log("Get PRoducts By Category", this.categoryName);
    this.productServiceService.getProductByCategory(value)
      .subscribe(
        data => {
          this.product = data.json();
        }

      )
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
  addtocart(product) {
    if (this.total_quantity + 1 < 11 && this.total_weight + product.weight <= 25000) {
     
      this.total_quantity = this.total_quantity+1;
      this.total_weight = this.total_weight+ product.weight;
    
    this.productServiceService.addtocart(product.productId).subscribe(
      res => {
        this.toasterService.pop('success', 'Card updated', 'product has been successfully added to cart');
      },
      err => {
        console.log(err.message);
      }
    );
  }
else{
  this.toasterService.pop('error', 'cart limit exceeded ', 'quantity must be less then 11');
}
}
popToast() {
  this.toasterService.pop('success', 'Card updated', 'product has been successfully added to cart');
}
}


