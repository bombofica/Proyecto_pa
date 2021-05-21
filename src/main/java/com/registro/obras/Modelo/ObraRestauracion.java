/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registro.obras.Modelo;

import com.registro.obras.Controlador.PoderInforme;

/**
 *
 * @author Ceseo
 */
//3000 - 5999
public class ObraRestauracion extends Obra implements PoderInforme{
    long presupuesto ;
    String tiempoRestante ;
    int fase ;
    PoderInforme informes;
    
    public ObraRestauracion(String nombreObra, String nombreRegion, String tiempoAsignado, long presupuesto)
    {
        super(nombreObra, nombreRegion, 2) ;
        this.presupuesto = presupuesto ;
        this.tiempoRestante = tiempoAsignado ;
        this.fase = 0;
    }
    public long getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(long presupuesto) {
        this.presupuesto = presupuesto;
    }

    public String getTiempoRestante() {
        return tiempoRestante;
    }

    public void setTiempoRestante(String tiempoRestante) {
        this.tiempoRestante = tiempoRestante;
    }

    public int getFase() {
        return fase;
    }

    public void setFase(int fase) {
        this.fase = fase;
    }
    
    public void crearInforme()
    {
        
    }
    
    public void crearGrafico()
    {
        
    }
    
    public int calcularFase()
    {
        return 0;
    }
    
    public double calcularPresupuestoGastadoMensual()
    {
        return 0;
    }
    
    public void informe()
    {
        informes.crearInforme();
        informes.crearGrafico();
        informes.calcularFase();
        informes.calcularPresupuestoGastadoMensual();
        
    }
}