public class FilaAzure implements Fila {
    static final double FIXO = 0.50;

    private final String id;

    FilaAzure(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }

    public double custo() {
        return FIXO;
    }
}
