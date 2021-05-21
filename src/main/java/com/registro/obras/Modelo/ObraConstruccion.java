package com.registro.obras.Modelo;

import com.registro.obras.Controlador.PoderInforme;

public class ObraConstruccion extends Obra implements PoderInforme{
    
    long presupuesto ;
    String tiempoRestante ;
    int fase ;
    public PoderInforme informes;
    //Constructor
    public ObraConstruccion(String nombreObra, String nombreRegion,String tiempoAsignado,long presupuesto)
    {
        super(nombreObra, nombreRegion, 1) ;
        this.presupuesto = presupuesto ;
        this.tiempoRestante = tiempoAsignado ;
        this.fase = 0;
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
    public void informe()
    {
        informes.crearInforme();
        informes.crearGrafico();
        informes.calcularFase();
        informes.calcularPresupuestoGastadoMensual();
        
    }
    /*double calcularPresupuestoGastadoMensual();
    int calcularFase();
    void crearGrafico();*/
    
}

