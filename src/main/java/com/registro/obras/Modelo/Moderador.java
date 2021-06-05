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
public class Moderador extends Persona{

    public Moderador(boolean permiso, String nombre, int rut) {
        super(nombre, rut);
        this.permiso = permiso;
    } 
    
    private boolean permiso;
    
    public boolean isPermiso() {
        return permiso;
    }

    public void setPermiso(boolean permiso) {
        this.permiso = permiso;
    }

    
    @Override
    public String descripcion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
