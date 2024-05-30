import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { ItemCart } from 'src/app/common/item-cart';
import { CartService } from 'src/app/services/cart.service';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-detail-product',
  templateUrl: './detail-product.component.html',
  styleUrls: ['./detail-product.component.css']
})
export class DetailProductComponent implements OnInit{

  idProduct : string = '';
  nameProduct : string = '';
  description : string = '';
  price : number = 0;
  urlImage : string = '';
  quantity : number = 0;

  ngOnInit(): void {
    this.getProductById();
    
  }

  constructor(private productService:ProductService, 
              private activatedRoute:ActivatedRoute,
              private cartService:CartService,
              private toastr:ToastrService){
  }

  getProductById(){
    this.activatedRoute.params.subscribe(
      p => {
        let id = p['id'];
        if(id){
          this.productService.getProductById(id).subscribe(
            data => {
              this.idProduct = data.idProduct;
              this.nameProduct = data.nameProduct;
              this.description = data.description;
              this.urlImage = data.urlImage;
              this.price = parseInt(data.price);

            }
          );
        }
      }
    );
  }

  addCart(id : string){
    console.log('id product', this.idProduct);
    console.log('name product', this.nameProduct);
    console.log('price product', this.price);
    console.log('quantity', this.quantity);

    let item = new ItemCart(this.idProduct, this.nameProduct, this.quantity, this.price);

    this.cartService.addItemCart(item);

    console.log("Total carrito: ");
    console.log(this.cartService.totalCart());

    this.toastr.success('Producto agregado al carrito!', 'Carrito compras');


  }
}
