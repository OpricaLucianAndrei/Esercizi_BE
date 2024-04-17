package Ecommerce;

public class Main {
    public static void main(String[] args) {
        Client client1 = new Client(1, "Mario Rossi", "mario@rossi.com");
        Client client2 = new Client(2, "Giuseppe Verdi", "giuseppe@verdi.com");

        Article article1 = new Article(1, "Libro Java" , 40.0, 5);
        Article article2 = new Article(2, "Libro C#" , 30.0, 10);
        Article article3 = new Article(3, "Libro C++", 20.0, 20);
        Article article4 = new Article(4, "Libro Js", 25.0, 7);

        Cart cart1 = new Cart(client1);
        Cart cart2 = new Cart(client2);

        cart1.addArticle(article1);
        cart1.addArticle(article2);
        cart1.addArticle(article4);
        cart1.removeArticle(article4);
        cart2.addArticle(article3);
        cart2.addArticle(article4);

        cart1.showArticlesDetails();
        cart2.showArticlesDetails();


    }
}
