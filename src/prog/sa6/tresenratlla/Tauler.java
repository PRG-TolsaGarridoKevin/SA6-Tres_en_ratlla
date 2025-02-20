package prog.sa6.tresenratlla;

public class Tauler {

    private int dimensio;
    private EstatCasella[][] estatCasella;

    public Tauler(int dimensio, EstatCasella[][] estatCasella) {
        this.dimensio = dimensio;
        this.estatCasella = estatCasella;
    }

    public void buidar() {
        for (int i = 0; i < dimensio; i++) {
            for (int j = 0; j < dimensio; j++) {
                estatCasella[i][j] = EstatCasella.BUIT;
            }
        }
    }

    public boolean isCoordenadaValida(Coordenada coordenada) {
        return coordenada.isValida(dimensio);
    }

    public void mostrar() {
        for (int i = 0; i < dimensio; i++) {
            System.out.println("|");
            for (int j = 0; j < dimensio; j++) {
                System.out.println(estatCasella[i][j]);
            }
            System.out.println("|");
        }
    }

    public void posarFitxa(Coordenada coordenada, EstatCasella tipusFitxa) {
        int fila = Integer.parseInt(coordenada.getFila());
        if (coordenada.isValida(dimensio) && !isOcupada(coordenada)) {
            estatCasella[fila][coordenada.getColumna()] = tipusFitxa;
        }
    }

    public boolean isOcupada(Coordenada coordenada) {
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String filaString = coordenada.getFila();
        int fila = letras.indexOf(filaString.toUpperCase());

        return estatCasella[fila][coordenada.getColumna()] != EstatCasella.BUIT;
    }

    public boolean estaPle() {
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

    public boolean hiHaTresEnRatlla() {
        return hiHaTresEnRatlla();
    }

    private boolean hiHaTresEnRatlla(EstatCasella tipusFitxa) {
        return comprobarLinea(tipusFitxa) || 
               comprobarColumna(tipusFitxa) || 
               comprobarDiagonal1(tipusFitxa) ||
               comprobarDiagonal2(tipusFitxa);

    }

    private boolean comprobarLinea(EstatCasella tipusFitxa) {
        for (int i = 0; i < dimensio; i++) {
            int contador = 0; 

            for (int j = 0; j < dimensio; j++) {
                if (estatCasella[i][j] == tipusFitxa && estatCasella[i][j] != tipusFitxa.BUIT) {
                    contador++;
                }
            }
            if (contador == dimensio) {
                return true; 
            }
        }
        return false;
    }
    
    private boolean comprobarColumna(EstatCasella tipusFitxa){
        for (int i = 0; i < dimensio; i++) {
            int contador = 0;
            
            for (int j = 0; j < dimensio; j++) {
                if (estatCasella[j][i] == tipusFitxa && estatCasella[j][i] != tipusFitxa.BUIT) {
                    contador++;
                }
            }
            if (contador == dimensio) {
                return true;
            }
        }
        return false;
    }
    
    private boolean comprobarDiagonal1(EstatCasella tipusFitxa){
        int contador = 0;
        for (int i = 0; i < dimensio; i++) {

            if (estatCasella[i][i] == tipusFitxa && estatCasella[i][i] != tipusFitxa.BUIT) {
                contador++;
            }  
        }
        return contador == dimensio;
    }
    
    private boolean comprobarDiagonal2(EstatCasella tipusFitxa){
        int contador = 0;
        for (int i = 0; i < dimensio; i++) {
            if (estatCasella[i][dimensio - 1 - i] == tipusFitxa && estatCasella[i][dimensio - 1 - i] != tipusFitxa.BUIT) {
                contador++;
            }
        }
        return contador == dimensio;
    }
}
