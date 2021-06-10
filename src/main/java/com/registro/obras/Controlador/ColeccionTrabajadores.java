/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registro.obras.Controlador;

import com.registro.obras.Modelo.Trabajador;
import java.util.HashMap;

/**
 *
 * @author Ceseo
 */
public class ColeccionTrabajadores {
    
    private HashMap<String, ColeccionPorProfecion> coleccionTrabajdores;
    
    public ColeccionTrabajadores()
    {
        coleccionTrabajdores = new HashMap();
        
    }
    
    public void agregarColeccionPorProfesion(String nombreProfesion){
        coleccionTrabajdores.put(nombreProfesion, new ColeccionPorProfecion(nombreProfesion));
    }
    
    public ColeccionTrabajadores(String profecion)
    {
        coleccionTrabajdores.put(profecion, new ColeccionPorProfecion(profecion));
    }
    
    public ColeccionPorProfecion getFiltradoPorProfecion(String profecion)
    {
        if(coleccionTrabajdores.containsKey(profecion))
        {
            return coleccionTrabajdores.get(profecion) ;
        }
        return null ;
    }
    
    public void eliminarEmpleado(Trabajador empleado)
    {        
        if(empleado != null && coleccionTrabajdores.containsKey(empleado.getLaborProfesional()))
        {
            this.coleccionTrabajdores.get(empleado.getLaborProfesional()).eliminarEmpleado(empleado);
        }
    }

    public boolean agregarEspecialista(Trabajador empleado) {
        if(empleado != null)
        {
            this.coleccionTrabajdores.get(empleado.getLaborProfesional()).agregarEspecialista(empleado) ;
            return true ;
        }
        return false ;
    }
    
    public boolean existenciaEspecializacion(String especializacion)
    {
        if(this.coleccionTrabajdores.containsKey(especializacion)) return true ;
            
        return false ;
        
    }

    public boolean existenciaEmpleado(Trabajador especialista) 
    {
        if(!this.coleccionTrabajdores.get(especialista.getLaborProfesional()).existenciaEmpleado(especialista)) return false ;
        
        return true ;
    }
}
