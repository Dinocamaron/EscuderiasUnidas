package escuderiasUnidas;

public class piloto extends Persona{

    private int numeroCompetencia;
    private int victorias;
    private int polePosition;
    private int vueltasRapidas;
    private int podio;


    public piloto (String dni, String nombre, String apellido,int numeroCompetencia, int victorias, int polePosition, int vueltasRapidas, int podio ){
        super(dni, nombre, apellido);
        this.numeroCompetencia= numeroCompetencia;
        this.victorias=victorias;
        this.polePosition=polePosition;
        this.vueltasRapidas=vueltasRapidas;
        this.podio=podio;
    }



}
