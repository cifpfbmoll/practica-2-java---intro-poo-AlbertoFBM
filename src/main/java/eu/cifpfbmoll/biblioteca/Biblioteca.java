/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.cifpfbmoll.biblioteca;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Alberto
 */
public class Biblioteca {
    // Atributos de la Biblioteca
    private String nombreBiblioteca;    
    private ArrayList<Libro> listaLibros = new ArrayList();
    private ArrayList<Persona> listaPersonal = new ArrayList();
    // añado un nuevo ArrayList<Usuario> para el ejercicio opcional
    private static ArrayList<Usuario> listaUsuarios = new ArrayList();
    // Constructor vacío
    public Biblioteca() {
    }
    
    // Constructor con todos los parámetros
    public Biblioteca(String nombreBiblioteca) {
        this.nombreBiblioteca = nombreBiblioteca;
    }
    // Constructor copia de Biblioteca
    public Biblioteca(Biblioteca Biblioteca){
        this.setNombreBiblioteca(Biblioteca.getNombreBiblioteca());
        this.setListaLibros(Biblioteca.getListaLibros());
        this.setListaPersonal(Biblioteca.getListaPersonal());
        this.setListaUsuarios(Biblioteca.getListaUsuarios());
    }   
    
    // GETTERS AND SETTERS
    public String getNombreBiblioteca() {
        return nombreBiblioteca;
    }

    public void setNombreBiblioteca(String nombreBiblioteca) {
        this.nombreBiblioteca = nombreBiblioteca;
    }
    //
    public ArrayList<Libro> getListaLibros() {
        return listaLibros;
    }

    public void setListaLibros(ArrayList<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }
    //
    public ArrayList<Persona> getListaPersonal() {
        return listaPersonal;
    }
    
    public void setListaPersonal(ArrayList<Persona> listaPersonal) {
        this.listaPersonal = listaPersonal;
    }

    // Los nuevos GETTER AND SETTER de Usuario
    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    
    
    // TO-STRING

    @Override
    public String toString() {
        return "Biblioteca{" + "nombreBiblioteca=" + nombreBiblioteca + ", listaLibros=" + listaLibros + ", "
                + "listaPersonal=" + listaPersonal + ", listaUsuarios=" + listaUsuarios + '}';
    }
    
    
    
    
    // MÉTODOS DE LA BIBLIOTECA
    
    public void mostrarLibros(){
        
        System.out.println("Estos son todos los libros que tiene la Biblioteca "
                + "del Francesc de Borja Moll:");
        for(int i=0; i < listaLibros.size(); i++){
            System.out.println(listaLibros.get(i));
        }
    }
 
    public void mostrarLibrosDisponibles(){
        
        System.out.println("Estos son los libros disponibles de la Biblioteca "
                + "del Francesc de Borja Moll:");
        for(int i=0; i<listaLibros.size(); i++){
            if(listaLibros.get(i).getNum_copias_disponibles()>0){
                System.out.println("El libro <<" + listaLibros.get(i).getTitulo() 
                        + ">> tiene " + listaLibros.get(i).getNum_copias_disponibles() + " copias disponibles");
            }
        }
    }
}
    

