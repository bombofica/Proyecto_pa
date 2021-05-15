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
    long InteresAnual ;
    boolean operativo ;

    ObraMantencion(String nombreObra, String nombreRegion, long mantenimientoMonetarioAnual, long InteresAnual, boolean operativo)
    {
        super(nombreObra, nombreRegion, 3) ;
        this.mantenimientoMonetarioAnual = mantenimientoMonetarioAnual;
        this.operativo = operativo ;
    }
    
    
}

