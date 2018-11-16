import { Injectable } from '@angular/core';
import { RequestOptions, Headers, Http } from '@angular/http';

@Injectable({
  providedIn: 'root'
})
export class FeedbackService {
  userId:string;

  constructor(private http:Http) { }

  showOrderDetailsForFeedback() {
    console.log("Fetching All Orders Data");
    let headers = new Headers();
    headers.append('Accept', 'application/json')
    headers.append("Authorization", "Basic " + localStorage.getItem("hederdata"));
    let options = new RequestOptions();
    options.headers=headers;
    this.userId=JSON.parse(localStorage.getItem('currentUser')).principal["userId"];
    const showOrderDetails_url="http://localhost:8080/CustomerFeedback/showOrderDetailsForFeedback/"+this.userId;
    return this.http.get(showOrderDetails_url,options)
  }
}
