import { Injectable } from '@angular/core';
import { Http, RequestOptions, Headers, Response } from '@angular/http';
import { CartService } from '../cart.service';
import { observable } from 'rxjs';
import { Cart } from './cart';
import { parseTemplate } from '@angular/compiler';
import { MatSnackBar } from '@angular/material';


@Injectable({
  providedIn: 'root'
})
export class ProductServiceService {
 
  getAllProducts_url = "http://localhost:8080/products/getAllProducts";
  getProductById_url = "http://localhost:8080/products/getProduct/";
  constructor(private http: Http, private cart: CartService, private snackBar: MatSnackBar) { }

  getProductCategory() {
    let headers = new Headers();
    headers.append('Accept', 'application/json') 
    headers.append("Authorization", "Basic " + localStorage.getItem("hederdata"));

    let options = new RequestOptions();
    options.headers = headers;
    let get_url = "http://localhost:8080/productCategory/getProductCategory";

    return this.http.get(get_url, options);
  }

  getProductByCategory(cid) {
    let headers = new Headers();
    headers.append('Accept', 'application/json')
    headers.append("Authorization", "Basic " + localStorage.getItem("hederdata"));
    let options = new RequestOptions();
    options.headers = headers;
    cart: CartService;

    console.log("http://localhost:8080/products/getByCategory/" + cid);
    return this.http.get("http://localhost:8080/products/getByCategory/" + cid, options);
  }

  addtocart(pid) {
    let cart = {
      "userId": JSON.parse(localStorage.getItem('currentUser')).principal["userId"],
      "productId": pid,
      "quantity": 1
    }
    let headers = new Headers();
    headers.append('Accept', 'application/json')

    headers.append("Authorization", "Basic " + localStorage.getItem("hederdata"));
    let options = new RequestOptions();
    options.headers = headers;
    const params = new URLSearchParams();
    params.append("", "");

    console.log("http://localhost:8080/cart/addToCart", cart, options);
    return this.http.post("http://localhost:8080/cart/addToCart", cart, { headers: headers });
  }

  getAllProducts() {
    console.log("Fetching all products ")
    let headers = new Headers();
    headers.append('Accept', 'application/json')
    // creating base64 encoded String from user name and passwor    
    headers.append("Authorization", "Basic " + localStorage.getItem("hederdata"));
    let options = new RequestOptions();
    options.headers = headers;
    return this.http.get(this.getAllProducts_url, options);

  }


  // Fetching Product Details by product id
  getProductDetails() {
    console.log("Fetching the details by Product id")
    var pid = localStorage.getItem("productId").trim();
    var pid = pid.replace(/['"]+/g, '');
    let headers = new Headers();
    headers.append('Accept', 'application/json')  
    headers.append("Authorization", "Basic " + localStorage.getItem("hederdata"));
    let options = new RequestOptions();
    options.headers = headers;
    return this.http.get(this.getProductById_url + pid, options);
  }


  toastcartUpdatedNotification() {
    this.snackBar.open('Product added to the cart !', '', {
      duration: 2000, verticalPosition: 'top', horizontalPosition: 'end'
    });
  }
}
