package Telefono;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci il numero di telefono:");
        String numeroTelefono = scanner.nextLine();
        Sim sim = new Sim(numeroTelefono);
        sim.stampaDatiSim();
        boolean continua = true;
        while (continua) {
            System.out.println("Cosa vuoi fare? (ricarica, chiudi telefono, effettua chiamata):");
            String scelta = scanner.nextLine();

            switch (scelta) {
                case "ricarica":
                    System.out.println("Inserisci l'importo della ricarica:");
                    double importoRicarica = scanner.nextDouble();
                    sim.ricaricaCredito(importoRicarica);
                    scanner.nextLine();
                    break;
                case "effettua chiamata":
                    System.out.println("Inserisci il numero del destinatario:");
                    String destinatario = scanner.nextLine();
                    System.out.println("Inserisci la durata della chiamata in minuti:");
                    int durataChiamata = scanner.nextInt();
                    scanner.nextLine();
                    sim.effettuaChiamata(destinatario, durataChiamata);
                    break;
                case "chiudi telefono":
                    continua = false;
                    break;
                default:
                    System.out.println("Comando non valido.");
                    break;
            }
        }

        sim.stampaDatiSim();
        scanner.close();
    }
}
