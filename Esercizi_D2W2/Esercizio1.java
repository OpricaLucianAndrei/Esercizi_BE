import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;

public class Esercizio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> parole = new HashSet<>();
        List<String> duplicati = new ArrayList<>();

        System.out.println("Inserisci il numero di parole seguito dal tasto invio: ");
        int numeroElementi = Integer.parseInt(scanner.nextLine());

        if (numeroElementi > 0) {
            for (int i = 0; i < numeroElementi; i++) {
                System.out.println("Inserisci una parola: ");
                String parola = scanner.nextLine();
                boolean aggiunta = parole.add(parola);
                if (!aggiunta) {
                    System.out.println("La parola " + parola + " è già presente");
                    duplicati.add(parola);
                }
            }
            System.out.println("Nymero di parole: " + parole.size());
            System.out.println("Parole: " + parole);
            System.out.println("Duplicati: " + duplicati);
        } else {
            System.out.println("Inserisci un numero maggiore di 0");
        }
        scanner.close();
    }

}
