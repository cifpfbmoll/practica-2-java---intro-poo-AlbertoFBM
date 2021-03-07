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
public class Persona {
    // Scanner para Persona
    public static Scanner lectorPersonal = new Scanner(System.in);
    // Atributos de Persona
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String NIF;
    private String contraseña;
    
    // Constructor vacío
    public Persona() {
    }
    
    // Constructor con parámetros
    public Persona(String nombre, String apellido1, String apellido2, String NIF, String contraseña) {
        this.setNombre(nombre);
        this.setApellido1(apellido1);
        this.setApellido2(apellido2);
        this.setNIF(NIF);
        this.setContraseña(contraseña);
    }
    
    // Contructor copia
    public Persona(Persona persona1){
        this.setNombre(persona1.getNombre());
        this.setApellido1(persona1.getApellido1());
        this.setApellido2(persona1.getApellido2());
        this.setNIF(persona1.getNIF());
        this.setContraseña(persona1.getContraseña());
        
    }
    
    // GETTERS AND SETTERS

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
            System.out.println("La contraseña debe tener al menos 8 carácteres.");
            System.out.println("Es por tu seguridad :)");
            contraseña = lectorPersonal.nextLine();
        }
        this.contraseña = contraseña;
    }
    
    // TOSTRING
    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", NIF=" + NIF + ", contrase\u00f1a=" + contraseña + '}';
    }
    
    // MÉTODOS
    // Añadir trabajador
    
    public static Persona añadirTrabajador(ArrayList<Persona> listaPersonal){
        Persona trabajador1 = new Persona();
        System.out.println("Vamos a añadir un nuevo trabajador a la Biblioteca.");
        System.out.println("Primero dime su nombre:");
        trabajador1.setNombre(lectorPersonal.nextLine());
        
        System.out.println("Ahora dime sus dos apellidos:");
        System.out.println("Primer Apellido: ");
        trabajador1.setApellido1(lectorPersonal.nextLine());
        System.out.println("Segundo Apellido: ");
        trabajador1.setApellido2(lectorPersonal.nextLine());
        
        System.out.println("Ahora dime su NIF:");
        trabajador1.setNIF(lectorPersonal.nextLine());
        
        System.out.println("Por último dime su contraseña como trabajador de la Biblioteca:");
        trabajador1.setContraseña(lectorPersonal.nextLine());
        
        listaPersonal.add(trabajador1);
        System.out.println("\n");
        System.out.println("Bienvenido al trabajo " + trabajador1.getNombre());
        System.out.println(trabajador1.toString());
        
        return trabajador1;
    }
    
    public static void eliminarTrabajador(ArrayList<Persona> listaPersonal){
        System.out.println("Vamos a eliminar a un trabajador.");
        System.out.println("Para ello pon su NIF y su contraseña personal:");
        System.out.println("NIF:");
        String NIF = lectorPersonal.nextLine();
        
        int i = 0;
        boolean encontrarPersona = false;
        
        while(!encontrarPersona && i<listaPersonal.size()){
            if(listaPersonal.get(i).getNIF().equals(NIF)){
                System.out.println("Contraseña: ");
                String contraseña = lectorPersonal.nextLine();
                if(listaPersonal.get(i).getContraseña().equals(contraseña)){
                    listaPersonal.remove(i);
                    System.out.println("Persona encontrada y eliminada.");
                    encontrarPersona = true;
                    break;
                } 
                else{
                    System.out.println("La contraseña no es correcta");
                }
            }
            else{
                System.out.println("El NIF no es correcto.");
            }
            i++;
        }
        
        
        if(encontrarPersona == false){
            System.out.println("No he encontrado a este trabajador...");
        }   
    }
    public static void mostrarPersonal(ArrayList<Persona> listaPersonal){
        
        System.out.println("Estos son los trabajadores que hay actualmente:");
        System.out.println("\n");
        for(int i=0; i<listaPersonal.size(); i++){
            System.out.println(listaPersonal.get(i).toString());
        }
    }

    
}

