import { Component, OnInit } from '@angular/core';
import { ProviderService } from '../service-provider/provider.service';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-track-order',
  templateUrl: './track-order.component.html',
  styleUrls: ['./track-order.component.css']
})
export class TrackOrderComponent implements OnInit {
  private gridApi;
  orderDetailsForTrackingOrder:any;
  constructor(private serviceProvider:ProviderService,private customerService:CustomerService) { }
  userName:string;
  isorderavailab=true;

  ngOnInit() {
    this.userName=localStorage.getItem("userName");
    this.serviceProvider.showOrderDetailsForTrackingOrder()
    .subscribe(
      data => {
        this.orderDetailsForTrackingOrder = data.json();
        
        this.rowData=data.json();
       if(this.orderDetailsForTrackingOrder[0]===undefined){
         this.isorderavailab=false;
       }
        console.log("Order Details Fetched For tracking order")
      }
    );

  }

 

  rowData = [];

  columnDefs = [
    { headerName: 'Order Id', field: 'OrderId', width: 400 },
    { headerName: 'Delivery Status', field: 'deliveryStatus', width: 200 },
    { headerName: 'Delivery Date', field: 'deliveryDate', width: 200 },
  ];
  logout(){
    this.customerService.logout();
  }
}
