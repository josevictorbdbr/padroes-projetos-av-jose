public class VmAws implements Vm {
    static final double HORA = 0.10;

    private final String id;
    private final int quantidade;

    VmAws(String id, int quantidade) {
        this.id = id;
        this.quantidade = quantidade;
    }

    public String id() {
        return id;
    }

    public double custo() {
        return quantidade * HORA * HORAS_MES;
    }
}
