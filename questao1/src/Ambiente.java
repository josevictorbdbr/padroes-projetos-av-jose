public record Ambiente(Vm vm, Storage storage, Fila fila) {
    public double custoMensal() {
        return vm.custo() + storage.custo() + fila.custo();
    }
}
