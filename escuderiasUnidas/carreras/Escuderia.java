package escuderiasUnidas.carreras;

public class Escuderia {
    private String nombre;

    public Escuderia(String nombre){
        this.nombre=nombre;
    }
    public Escuderia(){
        this.nombre="";
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
