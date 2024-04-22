import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Main {
    static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        logger.warn("Sto lanciando l'applicazione");

        try {
            System.out.println("Inserisci i km percorsi: ");
            double km = scanner.nextDouble();
            System.out.println("Inserisci i litri di carburante consumati: ");
            double litri = scanner.nextDouble();

            KmPerLitro kmPerLitro = new KmPerLitro();
            System.out.println("Numero di km per litro: " + kmPerLitro.divisione(km, litri));
        } catch ( java.util.InputMismatchException e ) {
            logger.error("Errore: Inserire un valore numerico valido.");
        } catch ( ArithmeticException e ) {
            System.out.println("Divisione per 0 non ammessa");
        } catch (DivisionePer0Exception e){
            System.out.println(e.getMessage());
        }
        logger.info("Sto terminando l'applicazione");
    }
}
