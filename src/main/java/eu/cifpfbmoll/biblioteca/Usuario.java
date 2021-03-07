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
 * @author Alberto y Jose
 */
public class Usuario {
    public static Scanner lectorUsuarios = new Scanner(System.in);

    // Atributos de usuario
    private String nombreReal;
    private String nombreUsuario;
    private String apellido1;
    private String apellido2;
    private String NIF;
    private String contraseña;
    private ArrayList<Usuario> listaLibrosReservados = new ArrayList();

    // Constructor vacío
    public Usuario() {
    }

    // Constructor con todos los parametros
    public Usuario(String nombreReal, String nombreUsuario, String apellido1, String apellido2, String NIF, String contraseña) {
        this.setNombreReal(nombreReal);
        this.setNombreUsuario(nombreUsuario);
        this.setApellido1(apellido1);
        this.setApellido2(apellido2);
        this.setNIF(NIF);
        this.setContraseña(contraseña);
        this.listaLibrosReservados = listaLibrosReservados;
    }
    
    // Constructor copia
    public Usuario(Usuario usuario1){
        this.setNombreReal(usuario1.getNombreReal());
        this.setNombreUsuario(usuario1.getNombreUsuario());
        this.setApellido1(usuario1.getApellido1());
        this.setApellido2(usuario1.getApellido2());
        this.setNIF(usuario1.getNIF());
        this.setContraseña(usuario1.getContraseña());
        this.setListaLibrosReservados(usuario1.getListaLibrosReservados());
    }
    
    // Getters and Setters
    public String getNombreReal() {
        return nombreReal;
    }

    public void setNombreReal(String nombre) {
        this.nombreReal = nombre;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    
    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        while(contraseña.length() < 8){
            System.out.println("La contraseña debe tener mínimo 8 carácteres");
            System.out.println("Es por tu seguridad compañero :)");
            contraseña = lectorUsuarios.nextLine();
        }
        this.contraseña = contraseña;
    }

    public ArrayList<Usuario> getListaLibrosReservados() {
        return listaLibrosReservados;
    }

    public void setListaLibrosReservados(ArrayList<Usuario> listaLibrosReservados) {
        this.listaLibrosReservados = listaLibrosReservados;
    }
    
    // TO-STRING

    @Override
    public String toString() {
        return "Usuario{" + "nombreReal=" + nombreReal + ", nombreUsuario=" + nombreUsuario + ","
                + " apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", "
                + "NIF=" + NIF + ", contrase\u00f1a=" + contraseña + ", "
                + "listaLibrosReservados=" + listaLibrosReservados + '}';
    }

    
    // MÉTODOS
    // Añadir usuario
    
    public static Usuario crearUsuario(ArrayList<Usuario> listaUsuarios){
        Usuario usuario1 = new Usuario();
        
        System.out.println("Para crear un usuario necesitaremos un nombre completo,"
                + " un nombre de Usuario, su NIF y una contraseña.");
        System.out.println("Vamos a empezar por el mombre completo:");
        System.out.println("\n");
        System.out.println("Nombre:");
        usuario1.setNombreReal(lectorUsuarios.nextLine());
        
        System.out.println("Primer apellido:");
        usuario1.setApellido1(lectorUsuarios.nextLine());
        
        System.out.println("Segundo apellido:");
        usuario1.setApellido2(lectorUsuarios.nextLine());
        
        System.out.println("Pon un nombre de usuario, con él podrás iniciar sesión cuando quieras:");
        usuario1.setNombreUsuario(lectorUsuarios.nextLine());
        
        System.out.println("NIF:");
        usuario1.setNIF(lectorUsuarios.nextLine());
        
        System.out.println("Contraseña que utilizarás:");
        usuario1.setContraseña(lectorUsuarios.nextLine());
        
        System.out.println("\n");
        System.out.println("Usuario añadido a la Biblioteca");
        System.out.println("Bienvenido " + usuario1.getNombreReal());
        listaUsuarios.add(usuario1);
        
        return usuario1;
    }
    
    public static void eliminarUsuario(ArrayList<Usuario> listaUsuarios){
        System.out.println("Vamos a eliminar un usuario de la Biblioteca");
        System.out.println("Para ello vamos a necesitar el NIF y la contraseña de dicho usuario.");
        
        System.out.println("NIF:");
        String NIF = lectorUsuarios.nextLine();
        System.out.println("contraseña:");
        String contraseña = lectorUsuarios.nextLine();
        
        boolean encontrado = false;
        int i = 0;
        
        while(!encontrado && i<listaUsuarios.size()){
            if(listaUsuarios.get(i).getNIF().equals(NIF)){
                if(listaUsuarios.get(i).getContraseña().equals(contraseña)){
                    listaUsuarios.remove(i);
                    System.out.println("Usuario encontrado y eliminado.");
                    encontrado = true;
                }
            }
        }
        i++;   
    }
    
    public static void mostrarUsuarios(ArrayList<Usuario> listaUsuarios){
        
        System.out.println("Estos son los usuarios que hay actualmente:");
        System.out.println("\n");
        
        for(int i=0; i<listaUsuarios.size(); i++){
            System.out.println(listaUsuarios.get(i).toString());
        }
    }
    
    public static int iniciarSesion(ArrayList<Usuario> listaUsuarios){
        int posicion = 0;
        boolean inicioSesion = false;
        int i = 0;
        System.out.println("Pon tu nombre de Usuario y contraseña");
        
        System.out.println("Nombre de usuario:");
        String nombre = lectorUsuarios.nextLine();
        
        System.out.println("Contraseña:");
        String contraseña = lectorUsuarios.nextLine();
        
        
        while(!inicioSesion && i<listaUsuarios.size()){
            if(listaUsuarios.get(i).getNombreUsuario().equals(nombre) 
                && listaUsuarios.get(i).getContraseña().equals(contraseña)){
                    System.out.println("Inicio de sesión completado");
                    System.out.println(" ---> Bienvenido " + listaUsuarios.get(i).getNombreReal() + " <---");
                    inicioSesion = true;
                    posicion = 1;
                    return posicion;
            }
            i++;
        }
        if(!inicioSesion){
            System.out.println("No he podido inicar sesión, vuelve a intentarlo ");
            posicion = 0;
            return posicion;
            
        }
        return posicion;
    }
    
    public static void reservarLibro(ArrayList<Libro> listaLibros, ArrayList<Usuario> listaUsuarios){
        int i = 0;
        int j = 0;
        boolean personaEncontrada = false;
        boolean libroEncontrado = false;
        System.out.println("Vamos a reservar un libro, para ello pon tu contraseña:");
        String contraseña = lectorUsuarios.nextLine();
        
        // Primero vamos a encontrar al Usuario
        while(!personaEncontrada && i<listaUsuarios.size()){
            if(listaUsuarios.get(i) instanceof Usuario){
                if(((Usuario)listaUsuarios.get(i)).getContraseña().equals(contraseña)){
                    personaEncontrada = true;
                    
                    System.out.println("Hola "+ listaUsuarios.get(i).getNombreReal());
                    System.out.println("Escribe el ISBN del libro que quieres reservar:");
                    int ISBN = lectorUsuarios.nextInt();
                    lectorUsuarios.nextLine();
                    
                    // Ahora vamos a buscar el libro que quiere
                    while(!libroEncontrado && j<listaLibros.size()){
                        if(listaLibros.get(j).getISBN() == ISBN){
                            libroEncontrado = true;
                            
                            // Hemos encontrado el libro, ahora solo falta mirar que tenga copias disponibles
                            if(listaLibros.get(j).getNum_copias_disponibles()>=1){
                                listaLibros.get(j).setNum_copias_disponibles(listaLibros.get(j).getNum_copias_disponibles()-1);
                                //Vamos a añadirlo a la lista de libros Reservados del usuario.
                                Libro libro = new Libro(listaLibros.get(j));
                                //((Usuario)listaUsuarios.get(i)).getListaLibrosReservados().add(libro);
                                //Vamos a restar un libro a sus copias disponibles
                                listaLibros.get(j).setNum_copias_disponibles(listaLibros.get(j).getNum_copias_disponibles()-1);
                                System.out.println("Reserva realizada con éxito");
                            }
                            else{
                                System.out.println("Lo siento, no hay copias disponibles de este libro en estos momentos.");
                            }
                        }
                    }
                    j++;
                    if(!libroEncontrado){
                        System.out.println("No hay ningún libro con ese ISBN");
                    }
                }
            }
        }
        i++;
        if(!personaEncontrada){
            System.out.println("Lo siento, ningún Usuario tiene esa contraseña");
        }
    }
       
}
