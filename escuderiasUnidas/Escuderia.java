package escuderiasUnidas;

import escuderiasUnidas.Mecanico;
import escuderiasUnidas.PilotoEscuderia;

import java.util.ArrayList;
import java.util.List;

public class Escuderia {
    private String nombre;
    private List<PilotoEscuderia> pilotosEscuderias;
    private List<Mecanico>mecanicos;
    private List<Auto>autos;

    public Escuderia(){
        this.pilotosEscuderias = new ArrayList<PilotoEscuderia>();
        this.mecanicos= new ArrayList<Mecanico>();
    }

    public Escuderia(String nombre){
        this.nombre=nombre;
        this.pilotosEscuderias = new ArrayList<PilotoEscuderia>();
        this.autos = new ArrayList<Auto>();
    }
    public Escuderia(String nombre,List<PilotoEscuderia> pilotosEscuderias,List<Mecanico>mecanicos){
        this.nombre=nombre;
        this.pilotosEscuderias = pilotosEscuderias;
        this.mecanicos= mecanicos;
    }


    public void agregarPilotoEsc(PilotoEscuderia p) {
        if (p.getEscuderia() != null) {
            throw new IllegalArgumentException("Piloto ya pertenece a otra escudería.");
        }
        pilotosEscuderias.add(p);
        p.setEscuderia(this);
    }

    public void agregarAuto(Auto a) {
        autos.add(a);
        a.setEscuderia(this);
    }
    // Asignar mecánico
    public void agregarMecanico(Mecanico m) {
        mecanicos.add(m);
        m.setEscuderia(this);
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
