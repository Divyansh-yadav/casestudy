import { Injectable } from '@angular/core';
import { Http, RequestOptions, Headers, Response } from '@angular/http';
import { Product } from '../customer/product';
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material';


@Injectable({
  providedIn: 'root'
})
export class EditProductService {
  updateProductDetails_url = "http://localhost:8080/products/updateProductDetails";

  constructor(private http: Http, private router:Router, private snackBar:MatSnackBar) { }
  updateProductDetails(updateProduct: Product) {
    console.log("Updating the Product Details");
    let headers = new Headers();
    headers.append('Accept', 'application/json')
    headers.append("Authorization", "Basic " + localStorage.getItem("hederdata"));
    let options = new RequestOptions();
    options.headers = headers;
    console.log(updateProduct.quantity);
    
    updateProduct.productId=localStorage.getItem("productId");
    return this.http.post(this.updateProductDetails_url, updateProduct, { headers: headers });
      
  }

  toastDetailsUpdatedNotification() {
    this.snackBar.open('Product Details Updated !', '', {
      duration: 2000, verticalPosition: 'top', horizontalPosition: 'end'
    });
  }
}
