package prog.sa6.tresenratlla;

public class TresEnRatlla {

    private static final String MENSAGE_DIMENSIO1 = "Vols donar una nova dimensió al tauler? (Per defecte 3) [S/N]: ";
    private static final String MENSAGE_DIMENSIO2 = "Introdueix la dimensió del tauler [3-8]: ";
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

    public void jugar() {

        boolean usarDimensionPredeterminada = GestorIO.solicitarConfirmacio(MENSAGE_DIMENSIO1);
        int dimensio = 3;

        if (usarDimensionPredeterminada) {
            boolean dimensioValida = false;
            while (!dimensioValida) {
                System.out.println(MENSAGE_DIMENSIO2);
                String entrada = GestorIO.scanner.nextLine();

                if (entrada.matches("\\d+")) {
                    dimensio = Integer.parseInt(entrada);

                    if (dimensio >= 3 && dimensio <= 8) {
                        dimensioValida = true;
                    } else {
                        System.out.println("Entrada incorrecta. Introduce un número entre 3 y 8.");
                    }
                } else {
                    System.out.println("Entrada incorrecta. Introduce un número entre 3 y 8.");
                }
            }
        }

        tablero = new Tauler(dimensio);
        Jugador jugador1 = new Jugador(EstatCasella.FITXA_O);
        Jugador jugador2 = new Jugador(EstatCasella.FITXA_X);
        arayJugadores[0] = jugador1;
        arayJugadores[1] = jugador2;
        tablero.buidar();
        System.out.println(MENSAGE_INICIO);

        boolean juegoTerminado = false;
        int turno = 0;

        while (!juegoTerminado) {
            tablero.mostrar();

            Jugador jugadorActual = arayJugadores[turno % 2];

            jugadorActual.posarFitxa(tablero);


            if (tablero.hiHaTresEnRatlla(EstatCasella.FITXA_O)) {
                jugador1.cantarVictoria(); 
                tablero.mostrar();
                juegoTerminado = true;
            } else if (tablero.hiHaTresEnRatlla(EstatCasella.FITXA_X)) {
                jugador2.cantarVictoria();
                tablero.mostrar();
                juegoTerminado = true;
            } else if (tablero.estaPle()) {
                System.out.println("¡Empate! El tablero está lleno.");
                tablero.mostrar();
                juegoTerminado = true;
            }

            turno++;
        }
    }
}
