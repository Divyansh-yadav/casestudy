import { Injectable } from '@angular/core';
import { Login } from './login';
import { HttpClient, HttpResponse, HttpHeaders} from '@angular/common/http';
import { Http, RequestOptions, Headers, Response } from '@angular/http';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { RouterModule} from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private _url="http://localhost:8080/user/signin";
  constructor(public http : Http) { }

  validateUser(login:Login){
    let headers = new Headers();
    headers.append('Accept', 'application/json')
    // creating base64 encoded String from user name and password
    var base64Credential: string = btoa( login.email+ ':' + login.password);
    localStorage.setItem("hederdata",base64Credential)
    headers.append("Authorization", "Basic " + base64Credential);
    let options = new RequestOptions();
    options.headers=headers;

    
    return this.http.get(this._url,options).pipe(map((response: Response) => {
      // login successful if there's a jwt token in the response
      let user = response.json();// the returned user object is a principal object
      if (user) {
        // store user details  in local storage to keep user logged in between page refreshes
        localStorage.setItem('currentUser', JSON.stringify(user));
        console.log(user)
      }
    }));
  }
    
  }
 
   

