package escuderiasUnidas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static java.util.Collections.*;

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
        for (Pais p : paises) {
            if (p.getIdPais() == idPais) {
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
        for (Pais p : paises) {
            if (p.getIdPais() == idpais) {
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
        for (Pais p : paises) {
            if (p.getIdPais() == idPais) {
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
    // Asignacion de Piloto a Escuderia con validaciones

    public void asignarPilotoAEscuderia(String nombrePiloto, String nombreEscuderia, Date fechaInicio, Date fechaFin) {
        Piloto p = null;
        for (Piloto pi : pilotos) {
            if (pi.getNombre().equals(nombrePiloto)) {
                p = pi;
                break;
            }
        }
        Escuderia e = null;
        for (Escuderia es : escuderias) {
            if (es.getNombre().equals(nombreEscuderia)) {
                e = es;
                break;
            }
        }
        if (p != null && e != null) {
            e.asignarPiloto(p, fechaInicio, fechaFin);
            System.out.println("Piloto asignado a escudería.");
        } else {
            System.out.println("Piloto o escudería no encontrados.");
        }
    }

    // Planificar carrera
    public void crearCarrera(Date fecha, int numeroVueltas, String hora, String nombreCircuito) {
        Circuito c = null;
        for (Circuito ci : circuitos) {
            if (ci.getNombre().equals(nombreCircuito)) {
                c = ci;
                break;
            }
        }
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
    public void carrerasEnCircuito(String nombreCircuito) {
        int veces = (int) carreras.stream().filter(c -> c.getCircuito().getNombre().equals(nombreCircuito)).count();
        System.out.println("Carreras en " + nombreCircuito + ": " + veces);
    }

    public void vecesPilotoEnCircuito(String nombrePiloto, String nombreCircuito) {
        int veces = 0;
        for (Carrera c : carreras) {
            if (c.getCircuito().getNombre().equals(nombreCircuito)) {
                for (Participacion part : c.getParticipaciones()) {
                    if (part.getPiloto().getNombre().equals(nombrePiloto)) veces++;
                }
            }
        }
        System.out.println(nombrePiloto + " corrió " + veces + " veces en " + nombreCircuito);
    }

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

    public void experienciaEspecialidadMecanicos(String nombreEscuderia) {
        Escuderia e = escuderias.stream().filter(es -> es.getNombre().equals(nombreEscuderia)).findFirst().orElse(null);
        if (e != null) {
            System.out.println("Mecánicos de " + nombreEscuderia + ":");
            for (Mecanico m : e.getMecanicos()) {
                System.out.println(m.getNombre() + " - Experiencia: " + m.getAñosExperiencia() + " años, Especialidad: " + m.getEspecialidad());
            }
        } else {
            System.out.println("Escudería no encontrada.");
        }
    }

    public void autosPorEscuderia(String nombreEscuderia) {
        Escuderia e = escuderias.stream().filter(es -> es.getNombre().equals(nombreEscuderia)).findFirst().orElse(null);
        if (e != null) {
            System.out.println("Autos que a utilizado la Escuderia: " + nombreEscuderia + " en carreras:");
            for (Auto a : e.getAutos()) {
                System.out.println(a.getModelo());
            }
        } else {
            System.out.println("Escudería no encontrada.");
        }
    }

    public void historicoPodiosVictorias(String nombrePiloto) {
        Piloto p = pilotos.stream().filter(pi -> pi.getNombre().equals(nombrePiloto)).findFirst().orElse(null);
        if (p != null) {
            System.out.println("Histórico de " + nombrePiloto + ": Victorias: " + p.getVictorias() + ", Podios: " + p.getPodio() + ", Poles: " + p.getPolePosition());
        } else {
            System.out.println("Piloto no encontrado.");
        }
    }


    // Asignar auto a piloto en carrera
    public void asignarAutoAPilotoEnCarrera(String nombrePiloto, String modeloAuto, String nombreCircuito, Date fechaCarrera) {
        Piloto p = pilotos.stream().filter(piloto -> piloto.getNombre().equals(nombrePiloto)).findFirst().orElse(null);
        Auto a = autos.stream().filter(auto -> auto.getModelo().equals(modeloAuto)).findFirst().orElse(null);
        Carrera c = carreras.stream().filter(carrera -> carrera.getCircuito().equals(nombreCircuito)).findFirst().orElse(null);

        if (p == null || a == null || c == null) {
            System.out.println("Piloto, auto o carrera no encontrados.");
            return;
        }else {
            AutoPiloto au = new AutoPiloto(fechaCarrera,p,a,c);
        }


    }
}



