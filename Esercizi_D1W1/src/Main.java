import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Questo programma fa una moltiplicazione!");
        System.out.println("Inserisci i due fattori usando tastiera e tasto invio per la conferma del numero");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        int moltiplicazione = moltiplicazione(num1, num2);
        System.out.println("Il tuo risultato è:");
        System.out.println(moltiplicazione);
        System.out.println("---------------");
        System.out.println("Questo programma concatena ad una stringa un intero!");
        System.out.println("Inserisci una stringa e poi un intero usando tastiera e tasto invio per la conferma della stringa e del intero");
        String stringa = scanner.nextLine();
        int numero = scanner.nextInt();
        String concatenato = concatena(stringa, numero);
        System.out.println("Il risultato della concatenazione è:");
        System.out.println(concatenato);
        scanner.nextLine();
        System.out.println("---------------");
        System.out.println("Questo programma inserisce una stringa in un array di stringhe inserendolo all'indice 3!");
        System.out.println("Inserisci un'array di 5 stringhe separate da invio:");
        String[] array = new String[5];
        array[0]=scanner.nextLine();
        array[1]=scanner.nextLine();
        array[2]=scanner.nextLine();
        array[3]=scanner.nextLine();
        array[4]=scanner.nextLine();
        System.out.println("Inserisci la stringa da aggiungere:");
        String stringaDaAggiungere = scanner.nextLine();

        String[] nuovoArray = inserisciInArray(array, stringaDaAggiungere);
        System.out.println("Il nuovo array è:");
        System.out.println(Arrays.toString(nuovoArray));
        System.out.println("---------------");

        System.out.println("Questo programma ordina stringhe!");
        String[] inputStrings = new String[3];
        System.out.println("Inserisci la prima stringa e premi invio");
        inputStrings[0] = scanner.nextLine();
        System.out.println("Inserisci la seconda stringa e premi invio");
        inputStrings[1] = scanner.nextLine();
        System.out.println("Inserisci la terza stringa e premi invio");
        inputStrings[2] = scanner.nextLine();

        System.out.println("Le stringhe concatenate:");
        System.out.println(inputStrings[0] + inputStrings[1] + inputStrings[2]);

        System.out.println("Le stringhe ordinate al contrario");
        System.out.println(inputStrings[2] + inputStrings[1] + inputStrings[0]);
        System.out.println("---------------");
        System.out.println("Questo programma calcola il perimetro del rettangolo!");
        System.out.println("Inserisci la misura del primo lato");
        double l1 = scanner.nextInt();
        System.out.println("Inserisci la misura del secondo lato");
        double l2 = scanner.nextInt();
        System.out.println("Il perimetro è:");
        System.out.println(perimetroRettangolo(l1, l2));
        System.out.println("---------------");
        System.out.println("Questo programma verifica se un numero da te inserito è pari o dispari!");
        System.out.println("inserissci un numero e premi invio");
        int n = scanner.nextInt();
        pariDispari(n);
        System.out.println("---------------");
        System.out.println("Questo programma calcola l'area del triangolo dati 3 lati!");
        System.out.println("inserisci i tre lati seguiti ciascuno dal tasto invio");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        System.out.println(areaTriangolo(a, b, c));

    }

    public static int moltiplicazione(int x, int y) {
        return x * y;
    }

    public static String concatena(String s, int a) {
        return s + "" + a;
    }
    public static String[] inserisciInArray(String[] array, String s) {
        String[] newArray = new String[array.length + 1];

        for (int i = 0; i < 2; i++) {
            newArray[i] = array[i];
        }

        newArray[2] = s;

        for (int i = 3; i < newArray.length; i++) {
            newArray[i] = array[i-1];
        }

        return newArray;
    }

    public static double perimetroRettangolo(double l1, double l2) {
        return (l1*2)+(l2*2);
    }

    public static void pariDispari(int x) {
        if (x % 2 == 0){
            System.out.println("il numero è pari");
        } else {
            System.out.println("il numero è dispari");
        }
    }

    public static double areaTriangolo(double l1, double l2, double l3) {
        double semiperimetro = (l1 + l2 + l3) / 2;
        double A = Math.sqrt(semiperimetro * (semiperimetro - l1) * (semiperimetro - l2) * (semiperimetro - l3));
        return A;
    }


}
