export class Book {

  id: number;
  title: string;
  overview: string;
  price: number;


  constructor(id: number, title: string, overview: string, price: number) {
    this.id = id;
    this.title = title;
    this.overview = overview;
    this.price = price;
  }
}
