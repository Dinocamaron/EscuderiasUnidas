package escuderiasUnidas;


import java.util.ArrayList;
import java.util.Date;

public class AutoPiloto {
    private Date fechaAsignacion;
    private Piloto piloto;
    private Auto auto;
    private Carrera carrera;


    public AutoPiloto(Date fechaAsignacion, Piloto piloto, Auto auto,Carrera carrera){
        this.fechaAsignacion = fechaAsignacion;
        this.piloto = piloto;
        this.auto = auto;
        this.carrera = carrera;

    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public Date getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(Date fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

}
