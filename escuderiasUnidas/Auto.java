package escuderiasUnidas;

import java.util.ArrayList;
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

    public void agregarPilotosA(AutoPiloto a){
        this.pilotosAutos.add(a);
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
