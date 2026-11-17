public class Embalagem implements ServicoAdicional {
    private static final double CUSTO = 180.00;

    @Override
    public String descricao() {
        return "Embalagem especial";
    }

    @Override
    public double custo(double valorVenda) {
        return CUSTO;
    }
}
