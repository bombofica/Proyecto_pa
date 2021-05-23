/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registro.obras.Modelo;

import com.registro.obras.Controlador.PoderInforme;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

/**
 *
 * @author Ceseo
 */
//3000 - 5999
public class ObraRestauracion extends Obra implements PoderInforme{
    long presupuesto ;
    String tiempoRestante ;
    int fase ;
    private ArrayList<String> fasesRestauracion;
    //PoderInforme informes;
    
    public ObraRestauracion(String nombreObra, String nombreRegion, String tiempoAsignado, long presupuesto)
    {
        super(nombreObra, nombreRegion, 2) ;
        this.presupuesto = presupuesto ;
        this.tiempoRestante = tiempoAsignado ;
        this.fase = 0;
        this.fasesRestauracion = new ArrayList();
        llenarArrayFases() ;
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
    
    @Override
    public long gastosObra()
    {
        long gastosTotales = 0;
        long sueldoEmpleados = 0;
        if(getNumeroEmpleados() != 0)
        {
            Trabajador[] listaEmpleados = new Trabajador[getNumeroEmpleados()] ;
            getListadoPersonas(listaEmpleados);
            for(int i = 0; i < listaEmpleados.length; i++)
            {
                sueldoEmpleados += (long)listaEmpleados[i].getSueldo() ;
            }
            gastosTotales = this.presupuesto - sueldoEmpleados;
            return gastosTotales;
        }
        
        return this.presupuesto;
    }
    
       public void crearInforme(String opcional)
    {
        try {
            FileWriter escritor = new FileWriter("Informes//Informe "+this.getNombreObra()+".doc");
            escritor.write("Nombre Obra: "+this.getNombreObra()+'\n'+
                    "Fase: "+this.getFase()+'\n'+
                    "Región: "+ this.getNombreLugar()+'\n'+
                    "Tiempo Restante: "+ this.getTiempoRestante()+'\n'+
                    "Presupuesto: $"+ this.getPresupuesto()+'\n'+
                    "Comentarios: \n"+opcional);
            escritor.close();
        } catch (IOException ex) {
            Logger.getLogger(ObraConstruccion.class.getName()).log(Level.SEVERE, null, ex);
        }   
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
        //informes.crearInforme("");
        //informes.crearGrafico();
        //informes.calcularFase();
        //informes.calcularPresupuestoGastadoMensual();
    }

    private void llenarArrayFases(){
        
    }
    
    
}