public class StorageAws implements Storage {
    static final double POR_GB = 0.023;

    private final String id;
    private final int gb;

    StorageAws(String id, int gb) {
        this.id = id;
        this.gb = gb;
    }

    public String id() {
        return id;
    }

    public double custo() {
        return gb * POR_GB;
    }
}
