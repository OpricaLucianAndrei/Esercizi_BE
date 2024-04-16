import java.util.Scanner;

public class For {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
        System.out.println("Questo programma fa il conto alla rovescia fino a zero a partire dal numero da te inserito.");
       int n = scanner.nextInt();
       contoAllaRovescia(n);
    }
    public static void contoAllaRovescia(int n) {
        for (int i = n; i >= 0; i--) {
            System.out.println(i);
        }
    }
}
