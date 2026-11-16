public class FilaAws implements Fila {
    static final double FIXO = 0.40;

    private final String id;

    FilaAws(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }

    public double custo() {
        return FIXO;
    }
}
