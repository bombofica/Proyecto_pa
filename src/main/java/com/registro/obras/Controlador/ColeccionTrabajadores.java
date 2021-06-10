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
        coleccionTrabajdores = new HashMap() ; 
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
            
        }
    }
    
}
