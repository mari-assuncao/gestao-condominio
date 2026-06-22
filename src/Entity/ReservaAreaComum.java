package Entity;

import java.time.LocalDateTime;

public class ReservaAreaComum {
    private LocalDateTime dataReserva;
    private String cpfSolicitante;
    private int idArea;
    private boolean disponivel;

    public ReservaAreaComum(LocalDateTime dataReserva, String cpfSolicitante, int idArea, boolean disponivel) {
        this.dataReserva = dataReserva;
        this.cpfSolicitante = cpfSolicitante;
        this.idArea = idArea;
        this.disponivel = disponivel;
    }

    public boolean confirmarReserva(int idArea) {
        if (disponivel) {
            return true;
        } else {
            return false;
        }
    }

    public LocalDateTime getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(LocalDateTime dataReserva) {
        this.dataReserva = dataReserva;
    }

    public String getCpfSolicitante() {
        return cpfSolicitante;
    }

    public void setCpfSolicitante(String cpfSolicitante) {
        this.cpfSolicitante = cpfSolicitante;
    }

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
