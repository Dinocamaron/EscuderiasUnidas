package escuderiasUnidas;

public class Circuito {
    private String nombre;
    private int longitud;
    private Pais pais;

    public Circuito(String nombre, int longitud,Pais pais){
        this.nombre= nombre;
        this.longitud = longitud;
        this.pais = pais;
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


}
