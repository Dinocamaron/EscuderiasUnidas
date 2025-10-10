package escuderiasUnidas.personal;

import escuderiasUnidas.carreras.Escuderia;

import java.util.ArrayList;
import java.util.List;

public class Mecanico extends Persona{

    private Especialidad especialidad;
    private int añosExperiencia;
    private List<Escuderia>escuderias;

    public Mecanico(){
        this.escuderias = new ArrayList<Escuderia>();
        }


    public Mecanico (String dni, String nombre, String apellido,Pais pais, Especialidad especialidad, int añosExperiencia, List<Escuderia>escuderias){
        super(dni, nombre, apellido, pais);
        this.especialidad=especialidad;
        this.añosExperiencia=añosExperiencia;
        this.escuderias=escuderias;
    }
    public void agregarEscuderia(Escuderia e){
        this.escuderias.add(e);
    }

}
