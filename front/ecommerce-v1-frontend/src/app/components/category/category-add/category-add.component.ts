import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Category } from 'src/app/common/category';
import { CategoryService } from 'src/app/services/category.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-category-add',
  templateUrl: './category-add.component.html',
  styleUrls: ['./category-add.component.css']
})
export class CategoryAddComponent implements OnInit{
  idCategory : string = "";
  nameCategory : string = "";

  constructor(private categoryService:CategoryService,
              private toastr:ToastrService, 
              private router:Router,
              private activatedRoute:ActivatedRoute){

              }
  
  ngOnInit(): void {   
    this.getCategoryById(); 
    }

  addCategory(){
    console.log(this.nameCategory);
    let category = new Category(this.idCategory, this.nameCategory);
    this.categoryService.createCategory(category).subscribe(
      respuesta=>{
        //this.toastr.success('Categoria registrada', 'Categorias');
        Swal.fire({
          position: "top-end",
          icon: "success",
          title: "Categoria Agregada!!",
          showConfirmButton: false,
          timer: 2000})
        this.router.navigate(['admin/category']);
      }
    )
  }

  getCategoryById(){
    this.activatedRoute.params.subscribe(
      category =>{
        let id = category['id'];
        if(id){
          console.log("Este es el id: "+id);
          this.categoryService.getCategoryById(id).subscribe(
            data => {
              this.idCategory =data.idCategory;
              this.nameCategory = data.nameCategory;
            }  
          )
        }
      } 
    );
  }

}
