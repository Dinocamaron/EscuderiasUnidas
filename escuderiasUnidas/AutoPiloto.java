package escuderiasUnidas;

import escuderiasUnidas.carreras.Auto;
import escuderiasUnidas.personal.Piloto;

public class AutoPiloto {
    private String fechaAsignacion;
    private Piloto piloto;
    private Auto auto;

    public AutoPiloto(String fechaAsignacion, Piloto piloto, Auto auto){
        this.fechaAsignacion = fechaAsignacion;
        this.piloto = piloto;
        this.auto = auto;
    }
}
