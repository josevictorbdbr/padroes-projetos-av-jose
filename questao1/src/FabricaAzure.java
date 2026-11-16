import java.util.concurrent.atomic.AtomicInteger;

public class FabricaAzure implements FabricaNuvem {
    private final AtomicInteger proximaVm = new AtomicInteger();
    private final AtomicInteger proximoStorage = new AtomicInteger();
    private final AtomicInteger proximaFila = new AtomicInteger();

    public String provedor() {
        return "AZURE";
    }

    public Vm criarVm(int quantidade) {
        return new VmAzure("vm-" + proximaVm.incrementAndGet(), quantidade);
    }

    public Storage criarStorage(int gb) {
        return new StorageAzure("blob://" + proximoStorage.incrementAndGet(), gb);
    }

    public Fila criarFila() {
        return new FilaAzure("sb-" + proximaFila.incrementAndGet());
    }

    public double estimar(int quantidadeVms, int gb) {
        double vms = quantidadeVms * VmAzure.HORA * Vm.HORAS_MES;
        double storage = gb * StorageAzure.POR_GB;
        return vms + storage + FilaAzure.FIXO;
    }
}
