package escuderiasUnidas.carreras;

public class Auto {
    private String modelo;
    private String motor;

    public Auto (String modelo, String motor){
        this.modelo= modelo;
        this.motor= motor;
    }
    public Auto (){
        this.modelo= "";
        this.motor= "";
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
