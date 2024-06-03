import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../common/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private apiUrl : string = "http://localhost:8080/v1/api/user";

  constructor(private httpClient:HttpClient) { }

  getUserById(id:string):Observable<User>{
    //return this.httpClient.get<User>(this.apiUrl+'/'+id);
    return this.httpClient.get<User>(`${this.apiUrl}/${id}`);
  }
}
