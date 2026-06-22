package Entity;

public class Apartamento {
    private int numero;
    private int limiteMoradores;
    private String moradores; // colocar cpf? fzr array list (condomino + dependentes)

    public Apartamento(int numero, int limiteMoradores, String moradores) {
        this.numero = numero;
        this.limiteMoradores = limiteMoradores;
        this.moradores = moradores;
    }

    public int getNumero() {
        return numero;

    public int getLimiteMoradores() {
        return limiteMoradores;
    }


    //fzr get e set pra moradores(array list)
}
