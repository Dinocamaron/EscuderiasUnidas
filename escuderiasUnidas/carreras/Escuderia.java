package escuderiasUnidas.carreras;

import escuderiasUnidas.PilotoEscuderia;

import java.util.ArrayList;
import java.util.List;

public class Escuderia {
    private String nombre;
    private List<PilotoEscuderia> pilotosEscuderias;

    public Escuderia(){
        this.pilotosEscuderias = new ArrayList<PilotoEscuderia>();
    }

    public Escuderia(String nombre){
        this.nombre=nombre;
        this.pilotosEscuderias = new ArrayList<PilotoEscuderia>();
    }
    public Escuderia(String nombre,List<PilotoEscuderia> pilotosEscuderias){
        this.nombre=nombre;
        this.pilotosEscuderias = pilotosEscuderias;
    }

    public void agregarPilotoEsc(PilotoEscuderia p){
        this.pilotosEscuderias.add(p);
    }

    public void setPilotosEscuderias(List<PilotoEscuderia> pilotosEscuderias) {
        this.pilotosEscuderias = pilotosEscuderias;
    }

    public List<PilotoEscuderia> getPilotosEscuderias() {
        return pilotosEscuderias;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
