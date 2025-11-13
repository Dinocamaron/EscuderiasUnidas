package escuderiasUnidas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static java.util.Collections.*;

public class SistemaF1  {
    private List<Piloto> pilotos;
    private List<Escuderia> escuderias;
    private List<Auto> autos;
    private List<Mecanico> mecanicos;
    private List<Circuito> circuitos;
    private List<Pais> paises;
    private List<Carrera> carreras;
    private List<PilotoEscuderia> pilotoEscuderias;

    public SistemaF1() {
        this.pilotos = new ArrayList<Piloto>();
        this.escuderias = new ArrayList<>();
        this.autos = new ArrayList<>();
        this.mecanicos = new ArrayList<>();
        this.circuitos = new ArrayList<>();
        this.paises = new ArrayList<>();
        this.carreras = new ArrayList<>();
    }

    // Métodos de registro
    public void registrarPiloto(String dni, String nombre, String apellido, int idPais) {
        Pais P = null;
        for (Pais p: paises){
            if(p.getIdPais()== idPais){
                P = p;
            }
        }
        Piloto p = new Piloto(dni, nombre, apellido, P);
        pilotos.add(p);
        System.out.println("Piloto registrado: " + nombre);
    }

    public void registrarEscuderia(String nombre) {
        Escuderia e = new Escuderia(nombre);
        escuderias.add(e);
        System.out.println("Escudería registrada: " + nombre);
    }

    public void registrarAuto(String modelo, String motor, String escu) {
        Auto a = autos.stream().filter(au -> au.getModelo().equals(modelo)).findFirst().orElse(null);
        Escuderia e = escuderias.stream().filter(es -> es.getNombre().equals(escu)).findFirst().orElse(null);
        if (a != null && e != null) {
            Auto A = new Auto(modelo, motor, e);
            autos.add(a);
            e.agregarAuto(A);
            System.out.println("Auto asignado a escudería.");
        } else {
            System.out.println("Auto o escudería no encontrados.");
        }

        System.out.println("Auto registrado: " + modelo);
    }

    public void registrarMecanico(String dni, String nombre, String apellido, int idpais, int añosExperiencia, Especialidad especialidad) {
        Pais P = null;
        for (Pais p: paises){
            if(p.getIdPais()== idpais){
                P = p;
            }
        }
        Mecanico m = new Mecanico(dni, nombre, apellido, P, añosExperiencia, especialidad);
        mecanicos.add(m);
        System.out.println("Mecánico registrado: " + nombre);
    }

    public void registrarPais(int idPais, String descripcion) {
        Pais p = new Pais(idPais, descripcion);
        paises.add(p);
        System.out.println("País registrado: " + idPais);
    }

    public void registrarCircuito(String nombre, int longitud, int idPais) {
        Pais P = null;
        for (Pais p: paises){
            if(p.getIdPais()== idPais){
                P = p;
            }
        }
        if (P != null) {
            Circuito c = new Circuito(nombre, longitud, P);
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

   /* public void asignarAutoAEscuderia(String modeloAuto, String nombreEscuderia) {
        Auto a = autos.stream().filter(au -> au.getModelo().equals(modeloAuto)).findFirst().orElse(null);
        Escuderia e = escuderias.stream().filter(es -> es.getNombre().equals(nombreEscuderia)).findFirst().orElse(null);
        if (a != null && e != null) {
            e.agregarAuto(a);
            System.out.println("Auto asignado a escudería.");
        } else {
            System.out.println("Auto o escudería no encontrados.");
        }
    }

    */

    // Planificar carrera
    public void crearCarrera(Date fecha, int numeroVueltas, String hora, String nombreCircuito) {
        for (Circuito c : circuitos) {
            if (c.getNombre().equals(nombreCircuito)) {
                Carrera ca = new Carrera(fecha, numeroVueltas, hora, c);
                carreras.add(ca);
            } else {
                System.out.println("Circuito no encontrado.");
            }
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
                    System.out.println(part.getPilotoP().getPiloto().getNombre() + " - Pos: " + part.getPosicion() + " - Vuelta Rápida: " + part.isVueltaRapida());
                }
            }
        }

        }

    public void RankingPilotos() {
        System.out.println("Ranking de Pilotos por Puntos:");
        Collections.sort(pilotos);
        for (Piloto p : pilotos) {
            System.out.println(p.getNombre() + " - Puntos: " + p.getPuntos());
        }
    }
}

