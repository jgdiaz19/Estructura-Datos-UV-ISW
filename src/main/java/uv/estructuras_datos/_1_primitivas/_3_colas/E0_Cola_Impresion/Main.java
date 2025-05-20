package uv.estructuras_datos._1_primitivas._3_colas.E0_Cola_Impresion;

import uv.estructuras_datos.compartido.ColorConsole;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ColaImpresion cola = new ColaImpresion();

        while (true) {
            System.out.println("\n-- MENÚ COLA DE IMPRESIÓN --");
            System.out.println("1. Agregar documento");
            System.out.println("2. Eliminar documento");
            System.out.println("3. Eliminar todos los documentos");
            System.out.println("4. Buscar documento");
            System.out.println("5. Mostrar cola");
            System.out.println("6. Imprimir todos los documentos");
            System.out.println("7. Fusionar con otra cola");
            System.out.println("8. Salir");
            System.out.print("\nSeleccione una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("\nNombre del documento: ");
                    String nombre = sc.nextLine();
                    System.out.print("Número de páginas: ");
                    int paginas = sc.nextInt();
                    Documento doc = new Documento(nombre, paginas);
                    cola.agregarDocumento(doc);
                    System.out.println(ColorConsole.green("Documento agregado.", true));
                    break;
                case 2:
                    Documento eliminado = cola.eliminarDocumento();
                    if (eliminado != null) {
                        System.out.println(ColorConsole.red("Documento eliminado."));
                    } else {
                        System.out.println(ColorConsole.red("La cola está vacía."));
                    }
                    break;
                case 3:
                    cola.eliminarTodos();
                    System.out.println(ColorConsole.green("Todos los documentos fueron eliminados.", true));
                    break;
                case 4:
                    System.out.print("Nombre del documento a buscar: ");
                    String buscar = sc.nextLine();
                    boolean encontrado = cola.buscarDocumento(buscar);
                    System.out.println(encontrado ? "Documento encontrado." : "Documento no encontrado.");
                    break;
                case 5:
                    cola.mostrarCola();
                    break;
                case 6:
                    if (cola.estaVacia()) {
                        System.out.println("No hay documentos para imprimir.");
                    } else {
                        System.out.println(ColorConsole.cyan("Iniciando impresión de documentos..."));
                        while (!cola.estaVacia()) {
                            Documento docImp = cola.eliminarDocumento();
                            System.out.println(ColorConsole.blue("🖨️ Imprimiendo: " + docImp.toString(), true));
                        }
                        System.out.println(ColorConsole.green("Todos los documentos han sido impresos.", true));
                    }
                    break;
                case 7:
                    ColaImpresion otra = new ColaImpresion();
                    otra.agregarDocumento(new Documento("ResumenFinal", 10));
                    otra.agregarDocumento(new Documento("Anexos", 5));
                    cola = FusionadorDeColas.fusionar(cola, otra);
                    System.out.println(ColorConsole.green("Cola fusionada correctamente.", true));
                    break;
                case 8:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println(ColorConsole.red("Opción no válida."));
            }
        }
    }
}
