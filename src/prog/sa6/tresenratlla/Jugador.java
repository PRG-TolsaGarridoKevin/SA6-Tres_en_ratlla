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
        GestorIO.llegirText(DEMANAR_COORDENADA);
        
        
        
        if (tauler.isCoordenadaValida()) {
            
        }

        
    }
    
    public void cantarVictoria(){
        System.out.printf("¡El jugador %s es el guanyador!",fitxa);
    }
}
