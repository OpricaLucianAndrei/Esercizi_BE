public class Rettangolo {
    private int larghezza;
    private int altezza;

    public Rettangolo(int larghezza, int altezza) {
        this.larghezza = larghezza;
        this.altezza = altezza;
    }

    public int getLarghezza() {
        return larghezza;
    }

    public int getAltezza() {
        return altezza;
    }

    public static int perimetro(int b, int h) {
        return 2 * (b + h);
    }

    public static int area(int b, int h) {
        return b * h;
    }

    public static void stampaRettangolo(int b, int h) {
        System.out.println("Il rettangolo ha l'area: " + area(b, h) + " e il perimetro: " + perimetro(b, h));
    }

    public static void stampaDueRettangoli(int b1, int h1, int b2, int h2) {
        System.out.println("Il primo rettangolo ha l'area: " + area(b1, h1) + " e il perimetro: " + perimetro(b1, h1));
        System.out.println("Il secondo rettangolo ha l'area: " + area(b2, h2) + " e il perimetro: " + perimetro(b2, h2));
        System.out.println("L'area totale dei due rettangoli è: " + (area(b1, h1) + area(b2, h2)));
        System.out.println("Il perimetro totale dei due rettangoli è: " + (perimetro(b1, h1) + perimetro(b2, h2)));
    }
}
