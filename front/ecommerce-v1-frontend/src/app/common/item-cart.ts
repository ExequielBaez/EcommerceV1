export class ItemCart {
    constructor(public idProduct:string, 
                public nameProduct:string,
                public quantity:number,
                public price:number){

    }

    getTotalPriceItem(){
        return this.quantity * this.price;
    }
}
