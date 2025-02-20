package prog.sa6.tresenratlla;

import java.util.Scanner;

public class GestorIO {
    private static final String MISSATGE_ERROR = "Error! Format incorrecte (ex: A-1)";
    public static final String FORMATO = "^[A-Za-z]-\\d$";
    public static Scanner scanner = new Scanner(System.in);

    public static String llegirText(String mensage) {
        System.out.println(mensage);
        String cadenaEntrada;
        while(true){
            cadenaEntrada = scanner.nextLine();
            
            if (validarCadenaCorrecta(cadenaEntrada)) {
                return cadenaEntrada;
            }else{
                System.out.println(MISSATGE_ERROR);
            }
        }
    }

    public static boolean validarCadenaCorrecta(String cadena) {
       return cadena.matches(FORMATO);
    }

    public static void llegirLletraGuioNumero(String cadena) {
        
    }

}
