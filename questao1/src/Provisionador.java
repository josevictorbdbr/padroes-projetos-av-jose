import java.util.Locale;
import java.util.Optional;

public class Provisionador {
    private static final Locale BR = Locale.forLanguageTag("pt-BR");

    private final FabricaNuvem fabrica;

    public Provisionador(FabricaNuvem fabrica) {
        this.fabrica = fabrica;
    }

    // Calcula custo antes para recusar pedidos fora do orcamento.
    public Optional<Ambiente> provisionar(String nome, int quantidadeVms, int gb) {
        double custo = fabrica.estimar(quantidadeVms, gb);
        if (custo > Config.getInstance().getOrcamento()) {
            recusar(nome, custo);
            return Optional.empty();
        }
        Ambiente ambiente = new Ambiente(
                fabrica.criarVm(quantidadeVms),
                fabrica.criarStorage(gb),
                fabrica.criarFila());
        aceitar(nome, ambiente);
        return Optional.of(ambiente);
    }

    private void recusar(String nome, double custo) {
        String motivo = String.format(BR, "custo estimado R$ %,.2f acima do orcamento de R$ %,.2f",
                custo, Config.getInstance().getOrcamento());
        Auditoria.getInstance().registrar(nome, fabrica.provedor(), "RECUSADO", motivo);
    }

    private void aceitar(String nome, Ambiente ambiente) {
        System.out.println(resumo(nome, ambiente));
        Auditoria.getInstance().registrar(nome, fabrica.provedor(), "ACEITO", "dentro do orcamento");
    }

    private String resumo(String nome, Ambiente ambiente) {
        return String.format(BR,
                "--- Ambiente %s ---%nProvedor: %s / Regiao: %s%nVM: %s / Storage: %s / Fila: %s%nCusto mensal estimado: R$ %,.2f%n",
                nome, fabrica.provedor(), Config.getInstance().getRegiao(),
                ambiente.vm().id(), ambiente.storage().id(), ambiente.fila().id(),
                ambiente.custoMensal());
    }
}
