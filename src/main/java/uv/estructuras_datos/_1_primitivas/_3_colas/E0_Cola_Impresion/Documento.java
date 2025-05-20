package uv.estructuras_datos._1_primitivas._3_colas.E0_Cola_Impresion;

import uv.estructuras_datos.compartido.ColorConsole;

public class Documento {
    private final String nombre;
    private final int numeroPaginas;

    public Documento(String nombre, int numeroPaginas) {
        this.nombre = nombre;
        this.numeroPaginas = numeroPaginas;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    @Override
    public String toString() {
        return ColorConsole.yellow("Documento: " + nombre + ", Páginas: " + numeroPaginas, true);
    }
}
