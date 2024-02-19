export class Product {

    constructor(
        public idProduct:string,
        public nameProduct:string,
        public code:string,
        public description:string,
        public price:string,
        public urlImage:string,
        public image:File,
        public idUser:string,
        public idCategory:string
    ){}


}
