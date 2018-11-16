import { Component, OnInit } from '@angular/core';
import { UserService } from '../user/user.service';
import { User } from '../user/user';
import { CustomerService } from '../customer.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-fetch-user-details',
  templateUrl: './fetch-user-details.component.html',
  styleUrls: ['./fetch-user-details.component.css']
})
export class FetchUserDetailsComponent implements OnInit {
userDetails:User;
userName:string;
  constructor( private userService:UserService,private customerService: CustomerService, private router:Router ) { }

  ngOnInit() {
    this.userName=localStorage.getItem("userName");
    if (localStorage.getItem('currentUser')) {
      this.userService.getAllUsers()
    .subscribe(data => {
      this.rowData=data.json();
      console.log(this.rowData)
      this.userDetails=data.json();
    });
    }
    else {
      this.router.navigate(['/'])
    } 
  }

  columnDefs = [
    {headerName: 'User Id', field: 'userid',width:370},
    {headerName: 'Name', field: 'userName',width:370},
    {headerName: 'Email', field: 'email',width:370},
    {headerName: 'Role', field: 'role',width:270},
    {headerName: 'Active', field: 'isactive',width:270 }
];

rowData = [];

  logout() {
    this.customerService.logout();
  }
}
