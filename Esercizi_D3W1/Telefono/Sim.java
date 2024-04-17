package Telefono;

import java.util.ArrayList;

public class Sim {
    private String numero;
    private double credit;
    private ArrayList<Chiamata> ultimeChiamate;

    class Chiamata {
        private int durata;
        private String destinatario;

        public Chiamata(int durata, String destinatario) {
            this.durata = durata;
            this.destinatario = destinatario;
        }

        public int getDurata() {
            return durata;
        }

        public String getDestinatario() {
            return destinatario;
        }

    }

    public Sim(String numeroTelefono) {
        this.numero = numeroTelefono;
        this.credit = 0.0;
        this.ultimeChiamate = new ArrayList<Chiamata>();
    }
    public double getCredit() {
        return credit;
    }
    public void ricaricaCredito(double importo) {
        credit += importo;
        System.out.println("Credito ricaricato. Nuovo credito disponibile: " + credit);
    }

    public void effettuaChiamata(String destinatario, int durata) {
        double costoChiamata = 0.2 * durata;
        if (credit >= costoChiamata) {
            credit -= costoChiamata; //
            ultimeChiamate.add(new Chiamata(durata, destinatario));
            System.out.println("Chiamata effettuata a " + destinatario + ". Credito rimanente: " + credit);
        } else {
            System.out.println("Credito insufficiente per effettuare la chiamata.");
        }
    }

    public void stampaDatiSim() {
        System.out.println("Numero Telefono: " + numero);
        System.out.println("Credit: " + credit);
        System.out.println("Ultime Chiamate: ");
        for (Chiamata c : ultimeChiamate) {
            System.out.println("Numero chiamato: " + c.getDestinatario() +
                    ", Durata: " + c.getDurata() + " minuti");
        }
    }
}
