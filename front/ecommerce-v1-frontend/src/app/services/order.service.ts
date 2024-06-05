import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Order } from '../common/order';

@Injectable({
  providedIn: 'root'
})
export class OrderService {
  private apiUrl : string = "http://localhost:8080/v1/api/order";
  private update: string = "/update/state";

  constructor(private httpClient:HttpClient) { }

  createOrder(order:Order):Observable<Order>{
    return this.httpClient.post<Order>(this.apiUrl, order);
  }

  updateOrder(formData:any):Observable<any>{
    return this.httpClient.post(`${this.apiUrl}/${this.update}`, formData);
    
  }

  getOrderByUser(idUser:string):Observable<Order[]>{
    return this.httpClient.get<Order[]>(`${this.apiUrl}/${idUser}`);

  }

  getOrderById(idOrder:string):Observable<Order>{
    return this.httpClient.get<Order>(`${this.apiUrl}/${idOrder}`);
  }
}
