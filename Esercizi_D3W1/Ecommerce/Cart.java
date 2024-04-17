package Ecommerce;

import java.util.ArrayList;

public class Cart {
    private Client client;
    private ArrayList<Article> articles;
    private double totalPrice;

    public Cart(Client client) {
        this.client = client;
        this.articles = new ArrayList<>();
        this.totalPrice = 0.0;
    }
    public void addArticle(Article article) {
        if (article.getQuantitaArticolo() > 0) {
            articles.add(article);
            totalPrice += article.getPrezzoArticolo();
            article.setQuantitaArticolo(article.getQuantitaArticolo() - 1);
            System.out.println("Articolo aggiunto al carrello");
        }
        else {
            System.out.println("Articolo non disponibile");
        }
    }
    public void removeArticle(Article article) {
        if (articles.remove(article)) {
            totalPrice -= article.getPrezzoArticolo();
            article.setQuantitaArticolo(article.getQuantitaArticolo() + 1);
            System.out.println("Articolo rimosso dal carrello");
        }
        else {
            System.out.println("Articolo non presente nel carrello");
        }
    }
    public void showArticlesDetails() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("Cliente: " + client.getNomeCompletoCliente());
        System.out.println("Elenco articoli nel carrello: ");
        for (Article article : articles) {
            System.out.println(" - " + article.getCodiceArticolo() + " - " + article.getQuantitaArticolo() + " - " + article.getPrezzoArticolo());
        }
        System.out.println("Totale costo carrello: " + totalPrice);
        System.out.println("----------------------------------------------------------------");
    }
}
