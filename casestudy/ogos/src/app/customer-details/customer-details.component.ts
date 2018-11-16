import { Component, OnInit, ElementRef,NgZone, ViewChild } from '@angular/core';
import  {CustomeDetals} from './customerdetils';
import {CustomerService} from '../customer.service'
import { Router } from '@angular/router';
import { MapsAPILoader } from '@agm/core';
import { FormControl,Validators, FormGroup, FormBuilder } from '@angular/forms';
import {} from "googlemaps";
import { StepperSelectionEvent, MAT_STEPPER_GLOBAL_OPTIONS } from '@angular/cdk/stepper';
import { MatStepper } from '@angular/material';
@Component({
  selector: 'app-customer-details',
  templateUrl: './customer-details.component.html',
  styleUrls: ['./customer-details.component.css']
})
export class CustomerDetailsComponent implements OnInit {
  userName:string;
  public latitude: number;
  public longitude: number;
  public searchControl: FormControl;
  public zoom: number;
  public lat:number;
  public long:number;
  deliverAddress:string='';
  distance:number=31;
  orderId:String;
  isLinear = true;
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;
distanceFlag:boolean=false;
zipcode = new FormControl('', [Validators.required, Validators.minLength(6) , Validators.maxLength(6), Validators.pattern('[0-9]*')]);
houseno = new FormControl('', [Validators.required, Validators.pattern('[0-9a-zA-Z]*')]);
landmark = new FormControl('', [Validators.required]);
contactno = new FormControl('', [Validators.required,Validators.pattern('[0-9]*'),  Validators.minLength(10) , Validators.maxLength(10)]);
cardno = new FormControl('', [Validators.required,Validators.pattern('[0-9]*'),  Validators.minLength(16) , Validators.maxLength(16)]);
cvc = new FormControl('', [Validators.required,Validators.pattern('[0-9]*'),  Validators.minLength(3) , Validators.maxLength(3)]);
dp3 =  new FormControl('', [Validators.required]);  
mat = false;
@ViewChild("search")
  public searchElementRef: ElementRef;

  constructor(private customerService:CustomerService,private route:Router, private mapsAPILoader: MapsAPILoader, private ngZone: NgZone, private _formBuilder: FormBuilder) { }

  getZipcodeErrorMessage() {
    return this.zipcode.hasError('required') ? 'this field is required' : 
     this.zipcode.hasError('minLength') ? 'length must be equal  to 6' : 
     this.zipcode.hasError('pattern') ? 'only integer values are allowed' :
     this.zipcode.hasError('maxLength') ? '':'length must be equal  to 6' ;
  }
  gethouseErrorMessage() {
    return this.houseno.hasError('required') ? 'this field is required' :     
     this.houseno.hasError('pattern') ? 'only integer values are allowed':'' ;
  }
  getContactErrorMessage() {
    return this.contactno.hasError('required') ? 'You must enter a value' : 
    this.contactno.hasError('minLength') ? 'Not a valid contact' : 
    this.contactno.hasError('maxLength') ? 'Not a valid contact' :     
            this.contactno.hasError('pattern') ? '':'Not a valid contact';
  }
  getlandmarkErrorMessage() {
    return this.landmark.hasError('required') ? 'You must enter a value' : '';
  }
  getaddresskErrorMessage() {
    return this.searchControl.hasError('required') ? 'You must enter a value' : '';
  }


  getcardErrorMessage(){
    return this.cardno.hasError('required') ? 'You must enter a value' : 
    this.cardno.hasError('minLength') ? 'Not a valid card' : 
    this.cardno.hasError('maxLength') ? 'Not a valid card' :     
            this.cardno.hasError('pattern') ? 'Not a valid card no':'';

  }
  getcvcErrorMessage(){
    return this.cvc.hasError('required') ? 'You must enter a value' : 
    this.cvc.hasError('minLength') ? 'Not a valid cvc no.' : 
    this.cvc.hasError('maxLength') ? 'Not a valid cvc no.' :     
            this.cvc.hasError('pattern') ? 'Only digits allowed':'';

  }
  getdateErrorMessage(){
    return this.dp3.hasError('required') ? 'You must enter a value' : 
    '';

  }


  ngOnInit() {this.firstFormGroup = this._formBuilder.group({
    firstCtrl: ['', Validators.required]
  });
  this.secondFormGroup = this._formBuilder.group({
    secondCtrl: ['', Validators.required]
  });

    this.userName=localStorage.getItem("userName");
    if (localStorage.getItem('currentUser')) {
     //set google maps defaults 
     this.zoom = 4;
     // this.latitude = 39.8282;
     // this.longitude = -98.5795;
     this.latitude = 22.7200;
     this.longitude = 75.8577;
 
     this.lat=this.latitude;
     this.long=this.longitude;
     //create search FormControl
     this.searchControl = new FormControl('', [Validators.required]);
 
     //set current position
     this.setCurrentPosition();
 
     //load Places Autocomplete
     this.mapsAPILoader.load().then(() => {
       let autocomplete = new google.maps.places.Autocomplete(this.searchElementRef.nativeElement, {
         types: ["address"]
       });
       autocomplete.addListener("place_changed", () => {
         this.ngZone.run(() => {
           //get the place result
           //let place: new google.maps.places.PlaceResult = autocomplete.getPlace();
          let place :  google.maps.places.PlaceResult = autocomplete.getPlace();
           //verify result
           if (place.geometry === undefined || place.geometry === null) {
             return;
           }
 
           //set latitude, longitude and zoom
           this.latitude = place.geometry.location.lat();
           this.longitude = place.geometry.location.lng();
           this.zoom = 12;
          //  console.log(this.latitude);
          //  console.log(this.longitude);
          //  console.log(place.address_components[0].long_name);
            this.deliverAddress = place.address_components[0].long_name.toString();
           this.getDistance();
         });
       });
     });
 
    }
    else{
      this.route.navigate(['/'])
    }
  }
  rad(x:number){
    return x * Math.PI / 180;
  }
  
  getDistance(){
    var R = 6378137; // Earth’s mean radius in meter
    var dLat = this.rad(this.lat-this.latitude);
    var dLong = this.rad(this.long-this.longitude);
    var a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
      Math.cos(this.rad(this.latitude)) * Math.cos(this.rad(this.lat)) *
      Math.sin(dLong / 2) * Math.sin(dLong / 2);
    var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    var d = R * c;
    this.distance=d/1000;
    this.distanceFlag=true;
    console.log(d); 
  }
  
  private setCurrentPosition() {
      if ("geolocation" in navigator) {
        navigator.geolocation.getCurrentPosition((position) => {
          this.latitude = position.coords.latitude;
          this.longitude = position.coords.longitude;
          this.zoom = 12;
        });
      }
    }
  
  c = new CustomeDetals();
  adddetail(stepper: MatStepper){    
    console.log("sfisifi",stepper)
    //this.isLinear = false;
    stepper.linear = false;
    stepper.next();
    stepper.linear = true;
    this.c.userid=JSON.parse(localStorage.getItem('currentUser')).principal["userId"]
    this.c.houseNo = this.houseno.value
    this.c.address = this.deliverAddress
    this.c.landmark = this.landmark.value
    this.c.contactNo = this.contactno.value
    this.c.zipcode  = this.zipcode.value
    
   
     this.customerService.adddetail(this.c);
  }
  logout(){
    this.customerService.logout();
  }
  
buynow(stepper: MatStepper){
  stepper.linear = false;
    stepper.next();
    stepper.linear = true;
    this.mat = true;
    
  this.customerService.buynow().subscribe(
    res =>{
      this.mat  = false;
     this.orderId= JSON.parse(JSON.stringify(res))._body
        
    },
    err => {
        console.log(err.message);
    }) }

}
