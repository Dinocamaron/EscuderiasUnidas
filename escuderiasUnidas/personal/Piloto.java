package escuderiasUnidas.personal;

import escuderiasUnidas.AutoPiloto;
import escuderiasUnidas.PilotoEscuderia;

import java.util.ArrayList;
import java.util.List;

public class Piloto extends Persona{

    private int numeroCompetencia;
    private int victorias;
    private int polePosition;
    private int vueltasRapidas;
    private int podio;
    private List<PilotoEscuderia>pilotosEscuderias;
    private List<AutoPiloto>pilotosAutos;

    public Piloto(){
        this.pilotosEscuderias = new ArrayList<PilotoEscuderia>();
        this.pilotosAutos = new ArrayList<AutoPiloto>();
    }

//constructor con el atributo PilotoEscuderia
    public Piloto (String dni, String nombre, String apellido,int numeroCompetencia, int victorias, int polePosition,
                   int vueltasRapidas, int podio, List<PilotoEscuderia>pilotosEscuderias, List<AutoPiloto>pilotosAutos){
        super(dni, nombre, apellido);
        this.numeroCompetencia= numeroCompetencia;
        this.victorias=victorias;
        this.polePosition=polePosition;
        this.vueltasRapidas=vueltasRapidas;
        this.podio=podio;
        this.pilotosEscuderias = pilotosEscuderias;
        this.pilotosAutos = pilotosAutos;
    }
    //metodo y setter de AutoPiloto
    public void agregarPilotosA(AutoPiloto a){
        this.pilotosAutos.add(a);
    }
    public void setPilotosAutos(List<AutoPiloto> pilotosAutos) {
        this.pilotosAutos = pilotosAutos;
    }

    //metodo y setter de PilotoEscuderia
    public void agregarPilotoEsc(PilotoEscuderia p){
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
    public int getVueltasRapidas() {
        return vueltasRapidas;
    }


}
