package escuderiasUnidas.carreras;

import escuderiasUnidas.PilotoEscuderia;
import escuderiasUnidas.personal.Mecanico;

import java.util.ArrayList;
import java.util.List;

public class Escuderia {
    private String nombre;
    private List<PilotoEscuderia> pilotosEscuderias;
    private List<Mecanico>mecanicos;

    public Escuderia(){
        this.pilotosEscuderias = new ArrayList<PilotoEscuderia>();
        this.mecanicos= new ArrayList<Mecanico>();
    }

    public Escuderia(String nombre){
        this.nombre=nombre;
        this.pilotosEscuderias = new ArrayList<PilotoEscuderia>();
    }
    public Escuderia(String nombre,List<PilotoEscuderia> pilotosEscuderias,List<Mecanico>mecanicos){
        this.nombre=nombre;
        this.pilotosEscuderias = pilotosEscuderias;
        this.mecanicos= mecanicos;
    }

    public void agregarMecanico(Mecanico m){
        this.mecanicos.add(m);
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
