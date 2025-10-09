package escuderiasUnidas.carreras;

public class Carrera {
    private String fechaRealizacion;
    private int numeroVueltas;
    private String horaRealizacion;

    public Carrera (String fechaRealizacion, int numeroVueltas, String horaRealizacion){
        this.fechaRealizacion= fechaRealizacion;
        this.numeroVueltas= numeroVueltas;
        this.horaRealizacion= horaRealizacion;
    }
    public Carrera(){
        this.fechaRealizacion="";
        this.numeroVueltas=0;
        this.horaRealizacion="";
    }

    public void setFechaRealizacion(String fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    public String getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setNumeroVueltas(int numeroVueltas) {
        this.numeroVueltas = numeroVueltas;
    }

    public int getNumeroVueltas() {
        return numeroVueltas;
    }

    public void setHoraRealizacion(String horaRealizacion) {
        this.horaRealizacion = horaRealizacion;
    }

    public String getHoraRealizacion() {
        return horaRealizacion;
    }
}
