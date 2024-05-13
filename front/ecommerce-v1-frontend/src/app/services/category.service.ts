import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Category } from '../common/category';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  private apiUrl : string = "http://localhost:8080/v1/api/category";

  constructor (private httpClient:HttpClient) { }

  getCategoryList():Observable<Category[]>{
    return this.httpClient.get<Category[]>(this.apiUrl);

  }

  createCategory(category:Category):Observable<Category>{
    return this.httpClient.post<Category>(this.apiUrl, category);

  }

  deleteCategoryById(id:string):Observable<any>{
    return this.httpClient.delete(`${this.apiUrl}/${id}`);

  }

  getCategoryById(id:string):Observable<Category>{
    return this.httpClient.get<Category>(`${this.apiUrl}/${id}`);

  }
}
