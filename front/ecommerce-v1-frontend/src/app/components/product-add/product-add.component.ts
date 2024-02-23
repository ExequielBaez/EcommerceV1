import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/services/product.service';


@Component({
  selector: 'app-product-add',
  templateUrl: './product-add.component.html',
  styleUrls: ['./product-add.component.css']
})

export class ProductAddComponent implements OnInit{
  
  idProduct : string = '';
  code : string = '';
  nameProduct : string = '';
  description : string = '';
  price : number = 0;
  urlImage : string = '';
  idUser : string = "1";
  idCategory : string = "90723e75-4f05-4ca9-a31f-867b1abac01b";

  constructor(private productService : ProductService){

  }
  
  ngOnInit(): void {
   
  }

  addProduct(){
    const formData = new FormData(); 
    formData.append('idProduct',this.idProduct);
    formData.append('code', this.code);
    formData.append('name', this.nameProduct);
    formData.append('description', this.description);
    formData.append('price', this.price.toString());
    formData.append('urlImage', this.urlImage);
    formData.append('idUser', this.idUser);
    formData.append('idcategory', this.idCategory);

    console.log(formData);
  }

}
