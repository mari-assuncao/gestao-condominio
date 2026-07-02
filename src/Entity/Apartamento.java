package Entity;

public class Apartamento {
    private int numero;
    private int limiteMoradores;
    private Condomino proprietario;

    public Apartamento(int numero, int limiteMoradores, Condomino proprietario) {
        this.numero = numero;
        this.limiteMoradores = limiteMoradores;
        this.proprietario = proprietario;
    }

    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public int getLimiteMoradores() {
        return limiteMoradores;
    }
    public void setLimiteMoradores(int limiteMoradores) {
        this.limiteMoradores = limiteMoradores;
    }
    public Condomino getProprietario() {
        return proprietario;
    }
    public void setProprietario(Condomino proprietario) {
        this.proprietario = proprietario;
    }

    @Override
    public String toString() {
        return "Apartamento{numero=" + numero + ", limite=" + limiteMoradores + "}";
    }
}