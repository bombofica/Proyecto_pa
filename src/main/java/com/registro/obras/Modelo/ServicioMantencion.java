package com.registro.obras.Modelo;


public class ServicioMantencion extends Obra {
    
    long mantenimientoMonetarioAnual ;
    double InteresAnual ;
    boolean operativo ;
    

    public ServicioMantencion(String nombreObra, String nombreRegion, long mantenimientoMonetarioAnual, double InteresAnual, boolean operativo)

    {
        super(nombreObra, nombreRegion, 3) ;
        this.mantenimientoMonetarioAnual = mantenimientoMonetarioAnual;
        this.operativo = operativo ;
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

    public void setInteresAnual(double InteresAnual) {
        this.InteresAnual = InteresAnual;
    }

    public boolean isOperativo() {
        return operativo;
    }

    public void setOperativo(boolean operativo) {
        this.operativo = operativo;
    }
    
    @Override
    public long gastosObra()
    {
        double valorAgregado = this.mantenimientoMonetarioAnual * this.InteresAnual;
        long gastosTotales = mantenimientoMonetarioAnual + (long)valorAgregado;
        long sueldoEmpleados = 0;
        if(getNumeroEmpleados() != 0)
        {
            Trabajador[] listaEmpleados = new Trabajador[getNumeroEmpleados()] ;
            
            getListadoPersonas(listaEmpleados);
            for(int i = 0; i < listaEmpleados.length; i++)
            {
                sueldoEmpleados += (long)listaEmpleados[i].getSueldo() ;
            }
            gastosTotales = gastosTotales - sueldoEmpleados;
            return gastosTotales;
        }
        
        return gastosTotales;
        
    }
    
    
    
}

