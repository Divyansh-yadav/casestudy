import { Component } from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-customer-navbar',
  templateUrl: './customer-navbar.component.html',
  styleUrls: ['./customer-navbar.component.css'],
})
export class CustomerNavbarComponent {
  userName:string;
  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches)
      );

  constructor(private breakpointObserver: BreakpointObserver, private customerService:CustomerService) {
    this.userName=localStorage.getItem("userName");
  }
  logout(){
    this.customerService.logout();
  }
}
