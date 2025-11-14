package escuderiasUnidas;

import java.util.Collections;
import java.util.List;

public class Piloto extends Persona implements Comparable<Piloto> {

    private int numeroCompetencia;
    private int victorias;
    private int polePosition;
    private int vueltasRapidas;
    private int podio;
    private int puntos;
    private List<PilotoEscuderia> pilotosEscuderias;
    private List<AutoPiloto> pilotosAutos;


    public Piloto(String dni, String nombre, String apellido, Pais pais) {
        super(dni, nombre, apellido, pais);
        this.victorias = 0;
        this.podio = 0;
        this.puntos = 0;

    }

    /*Constructor con el atributo PilotoEscuderia
     **/
    public Piloto(String dni, String nombre, String apellido, Pais pais, int numeroCompetencia, int victorias, int polePosition,
                  int vueltasRapidas, int podio, List<PilotoEscuderia> pilotosEscuderias, List<AutoPiloto> pilotosAutos) {
        super(dni, nombre, apellido, pais);
        this.numeroCompetencia = numeroCompetencia;
        this.victorias = victorias;
        this.polePosition = polePosition;
        this.vueltasRapidas = vueltasRapidas;
        this.podio = podio;
        this.pilotosEscuderias = pilotosEscuderias;
        this.pilotosAutos = pilotosAutos;
    }


    /*metodo y setter de AutoPiloto**/
    public void agregarPilotosA(AutoPiloto a) {
        this.pilotosAutos.add(a);
    }

    public void setPilotosAutos(List<AutoPiloto> pilotosAutos) {
        this.pilotosAutos = pilotosAutos;
    }

    /*metodo y setter de PilotoEscuderia**/
    public void agregarPilotoEsc(PilotoEscuderia p) {
        this.pilotosEscuderias.add(p);
    }

    public void setPilotosEscuderias(List<PilotoEscuderia> pilotosEscuderias) {
        this.pilotosEscuderias = pilotosEscuderias;
    }
    public List<PilotoEscuderia> getPilotosEscuderias() {
        return pilotosEscuderias;
    }
    public int getNumeroCompetencia() {
        return numeroCompetencia;
    }

    public int getPodio() {
        return podio;
    }

    public int getPolePosition() {
        return polePosition;
    }

    public int getVictorias() {
        return victorias;
    }

    public int getVueltasRapidas(int i) {
        return vueltasRapidas;
    }

    public void setNumeroCompetencia(int numeroCompetencia) {
        this.numeroCompetencia = numeroCompetencia;
    }

    public void setVictorias(int victorias) {
        this.victorias = victorias;
    }

    public void setPolePosition(int polePosition) {
        this.polePosition = polePosition;
    }

    public void setVueltasRapidas(int vueltasRapidas) {
        this.vueltasRapidas = vueltasRapidas;
    }

    public void setPodio(int podio) {
        this.podio = podio;

    }

    public int getVueltasRapidas() {
        return vueltasRapidas;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
   /* public Piloto getEscuderiaP(){
        for (pilotosEscuderias pe : Piloto)
        return }

    */

    public List<AutoPiloto> getPilotosAutos() {
        return pilotosAutos;
    }
    public void agregarPuntos(int posicion) {
        int[] puntuacion = {25, 18, 15, 12, 10, 8, 6, 4, 2, 1};
        if (posicion >= 1 && posicion <= 10) {
            puntos += puntuacion[posicion - 1];
            if (posicion == 1) {
                victorias++;
                polePosition++;
            }
            if (posicion <= 3) podio++;
        }
    }

public int compareTo(Piloto p){
    return Double.compare(p.puntos, this.puntos);
}


}


