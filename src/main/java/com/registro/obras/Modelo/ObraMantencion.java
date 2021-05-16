package com.registro.obras.Modelo;

public class ObraMantencion extends Obra{
    
    long mantenimientoMonetarioAnual ;
    double InteresAnual ;
    boolean operativo ;


    public ObraMantencion(String nombreObra, String nombreRegion, long mantenimientoMonetarioAnual, double InteresAnual, boolean operativo)

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

