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
    
    private HashMap<String, ColeccionPorProfesion> coleccionTrabajdores; //TreeMap que contiene todos los trabajadores con una profecion en particular
    
    public ColeccionTrabajadores()
    {
        coleccionTrabajdores = new HashMap();
        
    }
    
    public void agregarColeccionPorProfesion(String nombreProfesion){
        //Este metodo es llamado al comienzo para añadir cada una de las profeciones de los empleados
        coleccionTrabajdores.put(nombreProfesion, new ColeccionPorProfesion(nombreProfesion));
    }
    

    
    public ColeccionPorProfesion getFiltradoPorProfesion(String profecion)
    {
        //Se verifica que exista la profecion
        if(coleccionTrabajdores.containsKey(profecion))
        {
            return coleccionTrabajdores.get(profecion) ;
        }
        return null ;
    }
    
    public void eliminarEmpleado(Trabajador empleado)
    {        
        //Se verifica que exista la profecion y el empleado
        if(empleado != null && coleccionTrabajdores.containsKey(empleado.getLaborProfesional()))
        {
            this.coleccionTrabajdores.get(empleado.getLaborProfesional()).eliminarEmpleado(empleado);
        }
    }

    public boolean agregarEspecialista(Trabajador empleado) {
        //Se verifica que exista el empleado
        if(empleado != null)
        {
            this.coleccionTrabajdores.get(empleado.getLaborProfesional()).agregarEspecialista(empleado) ;
            return true ;
        }
        return false ;
    }
    
    public boolean existenciaEspecializacion(String especializacion)
    {
        //Se verifica que exista la profecion
        if(this.coleccionTrabajdores.containsKey(especializacion)) return true ;            
        return false ;
        
    }

    public boolean existenciaEmpleado(Trabajador especialista) 
    {
        //Se verifica que exista del empleado
        if(!this.coleccionTrabajdores.get(especialista.getLaborProfesional()).existenciaEmpleado(especialista)) return false ;        
        return true ;
    }
}

