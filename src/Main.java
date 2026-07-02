import Entity.Apartamento;
import Entity.AreaComum;
import Entity.Condomino;
import Entity.Dependente;
import Entity.Pagamento;
import Entity.ReservaAreaComum;
import Exception.CapacidadeExcedidaException;
import Exception.InadimplenciaException;
import Exception.ReservaDuplicadaException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        System.out.println("======= SISTEMA DE GESTÃO DE CONDOMÍNIO =======\n");

        // CONDÔMINOS
        Condomino Joao = new Condomino("João Pereira", "111.222.333-44", LocalDate.of(1985, 4, 12));
        Condomino Marina = new Condomino("Marina Souza", "555.666.777-88", LocalDate.of(1990, 9, 23));

        // APARTAMENTOS
        Apartamento apto101 = new Apartamento(101, 4, Joao);  
        Apartamento apto202 = new Apartamento(202, 2, Marina);
        Joao.adicionarApartamento(apto101);
        Marina.adicionarApartamento(apto202);

        // DEPENDENTES
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

        // PAGAMENTOS
        System.out.println("\n--- Registrando pagamentos ---");
        Joao.adicionarPagamento(new Pagamento(950.0, LocalDate.now().plusDays(10))); // em dia
        Marina.adicionarPagamento(new Pagamento(950.0, LocalDate.now().minusDays(7))); // atrasado

        Joao.gerarRelatorio();
        Marina.gerarRelatorio();

        for (Pagamento pagamento : Joao.getPagamentos()) {
            pagamento.gerarRelatorio();
        }

        // ÁREAS COMUNS
        AreaComum salaoFestas = new AreaComum("Salão de Festas", 50);
        AreaComum churrasqueira = new AreaComum("Churrasqueira", 15);

        List<ReservaAreaComum> reservasConfirmadas = new ArrayList<>();

        // RESERVA BEM SUCEDIDA (PAGAMENTO OK)
        System.out.println("\n--- Tentando reserva 1: João no Salão de Festas ---");
        ReservaAreaComum reserva1 = new ReservaAreaComum(
            LocalDateTime.of(2026, 8, 15, 19, 0), Joao, salaoFestas, 30
        );
        try {
            reserva1.confirmarReserva(reservasConfirmadas);
            reservasConfirmadas.add(reserva1);
            System.out.println("Reserva confirmada com sucesso!");
        } catch (InadimplenciaException | CapacidadeExcedidaException | ReservaDuplicadaException e) {
            System.out.println("Reserva negada: " + e.getMessage());
        }

        // RESERVA MAL SUCEDIDA (CALOTEIRA)
        System.out.println("\n--- Tentando reserva 2: Marina (inadimplente) na Churrasqueira ---");
        ReservaAreaComum reserva2 = new ReservaAreaComum(
            LocalDateTime.of(2026, 8, 20, 12, 0), Marina, churrasqueira, 10
        );
        try {
            reserva2.confirmarReserva(reservasConfirmadas);
            reservasConfirmadas.add(reserva2);
            System.out.println("Reserva confirmada com sucesso!");
        } catch (InadimplenciaException | CapacidadeExcedidaException | ReservaDuplicadaException e) {
            System.out.println("Reserva negada: " + e.getMessage());
        }

        // CAPACIDADE EXCEDIDA
        System.out.println("\n--- Tentando reserva 3: João excede capacidade da Churrasqueira ---");
        ReservaAreaComum reserva3 = new ReservaAreaComum(
            LocalDateTime.of(2026, 9, 1, 12, 0), Joao, churrasqueira, 25 // > 15
        );
        try {
            reserva3.confirmarReserva(reservasConfirmadas);
            reservasConfirmadas.add(reserva3);
            System.out.println("Reserva confirmada com sucesso!");
        } catch (InadimplenciaException | CapacidadeExcedidaException | ReservaDuplicadaException e) {
            System.out.println("Reserva negada: " + e.getMessage());
        }

        // RESERVA DUPLICADA
        System.out.println("\n--- Tentando reserva 4: outro condômino no mesmo horário do Salão ---");
        ReservaAreaComum reserva4 = new ReservaAreaComum(
            LocalDateTime.of(2026, 8, 15, 19, 0), Marina, salaoFestas, 5
        );
        try {
            reserva4.confirmarReserva(reservasConfirmadas);
            reservasConfirmadas.add(reserva4);
            System.out.println("Reserva confirmada com sucesso!");
        } catch (InadimplenciaException | CapacidadeExcedidaException | ReservaDuplicadaException e) {
            System.out.println("Reserva negada: " + e.getMessage());
        }


    }
}
