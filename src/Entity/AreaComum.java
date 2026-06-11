package Entity;

public class AreaComum {
    private static int proximoId = 1;
    private int id;
    private String nome;
    private int capacidadeMaxima;

    public AreaComum(String nome, int capacidadeMaxima) {
        this.id = proximoId++;
        this.nome = nome;
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public void setCapacidadeMaxima(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }
}
