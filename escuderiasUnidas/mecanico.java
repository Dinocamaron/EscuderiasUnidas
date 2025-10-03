package escuderiasUnidas;

public class mecanico extends Persona{

    private Especialidad especialidad;
    private int añosExperiencia;


    public mecanico (String dni, String nombre, String apellido, Especialidad especialidad, int añosExperiencia){
        super(dni, nombre, apellido);
        this.especialidad=especialidad;
        this.añosExperiencia=añosExperiencia;
    }
}
