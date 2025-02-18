package prog.sa6.tresenratlla;

import java.util.Scanner;

public class GestorIO {

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
                System.out.println("Introdiuce el formato valido Ejemplo:[B-3]");
            }
        }
    }

    public static boolean validarCadenaCorrecta(String cadena) {
       return cadena.matches(FORMATO);
    }

    public static void llegirLletraGioNumero(String cadena) {
    
    }

}
