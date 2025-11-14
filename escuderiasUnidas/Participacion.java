package escuderiasUnidas;

import java.util.List;

public class Participacion {
    private PilotoEscuderia piloto;
    private Auto auto;
    private int posicion;
    private boolean vueltaRapida;


    public Participacion(PilotoEscuderia piloto, Auto auto, int posicion, boolean vueltaRapida) {
        this.piloto = piloto;
        this.auto = auto;
        this.posicion = posicion;
        this.vueltaRapida = vueltaRapida;

        if (vueltaRapida = true){
            piloto.getPiloto().getVueltasRapidas(+1);

        }

    }

    public PilotoEscuderia getPilotoP() {
        return piloto;
    }

    public Auto getAuto() {
        return auto;
    }

    public int getPosicion() {
        return posicion;
    }

    public boolean isVueltaRapida() {
        return vueltaRapida;
    }

    public Escuderia getPiloto() { return piloto.getEscuderia();
    }
}
