import { Component, OnInit } from '@angular/core';
import { FeedbackService } from './feedback.service';
import { Router } from '@angular/router';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-feedback',
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.css']
})
export class FeedbackComponent implements OnInit {
  constructor(private feedbackService:FeedbackService,private route:Router, private customerService:CustomerService) { }
  orderDetails:any;
  userName:string;
  ac:string;
  isdata = true;
  ngOnInit() {
    if (localStorage.getItem('currentUser')) {
    this.userName=localStorage.getItem("userName");
    this.showOrderDetailsForFeedback();
    }
    else 
    {
      this.route.navigate(['/']);
    }
  }

  // Shows the details of the Order placed user till now.
  showOrderDetailsForFeedback() {
  this.feedbackService.showOrderDetailsForFeedback()
  .subscribe(
    data=>{   
    // this.ac=JSON.stringify(data.json())
    console.log("Feedback Object",data.json())
    this.orderDetails=data.json();
    this.isdata = (this.orderDetails[0]==undefined)
     
    }
   );
  }

  
  storeFeedback(feedbackId){
   localStorage.setItem('feedbackId',feedbackId)
this.route.navigate(['/storefeedback']);

  }

  logout(){
    this.customerService.logout();
  }
}
