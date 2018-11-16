import { Injectable } from '@angular/core';
import { Http, RequestOptions, Headers } from '@angular/http';
import { Product } from '../customer/product';

@Injectable({
  providedIn: 'root'
})
export class AddProductService {
  addNewProduct_url="http://localhost:8080/products/addProducts";
  constructor(private http:Http) { }

  addNewProduct(product:Product) {
    let headers = new Headers();
    headers.append('Accept', 'application/json')
    // creating base64 encoded String from user name and passwor    
    headers.append("Authorization", "Basic " + localStorage.getItem("hederdata"));
    
    let options = new RequestOptions();
    options.headers=headers;
    return this.http.post(this.addNewProduct_url, product, options);
  }
}
