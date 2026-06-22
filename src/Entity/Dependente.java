package Entity;

import java.time.LocalDate;

public class Dependente extends Pessoa {
    private String responsavel; // colocar cpf do condomino?

    public Dependente(String nome, String cpf, LocalDate dataNascimento, String responsavel) {
        super(nome, cpf, dataNascimento);
        this.responsavel = responsavel;
    }

    public String getResponsavel() {
        return responsavel;
    }
}
