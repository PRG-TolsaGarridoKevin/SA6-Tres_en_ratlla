package prog.sa6.tresenratlla;

import java.util.Scanner;

public class GestorIO {

    private static final String MENSAGE_ERROR2 = "¡Error! Ha d'introduir S o N";
    private static final String MENSAGE_ERROR1 = "Entrada incorrecta";

    public static final String FORMATO = "^[A-Za-z]-\\d$";
    public static Scanner scanner = new Scanner(System.in);

    public static String llegirLletraGuioNumero(String mensage) {

        String cadenaEntrada;
        while (true) {
            System.out.println(mensage);
            cadenaEntrada = scanner.nextLine();

            if (validarCadenaCorrecta(cadenaEntrada)) {
                return cadenaEntrada;
            } else {
                System.out.println(MENSAGE_ERROR1);
            }
        }
    }

    public static boolean validarCadenaCorrecta(String cadena) {
        return cadena.matches(FORMATO);
    }

    public static boolean solicitarConfirmacio(String missatge) {
        boolean bucleActivo = true;
        do {
            System.out.println(missatge);
            String respuesta = scanner.next();
            if (respuesta.equalsIgnoreCase("s")) {
                return true;
            } else if (respuesta.equalsIgnoreCase("n")) {
                return false;
            } else {
                System.out.println(MENSAGE_ERROR2);
            }
        } while (bucleActivo);
        return false;
    }

}
