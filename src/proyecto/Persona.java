/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

/**
 * Programación Avanzada ICI3241-1
 * @author Benjamín Rojas
 * @author Andrés Vidal
 */
public class Persona {
    
    private String nombre;
    private String laborProfecional;
    private int sueldo;
    private int rut;

    public Persona() {
    }

    
    public Persona(String nombre, String laborProfecional, int sueldo, int rut) {
        this.nombre = nombre;
        this.laborProfecional = laborProfecional;
        this.sueldo = sueldo;
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLaborProfecional() {
        return laborProfecional;
    }

    public void setLaborProfecional(String laborProfecional) {
        this.laborProfecional = laborProfecional;
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
