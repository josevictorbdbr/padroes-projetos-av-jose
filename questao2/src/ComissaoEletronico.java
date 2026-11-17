public class ComissaoEletronico implements RegraComissao {
    private static final double TAXA = 0.12;
    private static final double MINIMO = 50.00;

    @Override
    public double calcular(double valorVenda) {
        return Math.max(valorVenda * TAXA, MINIMO);
    }
}
