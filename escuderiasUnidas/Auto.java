package escuderiasUnidas;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Auto {
    private boolean asignado;
    private String modelo;
    private String motor;
    private Escuderia escuderia;

    private List<AutoPiloto>pilotosAutos;


    public Auto (String modelo, String motor, Escuderia escuderia){
        this.modelo= modelo;
        this.motor= motor;
        this.escuderia = escuderia;
        this.asignado = false;
        this.pilotosAutos = new ArrayList<AutoPiloto>();
    }
    public Auto (String modelo, String motor, List<AutoPiloto>pilotosAutos){
        this.modelo= modelo;
        this.motor= motor;
        this.pilotosAutos = pilotosAutos;
        asignado = false;
    }
    //Metodo Para Asignar un auto  un piloto y carrera especfica, con validacion
    public void asignarAutoPiloto(Piloto piloto, Carrera carrera, Date fecha) {

        for (AutoPiloto ap : pilotosAutos) {
            if (ap.getPiloto().equals(piloto) && ap.getCarrera().equals(carrera)) {
                throw new IllegalArgumentException("Piloto ya asignado a un auto en esta carrera.");
            }
        }
        for (AutoPiloto ap : pilotosAutos) {
            if (ap.getAuto().equals(this) && ap.getCarrera().equals(carrera) && !ap.getPiloto().equals(piloto)) {
                throw new IllegalArgumentException("Auto ya asignado a otro piloto en esta carrera.");
            }
        }
        AutoPiloto ap = new AutoPiloto(fecha, piloto,this, carrera);
        pilotosAutos.add(ap);
    }



    public void setPilotosAutos(List<AutoPiloto> pilotosAutos) {
        this.pilotosAutos = pilotosAutos;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMotor() {
        return motor;
    }

    public void setEscuderia(Escuderia escuderia) {
    }
    public boolean isAsignado() { return asignado; }
    public void setAsignado(boolean asignado) { this.asignado = asignado; }

    public Object getEscuderia() {return  escuderia;}
}

