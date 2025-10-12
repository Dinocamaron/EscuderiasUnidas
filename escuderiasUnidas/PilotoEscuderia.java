package escuderiasUnidas;

import escuderiasUnidas.carreras.Escuderia;
import escuderiasUnidas.personal.Piloto;

public class PilotoEscuderia {
    private String desdeFecha;
    private String hastaFecha;
    private Piloto piloto;
    private Escuderia escuderia;

    public PilotoEscuderia(String desdeFecha, String hastaFecha, Piloto piloto, Escuderia escuderia) {
        this.desdeFecha = desdeFecha;
        this.hastaFecha = hastaFecha;
        this.piloto = piloto;
        this.escuderia = escuderia;
    }

    public void setDesdeFecha(String desdefecha){
        this.desdeFecha=desdefecha;
    }
    public void setHastaFecha(String hastafecha){
        this.hastaFecha=hastafecha;
    }
    public void setPiloto(Piloto piloto){
        this.piloto=piloto;
    }
    public void setEscuderia(Escuderia escuderia){
        this.escuderia=escuderia;
    }

    public String getDesdeFecha(){
        return desdeFecha;
    }
    public String getHastaFecha(){
        return hastaFecha;
    }
    public Piloto getPiloto(){
        return piloto;
    }
    public Escuderia getEscuderia(){
        return escuderia;
    }

    public void MostrarPilotoEscuderia(){
        System.out.println("El Piloto " +piloto+ " pertenece a la Escuderia "+escuderia+ " desde "+desdeFecha+ " hasta "+hastaFecha); 
    }

}
