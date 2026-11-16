import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Auditoria {
    private static final Auditoria INSTANCIA = new Auditoria();

    private final List<RegistroAuditoria> registros = new ArrayList<>();

    private Auditoria() {
    }

    public static Auditoria getInstance() {
        return INSTANCIA;
    }

    // Sincroniza os registros.
    public synchronized void registrar(String ambiente, String provedor, String resultado, String motivo) {
        registros.add(new RegistroAuditoria(LocalDateTime.now(), ambiente, provedor, resultado, motivo));
    }

    public synchronized void imprimir() {
        System.out.println("=== Historico de auditoria ===");
        registros.forEach(System.out::println);
    }
}
