import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.forLanguageTag("pt-BR"));

        Participante ana = new Participante("Ana");
        Participante bruno = new Participante("Bruno");
        Participante carla = new Participante("Carla");
        PainelLeiloeiro painel = new PainelLeiloeiro();
        Auditor auditor = new Auditor();

        Lote quadro = new Lote("Pintura a oleo", new CategoriaArte(), 1000, 1500, new ComissaoArte());
        Lote notebook = new Lote("Notebook gamer", new CategoriaEletronico(), 2000, 3000,
                new ComissaoEletronico());

        for (Interessado interessado : List.of(ana, bruno, carla, painel, auditor)) {
            quadro.acompanhar(interessado);
        }
        for (Interessado interessado : List.of(bruno, carla, painel, auditor)) {
            notebook.acompanhar(interessado);
        }

        System.out.println("--- Lances ---");
        quadro.darLance("Ana", 1100);
        quadro.darLance("Bruno", 1200);
        quadro.darLance("Carla", 1230);
        quadro.sair(bruno);
        quadro.darLance("Carla", 1300);
        quadro.darLance("Ana", 1600);
        notebook.darLance("Bruno", 2200);
        notebook.darLance("Carla", 2400);

        System.out.println("--- Campanha: quadro passa a usar a regra de eletronicos ---");
        quadro.definirRegra(new ComissaoEletronico());

        System.out.println("--- Encerramento ---");
        quadro.encerrar();
        notebook.encerrar();
        notebook.darLance("Ana", 3000);

        System.out.println();
        new AcertoVendedor().imprimir(quadro);

        System.out.println();
        Fatura fatura = new Fatura(quadro);
        fatura.adicionar(new Seguro());
        fatura.adicionar(new Embalagem());
        fatura.adicionar(new Certificado());
        fatura.adicionar(new Embalagem());
        fatura.imprimir();

        System.out.println();
        auditor.imprimir();
    }
}
