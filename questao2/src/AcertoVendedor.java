public class AcertoVendedor {
    public void imprimir(Lote lote) {
        double valorVenda = lote.getValorVenda();
        double comissao = lote.calcularComissao();
        System.out.println("=== Acerto do vendedor ===");
        System.out.printf("Lote: %s (%s)%n", lote.getNome(), lote.getCategoria().nome());
        System.out.printf("Valor de venda: R$ %,.2f%n", valorVenda);
        System.out.printf("Comissao cobrada: R$ %,.2f%n", comissao);
        System.out.printf("Liquido a repassar: R$ %,.2f%n", valorVenda - comissao);
    }
}
