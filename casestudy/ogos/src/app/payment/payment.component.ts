import { Component, OnInit, ViewChild } from '@angular/core';
import {CustomerService} from '../customer.service'
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators,FormControl } from '@angular/forms';
import { NgxSpinnerService } from 'ngx-spinner';


@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {
  cardno = new FormControl('', [Validators.required,Validators.pattern('[0-9]*'),  Validators.minLength(16) , Validators.maxLength(16)]);
  cvc = new FormControl('', [Validators.required,Validators.pattern('[0-9]*'),  Validators.minLength(3) , Validators.maxLength(3)]);
  dp3 =  new FormControl('', [Validators.required]);
  
  // password = new FormControl('', [Validators.required, Validators.minLength(6)]);
  // cpassword = new FormControl('', [Validators.required, Validators.minLength(6)]);
  
  userName:string;
  
  constructor(private customerService:CustomerService,private route:Router,private spinner: NgxSpinnerService, private _formBuilder: FormBuilder  ) { 
    if (localStorage.getItem('currentUser')) {
      
    }
    else{
      this.route.navigate(['/'])
    }
    
  }
      ngOnInit() {
        
        this.userName=localStorage.getItem("userName");
      }
     
  getcardErrorMessage(){
    return this.cardno.hasError('required') ? 'You must enter a value' : 
    this.cardno.hasError('minLength') ? 'Not a valid card' : 
    this.cardno.hasError('maxLength') ? 'Not a valid card' :     
            this.cardno.hasError('pattern') ? 'Not a valid card no':'';

  }
  getcvcErrorMessage(){
    return this.cvc.hasError('required') ? 'You must enter a value' : 
    this.cvc.hasError('minLength') ? 'Not a valid cvc no.' : 
    this.cvc.hasError('maxLength') ? 'Not a valid cvc no.' :     
            this.cvc.hasError('pattern') ? 'Not a valid cvc':'';

  }
  getdateErrorMessage(){
    return this.dp3.hasError('required') ? 'You must enter a value' : 
    '';

  }
buynow(){
  this.spinner.show();
    setTimeout(() => {
        this.spinner.hide();
    }, 5000);
  this.customerService.buynow();
}
logout(){
  this.customerService.logout();
}

}
