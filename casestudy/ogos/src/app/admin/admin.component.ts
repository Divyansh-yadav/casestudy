import { Component, OnInit } from '@angular/core';
import { ProductServiceService } from '../customer/product-service.service'
import { Product } from '../customer/product';
import { Router } from '@angular/router';
import { ProductCategory } from '../customer/product-category';
import { CustomerService } from '../customer.service'


@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  gridColumnApi;

  private gridApi;
  product: Product;
  individualProduct: Product;
  productCategory: ProductCategory;
  rowData: any;
  constructor(private productServiceService: ProductServiceService, private router: Router, private customerService: CustomerService) { }
  ngOnInit() {
    if (localStorage.getItem('currentUser')){
      this.productServiceService.getProductCategory()
        .subscribe(
          data => {
            this.productCategory = data.json();
            console.log("Category data fetched")
          }
        );
      this.productServiceService.getAllProducts()
        .subscribe(
          data => {
            //  console.log(data)
            this.product = data.json();
            this.rowData = data.json()
            console.log("Fetched all products ")
          }
        );
    }
    else {
      this.router.navigate(['/'])
    }
  }
  getRowData() {
    var rowData = [];
    this.gridApi.forEachNode(function (node) {
      rowData.push(node.data);
    });
    console.log("Row Data:");
    console.log(rowData);
  }

  columnDefs = [
    { headerName: 'Product Name', field: 'productName', width: 600 },
    { headerName: 'Quantity', field: 'quantity', width: 220 },
    { headerName: 'weight Per Item (gm)', field: 'weight', width: 200 },
    { headerName: 'Price Per Item (₹) ', field: 'price', width: 200 },
    // { headerName: "Actions", field: 'productId',width:200 },
    {
      headerName: "Actions",
      template:
        `
        <span class="glyphicon glyphicon-pencil"></span>
     
     
       `,width:400 }
  ];

  // Fetching the details of individual product details.
  public onRowClicked(e) {
    console.log("Event Generation on Edit Button")
    console.log(e.data.productId);
    localStorage.setItem('productId', e.data.productId);
    this.router.navigate(["/edit"]);
  }

  getProductDetails(productId) {

    localStorage.setItem('productId', productId);
    console.log("Individual Product Details Fetched")
    this.router.navigate(["/edit"]);
  }

  onGridReady(params) {
    
    this.gridApi = params.api;
    this.gridColumnApi = params.columnApi;
  }
  logout() {
    this.customerService.logout();
  }
}

