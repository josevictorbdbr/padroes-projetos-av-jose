import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Provedores provedores = new Provedores();

        List<Thread> pedidos = List.of(
                pedido(provedores, "AWS", "loja-prod", 3, 100),
                pedido(provedores, "AWS", "loja-teste", 2, 200),
                pedido(provedores, "AZURE", "relatorios", 2, 100),
                pedido(provedores, "AZURE", "big-data", 10, 500));

        for (Thread pedido : pedidos) {
            pedido.start();
        }
        // Espera solicitacoes antes de imprimir.
        for (Thread pedido : pedidos) {
            pedido.join();
        }

        Auditoria.getInstance().imprimir();
    }

    private static Thread pedido(Provedores provedores, String provedor, String nome, int vms, int gb) {
        Provisionador provisionador = new Provisionador(provedores.escolher(provedor));
        return new Thread(() -> provisionador.provisionar(nome, vms, gb));
    }
}
