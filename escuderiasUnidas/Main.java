package escuderiasUnidas;

import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[]args) throws ParseException {
      SistemaF1 S1 = new SistemaF1();
      Pais p1 = new Pais(10,"Argentina");
      Pais p2 = new Pais(3, "Brazil");
      Escuderia e1 = new Escuderia("Ferrari");
      Escuderia e2 = new Escuderia("Toyota");
      Circuito c1 = new Circuito("Formula 1",1500,p1 );
      Circuito c2 = new Circuito("SanAndreas",5000,p2 );
      S1.registrarResultado("SanAndreas","juan","Toyota",3,true);
      S1.registrarResultado("Formula 1","pedro","peugot",1,true);


        Scanner sc = new Scanner(System.in);
        int opcion;

     do {
        System.out.println("0 - Salir.");
        System.out.println("1 - Registrar (Pilotos, Carreras, Escuderias, etc)");
        System.out.println("2 - Mostrar (Puntos, Podios, informes, etc)");
        System.out.println("Elija una opcion : ");
        opcion = sc.nextInt();

        switch (opcion) {
                case 0 :
                System.out.println("Saliendo del Menu.");
                break;
                case 1: 
                paraRegistro();
                break;
                case 2:
                    ResultadosDetalladosPorRango();
                break;
            case 3:
                RankingPilotos();
                break;
                default :
                System.out.println("Opcion invalida.");
        } 
        
        } while(opcion != 0);
sc.close();

    }



    public static void paraRegistro()  {
        Scanner sc = new Scanner(System.in);

        int op;
        do {
            System.out.println("1 - Piloto.");
            System.out.println("2 - Auto.");
            System.out.println("3 - Carrera.");
            System.out.println("4 - Mecanico.");
            System.out.println("5 - Escuderia.");
            System.out.println("6 - Circuito.");
            System.out.println("7 - Pais.");
            System.out.println("Elija una opción: ");
            op = sc.nextInt();

            switch(op) {
                case 1 :
                    RegistrarPiloto();
                case 2 :
                    RegistrarAuto();
                break;
                case 3:
                    try {
                        RegistroCarrera();
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 4:
                    RegistroMecanico();
                 break;
                case 5:
                    RegistroEscuderia();
                 break;
                case 6:
                    RegistrarCircuito();
                break;
                case 7:
                    RegistrarPais();
                break;
            }

        } while (op != 0);
        sc.close();
    }
static SistemaF1 S1 = new SistemaF1();
    public static void RegistrarPiloto() {
        Scanner sc = new Scanner(System.in);

        do {
            Pais Pa = null;
            System.out.println("Ingrese DNI: ");
            String dni = sc.nextLine();
            System.out.println("Ingrese Nombre: ");
            String nombre = sc.nextLine();
            System.out.println("Ingrese Apellido : ");
            String apellido = sc.nextLine();
            System.out.println("Ingrese Id del Pais");
            int idPais = sc.nextInt();

            S1.registrarPiloto(dni, nombre, apellido,idPais );

        } while(!sc.nextLine().isEmpty());
        paraRegistro();
    }

    public static void RegistrarAuto() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Modelo: ");
            String modelo = sc.nextLine();
            System.out.println("Motor: ");
            String motor = sc.nextLine();
            System.out.println("Escuderia");
            String escu = sc.nextLine();
            S1.registrarAuto(modelo, motor,escu);

        }while(!sc.nextLine().isEmpty());
        paraRegistro();
    }
    public static void RegistroMecanico(){
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Dni");
            String dni = sc.nextLine();
            System.out.println("Nombre");
            String nombre =sc.nextLine();
            System.out.println("Apellido");
            String apellido = sc.nextLine();
            System.out.println("Id del Pais");
            int pais = sc.nextInt();
            System.out.println("Años de experiecia");
            int añosExperiencia = sc.nextInt();
            System.out.println("Ingrese especialidad: 1 Motor, 2  Neumaticos, 3 Chasis, 4 Electroica");
            Especialidad d;
            int valor;
            valor = sc.nextInt();
            d = Especialidad.values()[valor - 1];

            S1.registrarMecanico( dni,  nombre,  apellido,  pais,  añosExperiencia,  d);
        }while(!sc.nextLine().isEmpty());
        paraRegistro();
    }

    public static void RegistroEscuderia(){
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Ingrese Nombre de Escuderia");
            String escu = sc.nextLine();
            S1.registrarEscuderia(escu);

        }while(!sc.nextLine().isEmpty());
        paraRegistro();
    }

    public static void RegistrarPais(){
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Ingrese Id del Pais");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.println("Ingrese Descripcion del Pais");
            String desc = sc.nextLine();
            S1.registrarPais(id,desc);

        }while(!sc.nextLine().isEmpty());
        paraRegistro();
    }

    public static void RegistroCarrera() throws ParseException {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Ingrese fecha de la Carrera, en formato dd/MM/yyyy");
            String f= sc.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date fecha = sdf.parse(f);
            System.out.println("Ingrese Numero de Vueltas");
            int numeroVueltas = sc.nextInt();
            sc.nextLine();
            System.out.println("ingrese hora en la que se realiza la carrera");
            String hora = sc.nextLine();
            System.out.println("Ingrese nombre del Circuito");
            String nombreCircuito = sc.nextLine();

            S1.crearCarrera(fecha,  numeroVueltas,  hora,  nombreCircuito);
            System.out.println("Carrera creada en " + nombreCircuito + " a las " + hora);

        }while(!sc.nextLine().isEmpty());
        paraRegistro();

    }

    public static void RegistrarCircuito(){
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Ingrese nombre");
            String nombre = sc.nextLine();
            System.out.println("ingrese Longitud");
            int longitud = sc.nextInt();
            System.out.println("ingrese Id del Pais");
            int idPais = sc.nextInt();

            S1.registrarCircuito( nombre,  longitud,  idPais);

        }while(!sc.nextLine().isEmpty());
        paraRegistro();
    }
    public static void ResultadosDetalladosPorRango() throws ParseException {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Ingrese Fecha de inicio");
            String d= sc.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date inicio = sdf.parse(d);
            System.out.println("Ingrese fecha de finalizacion");
            String e= sc.nextLine();
            SimpleDateFormat dsf = new SimpleDateFormat("dd/MM/yyyy");
            Date fin = dsf.parse(e);
            S1.resultadosDetalladosPorRango(inicio, fin);

        }while(!sc.nextLine().isEmpty());



    }


}






