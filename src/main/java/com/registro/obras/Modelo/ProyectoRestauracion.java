/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registro.obras.Modelo;

import com.registro.obras.Controlador.*;
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
public class ProyectoRestauracion extends Obra implements ProyectoReportable{
    private long presupuesto ;
    private String tiempoRestante ;
    private int fase ;
    private ArrayList<String> fasesRestauracion;
    //PoderInforme informes;
    
    public ProyectoRestauracion(String nombreObra, String nombreRegion, String tiempoAsignado, long presupuesto, int fase)
    {
        super(nombreObra, nombreRegion, 2) ;
        this.presupuesto = presupuesto ;
        this.tiempoRestante = tiempoAsignado ;
        this.fase = fase;
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
    public String getFaseActual(){
        return this.fasesRestauracion.get(fase) ;
    }
    public int getFase() {
        return fase ;
    }

    public void setFase() {
        if(fase != 5)
        {
            this.fase++ ;
        }
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
            Logger.getLogger(ProyectoRestauracion.class.getName()).log(Level.SEVERE, null, ex);
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
    

    private void llenarArrayFases(){
        this.fasesRestauracion.add("Analisis de la documentacion") ;
        this.fasesRestauracion.add("Determinar el grado de intervencion") ;
        this.fasesRestauracion.add("Consolidacion") ;
        this.fasesRestauracion.add("Limpieza general") ;
        this.fasesRestauracion.add("Reconstruccion") ;
        this.fasesRestauracion.add("Acabados y cierres") ;
    }
    
    
}