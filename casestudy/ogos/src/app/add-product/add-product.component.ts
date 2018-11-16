import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { ProductServiceService } from '../customer/product-service.service';
import { ProductCategory } from '../customer/product-category';
import { Product } from '../customer/product';
import { AddProductService } from './add-product.service';
import { Router } from '@angular/router';
import { CustomerService } from '../customer.service';
import { MatSnackBar } from '@angular/material';
import { FormControl, Validators } from '@angular/forms';
import { ToasterModule, ToasterService, ToasterConfig } from 'angular2-toaster';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {

  productName = new FormControl('', [Validators.required, Validators.pattern('^[a-zA-Z_ ]*')]);
  price = new FormControl('', [Validators.required, Validators.pattern('^[1-9][0-9]*([.][0-9]+)?$')]);
  quantity = new FormControl('', [Validators.required, Validators.pattern('^[0-9]*')]);
  weight = new FormControl('', [Validators.required, Validators.pattern('^[1-9][0-9]*([.][0-9]+)?$')]);
  categoryId = new FormControl('', [Validators.required]);
  public config1: ToasterConfig =
    new ToasterConfig({
      tapToDismiss: true,
      timeout: 1590
    });
  constructor(private productServiceService: ProductServiceService, private addNewProductService: AddProductService, private route: Router, private customerService: CustomerService,
    private toasterService: ToasterService, private snackBar: MatSnackBar) { }
  productCategory: ProductCategory;
  product = new Product();
  userName: string;
  ngOnInit() {
    this.userName = localStorage.getItem("userName");
    if (localStorage.getItem('currentUser')) {
      this.productServiceService.getProductCategory()
        .subscribe(
          data => {
            this.productCategory = data.json();
          }
        );
    }
    else {
      this.route.navigate(['/'])
    }
  }

  //  This method adds the new product to the category.
  addNewProduct() {
    this.product.productName = this.productName.value;
    this.product.weight = this.weight.value
    this.product.quantity = this.quantity.value
    this.product.price = this.price.value
    this.product.categoryId = this.categoryId.value;
    if (this.product.imageUrl === undefined) {
      this.product.imageUrl = "No_Image_Available.png"
    }
    this.addNewProductService.addNewProduct(this.product)
      .subscribe(res => {
        this.route.navigate(['/admin']);
        this.snackBar.open('Product added successfully !', ' ', {
          duration: 3000, verticalPosition: 'top', horizontalPosition: 'end'
        });
      })
  }
  getNameErrorMessage() {
    return this.productName.hasError('required') ? 'You must enter a value' :
      this.productName.hasError('pattern') ? 'Invalid input' :
        '';
  }
  getPriceErrorMessage() {
    return this.price.hasError('required') ? 'You must enter a value' :
      this.price.hasError('pattern') ? 'Invalid input' :
        '';

  }
  getQuantityErrorMessage() {
    return this.quantity.hasError('required') ? 'You must enter a value' :
      this.quantity.hasError('pattern') ? 'Invalid input' :
        '';

  }
  getWeightErrorMessage() {
    return this.weight.hasError('required') ? 'You must enter a value' :
      this.weight.hasError('pattern') ? 'Invalid input' :
        '';
  }

  getCompanySizeErrorMessage() {
    return this.categoryId.hasError('required') ? 'You must enter a value' : '';
  }


  // This method fetches the url of the image.
  onFileChange(event) {
    const fileSelected: File = event.target.files[0];

    this.product.imageUrl = fileSelected.name;
  }
  logout() {
    this.customerService.logout();
  }
}
