package uv.estructuras_datos._1_primitivas._3_colas.E0_Cola_Impresion;

import uv.estructuras_datos.compartido.ColorConsole;

public class ColaImpresion {
    private Nodo frente;
    private Nodo fin;

    public ColaImpresion() {
        this.frente = null;
        this.fin = null;
    }

    public void agregarDocumento(Documento doc) {
        Nodo nuevo = new Nodo(doc);
        if (estaVacia()) {
            frente = fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }
    }

    public Documento eliminarDocumento() {
        if (estaVacia()) {
            return null;
        }
        Documento eliminado = frente.documento;
        frente = frente.siguiente;
        if (frente == null) {
            fin = null;
        }
        return eliminado;
    }

    public void eliminarTodos() {
        frente = fin = null;
    }

    public boolean buscarDocumento(String nombre) {
        Nodo actual = frente;
        while (actual != null) {
            if (actual.documento.getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    public void mostrarCola() {
        if (estaVacia()) {
            System.out.println(ColorConsole.green("La cola está vacía.",true));
        } else {
            Nodo actual = frente;
            while (actual != null) {
                System.out.println(actual.documento);
                actual = actual.siguiente;
            }
        }
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public Nodo getFrente() {
        return frente;
    }
}

