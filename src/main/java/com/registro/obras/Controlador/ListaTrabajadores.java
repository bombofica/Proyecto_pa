
package com.registro.obras.Controlador;

import com.registro.obras.Modelo.Persona;
import com.registro.obras.Modelo.Trabajador;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTextArea;


public class ListaTrabajadores {
    private ArrayList<Trabajador> listaTrabajadores ;
    
    public ListaTrabajadores()
    {
        this.listaTrabajadores = new ArrayList() ;
    }
    
    public void agregarTrabajador(Trabajador trabajador){
        this.listaTrabajadores.add(trabajador) ;
    }
    
    public void modificarEmpleado(Trabajador empleado){
        //Se recorre al ArrayList en busca del empleado y modificarlo
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
        //Se recorre al ArrayList en busca del empleado y despedirlo
        for (int i = 0; i < this.listaTrabajadores.size(); i++) {
            if (empleadoActual.getRut() == this.listaTrabajadores.get(i).getRut()) {
                this.listaTrabajadores.get(i).setTrabajando(false);
                break;
            }
        }
    }
    void eliminarEmpleado(Trabajador empleadoActual) {
        //Se recorre al ArrayList en busca del empleado y eliminarlo
        for (int i = 0; i < this.listaTrabajadores.size(); i++) {
            if (empleadoActual.getRut() == this.listaTrabajadores.get(i).getRut()) {
                this.listaTrabajadores.remove(i);
                break;
            }
        } 
    }
    public void llenarJTextAreaEmpleados(JTextArea jTextArea, boolean bandera) {
        //Se verifica que existan trabajadores en la aplicacion
        if (this.listaTrabajadores.size() > 0) {
            jTextArea.setText("");
            //Se recorre el arreglo y se procede a escribir cada empleado
            for (int i = 0; i < this.listaTrabajadores.size(); i++) {
                Trabajador current = this.listaTrabajadores.get(i);
                if (bandera) {
                    //El empleado es parte de una obra
                    jTextArea.append(current.descripcion());
                } else {
                    //EL empleado no es parte de una obra
                    if (!current.isTrabajando()) {
                        jTextArea.append(current.descripcion());
                    }
                }
            }
        }
    }

    public void llenarComboBoxDePersonas(JComboBox comboBox, boolean estado){
        
        comboBox.removeAllItems();
        for (int i = 0; i < this.listaTrabajadores.size(); i++) {
            Persona current = this.listaTrabajadores.get(i);
            if ((estado == false && !((Trabajador) current).isTrabajando())){
                //EL empleado no es parte de una obra
                comboBox.addItem(current);
            } else if (estado == true) {
                //El empleado es parte de una obra
                comboBox.addItem(current);
            }

        }

    }

    

    

    
    
}
