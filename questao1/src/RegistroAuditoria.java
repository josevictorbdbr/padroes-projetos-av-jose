import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public record RegistroAuditoria(LocalDateTime dataHora, String nomeAmbiente, String provedor,
                                String resultado, String motivo) {
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.SSS");

    @Override
    public String toString() {
        return String.format("[%s] %s | %s | %s - %s",
                dataHora.format(FORMATO), nomeAmbiente, provedor, resultado, motivo);
    }
}
