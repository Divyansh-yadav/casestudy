import { Component, OnInit } from '@angular/core';
import { StorefeedbackService } from './storefeedback.service';
import { CustomerFeedback } from './customer-feedback';
import { CustomerService } from '../customer.service';
import { Router } from '@angular/router';
import {ToasterService, ToasterConfig} from 'angular2-toaster';
import { MatSnackBar } from '@angular/material';

@Component({
  selector: 'app-storefeedback',
  templateUrl: './storefeedback.component.html',
  styleUrls: ['./storefeedback.component.css']
})
export class StorefeedbackComponent implements OnInit {
  public config1: ToasterConfig = 
  new ToasterConfig({      
      tapToDismiss: true, 
      timeout: 1590
  });
  userName:string;
  feedbackId :any;
  customerFeedback=new CustomerFeedback();
  constructor(private storeFeedbackService:StorefeedbackService, private customerService:CustomerService, private router:Router,private toasterService: ToasterService
    ,private snackBar:MatSnackBar) { }

  ngOnInit() {
    if (localStorage.getItem('currentUser')) {
      this.userName=localStorage.getItem("userName");
    this.showFeedbackForm()
    }
    else {
      this.router.navigate(['/']);
    }
  }

showFeedbackForm(){
  this.feedbackId = localStorage.getItem('feedbackId');
  this.storeFeedbackService.showFeedbackForm(this.feedbackId)
  .subscribe(
    data =>{
      console.log(data);
      this.customerFeedback.orderId=data.json().orderDetails.orderId;
      console.log("ORDER Id", this.customerFeedback.orderId);
      this.customerFeedback.userId=localStorage.getItem("userId");
      console.log("USER Id",this.customerFeedback.userId)
    }
  )
}

updateFeedback(){
  console.log("Feedback is", this.customerFeedback.feedback);
  console.log("Comment is ",this.customerFeedback.comments)
  if(this.customerFeedback.feedback){
  this.storeFeedbackService.updateFeedback(this.customerFeedback).subscribe(
    data=>{
      this.snackBar.open('Feedback Stored !', ' ', {
        duration: 3000, verticalPosition: 'top', horizontalPosition: 'end'
        });

      this.router.navigate(['/customer'])
    }
  )
  
}
else{
  this.toasterService.pop('error', 'Feedback canot be null', '');
}
}



logout(){
  this.customerService.logout();
}
}
