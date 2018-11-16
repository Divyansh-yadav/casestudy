import { Injectable } from '@angular/core';
import { ProductCategory } from '../customer/product-category';
import { RequestOptions, Http,Headers } from '@angular/http';

@Injectable({
  providedIn: 'root'
})
export class ProductCategoryService {
addNewProductCategory_url="http://localhost:8080/productCategory/addProductCategory";
  constructor(private http:Http) { }

  addNewProductCategory(productCategory:ProductCategory) {
    let headers = new Headers();
    headers.append('Accept', 'application/json')
    // creating base64 encoded String from user name and passwor    
    headers.append("Authorization", "Basic " + localStorage.getItem("hederdata"));
    
    let options = new RequestOptions();
    options.headers=headers;
    return this.http.post(this.addNewProductCategory_url, productCategory, options);
  }
}
