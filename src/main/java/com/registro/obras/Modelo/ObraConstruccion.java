package com.registro.obras.Modelo;

import com.registro.obras.Controlador.PoderInforme;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;


public class ObraConstruccion extends Obra implements PoderInforme{
    
    private long presupuesto ;
    private String tiempoRestante ;
    private int fase ;
    private PoderInforme informes;
    private ArrayList<String> fasesConstruccion;
    //private PoderInforme informes;

    //Constructor
    public ObraConstruccion(String nombreObra, String nombreRegion,String tiempoAsignado,long presupuesto)
    {
        super(nombreObra, nombreRegion, 1) ;
        this.presupuesto = presupuesto ;
        this.tiempoRestante = tiempoAsignado ;
        this.fase = 0;
        this.fasesConstruccion = new ArrayList();
        llenarArrayFases() ;
    }
    
    //seter y geters
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
    
    //metodos publicos

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
    @Override
    public void crearInforme(String opcional)
    {
        try {
            
            FileWriter escritor = new FileWriter("Informes//Informe "+this.getNombreObra()+".doc");

            escritor.write("Nombre Obra: "+this.getNombreObra()+'\n'+
                    "Fase: "+this.getFase()+'\n'+
                    "Región: "+ this.getNombreLugar()+'\n'+
                    "Tiempo Restante: "+ this.getTiempoRestante()+'\n'+
                    "Presupuesto: $"+ this.getPresupuesto()+'\n'+
                    "Comentarios: "+'\n'+opcional);
            escritor.close();
        } catch (IOException ex) {
            Logger.getLogger(ObraConstruccion.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    @Override
    public void crearGrafico()
    {
        // no disponible aún
    }
    
    @Override
    public int calcularFase()
    {
        return 0;
    }
    
    @Override
    public double calcularPresupuestoGastadoMensual()
    {
        return 0;
    }
    public void informe()
    {
        informes.crearInforme("");
        informes.crearGrafico();
        informes.calcularFase();
        informes.calcularPresupuestoGastadoMensual();
    }
        

    private void llenarArrayFases() {
        this.fasesConstruccion.add("Cierre del área de espacio público") ;
        this.fasesConstruccion.add("Terreno y cimentación") ;
        this.fasesConstruccion.add("Estructura de la construcción") ;
        this.fasesConstruccion.add("Instalaciones de la construcción") ;
        this.fasesConstruccion.add("Aislamiento e impermeabilización") ;
        this.fasesConstruccion.add("Acabados y cierres") ;

    }

}

