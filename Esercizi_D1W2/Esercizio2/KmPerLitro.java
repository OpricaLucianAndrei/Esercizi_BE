public class KmPerLitro {
    public double divisione(double a, double b) throws DivisionePer0Exception{
        double risultato=0;

        if(b==0){
            throw new DivisionePer0Exception("Divisione per 0 non ammessa");
        }else{
            risultato=a/b;
        }

        return risultato;
    }
}
