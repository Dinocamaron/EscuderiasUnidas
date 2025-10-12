package escuderiasUnidas.personal;

import escuderiasUnidas.carreras.Escuderia;
import java.util.ArrayList;
import java.util.List;

public class Pais {
    private int idPais;
    private String descripcion;
    private List<Persona>personas;
    private List<Escuderia> escuderias;

    public Pais(){
        this.personas= new ArrayList<Persona>();
    }

    public Pais(int idPais, String descripcion, List<Persona>personas){
        this.idPais= idPais;
        this.descripcion= descripcion;
        this.personas = personas;
    }
    public void agregarPersona(Persona p){
        this.personas.add(p);
    }


    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdPais(){return idPais;}

    public String getDescripcion() {
        return descripcion;
    }
}
