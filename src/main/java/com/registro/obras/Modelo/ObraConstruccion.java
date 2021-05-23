package com.registro.obras.Modelo;

import com.registro.obras.Controlador.PoderInforme;
import java.util.ArrayList;

public class ObraConstruccion extends Obra implements PoderInforme{
    
    private long presupuesto ;
    private String tiempoRestante ;
    private int fase ;
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
    //@Override
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

    private void llenarArrayFases() {
        this.fasesConstruccion.add("Cierre del área de espacio público") ;
        this.fasesConstruccion.add("Terreno y cimentación") ;
        this.fasesConstruccion.add("Estructura de la construcción") ;
        this.fasesConstruccion.add("Instalaciones de la construcción") ;
        this.fasesConstruccion.add("Aislamiento e impermeabilización") ;
        this.fasesConstruccion.add("Acabados y cierres") ;
    }

}

