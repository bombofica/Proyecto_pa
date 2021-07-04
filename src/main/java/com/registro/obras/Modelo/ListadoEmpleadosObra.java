/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registro.obras.Modelo;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

/**
 *
 * @author andre
 */
public class ListadoEmpleadosObra {
    private HashMap<Integer, Trabajador> tablaPersonasRut;    
    private ArrayList<Trabajador> listadoPersonas;
    private int numeroEmpleados ;
    
    public ListadoEmpleadosObra()
    {
        this.listadoPersonas = new ArrayList();
        this.tablaPersonasRut = new HashMap() ;
        this.numeroEmpleados = 0;
    }

    public void getListadoPersonas(Trabajador[] listaEmpleados) {
        for(int i = 0; i < listadoPersonas.size(); i++)
        {
            listaEmpleados[i] = listadoPersonas.get(i) ;
        } 
    }

    public void eliminarDelListado(int rut) {
        Persona sujeto = tablaPersonasRut.get(rut);
        if(sujeto != null && this.listadoPersonas.size() > 0){
            for(int i = 0 ; i< this.listadoPersonas.size() ; i++)
            {
                if(sujeto.getRut() == this.listadoPersonas.get(i).getRut()){
                    this.listadoPersonas.remove(i);
                    break;
                }  
            }
        }
    }

    public Trabajador buscarPersona(int rut) {
        Trabajador Empleado = tablaPersonasRut.get(rut);
        return Empleado ;
    }

    public void despedirEmpleadoObra(int rut) {
        
        Trabajador sujeto = tablaPersonasRut.get(rut);
        
        if(sujeto != null){
            eliminarDelListado(rut);
            tablaPersonasRut.remove(rut);
            this.numeroEmpleados--;
            sujeto.setTrabajando(false);
        }
    }

    public void agregarPersona(Trabajador serHumano) {
        tablaPersonasRut.put(serHumano.getRut(), serHumano);
        this.listadoPersonas.add(serHumano);
        this.numeroEmpleados++;
        serHumano.setTrabajando(true);
    }

    public void eliminarObra() {
        for (int i = 0; i < this.listadoPersonas.size(); i++) {
            listadoPersonas.get(i).setTrabajando(false);
        }
    }

    public Trabajador devolverPersonaI(int index) {
        return this.listadoPersonas.get(index);
    }

    public long getSumaSueldos() {
        long sumaSueldos = 0;
        Trabajador personaActual ;
        
        for (int i = 0; i < this.listadoPersonas.size(); i++){
            personaActual = this.listadoPersonas.get(i);
            sumaSueldos += personaActual.getSueldo() ;
        }
        return sumaSueldos ;
    }

    public void cambiarNombre(String nombreObra) {
        int i;
        Trabajador personaActual;
        for(i = 0 ; i < listadoPersonas.size() ; i++)
        {
            personaActual = listadoPersonas.get(i) ;
            personaActual.setObraALaQuePertenece(nombreObra);
        }
    }

    void llenarComboBoxEmpleados(JComboBox<Persona> comboBox) {
        comboBox.removeAllItems();
        
        if(this.listadoPersonas.size() > 0){
            for(int i = 0 ; i< this.listadoPersonas.size() ; i++)
            {
                Persona current= this.listadoPersonas.get(i);
                comboBox.addItem(current);
            }
        }
    }

    void llenarJTextAreaEmpleados(JTextArea jTextArea, int valor) {
        if(this.listadoPersonas.size() > 0){
            for(int i = 0 ; i< this.listadoPersonas.size() ; i++)
            {
                Trabajador current= this.listadoPersonas.get(i);
                
                switch(valor){
                    case 0:
                        jTextArea.append(current.getNombre()+'\n');
                        break;
                    case 1:
                        jTextArea.append(String.valueOf(current.getRut())+'\n');
                        break;
                    case 2:
                        jTextArea.append(String.valueOf(current.getSueldo())+'\n');
                        break;
                    case 3:
                        //System.out.println(current.isTrabajando());

                        if(current.isTrabajando()){
                            jTextArea.append("Trabajando"+'\n');
                        }
                        else
                        {
                            jTextArea.append("Desempleado"+'\n');
                        }

                        break;
                    default: 
                }
            }
        } 
    }

    void llenarJTextAreaEmpleados(JTextArea jTextArea) {
        
        jTextArea.setText("");
        if(this.listadoPersonas.size() > 0){
            for(int i = 0 ; i< this.listadoPersonas.size() ; i++)
            {
                Trabajador current= this.listadoPersonas.get(i);
                jTextArea.append(current.descripcion());
            }
        }
    }

    void setNumeroEmpleados(int valor) {
        this.numeroEmpleados = valor;
    }
    
    void setNumeroEmpleados(double valor) {
        this.numeroEmpleados = (int) valor;
    }
    
    void setNumeroEmpleados(float valor) {
        this.numeroEmpleados = (int) valor;
    }

    int getNumeroEmpleados() {
        return this.numeroEmpleados;
    }


}
