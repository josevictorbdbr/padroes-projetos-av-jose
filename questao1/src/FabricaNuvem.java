public interface FabricaNuvem {
    String provedor();

    Vm criarVm(int quantidade);

    Storage criarStorage(int gb);

    Fila criarFila();

    double estimar(int quantidadeVms, int gb);
}
