import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Category } from 'src/app/common/category';
import { CategoryService } from 'src/app/services/category.service';
import { ProductService } from 'src/app/services/product.service';
import Swal from 'sweetalert2';


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

  selectFile! : File;//esta variable puede ser nula le decimos con el !

  categories : Category [] = []; 

  constructor(private productService : ProductService, private router : Router, 
              private activatedRoute : ActivatedRoute, private toastr: ToastrService,
              private categoryService: CategoryService){

  }
  
  ngOnInit(): void {
    this.getProductById();
    this.getCategories();
   
  }

  addProduct(){
    const formData = new FormData(); 
    formData.append('idProduct',this.idProduct);
    formData.append('code', this.code);
    formData.append('nameProduct', this.nameProduct);
    formData.append('description', this.description);
    formData.append('price', this.price.toString());
    formData.append('urlImage', this.urlImage);
    formData.append('idUser', this.idUser);
    formData.append('idCategory', this.idCategory);
    formData.append('image', this.selectFile)

    console.log(formData);

    this.productService.createProduct(formData).subscribe(
      data => {console.log(data);
        if(this.idProduct === ""){
          Swal.fire({
            position: "top-end",
            icon: "success",
            title: "Producto Agregado!",
            showConfirmButton: false,
            timer: 2000
          });


          // this.toastr.success('Producto Registrado', 'Productos');
        }else{
          Swal.fire({
            position: "top-end",
            icon: "success",
            title: "Producto Modificado!",
            showConfirmButton: false,
            timer: 2000
          });
        //  this.toastr.success('Producto Modificado', 'Productos');
        }
        
        this.router.navigate(['admin/product']);
      }
    );    
  }

  getProductById(){
    this.activatedRoute.params.subscribe(
      product =>{
        let id = product['id'];
        if(id){
          console.log('el valor de la variable id es: '+id);
          this.productService.getProductById(id).subscribe(
            data =>{
              this.idProduct = data.idProduct;
              this.code = data.code;
              this.nameProduct = data.nameProduct;
              this.description = data.description;
              this.urlImage = data.urlImage;
              this.price = parseInt(data.price);
              this.idUser = data.idUser;
              this.idCategory = data.idCategory;
            }
          )
        }
      }
    );
  }


  onFileSelected(event : any){//nombre de metodo lo pongo yo
    this.selectFile = event.target.files[0];
  }

  getCategories(){
    return this.categoryService.getCategoryList().subscribe(
      data => this.categories = data
    );
  }
}
