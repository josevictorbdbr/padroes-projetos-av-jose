public class Seguro implements ServicoAdicional {
    private static final double TAXA = 0.015;

    @Override
    public String descricao() {
        return "Seguro de transporte";
    }

    @Override
    public double custo(double valorVenda) {
        return valorVenda * TAXA;
    }
}
