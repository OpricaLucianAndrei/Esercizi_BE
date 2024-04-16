import java.util.Scanner;

public class While {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Questo programma suddivide i caratteri di una stringa da te inserita inserendo una virgola, e si interrompe solo quando inserisci :q.");
        String s = "";

        while (true) {
            System.out.print("Inserisci una stringa (o :q per uscire): ");
            String input = scanner.nextLine();

            if (input.equals(":q")) {
                break;
            }

            s += input;
            suddividiCaratteri(input);
        }
    }

    public static void suddividiCaratteri(String s) {
        for (int i = 0; i < s.length(); i++) {
            System.out.print(s.charAt(i));
            if (i != s.length() - 1) {
                System.out.print(",");
            }
        }
        System.out.println();
    }
}
