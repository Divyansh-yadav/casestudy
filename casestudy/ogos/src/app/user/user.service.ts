import { Injectable } from '@angular/core';
import { Http, RequestOptions, Headers, Response } from '@angular/http';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: Http, private router:Router) { }
  getAllUser_url="http://localhost:8080/user/getAllUsers";

  getAllUsers() {
    console.log("Fetching All Users Data");
    let headers = new Headers();
    headers.append('Accept', 'application/json')
    // creating base64 encoded String from user name and passwor    
    headers.append("Authorization", "Basic " + localStorage.getItem("hederdata"));
    let options = new RequestOptions();
    options.headers=headers;
    console.log("URL",this.getAllUser_url);
    return this.http.get(this.getAllUser_url,options)
     
  }
}
