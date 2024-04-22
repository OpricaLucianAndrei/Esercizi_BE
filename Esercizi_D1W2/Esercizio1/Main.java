import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        logger.warn("Sto lanciando l'applicazione");
        int[] array = new int[5];
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10)+1;
        }

        System.out.println("L'array generato randomicamente è: ");
        printArray(array);

        int position;
        int value;
        boolean validInput = true;

        while (validInput) {
            System.out.print("Inserisci la posizione (da 1 a 5, 0 per uscire): ");
            position = scanner.nextInt();

            if (position == 0) {
                validInput = false;
                break;
            }

            System.out.println("Inserisci il valore: ");
            value = scanner.nextInt();

            if (position < 1 || position > array.length) {
                logger.error("Errore: Posizione non valida.");
                validInput = false;
            } else {
                array[position - 1] = value;
                validInput = true;
            }
            if (validInput) {
                System.out.println("L'array aggiornato è: ");
                printArray(array);
            }
        }
        logger.info("Sto terminando l'applicazione");
        scanner.close();
    }

    public static void printArray(int[] array) {
        for (int j : array) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
}
