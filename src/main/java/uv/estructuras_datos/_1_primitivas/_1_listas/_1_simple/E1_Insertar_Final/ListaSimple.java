package uv.estructuras_datos._1_primitivas._1_listas._1_simple.E1_Insertar_Final;

public class ListaSimple {
    private Nodo cabeza;

    public ListaSimple() {
        this.cabeza = null;
    }

    // Agregar un nodo al final de la lista
    public void insertarAlFinal(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
    }

    // Imprimir la lista
    public void imprimir() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }

    // Verificar si la lista está vacía
    public boolean estaVacia() {
        return cabeza == null;
    }
}
