package uv.estructuras_datos._1_primitivas._1_listas._1_simple.E1_Insertar_Final;

import uv.estructuras_datos.compartido.ColorConsole;

import java.util.Scanner;

public class MenuListaSimple {
    private final ListaSimple lista;
    private final Scanner entrada;

    public MenuListaSimple() {
        this.lista = new ListaSimple();
        this.entrada = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;

        do {
            System.out.println(ColorConsole.blue("\n--- MENÚ: LISTA SIMPLE (Insertar al final) ---",true));
            System.out.println("1. Insertar un número al final");
            System.out.println("2. Mostrar la lista");
            System.out.println("3. Verificar si la lista está vacía");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Introduce un número: ");
                    int numero = entrada.nextInt();
                    lista.insertarAlFinal(numero);
                    System.out.println("Número insertado.");
                }
                case 2 -> {
                    System.out.println("Contenido de la lista:");
                    lista.imprimir();
                }
                case 3 -> {
                    System.out.println(lista.estaVacia() ? "La lista está vacía." : "La lista NO está vacía.");
                }
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
    }
}
