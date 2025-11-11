package escuderiasUnidas;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Carrera {
    private Date fechaRealizacion;
    private int numeroVueltas;
    private String horaRealizacion;
    private Circuito circuito;
    private List<Participacion> participaciones;


    public Carrera (Date fechaRealizacion, int numeroVueltas, String horaRealizacion, Circuito circuito){
        this.fechaRealizacion= fechaRealizacion;
        this.numeroVueltas= numeroVueltas;
        this.horaRealizacion= horaRealizacion;
        this.circuito = circuito;
        this.participaciones = new ArrayList<Participacion>();
    }
    public Carrera(){
        this.numeroVueltas=0;
        this.horaRealizacion="";
    }
    public List<Participacion> getParticipaciones() { return participaciones; }

    // Registrar participación con validaciones (auto no asignado, misma escudería)
    public void registrarParticipacion(PilotoEscuderia piloto, Auto auto, int posicion, boolean vueltaRapida) {
        if (auto.isAsignado()) {
            throw new IllegalArgumentException("Auto ya asignado en esta carrera.");
        }
        if (piloto.getEscuderia() == null || !piloto.getEscuderia().equals(auto.getEscuderia())) {
            throw new IllegalArgumentException("Piloto y auto deben pertenecer a la misma escudería.");
        }
        Participacion part = new Participacion( piloto, auto, posicion, vueltaRapida);
        participaciones.add(part);
        auto.setAsignado(true);
        piloto.getPiloto().agregarPuntos(posicion);
    }

    public void setFechaRealizacion(Date fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    public Date getFechaRealizacion() {
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

    public Circuito getCircuito() {return circuito;
    }

    public void setCircuito(Circuito circuito) {
        this.circuito = circuito;
    }

    public void setParticipaciones(List<Participacion> participaciones) {
        this.participaciones = participaciones;
    }
}
