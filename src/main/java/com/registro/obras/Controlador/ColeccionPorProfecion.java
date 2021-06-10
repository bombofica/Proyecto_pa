/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registro.obras.Controlador;

import com.registro.obras.Modelo.Trabajador;
import java.util.TreeMap;

/**
 *
 * @author Ceseo
 */
public class ColeccionPorProfecion {
    
    private String profecion ;
    private TreeMap<String, Trabajador> listadoEmpleados ;
    
    public ColeccionPorProfecion(String profecion)
    {
        this.profecion = profecion;
        this.listadoEmpleados = new TreeMap();
    }
    
    
}
