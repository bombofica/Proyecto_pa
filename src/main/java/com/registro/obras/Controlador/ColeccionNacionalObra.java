package com.registro.obras.Controlador;


import com.registro.obras.Modelo.*;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author Benjamín
 */
public class ColeccionNacionalObra {
    
    private HashMap <String, ColeccionRegionalObra> coleccionNacional;
        
    public ColeccionNacionalObra(){
        coleccionNacional = new HashMap();
    }
    
    public void agregarColeccionRegional(String nombre){
        coleccionNacional.put(nombre,new ColeccionRegionalObra(nombre));
    }
    
    public ColeccionRegionalObra obtenerColeccionRegion(String nombreRegion){
        if(coleccionNacional.containsKey(nombreRegion)){
            return coleccionNacional.get(nombreRegion);
        }
        return null;
    }
    
    public boolean agregarObra(Obra obra){ // retorna true si la obra ha sido agregada correctamente, 
        //false si la obra ya se encuentra o si no se ha agregado
        
        if(obra != null && coleccionNacional.containsKey(obra.getNombreLugar()))
        {
            return this.coleccionNacional.get(obra.getNombreLugar()).agregarObra(obra);
        }
        
        return false;
     
    }
    
    public void eliminarObra(Obra obra){
        
        if(coleccionNacional.containsKey(obra.getNombreLugar())){
            this.coleccionNacional.get(obra.getNombreLugar()).eliminarObra(obra);
        }
    }
    
    public ColeccionRegionalObra[] retornarColeccionNacional(){
        ColeccionRegionalObra [] coleccion = new ColeccionRegionalObra[this.coleccionNacional.size()];

        int index = 0;

        ColeccionRegionalObra current;
        
        for(Map.Entry me : this.coleccionNacional.entrySet())
        {       
            current = (ColeccionRegionalObra)me.getValue();
            coleccion[index] = current;
            index++;
        }          
        
        return coleccion;
    }
    
    
}
