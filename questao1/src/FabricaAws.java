import java.util.concurrent.atomic.AtomicInteger;

public class FabricaAws implements FabricaNuvem {
    private final AtomicInteger proximaVm = new AtomicInteger();
    private final AtomicInteger proximoStorage = new AtomicInteger();
    private final AtomicInteger proximaFila = new AtomicInteger();

    public String provedor() {
        return "AWS";
    }

    public Vm criarVm(int quantidade) {
        return new VmAws("i-" + proximaVm.incrementAndGet(), quantidade);
    }

    public Storage criarStorage(int gb) {
        return new StorageAws("s3://" + proximoStorage.incrementAndGet(), gb);
    }

    public Fila criarFila() {
        return new FilaAws("sqs-" + proximaFila.incrementAndGet());
    }

    public double estimar(int quantidadeVms, int gb) {
        double vms = quantidadeVms * VmAws.HORA * Vm.HORAS_MES;
        double storage = gb * StorageAws.POR_GB;
        return vms + storage + FilaAws.FIXO;
    }
}
