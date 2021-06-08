/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registro.obras.Controlador;

import com.registro.obras.Modelo.*;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JComboBox;

/**
 *
 * @author Benjamín
 */
public class ColeccionRegionalObra {

    public String getNombreRegion() {
        return nombreRegion;
    }

    public void setNombreRegion(String nombreRegion) {
        this.nombreRegion = nombreRegion;
    }
    
    public ColeccionRegionalObra(String nombreRegion){
        this.nombreRegion = nombreRegion;
        this.coleccionRegional = new TreeMap();
    }
    
    private TreeMap<String,Obra> coleccionRegional ;
    private String nombreRegion;
    
    
    public boolean agregarObra(Obra obra){
        if(obra != null){
            this.coleccionRegional.put(obra.getNombreObra(), obra);
            return true;
        }
        return false;
    }
    
    public Obra obtenerObra(String nombreObra){
        if(coleccionRegional.containsKey(nombreObra)){    
            return this.coleccionRegional.get(nombreObra);
        }
        
        return null;
    
    }
    
    public void eliminarObra(Obra obra){
        this.coleccionRegional.remove(obra.getNombreObra());
    }
    
    public void llenarComboBoxObra(JComboBox comboBoxObra){
        Obra current ;
        for(Map.Entry me : this.coleccionRegional.entrySet())
        {
            
            current = (Obra)me.getValue();
            comboBoxObra.addItem(current);
        }
    }
    
    
    public void llenarComboBoxObrasInterfaz(JComboBox comboBox){
        Obra current ;
        for(Map.Entry me : this.coleccionRegional.entrySet())
        {       
            current = (Obra)me.getValue();
            
            if( (current.getCodigo() == 1) || (current.getCodigo() == 2))
                comboBox.addItem((ProyectoReportable)current);
        }        
    }
    
    public Obra[] retornarArray(){
        Obra[] obrasRegionales = new Obra[this.coleccionRegional.size()];
        int index = 0;

        Obra current;
        
        for(Map.Entry me : this.coleccionRegional.entrySet())
        {       
            current = (Obra)me.getValue();
            obrasRegionales[index] = current;
            index++;
        }         
        
        
        return obrasRegionales;
    }
}
