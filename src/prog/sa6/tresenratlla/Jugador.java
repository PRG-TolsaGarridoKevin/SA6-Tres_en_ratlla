package prog.sa6.tresenratlla;

public class Jugador {
    
    
    private final String DEMANAR_COORDENADA = "Introdueix casella [Lletra-Número]: ";
    
    private EstatCasella fitxa;

    public Jugador(EstatCasella fitxa) {
        this.fitxa = fitxa;
    }
    
    public void posarFitxa(Tauler tauler){
        tauler.posarFitxa(obtenirCoordenada(tauler), fitxa); 
    }
    
    private Coordenada obtenirCoordenada(Tauler tauler){
        Coordenada coordenada;
        boolean coordenadaValida;
        
        do{
            String coordenadaRecibida = GestorIO.llegirLletraGuioNumero("Jugador amb "+this.fitxa+"\n"+"Introdueix una casella");
            
            char letraChar = coordenadaRecibida.charAt(0);
            String letraString = letraChar+""; //Letra
            coordenadaRecibida.charAt(2); //Numero
            
            coordenada = new Coordenada(letraString, coordenadaRecibida.charAt(2));
            coordenadaValida = tauler.isCoordenadaValida(coordenada);
            
            if (!coordenadaValida) {
                System.out.println("Error la coordenada esta fora del tauler");
            }
        }while(!coordenadaValida);
        return coordenada;
    
        
    }
    
    public void cantarVictoria(){
        System.out.printf("¡El jugador %s es el guanyador!",fitxa);
    }
}
