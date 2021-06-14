package com.registro.obras.Modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

//import java.util.Iterator;


public abstract class Obra {
    
    //Variables de instancia
    private String nombreObra;
    
    private String nombreLugar;
    
    private int numeroEmpleados;
    
    private int codigo;

    //private HashMap<String, Trabajador> tablaPersonasNombre;

    private HashMap<Integer, Trabajador> tablaPersonasRut;
    
    private ArrayList<Trabajador> listadoPersonas;
    

    
    
    //Constructor

    public Obra(String nombreObra, String nombreLugar, int codigo) {
        this.codigo = codigo ;
        this.nombreObra = nombreObra;
        this.nombreLugar = nombreLugar;
        this.tablaPersonasRut = new HashMap();
        this.numeroEmpleados = 0;
        this.listadoPersonas = new ArrayList();
    }
    
    //Metodos
    public int getCodigo(){
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNumeroEmpleados(int valor) {
        this.numeroEmpleados = valor;
    }
    
    public void setNumeroEmpleados(double valor){
        this.numeroEmpleados =(int) valor;
    }
    
    public void setNumeroEmpleados(float valor){
        this.numeroEmpleados = (int) valor;
    }
    
    public int getNumeroEmpleados(){
        return this.numeroEmpleados;
    }
    
    
    public String getNombreObra() {
        return nombreObra;
    }

    public void setNombreObra(String nombreObra) {
        this.nombreObra = nombreObra;
    }

    public String getNombreLugar() {
        return nombreLugar;
    }

    public void setNombreLugar(String nombreLugar) {
        this.nombreLugar = nombreLugar;
    }
    
    public void getListadoPersonas(Trabajador[] listaEmpleados)
    {
        for(int i = 0; i < listadoPersonas.size(); i++)
        {
            listaEmpleados[i] = listadoPersonas.get(i) ;
        }
    }    
    
    public Trabajador buscarPersona(int rut) {
        Trabajador Empleado = tablaPersonasRut.get(rut);
        return Empleado;
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
    
    private void eliminarDelListado(int rut){
        
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

    public void agregarPersona(Trabajador serHumano) {
        tablaPersonasRut.put(serHumano.getRut(), serHumano);
        this.listadoPersonas.add(serHumano);
        this.numeroEmpleados++;
        serHumano.setTrabajando(true);
    }
    
    public void eliminarObra(){ //crear un getEmpleados y mover los metodos a registroObras
        for (int i = 0; i < this.listadoPersonas.size(); i++) {
            listadoPersonas.get(i).setTrabajando(false);
        }
    }
    
    public Trabajador devolverPersonaI(int index){
        return this.listadoPersonas.get(index);
    }

    public long getSumaSueldos()
    {
        long sumaSueldos = 0;
        Trabajador personaActual ;
        
        for (int i = 0; i < this.listadoPersonas.size(); i++){
            personaActual = this.listadoPersonas.get(i);
            sumaSueldos += personaActual.getSueldo() ;
        }
        return sumaSueldos ;
    }
    public abstract long gastosObra();
    
    public void cambiarNombre()
    {
        int i;
        Trabajador personaActual;
        for(i = 0 ; i < listadoPersonas.size() ; i++)
        {
            personaActual = listadoPersonas.get(i) ;
            personaActual.setObraALaQuePertenece(nombreObra);
        }
    }
    
// Estos metodos sirven para utilizar la interfaz gráfica
    
    public void llenarComboBoxEmpleados(JComboBox<Persona> comboBox){
        
        comboBox.removeAllItems();
        
        if(this.listadoPersonas.size() > 0){
            for(int i = 0 ; i< this.listadoPersonas.size() ; i++)
            {
                Persona current= this.listadoPersonas.get(i);
                comboBox.addItem(current);
                //comboBox.add
            }
        }
    }
    
    public void llenarJTextAreaEmpleados(JTextArea jTextArea, int valor){
        
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
    
     public void llenarJTextAreaEmpleados(JTextArea jTextArea){
         jTextArea.setText("");
        if(this.listadoPersonas.size() > 0){
            for(int i = 0 ; i< this.listadoPersonas.size() ; i++)
            {
                Trabajador current= this.listadoPersonas.get(i);
                jTextArea.append(current.descripcion());
            }
        }         
     }
    
    @Override
    public String toString() {
        return this.nombreObra;
    }
    
    

}
