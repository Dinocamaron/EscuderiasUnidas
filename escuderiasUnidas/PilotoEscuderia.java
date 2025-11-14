package escuderiasUnidas;


import java.util.Date;

public class PilotoEscuderia {
    private Date desdeFecha;
    private Date hastaFecha;
    private Piloto piloto;
    private Escuderia escuderia;

    public PilotoEscuderia( Date desdeFecha, Date hastaFecha, Piloto piloto, Escuderia escuderia) {

        this.desdeFecha = desdeFecha;
        this.hastaFecha = hastaFecha;
        this.piloto = piloto;
        this.escuderia = escuderia;
    }

    public void setDesdeFecha(Date desdefecha){
        this.desdeFecha=desdefecha;
    }
    public void setHastaFecha(Date hastafecha){
        this.hastaFecha=hastafecha;
    }
    public void setPiloto(Piloto piloto){
        this.piloto=piloto;
    }
    public void setEscuderia(Escuderia escuderia){
        this.escuderia=escuderia;
    }

    public Date getDesdeFecha(){
        return desdeFecha;
    }
    public Date getHastaFecha(){
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


    public boolean estaActivo(Date fecha) {
        return fecha.after(desdeFecha) && (hastaFecha == null || fecha.before(hastaFecha));
    }
    }

