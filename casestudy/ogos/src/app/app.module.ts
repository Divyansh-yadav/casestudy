import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AuthGuard } from './auth.guard';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HttpModule } from '@angular/http';
import { HttpClientModule } from '@angular/common/http';
import { LoginService } from './login/login.service';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { UserComponent } from './user/user.component';
import { SignupService } from './user/signup.service';
import { AdminComponent } from './admin/admin.component';
import { ServiceProviderComponent } from './service-provider/service-provider.component';
import { CustomerComponent } from './customer/customer.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CustomerNavbarComponent } from './customer-navbar/customer-navbar.component';
import { LayoutModule } from '@angular/cdk/layout';
import { MatToolbarModule, MatButtonModule, MatSidenavModule, MatIconModule, MatListModule, MatSnackBarModule } from '@angular/material';
import { CartComponent } from './cart/cart.component';
import { CustomerDetailsComponent } from './customer-details/customer-details.component';
import { PaymentComponent } from './payment/payment.component';
import { AdminNavBarComponent } from './admin-nav-bar/admin-nav-bar.component';
import { EditProductComponent } from './edit-product/edit-product.component';
import { FetchUserDetailsComponent } from './fetch-user-details/fetch-user-details.component';
import { MatDialogModule } from "@angular/material";
import { AgGridModule } from 'ag-grid-angular';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { NgxSpinnerModule } from 'ngx-spinner';
import { MatStepperModule } from  "@angular/material";
import {
  MatMenuModule,
  MatCardModule,
  MatFormFieldModule,
  MatInputModule,
  MatNativeDateModule,
  MatRadioModule,
  MatSelectModule,
  MatProgressSpinnerModule,
  MatOptionModule,
  MatSlideToggleModule, ErrorStateMatcher, ShowOnDirtyErrorStateMatcher
} from '@angular/material';
import {ToasterModule, ToasterService} from 'angular2-toaster';
import { AddProductComponent } from './add-product/add-product.component';
import { AddProductCategoryComponent } from './add-product-category/add-product-category.component';
import { AgmCoreModule } from '@agm/core';
import { OrderDetailsComponent } from './order-details/order-details.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { TrackOrderComponent } from './track-order/track-order.component';
import { StorefeedbackComponent } from './storefeedback/storefeedback.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    UserComponent,
    AdminComponent,
    ServiceProviderComponent,
    CustomerComponent,
    CustomerNavbarComponent,
    CartComponent,
    CustomerDetailsComponent,
    PaymentComponent,
    AdminNavBarComponent,
    EditProductComponent,
    FetchUserDetailsComponent,
    AddProductComponent,
    AddProductCategoryComponent,
    OrderDetailsComponent,
    FeedbackComponent,
    TrackOrderComponent,
    StorefeedbackComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    MatDialogModule,
    HttpModule,
    FormsModule,
    MatStepperModule,
    BrowserModule,
    MatProgressSpinnerModule,
    FormsModule,
    ReactiveFormsModule,
    MatButtonModule,
    MatDatepickerModule,
    MatMenuModule,
    MatToolbarModule,
    MatIconModule,
    MatCardModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatInputModule,
    MatNativeDateModule,
    MatRadioModule,
    MatSelectModule,
    MatOptionModule,
    MatSnackBarModule,
    MatSlideToggleModule,
    NgxSpinnerModule,
    ToasterModule.forRoot(),
    AgmCoreModule.forRoot({
      apiKey: "AIzaSyDF1CywhE_Ch2pHud2zcqEfoY4r6G75lfY",
      libraries: ["places"]
    }),
    RouterModule.forRoot([
      {
        path: '',
        component: LoginComponent
      },
      {
        path: 'register',
        component: UserComponent
      },
      {
        path: 'admin',
        component: AdminNavBarComponent

      },
      {
        path: 'customer',
        component: CustomerNavbarComponent
      },
      {
        path: 'cart',
        component: CartComponent
      },
      {
        path: 'adddetails',
        component: CustomerDetailsComponent
      },
      {
        path: 'payment',
        component: PaymentComponent
      },
      {
        path: 'edit',
        component: EditProductComponent
      },
      {
        path: 'getAllUsers',
        component: FetchUserDetailsComponent
      },
      {
        path: 'setstatus',
        component: ServiceProviderComponent
      },
      {
        path: 'addProduct',
        component: AddProductComponent
      },
      {
        path: 'addProductCategory',
        component: AddProductCategoryComponent
      },
      {
        path: 'feedback',
        component: FeedbackComponent
      },
      {
        path:'trackOrder',
        component:TrackOrderComponent
      },
      {
        path:'storefeedback',
        component:StorefeedbackComponent
      }
    ]),
    BrowserAnimationsModule,
    LayoutModule,
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    AgGridModule.withComponents([FetchUserDetailsComponent])
  ],
  providers: [LoginService, SignupService, AuthGuard, { provide: ErrorStateMatcher, useClass: ShowOnDirtyErrorStateMatcher }],
  bootstrap: [AppComponent]
})
export class AppModule { }
