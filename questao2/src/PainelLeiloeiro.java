public class PainelLeiloeiro implements Interessado {
    @Override
    public String nome() {
        return "Painel do leiloeiro";
    }

    // Exibe o maior lance e o total de lances do lote
    @Override
    public void atualizar(Lote lote, Lance lance) {
        System.out.printf("[Painel] %s / maior lance: R$ %,.2f / total de lances: %d%n",
                lote.getNome(), lote.getLanceAtual(), lote.getTotalLances());
    }
}
