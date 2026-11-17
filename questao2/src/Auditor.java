import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Auditor implements Interessado {
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private final List<String> registros = new ArrayList<>();

    @Override
    public String nome() {
        return "Auditor";
    }

    //Guarda o lance aceito para auditoria.
    @Override
    public void atualizar(Lote lote, Lance lance) {
        registros.add(String.format("%s / %s / %s / R$ %,.2f",
                lance.dataHora().format(FORMATO), lote.getNome(), lance.participante(), lance.valor()));
    }

    public void imprimir() {
        System.out.println("=== Registro do auditor ===");
        registros.forEach(System.out::println);
    }
}
