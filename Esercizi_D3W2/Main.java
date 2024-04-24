import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(1, "aldo", 2);
        Customer customer1 = new Customer(2, "giovanni", 1);
        Customer customer2 = new Customer(3, "giacomo", 3);
        Customer customer3 = new Customer(4, "marco", 2);


        List<Product> listaProdotti = new ArrayList<>();
        listaProdotti.add(new Product(1, "Libro1", "Books", 25.99));
        listaProdotti.add(new Product(2, "Libro2", "Books", 105.99));
        listaProdotti.add(new Product(3, "Libro3", "Books", 15.99));
        listaProdotti.add(new Product(4, "Libro4", "Books", 125.99));
        listaProdotti.add(new Product(5, "Libro5", "Books", 35.99));
        listaProdotti.add(new Product(6, "Boys1", "Boys", 25.99));
        listaProdotti.add(new Product(7, "Boys2", "Boys", 105.99));
        listaProdotti.add(new Product(8, "Boys3", "Boys", 15.99));
        listaProdotti.add(new Product(9, "Boys4", "Boys", 125.99));
        listaProdotti.add(new Product(10, "Baby1", "Baby", 35.99));
        listaProdotti.add(new Product(11, "Baby2", "Baby", 55.99));
        listaProdotti.add(new Product(12, "Baby3", "Baby", 95.99));



        List<Product> libriCostosi = listaProdotti.stream()
                .filter(product -> product.getCategory().equals("Books") && product.getPrice() > 100)
                .toList();

        System.out.println("-------------------------------Esercizio1------------------------------");
        System.out.println("Prodotti appartenenti alla categoria 'Books' con prezzo maggiore di 100:");
        libriCostosi.forEach(p-> System.out.println(p));
        System.out.println("-----------------------------------------------------------------------");



        List<Product> prodottiPerBambini = listaProdotti.stream()
                .filter(product -> product.getCategory().equals("Baby"))
                .toList();

        System.out.println("-------------------------------Esercizio2------------------------------");
        System.out.println("Prodotti appartenenti alla categoria 'Baby':");
        prodottiPerBambini.forEach(p-> System.out.println(p));
        System.out.println("-----------------------------------------------------------------------");



        List<Product> prodottiPerRagazzi = listaProdotti.stream()
                .filter(product -> product.getCategory().equals("Boys"))
                .map(product -> new Product(product.getId(), product.getName(), product.getCategory(), product.getPrice() * 0.9))
                .toList();

        System.out.println("-------------------------------Esercizio3------------------------------");
        System.out.println("Prodotti appartenenti alla categoria 'Boys':");
        prodottiPerRagazzi.forEach(p-> System.out.println(p));
        System.out.println("-----------------------------------------------------------------------");

        List<Product> prodottiCustomer = new ArrayList<Product>();
        for (Product p : listaProdotti) {
            if (p.getId() % 2 == 0) {
                prodottiCustomer.add(p);
            }
        }
        List<Product> prodottiCustomer1 = new ArrayList<Product>();
        for (Product p : listaProdotti) {
            if (p.getId() % 2 != 0) {
                prodottiCustomer1.add(p);
            }
        }
        List<Product> prodottiCustomer2 = new ArrayList<Product>();
        for (Product p : listaProdotti) {
            if (p.getCategory().equals("Books") && p.getPrice() < 100) {
                prodottiCustomer2.add(p);
            }
        }
        List<Product> prodottiCustomer3 = new ArrayList<Product>();
        for (Product p : listaProdotti) {
            if (p.getCategory().equals("Baby")) {
                prodottiCustomer3.add(p);
            }
        }


        Order order1 = new Order(1, "delivered", LocalDate.of(2021, 2, 5), LocalDate.of(2021, 2, 1), prodottiCustomer ,customer);
        Order order2 = new Order(2, "pending", LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 21), prodottiCustomer1 ,customer1);
        Order order3 = new Order(3, "pending", LocalDate.of(2021, 3, 20), LocalDate.of(2021, 4, 6), prodottiCustomer2 ,customer2);
        Order order4 = new Order(4, "delivered", LocalDate.of(2021, 3, 15), LocalDate.of(2021, 4, 3), prodottiCustomer3 ,customer3);

        List<Order> listaOrdini = new ArrayList<>();
        listaOrdini.add(order1);
        listaOrdini.add(order2);
        listaOrdini.add(order3);
        listaOrdini.add(order4);

        LocalDate startDate = LocalDate.of(2021, 2, 1);
        LocalDate endDate = LocalDate.of(2021, 4, 1);

        List<Product> prodottiOrdinatiDaTier2 = listaOrdini.stream()
                .filter(order -> order.getCustomer().getTier() == 2)
                .filter(order -> order.getOrderDate().isAfter(startDate) && order.getOrderDate().isBefore(endDate))
                .flatMap(order -> order.getProducts().stream())
                .toList();

        System.out.println("-------------------------------Esercizio4------------------------------");
        System.out.println("Prodotti ordinati da clienti di livello (tier) 2 tra l'01-Feb-2021 e 1'01-Apr-2021:");
        prodottiOrdinatiDaTier2.forEach(p-> System.out.println(p));
        System.out.println("-----------------------------------------------------------------------");

    }
}
