/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registro.obras.Controlador;

import java.util.ArrayList;

/**
 *asd bvc asd
 * @author Benjamín
 */
public class ListaRegionesNombre {
    private ArrayList<String> listadoRegiones;

    public ListaRegionesNombre() {
        this.listadoRegiones = new ArrayList();
    }
    
    public void agregarNombre(String nombre){
        this.listadoRegiones.add(nombre);
    }
    
    public String retornarRegioni(int i){
        return this.listadoRegiones.get(i);
    }
    
    public long size(){       
        return this.listadoRegiones.size();
    }
    
    public boolean contains (String nuevoDato){
        return this.listadoRegiones.contains(nuevoDato);
    }
    
}
