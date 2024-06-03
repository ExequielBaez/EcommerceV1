import { OrderProduct } from "./order-product";
import { OrderState } from "./order-state";

export class Order {
    constructor(
        public idOrder : string,
        public dateCreated : Date,
        public orderProducts : OrderProduct [],
        public idUser : string,
        public state : OrderState
    ){}

    getTotal(){
        let total = 0;
        for(let orderProduct of this.orderProducts){
            total += orderProduct.price * orderProduct.quantity;
            console.log('Total: '+total);
        }
    }
}
