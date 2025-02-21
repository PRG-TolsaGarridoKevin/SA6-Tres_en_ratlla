package prog.sa6.tresenratlla;
public class Coordenada {
    private char fila;
    private int columna;

    public Coordenada(String fila, int columna) {
        this.fila = fila.toUpperCase().charAt(0); 
        this.columna = columna - 1; 
    }

    public int getFila() {
        return fila - 'A'; 
    }

    public int getColumna() {
        return columna; 
    }

    public boolean isValida(int dimensio) { 
        return getFila() >= 0 && getFila() < dimensio && columna >= 0 && columna < dimensio;
    }
}
