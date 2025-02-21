package prog.sa6.tresenratlla;
public class Coordenada {
    private String fila;
    private int columna;

    public Coordenada(String fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public String getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }
    
    public boolean isValida(int dimensio){ //Fila ABC , Columna 123 (De 3 hasta 8)
    return dimensio >= 3 && dimensio <= 8;
    }
}
