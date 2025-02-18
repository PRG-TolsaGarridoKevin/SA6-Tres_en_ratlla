package prog.sa6.tresenratlla;
public class Tauler {
    private int dimensio;
    private EstatCasella[][] estatCasella;

    public Tauler(int dimensio, EstatCasella[][] estatCasella) {
        this.dimensio = dimensio;
        this.estatCasella = estatCasella;
    }
    
    public void buidar(){
        for (int i = 0; i < dimensio; i++) {
            for (int j = 0; j < dimensio; j++) {
                estatCasella[i][j] = EstatCasella.BUIT;
            }
        }
    }
    
    public boolean isCoordenadaValida(Coordenada coordenada){
        return coordenada.isValida(dimensio);
    }
    
    public void mostrar(){
        //Falta por implementar
        //
        //Dibuja el estado actual de tablero
        //
    }
    
    public void posarFitxa(Coordenada coordenada, EstatCasella tipusFitxa){
        //Inserta una ficha en la casilla seleccionada
    }

    public boolean isOcupada(Coordenada coordenada){
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String filaString = coordenada.getFila();
        int fila = letras.indexOf(filaString.toUpperCase());
        
        return estatCasella[fila][coordenada.getColumna()] != EstatCasella.BUIT;
    }
    
    public boolean estaPle(){
        for (int i = 0; i < dimensio; i++) {
            for (int j = 0; j < dimensio; j++) {
                Coordenada coordenada = new Coordenada(String.valueOf(i), j);
                if (!isOcupada(coordenada)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean hiHaTresEnRatlla(){
        hiHaTresEnRatlla();
        
        return true;
    }
    
    
    private boolean hiHaTresEnRatlla(EstatCasella tipusFitxa){
         //verificar si hay un tres en ralla
        
        return true;
    }
    
    
    
    
    
}
