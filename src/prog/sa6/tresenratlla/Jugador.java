package prog.sa6.tresenratlla;

public class Jugador {

    private final String DEMANAR_COORDENADA = "Introdueix casella [Lletra-Número]: ";

    private EstatCasella fitxa;

    public Jugador(EstatCasella fitxa) {
        this.fitxa = fitxa;
    }

    public void posarFitxa(Tauler tauler) {
        tauler.posarFitxa(obtenirCoordenada(tauler), fitxa);
    }

    private Coordenada obtenirCoordenada(Tauler tauler) {
        Coordenada coordenada;
        boolean coordenadaValida;

        do {
            String coordenadaRecibida = GestorIO.llegirLletraGuioNumero("Jugador amb " + this.fitxa + "\n" + "Introdueix una casella");

            char letraChar = coordenadaRecibida.charAt(0);
            char numeroChar = coordenadaRecibida.charAt(2);

            int numero = Character.getNumericValue(numeroChar);
            coordenada = new Coordenada(String.valueOf(letraChar), numero);
            coordenadaValida = tauler.isCoordenadaValida(coordenada);

            if (!coordenadaValida) {
                System.out.println("Error: la coordenada está fuera del tauler.");
            }
        } while (!coordenadaValida);

        return coordenada;
    }
    public void cantarVictoria() {
        System.out.printf("¡El jugador %s es el guanyador!\n", fitxa);
    }
}
