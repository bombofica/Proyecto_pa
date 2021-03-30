/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

/**
 * Programación Avanzada ICI3241-1
 * @author Benjamín Rojas Henríquez
 * @author Andrés Vidal Soto
 */
public class Persona {
    
    private String nombre;
    private String laborProfesional;
    private int sueldo;
    private int rut;
    

    public Persona() {
    }

    
    public Persona(String nombre, String laborProfecional, int sueldo, int rut) {
        this.nombre = nombre;
        this.laborProfesional = laborProfecional;
        this.sueldo = sueldo;
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLaborProfesional() {
        return laborProfesional;
    }

    public void setLaborProfesional(String laborProfecional) {
        this.laborProfesional = laborProfecional;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }
    
    
    
}
