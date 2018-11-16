import { Component, OnInit } from '@angular/core';
import { LoginService } from './login.service';
import { Login } from './login';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import {ToasterService, ToasterConfig} from 'angular2-toaster';
import { MatSnackBar } from '@angular/material';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public config1: ToasterConfig = 
  new ToasterConfig({      
      tapToDismiss: true, 
      timeout: 1590
  });
  userName:string;
  login = new Login();
  email = new FormControl('', [Validators.required, Validators.email, Validators.pattern("[a-zA-Z0-9.-_]{1,}@[a-zA-Z.-]{2,}[.]{1}[a-zA-Z]{2,5}")]);
  password = new FormControl('', [Validators.required, Validators.minLength(6)]);
  hide1 = true;
  hide2 = true;
  constructor(private loginService: LoginService, private router: Router, private toasterService: ToasterService) { }

  ngOnInit() {
  }
  getEmailErrorMessage() {
    return this.email.hasError('required') ? 'You must enter a value' :
      this.email.hasError('email') ? 'Not a valid email' :
        this.email.hasError('pattern') ? '' : 'Not a valid email';
  }

  getPasswordErrorMessage() {
    return this.password.hasError('required') ? 'You must enter a value' :
      this.password.hasError('minLength') ? '' : 'Minimum length is 6';
  }
  validateUser() {
    this.login.email = this.email.value;
    this.login.password = this.password.value;

    this.loginService.validateUser(this.login)
      .subscribe(
        data => {
          console.log(JSON.parse(localStorage.getItem('currentUser')).principal["userId"]);
          const userId=JSON.parse(localStorage.getItem('currentUser')).principal["userId"];
          localStorage.setItem("userId", userId);   
          this.userName=JSON.parse(localStorage.getItem('currentUser')).principal["name"];
          localStorage.setItem("userName", this.userName.split(' ')[0]);
          console.log(this.userName);
          this.userName=JSON.parse(localStorage.getItem('currentUser'));
          console.log("HERE", this.userName);
          let role = JSON.parse(localStorage.getItem('currentUser')).authorities["0"].authority;
          if (role === "ROLE_ADMIN") {
            this.toastLoginSuccessfulNotification();
            this.router.navigate(["/admin"]);
          }
          if (role === "ROLE_CUSTOMER") {
           
            this.router.navigate(["/customer"]);
            this.toastLoginSuccessfulNotification();
          }
          if (role == "ROLE_SERVICEPROVIDER") {
            this.toastLoginSuccessfulNotification();
            this.router.navigate(["/setstatus"]);
          }
        },
        err => {
          this.toastUnsuccessfulLogiNotification();
        }
      )
  }

  toastLoginSuccessfulNotification() {
   this.toasterService.pop('success', 'Login Successfull', '');
  }

  toastUnsuccessfulLogiNotification() {
    this.toasterService.pop('error', 'Invalid Credentials', '');
  }

}
