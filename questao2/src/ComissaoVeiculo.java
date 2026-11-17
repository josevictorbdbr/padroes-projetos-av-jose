public class ComissaoVeiculo implements RegraComissao {
    private static final double TAXA = 0.08;
    private static final double TETO = 5000.00;

    // Aplica o teto de comissao previsto para veiculos.
    @Override
    public double calcular(double valorVenda) {
        return Math.min(valorVenda * TAXA, TETO);
    }
}
