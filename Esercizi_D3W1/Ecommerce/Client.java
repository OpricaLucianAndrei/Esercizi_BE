package Ecommerce;

public class Client {
    private int codiceCliente;
    private String nomeCompletoCliente;
    private String emailCliente;

    public Client(int codiceCliente, String nomeCompletoCliente, String emailCliente) {
        this.codiceCliente = codiceCliente;
        this.nomeCompletoCliente = nomeCompletoCliente;
        this.emailCliente = emailCliente;
    }

    public int getCodiceCliente() {
        return codiceCliente;
    }

    public String getNomeCompletoCliente() {
        return nomeCompletoCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

}
