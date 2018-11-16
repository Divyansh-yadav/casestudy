import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-order-details',
  templateUrl: './order-details.component.html',
  styleUrls: ['./order-details.component.css']
})
export class OrderDetailsComponent implements OnInit {

  userName:string;
  constructor() { }

  ngOnInit() {
    this.userName=localStorage.getItem("userName");
  }

}
