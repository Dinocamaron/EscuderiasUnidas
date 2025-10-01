package escuderiasUnidas;

public class Persona {
    private String dni;
    private String nombre;
    private String apellido;

    public Persona (String dni, String nombre, String apellido){
        this.dni= dni;
        this.nombre=apellido;
        this.apellido= apellido;

    }

    public Persona (){
        dni = "";
        nombre ="";
        apellido="";
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido() {
        return apellido;
    }
}

