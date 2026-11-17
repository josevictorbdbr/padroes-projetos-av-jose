import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Lote {
    private static final double AUMENTO_MINIMO = 1.05;

    private final String nome;
    private final Categoria categoria;
    private final double precoInicial;
    private final double reserva;
    private final List<Interessado> interessados = new ArrayList<>();
    private final List<Lance> lances = new ArrayList<>();
    private RegraComissao regra;
    private double lanceAtual;
    private boolean encerrado;
    private boolean vendido;

    public Lote(String nome, Categoria categoria, double precoInicial, double reserva, RegraComissao regra) {
        this.nome = nome;
        this.categoria = categoria;
        this.precoInicial = precoInicial;
        this.reserva = reserva;
        this.regra = regra;
        this.lanceAtual = precoInicial;
    }

    // registra o lance e notifica os interessados.
    public boolean darLance(String participante, double valor) {
        if (encerrado) {
            return recusar(participante, "o lote " + nome + " esta encerrado");
        }
        double minimo = lanceAtual * AUMENTO_MINIMO;
        if (valor < minimo) {
            return recusar(participante, String.format(
                    "R$ %,.2f e menor que o minimo de R$ %,.2f (5%% acima do lance atual)", valor, minimo));
        }
        Lance lance = new Lance(participante, valor, LocalDateTime.now());
        lances.add(lance);
        lanceAtual = valor;
        notificar(lance);
        return true;
    }

    public void acompanhar(Interessado interessado) {
        if (!interessados.contains(interessado)) {
            interessados.add(interessado);
        }
    }

    public void sair(Interessado interessado) {
        interessados.remove(interessado);
    }

    // O participante que deu o lance nao recebe.
    public void notificar(Lance lance) {
        for (Interessado interessado : interessados) {
            if (!interessado.nome().equals(lance.participante())) {
                interessado.atualizar(this, lance);
            }
        }
    }

    // Deixa trocar a estrategia antes do encerramento do lote.
    public void definirRegra(RegraComissao novaRegra) {
        if (encerrado) {
            throw new IllegalStateException("Lote encerrado: a regra nao pode mais ser trocada");
        }
        regra = novaRegra;
    }

    public void encerrar() {
        encerrado = true;
        vendido = !lances.isEmpty() && lanceAtual >= reserva;
        if (vendido) {
            System.out.printf("Lote %s encerrado: vendido por R$ %,.2f%n", nome, lanceAtual);
        } else {
            System.out.printf("Lote %s encerrado: nao vendido (reserva de R$ %,.2f nao atingida)%n", nome, reserva);
        }
    }

    public double getValorVenda() {
        if (!vendido) {
            throw new IllegalStateException("Lote nao vendido: " + nome);
        }
        return lanceAtual;
    }

    public double calcularComissao() {
        return regra.calcular(getValorVenda());
    }

    public String getNome() {
        return nome;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public double getPrecoInicial() {
        return precoInicial;
    }

    public double getLanceAtual() {
        return lanceAtual;
    }

    public int getTotalLances() {
        return lances.size();
    }

    private boolean recusar(String participante, String motivo) {
        System.out.printf("Lance de %s recusado: %s%n", participante, motivo);
        return false;
    }
}
