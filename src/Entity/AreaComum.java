package Entity;

import java.util.Objects;

public class AreaComum {
    //ATRIBUTOS
    private String nome;
    private int capacidadeMaxima;

    //CONSTRUTOR
    public AreaComum(String nome, int capacidadeMaxima) {
        this.nome = nome;
        this.capacidadeMaxima = capacidadeMaxima;
    }

    //GETTERS E SETTERS
    public String getNome(){
         return nome;
         }
    public void setNome(String nome){
         this.nome = nome;
         }
    public int getCapacidadeMaxima(){
         return capacidadeMaxima;
         }
    public void setCapacidadeMaxima(int capacidadeMaxima){
         this.capacidadeMaxima = capacidadeMaxima;
         }

    //MÉTODOS
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AreaComum)) return false;
        AreaComum other = (AreaComum) o;
        return Objects.equals(nome, other.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    @Override
    public String toString() {
        return "AreaComum{nome='" + nome + "', capacidade=" + capacidadeMaxima + "}";
    }
}