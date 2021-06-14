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

    private TreeMap<String, Obra> coleccionRegional;
    private String nombreRegion;

    public ColeccionRegionalObra(String nombreRegion) {
        this.nombreRegion = nombreRegion;
        this.coleccionRegional = new TreeMap();
    }

    public String getNombreRegion() {
        return nombreRegion;
    }

    public void setNombreRegion(String nombreRegion) {
        this.nombreRegion = nombreRegion;
    }

    /*Agrega una Obra a la coleccion*/
    public boolean agregarObra(Obra obra) {
        if (obra != null) {
            if (!coleccionRegional.containsKey(obra.getNombreObra())) {
                this.coleccionRegional.put(obra.getNombreObra(), obra);
                return true;
            } else {
                System.out.println("La obra ya ha sido ingresada");//aweonao
            }
        }

        return false;
    }

    /*Permite retornar la instancia de clase Obra pedida por el usuario*/
    public Obra obtenerObra(String nombreObra) {
        if (coleccionRegional.containsKey(nombreObra)) {
            return this.coleccionRegional.get(nombreObra);
        }
        return null;
    }
    /*Elimina una instancia de clase Obra de la coleccionRegional*/
    public void eliminarObra(Obra obra) {
        this.coleccionRegional.remove(obra.getNombreObra());
    }
    /*Los siguientes métodos llenan los combobox de la interfaz grafica  */
    public void llenarComboBoxObra(JComboBox comboBoxObra) {
        Obra current;
        for (Map.Entry me : this.coleccionRegional.entrySet()) {

            current = (Obra) me.getValue();
            comboBoxObra.addItem(current);
        }
    }

    public void llenarComboBoxObrasInterfaz(JComboBox comboBox) {
        Obra current;
        for (Map.Entry me : this.coleccionRegional.entrySet()) {
            current = (Obra) me.getValue();

            if ((current.getCodigo() == 1) || (current.getCodigo() == 2)) {
                comboBox.addItem((ProyectoReportable) current);
            }
        }
    }

    
    /*Retorna un Array de objetos de tipo Obra, la existencia de esta funcion permite una mayor facilidad
    de acceso a los objetos tipo Obra a la hora de escribirlos en un archivo de texto*/
    public Obra[] retornarArray() {
        Obra[] obrasRegionales = new Obra[this.coleccionRegional.size()];
        int index = 0;

        Obra current;

        for (Map.Entry me : this.coleccionRegional.entrySet()) {
            current = (Obra) me.getValue();
            obrasRegionales[index] = current;
            index++;
        }

        return obrasRegionales;
    }

}
