import { Injectable } from '@angular/core';
import { Http, RequestOptions, Headers, Response } from '@angular/http';
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material';


@Injectable({
  providedIn: 'root'
})
export class CartService {
  increaseProductQuantity_url = "http://localhost:8080/cart/updateQuantity/";

  constructor(private http: Http, private route: Router, private snackBar: MatSnackBar) { }

  getcartbyuser() {
    console.log(localStorage.getItem('currentUser'))
    let userId = JSON.parse(localStorage.getItem('currentUser')).principal["userId"];
    let headers = new Headers();
    headers.append('Accept', 'application/json')
    headers.append("Authorization", "Basic " + localStorage.getItem("hederdata"));
    let options = new RequestOptions();
    options.headers = headers;
    return this.http.get("http://localhost:8080/cart/getcartbyuser/" + userId, options);
  }
checkcart(){
  let userId = JSON.parse(localStorage.getItem('currentUser')).principal["userId"];
  let headers = new Headers();
    headers.append('Accept', 'application/json') 
    headers.append("Authorization", "Basic " + localStorage.getItem("hederdata"));
    let options = new RequestOptions();
    options.headers = headers;
    
    return this.http.get("http://localhost:8080/cart/checkquantity/" + userId, options);
}

  getcartvalue() {
    let userId = JSON.parse(localStorage.getItem('currentUser')).principal["userId"];
    let headers = new Headers();
    headers.append('Accept', 'application/json')
    headers.append("Authorization", "Basic " + localStorage.getItem("hederdata"));
    let options = new RequestOptions();
    options.headers = headers;
    return this.http.get("http://localhost:8080/cart/getcartbyvalue/" + userId, options);
  }

  removefromcart(cid: String) {

    let headers = new Headers();
    headers.append('Accept', 'application/json') 
    headers.append("Authorization", "Basic " + localStorage.getItem("hederdata"));
    let options = new RequestOptions();
    options.headers = headers;
    return this.http.get("http://localhost:8080/cart/removeitem/" + cid, options);

  }

  updateQuantity(quantityNumber: number, cartId: String) {
    let headers = new Headers();
    headers.append('Accept', 'application/json') 
    headers.append("Authorization", "Basic " + localStorage.getItem("hederdata"));
    let options = new RequestOptions();
    options.headers = headers;
    console.log(this.increaseProductQuantity_url + cartId + "/" + quantityNumber, options)
    return this.http.post(this.increaseProductQuantity_url + cartId + "/" + quantityNumber,null, options);
      
  }


  toastCartUpdatedNotification() {
    this.snackBar.open('Cart Updated !', '', {
      duration: 2000, verticalPosition: 'top', horizontalPosition: 'end'
    });
  }
}
