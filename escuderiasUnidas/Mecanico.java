package escuderiasUnidas;


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

    public Mecanico(String dni, String nombre, String apellido, Pais pais, int añosExperiencia, Especialidad especialidad) {
        super(dni, nombre, apellido, pais);
        this.especialidad=especialidad;
        this.añosExperiencia=añosExperiencia;
    }

    public void agregarEscuderia(Escuderia e){
        this.escuderias.add(e);
    }
    public void setEscuderia(Escuderia escuderia) {
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public int getAñosExperiencia() {
        return añosExperiencia;
    }

    public void setAñosExperiencia(int añosExperiencia) {
        this.añosExperiencia = añosExperiencia;
    }

    public List<Escuderia> getEscuderias() {
        return escuderias;
    }

    public void setEscuderias(List<Escuderia> escuderias) {
        this.escuderias = escuderias;
    }

    @Override
    public String toString(){
        return "Mecanico: " + getNombre() + " " + getApellido() + " " + "Especialidad: " + getEspecialidad() + "Años de Experiencia: " + getAñosExperiencia();
    }

}
