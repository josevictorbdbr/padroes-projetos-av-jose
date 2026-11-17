public class ComissaoArte implements RegraComissao {
    private static final double TAXA = 0.20;

    @Override
    public double calcular(double valorVenda) {
        return valorVenda * TAXA;
    }
}
