package escuderiasUnidas;

import java.util.ArrayList;
import java.util.List;

public class Circuito {
    private String nombre;
    private int longitud;
    private Pais pais;
    private List<Carrera> carreras;

    public Circuito(String nombre, int longitud,Pais pais){
        this.nombre= nombre;
        this.longitud = longitud;
        this.pais = pais;
        this.carreras = new ArrayList<Carrera>();
    }
    public Circuito(){
        this.nombre= "";
        this.longitud = 0;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public int getLongitud() {
        return longitud;
    }

    public int cantidaddeCarreras(){return carreras.size();}

    public void agregarCarrera(Carrera c){
        this.carreras.add(c);
    }


}
