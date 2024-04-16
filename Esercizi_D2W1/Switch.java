    import java.util.Scanner;

public class Switch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Questo programma stampa un numero da te inserito a lettere se il numero è compreso tra 0 e 3.");
        int i = scanner.nextInt();
        numberTranslate(i);

    }
    public static void numberTranslate(int i) {
        switch (i) {
            case 0:
                System.out.println("Zero");
                break;
            case 1:
                System.out.println("Uno");
                break;
            case 2:
                System.out.println("Due");
                break;
            case 3:
                System.out.println("Tre");
                break;
            default:
                System.out.println("Non valido");
                break;
        }
    }

}
