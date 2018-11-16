import { Injectable } from '@angular/core';
import { Http, RequestOptions, Headers, Response } from '@angular/http';
import  {CustomeDetals} from './customer-details/customerdetils';
import { Router } from '@angular/router';
import {ToasterService, ToasterConfig} from 'angular2-toaster';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http:Http,private route:Router, private toasterService: ToasterService) { }
  adddetail(customeDetals:CustomeDetals){

    let headers = new Headers();
    headers.append('Accept', 'application/json')   
    headers.append("Authorization", "Basic " + localStorage.getItem("hederdata"));    
    
    return this.http.post("http://localhost:8080/customer/addCustomerDetails",customeDetals,{ headers: headers}).subscribe(
      res =>{
          let cid=res.json();
         localStorage.setItem("customerId",cid.customerId);
         
      },
      err => {
          console.log(err.message);
      }
  )
  }

  buynow(){
  let headers = new Headers();
  headers.append('Accept', 'application/json')   
  headers.append("Authorization", "Basic " + localStorage.getItem("hederdata"));    
  
  return this.http.get("http://localhost:8080/order/addorder/"+JSON.parse(localStorage.getItem('currentUser')).principal["userId"]+"/"+localStorage.getItem("customerId"),{ headers: headers}); }

    logout(){
        localStorage.removeItem('currentUser');
this.toastLogoutNotification();
        this.route.navigate(['/'])
    }

    toastPaymentSuccessfulNotification() {
      this.toasterService.pop('success', 'Payment successfully', '');
      }
      toastLogoutNotification() {
        
      }

  }


