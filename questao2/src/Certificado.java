public class Certificado implements ServicoAdicional {
    private static final double CUSTO = 300.00;

    @Override
    public String descricao() {
        return "Certificado de autenticidade";
    }

    @Override
    public double custo(double valorVenda) {
        return CUSTO;
    }
}
