package Entity;

import Exception.CapacidadeExcedidaException;
import Exception.InadimplenciaException;
import Exception.ReservaDuplicadaException;
import java.time.LocalDateTime;
import java.util.List;

public class ReservaAreaComum {
    private LocalDateTime dataReserva;
    private Condomino solicitante;   
    private AreaComum area;          
    private int numConvidados;

    public ReservaAreaComum(LocalDateTime dataReserva, Condomino solicitante,
                            AreaComum area, int numConvidados) {
        this.dataReserva = dataReserva;
        this.solicitante = solicitante;
        this.area = area;
        this.numConvidados = numConvidados;
    }

    /**
     * Confirma a solicitação de reserva de uma área comum do condomínio.
     * Este método valida três regras de negócio cruciaais antes de aprovar:
     * a situação financeira do solicitante, a capacidade física do local 
     * e a disponibilidade de agenda.
     *
     * @param reservasExistentes a lista do banco de dados contendo todas as reservas já confirmadas
     * @throws InadimplenciaException se o condômino possuir qualquer pagamento com status atrasado
     * @throws CapacidadeExcedidaException se a quantidade de convidados ultrapassar o limite da área solicitada
     * @throws ReservaDuplicadaException se a área solicitada já possuir uma reserva para a mesma data e horário
     */
    public void confirmarReserva(List<ReservaAreaComum> reservasExistentes)
            throws InadimplenciaException, CapacidadeExcedidaException, ReservaDuplicadaException {

        // Verifica se o condômino tem pagamentos em atraso
        if (solicitante.isInadimplente()) {
            throw new InadimplenciaException(
                    "Condômino '" + solicitante.getNome() + "' possui pagamentos em atraso " +
                            "e não pode reservar áreas comuns."
            );
        }

        // Verifica se o número de convidados ultrapassa a capacidade da área
        if (numConvidados > area.getCapacidadeMaxima()) {
            throw new CapacidadeExcedidaException(
                    "Número de convidados (" + numConvidados + ") excede a capacidade da área '" +
                            area.getNome() + "' (" + area.getCapacidadeMaxima() + " pessoas)."
            );
        }

        // Verifica se já existe uma reserva para a mesma área e mesmo horário
        for (ReservaAreaComum reserva : reservasExistentes) {
            if (reserva.getArea().equals(this.area) && reserva.getDataReserva().equals(this.dataReserva)) {
                throw new ReservaDuplicadaException("A área '" + area.getNome() +
                        "' já está reservada para " + dataReserva + "."
                );
            }
        }
    }


    // GETTERS E SETTERS
    public LocalDateTime getDataReserva() {
        return dataReserva;
    }
    public void setDataReserva(LocalDateTime dataReserva) {
        this.dataReserva = dataReserva;
    }
    public Condomino getSolicitante() {
        return solicitante;
    }
    public void setSolicitante(Condomino solicitante) {
        this.solicitante = solicitante;
    }
    public AreaComum getArea() {
        return area;
    }
    public void setArea(AreaComum area) {
        this.area = area;
    }
    public int getNumConvidados() {
        return numConvidados;
    }
    public void setNumConvidados(int numConvidados) {
        this.numConvidados = numConvidados;
    }
}