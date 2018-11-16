import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from './user'
import { Router } from '@angular/router';
import { ToasterService } from 'angular2-toaster';

@Injectable({
  providedIn: 'root'
})
export class SignupService {

  private _url = "http://localhost:8080/user/addUser";
  constructor(private http: HttpClient, private route: Router, private toasterService: ToasterService) { }

  registerUser(user: User) {
    console.log(user)
    return this.http.post<User>(this._url, user);
     
  }

  toastEmailIdNotAvailabeNotification() {
    this.toasterService.pop('error', 'Email Id not available !', '')
  }
}
