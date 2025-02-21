package prog.sa6.tresenratlla;

import java.util.Scanner;

public class GestorIO {
    private static final String MISSATGE_ERROR = "Error! Format incorrecte";
     private static final String MENSAGE_ERROR = "¡Error! Ha d'introduir S o N"; 
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
    
     public static boolean solicitarConfirmacio(String missatge){  
        boolean bucleActivo = true;
        do{
            System.out.println(missatge);
            String respuesta = scanner.next();
            if(respuesta.equalsIgnoreCase("s")||respuesta.equalsIgnoreCase("n")){
                bucleActivo = false;
                return true; 
            }else{
                System.out.println(MENSAGE_ERROR);
                return false;
            }
        }while(bucleActivo);
    }

}
