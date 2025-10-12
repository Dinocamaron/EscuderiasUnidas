package escuderiasUnidas;
import java.util.*;
import escuderiasUnidas.carreras.*;
import escuderiasUnidas.personal.*;
import java.util.Scanner;

public class Main {
    public static void main(String[]args){
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
                paraRegistro(sc);
                break;
                case 2:
                paraMostrarCosas();
                break;
                default :
                System.out.println("Opcion invalida.");
        } 
        
        } while(opcion != 0);

        sc.close();
    }

    public static void paraRegistro(Scanner sc){
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
                break;
            }

        } while (op != 0);
    }

    public static void RegistrarPiloto(Scanner sc){
        System.out.println("Ingrese DNI: ");
        String dni = sc.nextLine();
        System.out.println("Ingrese Nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese Apellido : ");
        String apellido = sc.nextLine();
        
    }

}