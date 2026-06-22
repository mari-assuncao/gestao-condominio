package Entity;
import java.time.LocalDate;

public class Dependente extends Pessoa {
    //ATRIBUTOS
    private Condomino responsavel; // colocar cpf do condomino?
    
    //CONSTRUTOR
    public Dependente(String nome, String cpf, LocalDate dataNascimento, Condomino responsavel){
        super(nome, cpf, dataNascimento);
        this.responsavel = responsavel;
    }

    //GETTERS E SETTERS
    public Condomino getResponsavel(){
        return responsavel;
    }
    public void setResponsavel(Condomino responsavel){
        this.responsavel = responsavel;
    }
}