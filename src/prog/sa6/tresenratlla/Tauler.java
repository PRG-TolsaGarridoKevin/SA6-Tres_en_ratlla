package prog.sa6.tresenratlla;

public class Tauler {
    private EstatCasella[][] caselles;
    private int dimensio;

    public Tauler(int dimensio) {
        this.dimensio = dimensio;
        this.caselles = new EstatCasella[dimensio][dimensio];
        buidar();
    }

    public void buidar() {
        for (int i = 0; i < dimensio; i++) {
            for (int j = 0; j < dimensio; j++) {
                caselles[i][j] = EstatCasella.BUIT;
            }
        }
    }

    public boolean isCoordenadaValida(Coordenada coordenada) {
        return coordenada != null && coordenada.isValida(dimensio);
    }

    public void posarFitxa(Coordenada coordenada, EstatCasella tipusFitxa) {
        if (!isCoordenadaValida(coordenada)) {
        System.out.println("Error: la coordenada está fuera del tauler");
        return;
    }
    
    int fila = coordenada.getFila();
    int columna = coordenada.getColumna();

    if (isOcupada(coordenada)) {
        System.out.println("La casilla está ocupada.");
        return;
    }

    caselles[fila][columna] = tipusFitxa;
    }

    public boolean isOcupada(Coordenada coordenada) {
        int fila = coordenada.getFila();
        int columna = coordenada.getColumna();

        if (!isCoordenadaValida(coordenada)) {
            return true;
        }

        return caselles[fila][columna] != EstatCasella.BUIT;
    }

    public boolean estaPle() {
        for (int i = 0; i < dimensio; i++) {
            for (int j = 0; j < dimensio; j++) {
                if (caselles[i][j] == EstatCasella.BUIT) {
                    return false;
                }
            }
        }
        return true;
    }

    public void mostrar() {
        System.out.print("  ");
        for (int j = 1; j <= dimensio; j++) {
            System.out.print(" " + j + " ");
        }
        System.out.println();

        for (int i = 0; i < dimensio; i++) {
            System.out.print((char) ('A' + i) + " ");
            for (int j = 0; j < dimensio; j++) {
                System.out.print("|" + caselles[i][j] + " ");
            }
            System.out.println("|");
        }
    }
    
      public boolean hiHaTresEnRatlla(EstatCasella tipusFitxa){
        return comprobarFila(tipusFitxa) || comprobarDiagonals(tipusFitxa) || comprobarColumna(tipusFitxa);
    }
    
    private boolean comprobarFila(EstatCasella tipusFitxa){
        for (int i = 0; i < dimensio; i++) {
            boolean lineaCompleta = true;
            for (int j = 0; j < dimensio; j++) {
                if (caselles[i][j]!=tipusFitxa) {
                    lineaCompleta=false;
                    break;
                }
            }
            if (lineaCompleta) {
                return true;
            }
        }
        return false;
    } 
    
    private boolean comprobarColumna(EstatCasella tipusFitxa){
        for (int j = 0; j < dimensio; j++) {
            boolean columnaCompleta = true;
            for (int i = 0; i < dimensio; i++) {
                if (caselles[i][j]!=tipusFitxa) {
                    columnaCompleta=false;
                    break;
                }
            }
            if (columnaCompleta) {
                return true;
            }
        }
        return false;
    } 
    
    private boolean comprobarDiagonals (EstatCasella tipusFitxa){
        boolean diagonalPrincipal = true;
        boolean diagonalSecundaria = true;
        
        for (int i = 0; i < dimensio; i++) {
            if (caselles[i][i] != tipusFitxa) {
                diagonalPrincipal = false;
            }
            if (caselles[i][dimensio - 1 - i]!= tipusFitxa) {
                diagonalSecundaria = false;
            }
        }
        return diagonalPrincipal || diagonalSecundaria;
    }
}
