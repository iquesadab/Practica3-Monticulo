public class Main {
    public static void main(String[] args) {
        MinHeap monticulo = new MinHeap();

        monticulo.insertar(10);
        monticulo.insertar(20);
        monticulo.insertar(30);
        monticulo.insertar(5);

        monticulo.mostrarHeap();
    }
}
