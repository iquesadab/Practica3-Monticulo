import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        MinHeap monticulo = new MinHeap();

        int opcion = 0;
        boolean continuar = true; // Variable para controlar el ciclo while principal

        while(continuar){
            System.out.println("***** MENÚ MONTÍCULO MÍNIMO *****\n" +
                    "1. Insertar elemento\n" +
                    "2. Eliminar mínimo\n" +
                    "3. Ver mínimo (peek)\n" +
                    "4. Mostrar montículo\n" +
                    "5. Crear montículo (heapify)\n" +
                    "0. Salir\n");

            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); //Borrar el buffer

            switch(opcion){

                // Inserta un número
                case 1:
                    System.out.println("Ingrese el número a insertar: ");
                    int valor = scanner.nextInt();
                    monticulo.insertar(valor);
                    System.out.println("Elemento isertado correctamente.\n");
                    break;

                // Elimina el mínimo
                case 2:
                    int eliminado = monticulo.eliminarMin();
                    if (eliminado != -1){
                        System.out.println("Elemento mínimo eliminado: " + eliminado + "\n");
                    }
                    break;

                // Muestra el mínimo
                case 3:
                    int minimo = monticulo.peek();
                    if (minimo != -1){
                        System.out.println("El elemento mínimo es: " + minimo + "\n");
                    }
                    break;

                // Muestra el contenido del montículo
                case 4:
                    System.out.println("Contenido del montículo");
                    monticulo.mostrarHeap();
                    break;

                // Permite ingresar varios números y luego aplicar
                case 5:
                    System.out.println("Cuántos elementos desea ingresar: ");
                    int cantidad = scanner.nextInt();

                    ArrayList<Integer> datos = new ArrayList<>();

                    for(int i = 0; i < cantidad; i++){
                        System.out.println("Ingrese el número " + (i + 1) + ": ");
                        int num = scanner.nextInt();
                        datos.add(num);
                    }

                    monticulo.heapify(datos);

                    System.out.println("El arreglo ha sido convertido en un montículo mínimo. \n");
                    break;

                // Opción Salir
                case 0:
                    System.out.println("Saliendo del sistema...");
                    continuar = false;
                    break;

                // Opción inválida
                default:
                    System.out.println("Opción inválida. Intente nuevamente.\n");
                    break;
            }
        }

    }
}
