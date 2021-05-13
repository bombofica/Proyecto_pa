/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registro.obras.Modelo;

/**
 *
 * @author Benjamín
 */
public class Trabajador extends Persona{
    
    private String laborProfesional;
    private int sueldo;
    private String obraALaQuePertenece;
    private boolean trabajando;
    
    public Trabajador(){
        
    }
    
    // NombrePersona,Labor,Sueldo,Rut,Estado(Trabajando o no),
    public Trabajador(String nombre,String laborProfesional,int sueldo, int rut,boolean trabajando, String obraALaQuePertenece){
        super(nombre,rut);
        this.obraALaQuePertenece = obraALaQuePertenece;
        this.sueldo = sueldo;
        this.laborProfesional = laborProfesional;
        this.trabajando = trabajando;
    }

    public String getObraALaQuePertenece(){
        return this.obraALaQuePertenece;
    }

    public void setObraALaQuePertenece(String obraNueva){
        this.obraALaQuePertenece = obraNueva;
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
    
    public boolean isTrabajando() {
        return trabajando;
    }

    public void setTrabajando(boolean trabajando) {
        this.trabajando = trabajando;
    }
    
}
