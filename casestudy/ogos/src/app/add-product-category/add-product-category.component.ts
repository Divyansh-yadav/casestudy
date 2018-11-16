import { Component, OnInit } from '@angular/core';
import { ProductCategory } from '../customer/product-category';
import { ProductCategoryService } from './product-category.service';
import { CustomerService } from '../customer.service';
import { ToasterService, ToasterConfig} from 'angular2-toaster';
import { FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
@Component({
  selector: 'app-add-product-category',
  templateUrl: './add-product-category.component.html',
  styleUrls: ['./add-product-category.component.css']
})
export class AddProductCategoryComponent implements OnInit {
productCategory=new ProductCategory();
userName:string;
categoryName = new FormControl('', [Validators.required, Validators.pattern('^[a-zA-Z]*')]);
// categoryName = new FormControl('', [Validators.required]);
public config1: ToasterConfig = 
  new ToasterConfig({      
      tapToDismiss: true, 
      timeout: 1590
  });
  constructor(private productCategoryService:ProductCategoryService, private route: Router,private customerService: CustomerService, private toasterService: ToasterService) { }
  ngOnInit() {
    this.userName=localStorage.getItem("userName");
    if (localStorage.getItem('currentUser')) {
      
    }
    else {
      this.route.navigate(['/'])
    }
  }

  getNameErrorMessage(){
    return this.categoryName.hasError('required') ? 'You must enter a value' :
    this.categoryName.hasError('pattern') ? 'Invalid input' :
      '';
}

  onFileChange(event) {
    const fileSelected: File = event.target.files[0];
     this.productCategory.imageUrl=fileSelected.name;
  }

  addNewProductCategory() {
    this.productCategory.categoryName=this.categoryName.value;
    if(this.productCategory.imageUrl === undefined) {
      this.productCategory.imageUrl="No_Image_Available.png"
    }
    this.productCategoryService.addNewProductCategory(this.productCategory)
    .subscribe(res =>{
      this.toasterService.pop('success', 'Category created', 'Category has been successfully created ');
  })
  }
  logout() {
    this.customerService.logout();
  }


 
}
