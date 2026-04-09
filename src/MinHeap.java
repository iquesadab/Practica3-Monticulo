import java.util.ArrayList;

public class MinHeap {
    // ArrayList que va a almacenar los elementos del monticulo
    private ArrayList<Integer> heap;

    // Constructor
    public MinHeap(){
        heap = new ArrayList<>();
    }

    // Metodo para insertar
    public void insertar(int valor){
        heap.add(valor);
        // Llama a upHeapify para acomodar el nuevo valor
        // Pasando la posición del último elemento porque ahí se insertó
        upHeapify(heap.size() - 1);
    }

    // Metodo que sube un elemento hasta la posicion correcta
    private void upHeapify(int indice){
        // Mientras el nodo no sea la raiz
        while (indice > 0){

            int indicePadre = (indice - 1) / 2;

            // Si el valor actual es menor que su padre, se intercambian
            if(heap.get(indice) < heap.get(indicePadre)){
                int temp = heap.get(indice);
                heap.set(indice, heap.get(indicePadre));
                heap.set(indicePadre, temp);

                // Se sigue revisando desde la nueva posicion del nodo
                indice = indicePadre;
            }
            else{
                // Si no es menor que el padre quiere decir que ya esta en su posicion correcta
                break;
            }
        }
    }

    // Metodo para mostrar contenido
    public void mostrarHeap(){
        System.out.println(heap);
    }

    // Metodo que baja un nodo hasta la posicion correcta
    private void downHeapify(int indice){

        // Repetir hasta que el nodo quede bien acomodado
        while(true){

            // calcular indice de hijos
            int hijoIzquierdo = 2 * indice + 1;
            int hijoDerecho = 2 * indice + 2;

            // Asumimos que el menor es el nodo actual(padre)
            int menor = indice;

            // Verificar si el hijo izquierdo existe y es menor
            if(hijoIzquierdo < heap.size() && heap.get(hijoIzquierdo) < heap.get(menor)){
                menor = hijoIzquierdo;
            }

            // Verificar si el hijo derecho existe y es menor
            if(hijoDerecho < heap.size() && heap.get(hijoDerecho) < heap.get(menor)){
                menor = hijoDerecho;
            }

            // Si la posición del menor cambió, entonces hay que intercambiar
            if(menor != indice){
                int temp = heap.get(indice);
                heap.set(indice, heap.get(menor));
                heap.set(menor, temp);

                // Seguimos revisando desde la nueva posición del nodo
                indice = menor;

            } else {
                break;
            }
        }
    }

    // Metodo que devuelve el valor minimo del monticulo sin eliminarlo
    public int peek() {

        // Verificar si el heap esta vacio
        if (heap.isEmpty()) {
            System.out.println("El montículo está vacío");
            return -1;
        }

        // El elemento minimo siempre esta en la raiz (posicion 0)
        return heap.get(0);
    }

    // Metodo que elimina y devuelve el elemento mínimo del montículo
    public int eliminarMin() {

        // Verificar si el heap está vacío
        if (heap.isEmpty()) {
            System.out.println("El montículo está vacío");
            return -1;
        }

        // Guardar el valor mínimo (siempre está en la raíz)
        int minimo = heap.get(0);

        // Obtener el último elemento del heap
        int ultimo = heap.get(heap.size() - 1);

        // Colocar el último elemento en la raíz
        heap.set(0, ultimo);

        // Eliminar el último elemento del arreglo
        heap.remove(heap.size() - 1);

        // Restaurar la propiedad del heap si aún quedan elementos
        if (!heap.isEmpty()) {
            downHeapify(0);
        }

        // Devolver el valor mínimo que se eliminó
        return minimo;
    }

}
