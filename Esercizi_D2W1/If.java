import java.util.Scanner;

public class If {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci una stringa e questo programma ritornerà true se la stringa è pari, false altrimenti.");
        String s = scanner.nextLine();
        stringaPariDispari(s);
        System.out.println("----------------------------------------------------------------");
        System.out.println("Inserisci un anno e questo programma ritornerà true se l'anno è bisestile, false altrimenti.");
        int a = scanner.nextInt();
        annoBisestile(a);
    }

    public static void stringaPariDispari(String s) {
        if (s.length() % 2 == 0) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    public static void annoBisestile(int a) {
        if (a % 4 == 0) {
            System.out.println("True");
        } else if (a % 100 == 0 && a % 400 == 0) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}

