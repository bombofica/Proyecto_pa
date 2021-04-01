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
    private String laborProfesional;
    private int sueldo;
    private int rut;
    private boolean trabajando;

    public boolean isTrabajando() {
        return trabajando;
    }

    public void setTrabajando(boolean trabajando) {
        this.trabajando = trabajando;
    }

    public Persona() {
    }

    
    public Persona(String nombre, String laborProfecional, int sueldo, int rut, boolean estado) {
        this.nombre = nombre;
        this.laborProfesional = laborProfecional;
        this.sueldo = sueldo;
        this.rut = rut;
        this.trabajando = estado;
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
