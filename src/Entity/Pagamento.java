package Entity;

import java.time.LocalDate;

    public class Pagamento implements IRelatorio {
        // Taxa de juros aplicada em caso de atraso
        private static final double taxaJuros = 0.02; // 2% de multa

        private double valorBase;
        private LocalDate dataVencimento;
        private boolean atrasado;

        public Pagamento(double valorBase, LocalDate dataVencimento) {
            this.valorBase = valorBase;
            this.dataVencimento = dataVencimento;
        }

        public double calcularValorFinal() {
            if (isAtrasado()) {
                return valorBase + (valorBase * taxaJuros);
            }
            return valorBase;
        }

        @Override
        public void gerarRelatorio() {
            System.out.println("--------------------------------------------------------");
            System.out.println("Valor base:        R$ " + String.format("%.2f", valorBase));
            System.out.println("Data vencimento:   " + dataVencimento);
            System.out.println("Status:            " + (isAtrasado() ? "ATRASADO" : "Em dia"));
            System.out.println("Valor final:       R$ " + String.format("%.2f", calcularValorFinal()));
            System.out.println("--------------------------------------------------------");
        }


        public boolean isAtrasado() {
            return LocalDate.now().isAfter(dataVencimento);
        }

        public double getValorBase() {
            return valorBase;
        }
        public void setValorBase(double valorBase) {
            this.valorBase = valorBase;
        }
        public LocalDate getDataVencimento() {
            return dataVencimento;
        }
        public void setDataVencimento(LocalDate dataVencimento) {
            this.dataVencimento = dataVencimento;
        }
        public void setAtrasado(boolean atrasado) {
            this.atrasado = atrasado;
        }
    }
}
