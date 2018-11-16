import { Component, OnInit } from '@angular/core';
import { ProductServiceService } from '../customer/product-service.service';
import { Product } from '../customer/product';
import { Router } from '@angular/router';
import { EditProductService } from './edit-product.service';
import { CustomerService } from '../customer.service';
import { FormControl,Validators } from '@angular/forms';
import {ToasterService, ToasterConfig} from 'angular2-toaster';

@Component({
  selector: 'app-edit-product',
  templateUrl: './edit-product.component.html',
  styleUrls: ['./edit-product.component.css']
})
export class EditProductComponent implements OnInit {
  public config1: ToasterConfig = 
  new ToasterConfig({      
      tapToDismiss: true, 
      timeout: 1590
  });
  individualProduct:Product;
 updateProduct=new Product();
 productName = new FormControl('', [Validators.required, Validators.pattern('^[a-zA-Z]*')]);
  price = new FormControl('', [Validators.required, Validators.pattern('^[1-9][0-9]+([.][0-9]+)?$')]);
  quantity = new FormControl('', [Validators.required, Validators.pattern('^[0-9]*')]);
  weight = new FormControl('', [Validators.required, Validators.pattern('^[1-9][0-9]+([.][0-9]+)?$')]);
userName:any;
  constructor(private productServiceService:ProductServiceService,private router:Router, private editProductService:EditProductService, 
    private customerService:CustomerService, private toasterService: ToasterService) { }

  ngOnInit() {
    this.userName=localStorage.getItem("userName");
    if (localStorage.getItem('currentUser')) {
      this.productServiceService.getProductDetails()
      .subscribe (
          data=>{
            console.log(data)
            this.individualProduct=data.json()
            this.productName.patchValue(this.individualProduct.productName) 
            this.price.patchValue(this.individualProduct.price)
            this.quantity.patchValue(this.individualProduct.quantity)
            this.weight.patchValue(this.individualProduct.weight)
          }
        )
    }
    else {
      this.router.navigate(['/'])
    }
  }

  updateProductDetails() {
    this.individualProduct.productName =  this.productName.value
    this.individualProduct.price = this.price.value
    this.individualProduct.quantity = this.quantity.value
    this.individualProduct.weight = this.weight.value
    this.editProductService.updateProductDetails(this.individualProduct).subscribe(data => {
      this.toasterService.pop('success', 'product updated', 'product has been successfully updated');
      this.router.navigate(["/admin"]);
    },
      err => {
        console.log(err.message);
      }
    ); 
  }
  getNameErrorMessage(){
    return this.productName.hasError('required') ? 'You must enter a value' : 
    this.productName.hasError('pattern') ? 'invalid input' :
    '';
  }
  getPriceErrorMessage(){
    return this.price.hasError('required') ? 'You must enter a value' : 
    this.price.hasError('pattern') ? 'invalid input' :
    '';
 
  }
  getQuantityErrorMessage(){
    return this.quantity.hasError('required') ? 'You must enter a value' : 
    this.quantity.hasError('pattern') ? 'invalid input' :
    '';
 
  }
  getWeightErrorMessage(){
    return this.weight.hasError('required') ? 'You must enter a value' : 
    this.weight.hasError('pattern') ? 'invalid input' :
    '';
 
  }
  logout(){
    this.customerService.logout();
  }
}
