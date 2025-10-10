package escuderiasUnidas.carreras;

import escuderiasUnidas.AutoPiloto;

import java.util.ArrayList;
import java.util.List;

public class Auto {
    private String modelo;
    private String motor;
    private List<AutoPiloto>pilotosAutos;

    public Auto(){
        this.pilotosAutos = new ArrayList<AutoPiloto>();
    }

    public Auto (String modelo, String motor){
        this.modelo= modelo;
        this.motor= motor;
        this.pilotosAutos = new ArrayList<AutoPiloto>();
    }
    public Auto (String modelo, String motor, List<AutoPiloto>pilotosAutos){
        this.modelo= modelo;
        this.motor= motor;
        this.pilotosAutos = pilotosAutos;
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
}
