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
//3000 - 5999
public class ObraRestauracion extends Obra{
    
    long presupuesto ;
    String tiempoRestante ;
    int fase ;

    
    public ObraRestauracion(String nombreObra, String nombreRegion,String tiempoAsignado,long presupuesto)
    {
        super(nombreObra, nombreRegion, 2) ;
        this.presupuesto = presupuesto ;
        this.tiempoRestante = tiempoAsignado ;
        this.fase = 0;
    }
}
