import Entity.Apartamento;
import Entity.Condomino;
import Entity.Dependente;
import Exception.CapacidadeExcedidaException;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("======= SISTEMA DE GESTÃO DE CONDOMÍNIO =======\n");

        //Cadastro de condôminos
        Condomino Joao = new Condomino("João Pereira", "111.222.333-44", LocalDate.of(1985, 4, 12));
        Condomino Marina = new Condomino("Marina Souza", "555.666.777-88", LocalDate.of(1990, 9, 23));

        //Cadastro de apartamentos
        Apartamento apto101 = new Apartamento(101, 4, Joao);  
        Apartamento apto202 = new Apartamento(202, 2, Marina);
        Joao.setApartamentos((List<Apartamento>) apto101);
        Marina.setApartamentos((List<Apartamento>) apto202);

        //Cadastro de dependentes
        System.out.println("--- Cadastrando dependentes ---");
        try {
            Dependente filhoJoao = new Dependente("Lucas Pereira", "222.333.444-55", LocalDate.of(2015, 6, 1), Joao);
            Joao.adicionarDependente(filhoJoao);
            System.out.println("Dependente de João cadastrado com sucesso.");
        } catch (CapacidadeExcedidaException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            Dependente filho1 = new Dependente("Pedro Souza", "333.444.555-66", LocalDate.of(2018, 2, 14), Marina);
            Marina.adicionarDependente(filho1); // titular + filho1 = 2 (ok)

            Dependente filho2 = new Dependente("Ana Souza", "444.555.666-77", LocalDate.of(2020, 11, 30), Marina);
            Marina.adicionarDependente(filho2); // titular + filho1 + filho2 = 3 > limite (2)
        } catch (CapacidadeExcedidaException e) {
            System.out.println("Erro ao cadastrar dependente: " + e.getMessage());
        }






    }
}
