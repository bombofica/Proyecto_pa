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
    private int codigo;
    private ListadoEmpleadosObra listadoEmpleados;
    
    //Constructor
    public Obra(String nombreObra, String nombreLugar, int codigo) {
        this.nombreObra = nombreObra;
        this.nombreLugar = nombreLugar;
        this.listadoEmpleados = new ListadoEmpleadosObra() ;
    }
    
    //Metodos
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {    
        this.codigo = codigo;
    }

    public void setNumeroEmpleados(int valor) {
        this.listadoEmpleados.setNumeroEmpleados(valor) ;
    }
    
    public void setNumeroEmpleados(double valor){
        this.listadoEmpleados.setNumeroEmpleados(valor) ;
    }
    
    public void setNumeroEmpleados(float valor){
        this.listadoEmpleados.setNumeroEmpleados(valor) ;
    }
    
    public int getNumeroEmpleados(){
        return this.listadoEmpleados.getNumeroEmpleados() ;
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
        this.listadoEmpleados.getListadoPersonas(listaEmpleados) ;
    }    
    
    public Trabajador buscarPersona(int rut) {
        return this.listadoEmpleados.buscarPersona(rut) ;
    }
    
    public void despedirEmpleadoObra(int rut) {
        this.listadoEmpleados.despedirEmpleadoObra(rut) ;
    }

    public void agregarPersona(Trabajador serHumano) {
        this.listadoEmpleados.agregarPersona(serHumano) ;
    }
    
    public void eliminarObra(){ //crear un getEmpleados y mover los metodos a registroObras
        this.listadoEmpleados.eliminarObra() ;
    }
    
    public Trabajador devolverPersonaI(int index){
        return this.listadoEmpleados.devolverPersonaI(index) ;
    }

    public long getSumaSueldos()
    {
        return this.listadoEmpleados.getSumaSueldos() ;
    }
    
    public abstract long gastosObra();
    
    public void cambiarNombre()
    {
        this.listadoEmpleados.cambiarNombre(nombreObra) ;
    }
    
// Estos metodos sirven para utilizar la interfaz gráfica
    
    public void llenarComboBoxEmpleados(JComboBox<Persona> comboBox){
        
        this.listadoEmpleados.llenarComboBoxEmpleados(comboBox) ;
    }
    
    public void llenarJTextAreaEmpleados(JTextArea jTextArea, int valor){
        
        this.listadoEmpleados.llenarJTextAreaEmpleados(jTextArea, valor) ; 
    }
    
     public void llenarJTextAreaEmpleados(JTextArea jTextArea){
         this.listadoEmpleados.llenarJTextAreaEmpleados(jTextArea) ;      
     }
    
    @Override
    public String toString() {
        return this.nombreObra;
    }
    
    

}
