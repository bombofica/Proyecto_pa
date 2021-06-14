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
    
    // agrega una ColeccionRegionalObra segun sea la región
    public void agregarColeccionRegional(String nombre){
        coleccionNacional.put(nombre,new ColeccionRegionalObra(nombre));
    }
    /*Esta funcion se utiliza para obtener una instancia de ColeccionRegionalObra para que sea mas facil retornar
    una instancia de la clase Obra*/
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
    /* Elimina una Obra del registro a traves de una instancia de clase de ColeccionRegionalObra*/
    public void eliminarObra(Obra obra){
        
        if(obra != null && coleccionNacional.containsKey(obra.getNombreLugar())){
            this.coleccionNacional.get(obra.getNombreLugar()).eliminarObra(obra);
        }
    }
    /*Retorna un Array de objetos de tipo ColeccionRegionalObra, la existencia de esta funcion permite una mayor facilidad
    de acceso a los objetos tipo Obra a la hora de escribirlos en un archivo de texto*/
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
