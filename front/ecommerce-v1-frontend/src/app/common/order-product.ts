export class OrderProduct {
    constructor(
        public idOrder : string|null,
        public idProduct : string,
        public quantity : number,
        public price : number
    ){}
}
