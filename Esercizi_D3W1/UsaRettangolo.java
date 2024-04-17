import java.util.Scanner;

public class UsaRettangolo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Questo programma calcola il perimetro e l'area di un rettangolo dati base e altezza");
        System.out.println("Inserisci l'altezza del rettangolo: ");
        int altezza = scanner.nextInt();
        System.out.println("Inserisci la base del rettangolo: ");
        int base = scanner.nextInt();
        Rettangolo r = new Rettangolo(base, altezza);
        Rettangolo.stampaRettangolo(r.getLarghezza(), r.getAltezza());

        System.out.println("--------------------------------------------------------");

        System.out.println("Questo programma calcola il perimetro e l'area di due rettangolo dati base e altezza");

        System.out.println("Inserisci l'altezza del primo rettangolo: ");
        int altezza1 = scanner.nextInt();
        System.out.println("Inserisci la base del primo rettangolo: ");
        int base1 = scanner.nextInt();

        System.out.println("Inserisci l'altezza del secondo rettangolo: ");
        int altezza2 = scanner.nextInt();
        System.out.println("Inserisci la base del secondo rettangolo: ");
        int base2 = scanner.nextInt();

        Rettangolo r1 = new Rettangolo(base1, altezza1);
        Rettangolo r2 = new Rettangolo(base2, altezza2);

        Rettangolo.stampaDueRettangoli(r1.getLarghezza(), r1.getAltezza(), r2.getLarghezza(), r2.getAltezza());
    }
}
