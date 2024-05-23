export class ItemCart {
    constructor(public idProduct:String, 
                public nameProduct:string,
                public quantity:number,
                public price:number){

    }

    getTotalPriceItem(){
        return this.quantity * this.price;
    }
}
