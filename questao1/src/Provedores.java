import java.util.Map;

public class Provedores {
    // Centraliza escolha da fabrica para o restante do sistema.
    private final Map<String, FabricaNuvem> fabricas = Map.of(
            "AWS", new FabricaAws(),
            "AZURE", new FabricaAzure());

    public FabricaNuvem escolher(String nome) {
        FabricaNuvem fabrica = fabricas.get(nome.toUpperCase());
        if (fabrica == null) {
            throw new IllegalArgumentException("Provedor desconhecido: " + nome);
        }
        return fabrica;
    }
}
