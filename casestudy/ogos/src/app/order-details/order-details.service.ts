import { Injectable } from '@angular/core';
import { RequestOptions, Headers, Http } from '@angular/http';

@Injectable({
  providedIn: 'root'
})
export class OrderDetailsService {
  
  constructor(private http:Http) { }
userId:any;
showOrderDetails_url:any;
  

  showOrderDetails() {
    console.log("Fetching All Orders Data");
    let headers = new Headers();
    headers.append('Accept', 'application/json')
    headers.append("Authorization", "Basic " + localStorage.getItem("hederdata"));
    let options = new RequestOptions();
    options.headers=headers;
    this.userId=JSON.parse(localStorage.getItem('currentUser')).principal["userId"];
    this.showOrderDetails_url="http://localhost:8080/order/"+this.userId;
    return this.http.get(this.showOrderDetails_url,options)
  }
}
