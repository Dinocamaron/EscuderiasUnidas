package escuderiasUnidas;

import java.util.ArrayList;
import java.util.List;

public class Pais {
    private int idPais;
    private String descripcion;
    private List<Persona>personas;
    private List<Escuderia> escuderias;
    private List<Circuito>circuitos;

    public Pais(){
        this.personas= new ArrayList<Persona>();
        this.circuitos = new ArrayList<Circuito>();
    }

    public Pais(int idPais, String descripcion, List<Persona>personas){
        this.idPais= idPais;
        this.descripcion= descripcion;
        this.personas = personas;
    }

    public Pais(int idPais,String descripcion) {
        this.idPais= idPais;
        this.descripcion= descripcion;
    }

    public void agregarCircuito (Circuito c){ this.circuitos.add(c);}
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
