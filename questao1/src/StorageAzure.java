public class StorageAzure implements Storage {
    static final double POR_GB = 0.02;

    private final String id;
    private final int gb;

    StorageAzure(String id, int gb) {
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
