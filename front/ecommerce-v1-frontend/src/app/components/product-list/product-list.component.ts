import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/common/product';
import { ProductService } from 'src/app/services/product.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit{
  
  products : Product[] = [];

  constructor(private productService:ProductService){}
  
  ngOnInit(): void {
    this.listProducts();
    
  }

  listProducts(){
    this.productService.getProducts().subscribe(
      data => {
        this.products = data
        console.log(data);            
      }
    );
  }

  deleteProductById(id:string){

    Swal.fire({//libreria sweetalert2
      title: "Estas seguro?",
      text: "Una vez borrado no podras recuperarlo!",
      icon: "warning",
      showCancelButton: true,
      confirmButtonColor: "#3085d6",
      cancelButtonColor: "#d33",
      confirmButtonText: "Si, borrarlo!",
      cancelButtonText: "Cancelar"
    }).then((result) => {
      if (result.isConfirmed) {
        this.productService.deleteProductById(id).subscribe(
          () => this.listProducts() 
        );
        Swal.fire({
          title: "Listo, Borrado!",
          text: "Producto eliminado",
          icon: "success"
        });
      }
    });

   
  }

}
