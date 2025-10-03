package escuderiasUnidas;

public class Pais {
    private int idPais;
    private String descripcion;

    public Pais(int idPais, String descripcion){
        this.idPais= idPais;
        this.descripcion= descripcion;

    }

    public Pais() {
       this.idPais= 0;
       this.descripcion="";
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
