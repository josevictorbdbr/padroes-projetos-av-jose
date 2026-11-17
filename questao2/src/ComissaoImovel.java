public class ComissaoImovel implements RegraComissao {
    private static final double TAXA = 0.03;
    private static final double FIXO = 1500.00;

    @Override
    public double calcular(double valorVenda) {
        return valorVenda * TAXA + FIXO;
    }
}
