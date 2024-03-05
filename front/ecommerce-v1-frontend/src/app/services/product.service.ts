import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Product } from '../common/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private apiUrl : string = "http://localhost:8080/v1/api/product";

  constructor (private httpClient:HttpClient) { }

  getProducts():Observable<Product[]>{
    return this.httpClient.get<Product[]>(this.apiUrl);
  }

  createProduct(formData:any):Observable<any>{
    return this.httpClient.post<Product>(this.apiUrl, formData);
  }

  deleteProductById(id:string):Observable<any>{
    console.log(id)
    return this.httpClient.delete(this.apiUrl +"/"+id)
  }

  getProductById(id:string):Observable<Product>{
    return this.httpClient.get<Product>(this.apiUrl+"/"+id)
  }
   
}
