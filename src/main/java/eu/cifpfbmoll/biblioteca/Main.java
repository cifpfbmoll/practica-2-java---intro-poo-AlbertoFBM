/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.cifpfbmoll.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author Alberto
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Biblioteca biblioteca = new Biblioteca("Libreria");
        inicializarBiblioteca(biblioteca);
        mostrarMenuBiblioteca(biblioteca);
    }
        
    public static void mostrarMenuBiblioteca(Biblioteca biblioteca){
        Scanner lectorMenu = new Scanner(System.in);
        int menu = 1;
        while(menu != 0){
            System.out.println("------------------------------------------------------------------");
            System.out.println("Bienvenido al menú de la Biblioteca del Francesc de Borja Moll !!!");
            System.out.println("------------------------------------------------------------------");
            System.out.println("                   En qué menú quieres entrar?"                    );
            System.out.println("                   1.- Menú de reservas."                          );
            System.out.println("                   2.- Menú del personal."                         );
            System.out.println("                   3.- Menú de usuarios."                          );
            System.out.println("                   4.- Salir."                                     );
            System.out.println("------------------------------------------------------------------");
        
            int opcion = lectorMenu.nextInt();
            lectorMenu.nextLine();
            switch(opcion){
                case 1:
                    mostrarMenuReservas(biblioteca);
                    break;
                case 2:
                    mostrarMenuPersonal(biblioteca);
                    break;
                case 3:
                    mostrarMenuUsuarios(biblioteca);
                    break;
                case 4:
                    System.out.println("------------------------------------------------------------------");
                    System.out.println("                             Adiós"                                );
                    menu = 0;
                    break;
            }
        }  
    }
    public static void mostrarMenuReservas(Biblioteca biblioteca){
        Scanner lectorMenuReservas = new Scanner(System.in);
        boolean menuReservas = false;
        while(!menuReservas){
            System.out.println("------------------------------------------------------------------");
            System.out.println("                   1.- Añadir libros"                              );
            System.out.println("                   2.- Eliminar libro"                             );
            System.out.println("                   3.- Buscar libro por ISBN"                      );
            System.out.println("                   4.- Buscar libro por título"                    );
            System.out.println("                   5.- Mostrar todos los libros de la Biblioteca"  );
            System.out.println("                   6.- Mostrar solo los libros disponibles"        );
            System.out.println("                   7.- Volver al menú anterior"                    );
            System.out.println("------------------------------------------------------------------");
        
            int opcion = lectorMenuReservas.nextInt();
            lectorMenuReservas.nextLine();
            switch (opcion) {
                case 1:
                    Libro.añadirLibro(biblioteca.getListaLibros());
                    System.out.println(biblioteca);
                    break;
                case 2:
                    Libro.eliminarLibro(biblioteca.getListaLibros());
                    break;
                case 3:
                    Libro.buscarISBN(biblioteca.getListaLibros());
                    break;
                case 4:
                    Libro.buscarTitulo(biblioteca.getListaLibros());
                    break;
                case 5:
                    biblioteca.mostrarLibros();
                    break;
                case 6:
                    biblioteca.mostrarLibrosDisponibles();
                    break;
                case 7:
                    mostrarMenuBiblioteca(biblioteca);
                    break;
                default:
                    System.out.println(" El número " + opcion + " no está disponible");
                    break;
            }
        }
    }
    public static void mostrarMenuPersonal(Biblioteca biblioteca){
        Scanner lectorMenuPersonal = new Scanner(System.in);
        boolean menuPersonal = false;
        while(!menuPersonal){
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("Bienvenido al menú de los trabajadores de la Biblioteca del Francesc de Borja Moll !!!");
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("                             1. Añadir trabajador"                                     );
            System.out.println("                             2. Encontrar y eliminar trabajador"                       );
            System.out.println("                             3. Mostrar todo el personal de la biblioteca"             );
            System.out.println("                             4. Volver al menú anterior"                               );
            System.out.println("--------------------------------------------------------------------------------------");
            
            int opcion = lectorMenuPersonal.nextInt();
            lectorMenuPersonal.nextLine();
            
            switch(opcion) {
                case 1:
                    Persona.añadirTrabajador(biblioteca.getListaPersonal());
                    break;
                case 2:
                    Persona.eliminarTrabajador(biblioteca.getListaPersonal());
                    break;
                case 3:
                    Persona.mostrarPersonal(biblioteca.getListaPersonal());
                    break;
                case 4:
                    mostrarMenuBiblioteca(biblioteca);
                    break;
                default:
                    System.out.println(" El número " + opcion + " no está disponible");
                    break;
            }
        }
    }
    
    public static void mostrarMenuUsuarios(Biblioteca biblioteca){
        Scanner lectorMenuUsuarios = new Scanner(System.in);
        boolean menu_usuarios = false;
        while(!menu_usuarios){
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println("Bienvenido al menú de los usuarios de la Biblioteca del Francesc de Borja Moll !!!");
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println("                           1. Añadir usuario"                                      );
            System.out.println("                           2. Encontrar y eliminar usuario"                        );
            System.out.println("                           3. Reservar libros"                                     );
            System.out.println("                           4. Mostrar usuarios"                                    );
            System.out.println("                           5. Volver al menú anterior"                             );
            System.out.println("----------------------------------------------------------------------------------");
         
            int opcion = lectorMenuUsuarios.nextInt();
            lectorMenuUsuarios.nextLine();
        
            switch (opcion) {
                case 1:
                    Usuario.crearUsuario(biblioteca.getListaUsuarios());
                    break;
                case 2:
                    Usuario.eliminarUsuario(biblioteca.getListaUsuarios());
                    break;
                case 3:
                    Usuario.reservarLibro(biblioteca.getListaLibros(), biblioteca.getListaUsuarios());
                    break;
                case 4:
                    Usuario.mostrarUsuarios(biblioteca.getListaUsuarios());
                    break;
                case 5:
                    mostrarMenuBiblioteca(biblioteca);
                    break;
                default:
                    System.out.println("El número " + opcion + " no está disponible");
            }
        }
    }
    public static Biblioteca inicializarBiblioteca(Biblioteca biblioteca){
        // Este es un método para añadir Trabajadores, Usuarios y unos cuantos libros a la Biblioteca
        
        // Primero añadimos Personas, que son los Trabajadores
        Persona B1 = new Persona("Alberto", "Serrano", "Ruiz", "123A", "contraseña1");
        
        biblioteca.getListaPersonal().add(B1);
        
        // Segundo añadimos Usuarios
        Usuario U1 = new Usuario("Alberto", "alberto1", "Serrano", "Ruiz", "123A", "contraseña1");
        
        biblioteca.getListaUsuarios().add(U1);
        
        // Por último añadimos unos cuantos Libros
        Libro L1 = new Libro(12345, "Harry Potter y la Piedra Filosofal", "JK Rowling", "Salamanca", 1000, 100);
        Libro L2 = new Libro(24680, "Harry Potter y la Cámara Secreta", " JK Rowling ", "Salamanca", 1000, 68);
        Libro L3 = new Libro(36912, "Harry Potter y el Prisionero De Azcaban", "JK Rowling", "Salamanca", 1000, 25);
        Libro L4 = new Libro(98765, "Harry Potter y el Caliz de Fuego", "JK Rowling", "Salamanca", 1000, 89);
        Libro L5 = new Libro(97531, "Harry Potter y la Orden del Fénix", "JK Rowling", "Salamanca", 1000, 76);
        Libro L6 = new Libro(12345, "Harry Potter y el misterio del Principe", "JK Rowling", "Salamanca", 1000, 30);
        Libro L7 = new Libro(10203, "Harry Potter y las Reliquias de la Muerte", "JK Rowling", "Salamanca", 1000, 0);
        
        biblioteca.getListaLibros().add(L1);
        biblioteca.getListaLibros().add(L2);
        biblioteca.getListaLibros().add(L3);
        biblioteca.getListaLibros().add(L4);
        biblioteca.getListaLibros().add(L5);
        biblioteca.getListaLibros().add(L6);
        biblioteca.getListaLibros().add(L7);
        
        return biblioteca; 
    }
}
