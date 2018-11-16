import { Component, OnInit } from '@angular/core';
import {ProviderService} from "./provider.service"
import {ProviderS} from '../service-provider/provider';
import { CustomerService } from '../customer.service';
import {ToasterService, ToasterConfig} from 'angular2-toaster';
import { Router } from '@angular/router';

@Component({
  selector: 'app-service-provider',
  templateUrl: './service-provider.component.html',
  styleUrls: ['./service-provider.component.css']
})
export class ServiceProviderComponent implements OnInit {
  
  public config1: ToasterConfig = 
  new ToasterConfig({      
      tapToDismiss: true, 
      timeout: 1590
  });
  sp:ProviderS;
  userName:string;
  isdata= true;
  mat = false;
  constructor(private providerService:ProviderService, private customerService: CustomerService, private toasterService: ToasterService,private router:Router
    ) { }

  ngOnInit() {
    this.userName=localStorage.getItem("userName");
    if (localStorage.getItem('currentUser')){
    this.displayOrders();
    }
    else{
      this.router.navigate(['/'])
    }
  }
  
  displayOrders(){
    this.providerService.showOrders()
    .subscribe(
      data=>{
      this.sp=data.json()
      console.log(this.sp)
      this.isdata = (this.sp[0]===undefined)
console.log(this.isdata)
  
    }
    )  
  }
  
  updateStatus(status, id){
    this.mat = true;
  this.providerService.updatestatus(status, id)
  .subscribe(
    data=>{
      this.mat = false;
      this.toastMailSentNotification();
      location.reload();
  })
  }
  
logout() {
  this.customerService.logout();
}

toastMailSentNotification() {
  
  this.toasterService.pop('success', 'Message Sent Successfully !', '');
}
}
