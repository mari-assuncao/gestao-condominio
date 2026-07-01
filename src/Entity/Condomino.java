package Entity;
import Exception.CapacidadeExcedidaException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Condomino extends Pessoa implements IRelatorio{
    //ATRIBUTOS
    private List<Dependente> dependentes;
    private List<Apartamento> apartamentos;
    private List<Pagamento> pagamentos;

    //CONSTRUTOR
    public Condomino(String nome, String cpf, LocalDate dataNascimento){
        super(nome, cpf, dataNascimento);
        this.dependentes = new ArrayList<>();
        this.apartamentos = new ArrayList<>();
        this.pagamentos = new ArrayList<>();
    }

    //MÉTODOS
    @Override
    public void gerarRelatorio(){
        System.out.println("--------------------------------------------------------");
        System.out.println("Nome: " + this.getNome());
        System.out.println("CPF: " + this.getCpf());
        System.out.println("Quantidade de dependentes: " + this.dependentes.size());
        System.out.println("Total de Apartamentos: " + this.apartamentos.size());
        System.out.println("Total de pagamentos realizados: " + this.pagamentos.size());
        System.out.println("Status financeiro: " + (isInadimplente() ? "INADIMPLENTE" : "Em dia"));
        System.out.println("--------------------------------------------------------");
    }

    public void adicionarDependente(Dependente dependente) throws CapacidadeExcedidaException {
        if (!apartamentos.isEmpty()) {
            Apartamento ap = apartamentos.get(0);
            if (1 + this.dependentes.size() + 1 > ap.getLimiteMoradores()) {
                throw new CapacidadeExcedidaException(
                    "Limite de moradores do apartamento " + ap.getNumero() +
                    " (" + ap.getLimiteMoradores() + ") seria excedido."
                );
            }
        }
        this.dependentes.add(dependente);
    }

    public boolean isInadimplente() {
        for (Pagamento pagamento : pagamentos) {
            if (pagamento.isAtrasado()) {
                return true;
            }
        }
        return false; 
    }

    // GETTERS E SETTERS
    public List<Dependente> getDependentes(){
        return dependentes;
    }
    public void setDependentes(List<Dependente> dependentes){
        this.dependentes = dependentes;
    }

    public List<Apartamento> getApartamentos(){
        return apartamentos;
    }
    public void setApartamentos(List<Apartamento> apartamentos){
        this.apartamentos = apartamentos;
    }

    public List<Pagamento> getPagamentos(){
        return pagamentos;
    }
    public void setPagamentos(List<Pagamento> pagamentos){
        this.pagamentos = pagamentos;
    }
}