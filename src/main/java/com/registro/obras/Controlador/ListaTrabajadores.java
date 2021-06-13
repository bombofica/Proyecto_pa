/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registro.obras.Controlador;

import com.registro.obras.Modelo.Persona;
import com.registro.obras.Modelo.Trabajador;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

/**
 *
 * @author Ceseo
 */
public class ListaTrabajadores {
    ArrayList<Trabajador> listaTrabajadores ;
    
    public ListaTrabajadores()
    {
        this.listaTrabajadores = new ArrayList() ;
    }
    
    public void agregarTrabajador(Trabajador trabajador){
        this.listaTrabajadores.add(trabajador) ;
    }
    
    public void modificarEmpleado(Trabajador empleado){
        
        for (int i = 0; i < this.listaTrabajadores.size(); i++) {
            if (empleado.getRut() == this.listaTrabajadores.get(i).getRut()) {
                this.listaTrabajadores.remove(i);
                this.listaTrabajadores.add(empleado);
                break;
            }
        }
    }
    
    public Trabajador retornarIndex(int index) {
        return this.listaTrabajadores.get(index) ;
    }

    int retornarNumeroTrabajadores() {
        return this.listaTrabajadores.size() ;
    }
    
    public void despedirEmpleado(Trabajador empleadoActual) {
        for (int i = 0; i < this.listaTrabajadores.size(); i++) {
            if (empleadoActual.getRut() == this.listaTrabajadores.get(i).getRut()) {
                this.listaTrabajadores.get(i).setTrabajando(false);
                break;
            }
        }
    }
    void eliminarEmpleado(Trabajador empleadoActual) {
        for (int i = 0; i < this.listaTrabajadores.size(); i++) {
            if (empleadoActual.getRut() == this.listaTrabajadores.get(i).getRut()) {
                this.listaTrabajadores.remove(i);
                break;
            }
        } 
    }
    public void llenarJTextAreaEmpleados(JTextArea jTextArea, boolean bandera) {
        
        if (this.listaTrabajadores.size() > 0) {
            jTextArea.setText("");
            for (int i = 0; i < this.listaTrabajadores.size(); i++) {
                Trabajador current = this.listaTrabajadores.get(i);
                if (bandera) {

                    jTextArea.append(current.descripcion());
                } else {
                    if (!current.isTrabajando()) {
                        jTextArea.append(current.descripcion());
                    }
                }
            }
        }
    }

    public void llenarComboBoxDePersonas(JComboBox comboBox, boolean estado) {
        
        comboBox.removeAllItems();
        for (int i = 0; i < this.listaTrabajadores.size(); i++) {

            Persona current = this.listaTrabajadores.get(i);
            if ((estado == false && !((Trabajador) current).isTrabajando())) {
                comboBox.addItem(current);
            } else if (estado == true) {
                comboBox.addItem(current);
            }

        }

    }

    

    

    
    
}