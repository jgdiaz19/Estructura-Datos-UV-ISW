package uv.estructuras_datos.compartido;

/**
 * Clase utilitaria estática para aplicar colores ANSI a los textos impresos en consola.
 * Compatible con terminales que soportan códigos ANSI.
 */
public class ColorConsole {

    // Códigos de color ANSI
    private static final String RESET = "\u001B[0m";

    private static final String RED = "\u001B[31m";

    private static final String GREEN = "\u001B[32m";
    private static final String GREEN_B = " \u001B[92m";

    private static final String YELLOW = "\u001B[33m";
    private static final String YELLOW_B = "\u001B[93m";

    private static final String BLUE = "\u001B[34m";
    private static final String BLUE_B = "\u001B[94m";

    private static final String PURPLE = "\u001B[35m";

    private static final String CYAN = "\u001B[36m";

    private static final String WHITE = "\u001B[37m";

    private static final String BOLD = "\u001B[1m";


    // Métodos estáticos para aplicar color

    public static String red(String message) {
        return RED + message + RESET;
    }

    public static String green(String message, boolean bright) {
        return  bright ? GREEN_B + message + RESET :  GREEN + message + RESET;
    }

    public static String yellow(String message,
                                boolean bright) {
        return bright ? YELLOW_B + message + RESET :
                YELLOW + message + RESET;
    }

     public static String blue(String message, boolean bright) {
        return bright ? BLUE_B + message + RESET : BLUE + message + RESET;
    }

    public static String cyan(String message) {
        return CYAN + message + RESET;
    }

    public static String purple(String message) {
        return PURPLE + message + RESET;
    }

    public static String bold(String message) {
        return BOLD + message + RESET;
    }

    public static String headline(String message) {
        return BOLD + BLUE + message + RESET;
    }

    public static String success(String message) {
        return GREEN + message + RESET;
    }

    public static String warning(String message) {
        return YELLOW + message + RESET;
    }

    public static String error(String message) {
        return RED + message + RESET;
    }
}

