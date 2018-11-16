import { Injectable } from '@angular/core';
import { RequestOptions,Headers, Http } from '@angular/http';
import { CustomerFeedback } from './customer-feedback';

@Injectable({
  providedIn: 'root'
})
export class StorefeedbackService {

  constructor(private http:Http) { }

  showFeedbackForm(feedbackId) {
    
    let headers = new Headers();
    headers.append('Accept', 'application/json')
    headers.append("Authorization", "Basic " + localStorage.getItem("hederdata"));
    let options = new RequestOptions();
    options.headers=headers;
  
    const showFeedbackDetails_url="http://localhost:8080/CustomerFeedback/showcustomerfeedbackbyid/"+feedbackId;
    return this.http.get(showFeedbackDetails_url,options)

  }

  updateFeedback(customerFeedback:CustomerFeedback){
    const updateFeedback_url="http://localhost:8080/CustomerFeedback/updateFeedback";
    let headers = new Headers();
    headers.append('Accept', 'application/json')
    headers.append("Authorization", "Basic " + localStorage.getItem("hederdata"));
    let options = new RequestOptions();
    options.headers=headers;
    return this.http.put(updateFeedback_url,customerFeedback,options)
  }
}
