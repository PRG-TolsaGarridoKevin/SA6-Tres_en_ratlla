package prog.sa6.tresenratlla;
public class TresEnRatlla {
    
    private static final String MENSAGE_DIMENSIO1 = "Vols donar una nova dimensió al tauler? (Per defecte 3) [S/N]: "; 
    private static final String MENSAGE_DIMENSIO2 = "Introdueix la dimesió del tauler [3-8]: "; 
    private static final String MENSAGE_INICIO = "Jugarem al Marro"; 
   
    private Tauler tablero;
    private Jugador[] arayJugadores;
    
    public TresEnRatlla() {
        this.tablero = null;
        this.arayJugadores = new Jugador[2];
    }

    
    
    public static void main(String[] args) {
        TresEnRatlla tresEnRatlla = new TresEnRatlla();
        tresEnRatlla.jugar(); 
    }
    
    public void jugar(){
        int dimensio = 3;
        if (GestorIO.solicitarConfirmacio(MENSAGE_DIMENSIO1)) {
            dimensio = Integer.parseInt(GestorIO.llegirText(MENSAGE_DIMENSIO2));
            tablero = new Tauler(dimensio, EstatCasella.BUIT);
            tablero.buidar();
            Jugador jugador1 = new Jugador(EstatCasella.FITXA_O);
            Jugador jugador2 = new Jugador(EstatCasella.FITXA_X);
                
            arayJugadores = new Jugador[] {jugador1,jugador2};
            
            System.out.println(MENSAGE_INICIO);
            
        }

       
    }
}
