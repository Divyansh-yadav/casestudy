import { Component, OnInit } from '@angular/core';
import { SignupService } from './signup.service';
import { User } from './user'
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { ToasterService, ToasterConfig } from 'angular2-toaster';
import { MatSnackBar } from '@angular/material';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  name = new FormControl('', [Validators.required]);
  email = new FormControl('', [Validators.required, Validators.email, Validators.pattern("[a-zA-Z0-9.-_]{1,}@[a-zA-Z.-]{2,}[.]{1}[a-zA-Z]{2,5}")]);
  password = new FormControl('', [Validators.required, Validators.minLength(6)]);
  cpassword = new FormControl('', [Validators.required, Validators.minLength(6)]);
  hide1 = true;
  hide2 = true;
  user = new User();
    mat = false;
  ngOnInit() {
  }

  registerForm: FormGroup;
  submitted = false;
  constructor(private signupService: SignupService, private route: Router, private formBuilder: FormBuilder, private toasterService: ToasterService,
    private snackBar:MatSnackBar) { }
  getNameErrorMessage() {
    return this.name.hasError('required') ? 'You must enter a value' : '';
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

  getCPasswordErrorMessage() {
    return this.cpassword.hasError('required') ? 'You must enter a value' :
      this.cpassword.hasError('minLength') ? '' : 'Minimum length is 6';
  }

  matchPassword() {
    if (this.password.value !== this.cpassword.value)
      this.cpassword.setErrors({
        matchPassword: false
      })
    return this.password.value !== this.cpassword.value;
  }

  registerUser() {
    this.mat =true;
    if (this.cpassword.value === this.password.value) {
      this.user.userName = this.name.value;
      this.user.email = this.email.value;
      this.user.password = this.cpassword.value;
      this.signupService.registerUser(this.user).
      subscribe(res => {
       
this.snackBar.open('Registration successful !', ' ', {


  duration: 3000, verticalPosition: 'top', horizontalPosition: 'end'
  
  
  });
        this.mat=false;
        this.route.navigate(['/'])
      },
        error => {
          if (error.error.status === 500) {
            this.toastEmailIdNotAvailabeNotification();
          }
        });
    }
    else {

      this.toastPasswordMatchingErrorNotification()
    }

  }
  toastSuccessfulRegisterNotification() {

    this.toasterService.pop('success', 'Registration Successful !', '');
  }

  toastPasswordMatchingErrorNotification() {

    this.toasterService.pop('error', 'Password do not Match !', '');
  }
  toastEmailIdNotAvailabeNotification() {
    this.toasterService.pop('error', 'Email Id not available !', '')
  }
}
