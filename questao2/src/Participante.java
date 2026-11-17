public record Participante(String nome) implements Interessado {
    @Override
    public void atualizar(Lote lote, Lance lance) {
        System.out.printf("[%s] Novo lance no lote %s: R$ %,.2f%n", nome, lote.getNome(), lance.valor());
    }
}
