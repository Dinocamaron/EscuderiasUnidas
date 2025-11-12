package escuderiasUnidas;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SistemaF1 {
    private List<Piloto> pilotos;
    private List<Escuderia> escuderias;
    private List<Auto> autos;
    private List<Mecanico> mecanicos;
    private List<Circuito> circuitos;
    private List<Pais> paises;
    private List<Carrera> carreras;
    private List<PilotoEscuderia> pilotoEscuderias;

    public SistemaF1() {
        this.pilotos = new ArrayList<>();
        this.escuderias = new ArrayList<>();
        this.autos = new ArrayList<>();
        this.mecanicos = new ArrayList<>();
        this.circuitos = new ArrayList<>();
        this.paises = new ArrayList<>();
        this.carreras = new ArrayList<>();
    }

    // Métodos de registro
    public void registrarPiloto(String dni, String nombre, String apellido, Pais pais) {
        Piloto p = new Piloto(dni, nombre, apellido, pais);
        pilotos.add(p);
        System.out.println("Piloto registrado: " + nombre);
    }

    public void registrarEscuderia(String nombre) {
        Escuderia e = new Escuderia(nombre);
        escuderias.add(e);
        System.out.println("Escudería registrada: " + nombre);
    }

    public void registrarAuto(String modelo, String motor, Escuderia escuderia) {
        Auto a = new Auto(modelo, motor, escuderia);
        autos.add(a);
        System.out.println("Auto registrado: " + modelo);
    }

    public void registrarMecanico(String dni, String nombre, String apellido, Pais pais, int añosExperiencia, Especialidad especialidad) {
        Mecanico m = new Mecanico(dni, nombre, apellido, pais, añosExperiencia, especialidad);
        mecanicos.add(m);
        System.out.println("Mecánico registrado: " + nombre);
    }

    public void registrarPais(int idPais, String descripcion) {
        Pais p = new Pais(idPais, descripcion);
        paises.add(p);
        System.out.println("País registrado: " + idPais);
    }

    public void registrarCircuito(String nombre, int longitud, String idPais) {
        Pais p = null;
        for (Pais pa : paises) {
            if ((idPais).equals(p.getIdPais())) {
                p = pa;
                break;
            }
        }
        if (p != null) {
            Circuito c = new Circuito(nombre, longitud, p);
            circuitos.add(c);
            System.out.println("Circuito registrado: " + nombre);
        } else {
            System.out.println("País no encontrado.");
        }
    }

    // Asignaciones con validaciones
    public void asignarPilotoAEscuderia(String desdeFecha, String hastaFecha, String nombrePiloto, String nombreEscuderia) {
        Piloto p = pilotos.stream().filter(pi -> pi.getNombre().equals(nombrePiloto)).findFirst().orElse(null);
        Escuderia e = escuderias.stream().filter(es -> es.getNombre().equals(nombreEscuderia)).findFirst().orElse(null);
        if (p != null && e != null) {
            PilotoEscuderia pe = new PilotoEscuderia(desdeFecha, hastaFecha, p, e);

            p.agregarPilotoEsc(pe);
            e.agregarPilotoEsc(pe);
            System.out.println("Piloto asignado a escudería.");
        } else {
            System.out.println("Piloto o escudería no encontrados.");
        }
    }

    public void asignarAutoAEscuderia(String modeloAuto, String nombreEscuderia) {
        Auto a = autos.stream().filter(au -> au.getModelo().equals(modeloAuto)).findFirst().orElse(null);
        Escuderia e = escuderias.stream().filter(es -> es.getNombre().equals(nombreEscuderia)).findFirst().orElse(null);
        if (a != null && e != null) {
            e.agregarAuto(a);
            System.out.println("Auto asignado a escudería.");
        } else {
            System.out.println("Auto o escudería no encontrados.");
        }
    }

    // Planificar carrera
    public void crearCarrera(Date fecha, int numeroVueltas, String hora, String nombreCircuito) {
        Circuito c = circuitos.stream().filter(ci -> ci.getNombre().equals(nombreCircuito)).findFirst().orElse(null);
        if (c != null) {
            Carrera ca = new Carrera(fecha, numeroVueltas, hora, c);
            carreras.add(ca);
            System.out.println("Carrera creada en " + nombreCircuito + " a las " + hora);
        } else {
            System.out.println("Circuito no encontrado.");
        }
    }

    // Registrar resultado
    public void registrarResultado(String nombreCircuito, String nombrePiloto, String modeloAuto, int posicion, boolean vueltaRapida) {
        Carrera ca = carreras.stream().filter(c -> c.getCircuito().getNombre().equals(nombreCircuito)).findFirst().orElse(null);
        PilotoEscuderia p = pilotoEscuderias.stream().filter(pi -> pi.getPiloto().getNombre().equals(nombrePiloto)).findFirst().orElse(null);
        Auto a = autos.stream().filter(au -> au.getModelo().equals(modeloAuto)).findFirst().orElse(null);
        if (ca != null && p != null && a != null) {
            ca.registrarParticipacion(p, a, posicion, vueltaRapida);
            System.out.println("Resultado registrado.");
        } else {
            System.out.println("Carrera, piloto o auto no encontrados.");
        }
    }

    // Informes
    public void resultadosDetalladosPorRango(Date inicio, Date fin) {
        System.out.println("Resultados detallados entre " + inicio + " y " + fin + ":");
        for (Carrera c : carreras) {
            if (!(c.getFechaRealizacion().before(inicio) && !c.getFechaRealizacion().after(fin))) {
                System.out.println("Carrera en " + c.getCircuito().getNombre() + " - " + c.getFechaRealizacion() + " " + c.getHoraRealizacion());
                for (Participacion part : c.getParticipaciones()) {
                    System.out.println(part.getPiloto().getNombre() + " - Pos: " + part.getPosicion() + " - Vuelta Rápida: " + part.isVueltaRapida());
                }
            }
        }
        public void rankingPilotos(){
            pilotos.sort((p1, p2) -> Integer.compare(p2.getPuntos(), p1.getPuntos()));
            System.out.println("Ranking de Pilotos por Puntos:");
            for (Piloto p : pilotos) {
                System.out.println(p.getNombre() + " - Puntos: " + p.getPuntos());
            }
        }
    }
}
