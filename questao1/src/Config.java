import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class Config {
    // A instancia carrega e compartilha a configuracao.
    private static final Config INSTANCIA = new Config();

    private final String regiao;
    private final double orcamento;

    private Config() {
        Properties propriedades = carregar();
        regiao = propriedades.getProperty("regiao.padrao");
        orcamento = Double.parseDouble(propriedades.getProperty("orcamento.mensal"));
    }

    public static Config getInstance() {
        return INSTANCIA;
    }

    public String getRegiao() {
        return regiao;
    }

    public double getOrcamento() {
        return orcamento;
    }

    private static Properties carregar() {
        Path arquivo = Files.exists(Path.of("config.properties"))
                ? Path.of("config.properties")
                : Path.of("../config.properties");
        Properties propriedades = new Properties();
        try (Reader leitor = Files.newBufferedReader(arquivo)) {
            propriedades.load(leitor);
        } catch (IOException e) {
            throw new IllegalStateException("config.properties nao encontrado", e);
        }
        return propriedades;
    }
}
