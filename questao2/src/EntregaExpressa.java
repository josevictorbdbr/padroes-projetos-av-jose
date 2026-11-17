public class EntregaExpressa implements ServicoAdicional {
    private static final double CUSTO = 450.00;

    @Override
    public String descricao() {
        return "Entrega expressa";
    }

    @Override
    public double custo(double valorVenda) {
        return CUSTO;
    }
}
