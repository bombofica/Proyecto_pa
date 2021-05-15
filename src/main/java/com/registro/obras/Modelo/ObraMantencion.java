/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registro.obras.Modelo;

/**
 *
 * @author Ceseo
 */
//3000 - 3999
public class ObraMantencion extends Obra{
    
    long mantenimientoMonetarioAnual ;
    double InteresAnual ;
    boolean operativo ;


    public ObraMantencion(String nombreObra, String nombreRegion, long mantenimientoMonetarioAnual, double InteresAnual)

    {
        super(nombreObra, nombreRegion, 3) ;
        this.mantenimientoMonetarioAnual = mantenimientoMonetarioAnual;
        this.operativo = false ;
        this.InteresAnual = InteresAnual;
        
    }
    public long getMantenimientoMonetarioAnual() {
        return mantenimientoMonetarioAnual;
    }

    public void setMantenimientoMonetarioAnual(long mantenimientoMonetarioAnual) {
        this.mantenimientoMonetarioAnual = mantenimientoMonetarioAnual;
    }

    public double getInteresAnual() {
        return InteresAnual;
    }

    public void setInteresAnual(long InteresAnual) {
        this.InteresAnual = InteresAnual;
    }

    public boolean isOperativo() {
        return operativo;
    }

    public void setOperativo(boolean operativo) {
        this.operativo = operativo;
    }
    

    
    
}

