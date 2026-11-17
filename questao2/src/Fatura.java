import java.util.ArrayList;
import java.util.List;

public class Fatura {
    private final Lote lote;
    private final List<ServicoAdicional> servicos = new ArrayList<>();

    public Fatura(Lote lote) {
        this.lote = lote;
    }

    public void adicionar(ServicoAdicional servico) {
        servicos.add(servico);
    }

    // Soma cada servico adicionado.
    public double total() {
        double valorVenda = lote.getValorVenda();
        double adicionais = servicos.stream().mapToDouble(servico -> servico.custo(valorVenda)).sum();
        return valorVenda + adicionais;
    }

    public void imprimir() {
        double valorVenda = lote.getValorVenda();
        System.out.println("=== Fatura do comprador ===");
        System.out.printf("Lote: %s (%s)%n", lote.getNome(), lote.getCategoria().nome());
        System.out.printf("Valor de venda: R$ %,.2f%n", valorVenda);
        for (ServicoAdicional servico : servicos) {
            System.out.printf("  + %s: R$ %,.2f%n", servico.descricao(), servico.custo(valorVenda));
        }
        System.out.printf("Total a pagar: R$ %,.2f%n", total());
    }
}
