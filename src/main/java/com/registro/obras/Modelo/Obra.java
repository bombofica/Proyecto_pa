package com.registro.obras.Modelo;

import com.registro.obras.Modelo.Persona;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

//import java.util.Iterator;
//crear un getEmpleados y mover los metodos a registroObras
//crear un getEmpleados y mover los metodos a registroObras
//crear un getEmpleados y mover los metodos a registroObras
//crear un getEmpleados y mover los metodos a registroObras
//crear un getEmpleados y mover los metodos a registroObras

public abstract class Obra {
    
    //Variables de instancia
    private String nombreObra;
    
    private String nombreLugar;

    //private double presupuestoObra;

    //private String tiempoParaTerminarObra;

    private HashMap<String, Trabajador> tablaPersonasNombre;

    private HashMap<Integer, Trabajador> tablaPersonasRut;
    
    private ArrayList<Trabajador> listadoPersonas;
    
    private int numeroEmpleados;
    
    //Constructores
    public Obra() {
        this.tablaPersonasNombre = new HashMap();
        this.tablaPersonasRut = new HashMap();
        this.numeroEmpleados = tablaPersonasNombre.size();
        this.listadoPersonas = new ArrayList();
    }

    public Obra(String nombreObra, String nombreLugar, double presupuestoObra, String tiempoNecesarioParaTerminarObra) {
        this.nombreObra = nombreObra;
        this.nombreLugar = nombreLugar;
        //this.presupuestoObra = presupuestoObra;
        //this.tiempoParaTerminarObra = tiempoNecesarioParaTerminarObra;
        this.tablaPersonasNombre = new HashMap();
        this.tablaPersonasRut = new HashMap();
        this.numeroEmpleados = tablaPersonasNombre.size();
        this.listadoPersonas = new ArrayList();
    }
    
    //Metodos
    public void setNumeroEmpleados(int valor){
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

/*    public double getPresupuestoObra() {
        return presupuestoObra;
    }

    public void setPresupuestoObra(int presupuestoObra) {
        this.presupuestoObra = presupuestoObra;
    }

    public void setPresupuestoObra(double presupuestoObra) {
        this.presupuestoObra = (int) presupuestoObra;
    }

    public String getTiempoParaTerminarObra() {
        return tiempoParaTerminarObra;
    }

    public void setTiempoParaTerminarObra(String tiempoParaTerminarObra) {
        this.tiempoParaTerminarObra = tiempoParaTerminarObra;
    }*/

    public void despedirEmpleado(String nombre) {
        Trabajador sujeto = tablaPersonasNombre.get(nombre);
        if(sujeto != null){
            eliminarDelListado(sujeto.getRut());
            tablaPersonasNombre.remove(nombre);
            tablaPersonasRut.remove(sujeto.getRut());
            this.numeroEmpleados= tablaPersonasNombre.size();
            sujeto.setTrabajando(false);
            System.out.println("El sujeto ha sido eliminado");
        }
    }
    
    public void despedirEmpleado(int rut) {
        Trabajador sujeto = tablaPersonasRut.get(rut);
        
        if(sujeto != null){
            eliminarDelListado(rut);
            tablaPersonasRut.remove(rut);
            tablaPersonasNombre.remove(sujeto.getNombre());
            this.numeroEmpleados= tablaPersonasNombre.size();
            sujeto.setTrabajando(false);
            System.out.println("El sujeto ha sido eliminado");
        }
    }
    
    public void eliminarDelListado(int rut){
        Persona sujeto = tablaPersonasRut.get(rut);
        
        System.out.println(this.listadoPersonas.size());
        
        if(sujeto != null && this.listadoPersonas.size() > 0){
            for(int i = 0 ; i< this.listadoPersonas.size() ; i++)
            {
                if(sujeto.getRut() == this.listadoPersonas.get(i).getRut()){
                    this.listadoPersonas.remove(i);
                    break;
                }  
            }
        }
        System.out.println(this.listadoPersonas.size());
    }

    
/*
    public void cambiarPresupuesto(double presupuestoObra) {
        this.presupuestoObra = presupuestoObra;
    }*/

    public Persona buscarPersona(int rut) {
        Persona valor = tablaPersonasRut.get(rut);
        return valor;
    }

    public Persona buscarPersona(String nombre) {
        Persona valor = tablaPersonasNombre.get(nombre);
        return valor;
    }

    public void agregarPersona(Trabajador serHumano) {
        tablaPersonasRut.put(serHumano.getRut(), serHumano);
        tablaPersonasNombre.put(serHumano.getNombre(), serHumano);
        this.listadoPersonas.add(serHumano);
        this.numeroEmpleados= this.tablaPersonasNombre.size();
        serHumano.setTrabajando(true);
    }
    
    public void mostrarEmpleados()
    {
        for (Map.Entry me : tablaPersonasRut.entrySet()) {
            Trabajador current = (Trabajador) me.getValue();
            System.out.print("Nombre: " + current.getNombre());
            System.out.print(" Rut: " + current.getRut());
            System.out.print(" Sueldo: " + current.getSueldo());
            System.out.println(" Labor: " + current.getLaborProfesional());
        }
    }
    
    public void eliminarObra(){ //crear un getEmpleados y mover los metodos a registroObras
        
        Trabajador current ;
        for (Map.Entry persona : tablaPersonasNombre.entrySet()) {
            
            current = (Trabajador) persona.getValue();
            current.setTrabajando(false) ;
        }        
    }
    
    public Persona devolverPersonaI(int index){
        
        Persona current = null;
        int cont =0;
        
        for (Map.Entry persona : tablaPersonasNombre.entrySet()) {

          //System.out.println("Key: "+me.getKey() + " & Value: " + me.getValue());
            current = (Persona) persona.getValue();        
            if(cont == index) break;
            cont++;
        }
        return current;
    }

    public long retornarSueldos()
    {
        long sumaSueldos = 0;
        Trabajador personaActual ;
        
        for (Map.Entry me : this.tablaPersonasNombre.entrySet()) {
            personaActual = (Trabajador) me.getValue();
            //System.out.println(sumaSueldos);
            sumaSueldos += personaActual.getSueldo() ;
        }
        return sumaSueldos ;
    }
    
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
    
    public void llenarComboBoxEmpleados(JComboBox comboBox){
        
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
    
    @Override
    public String toString() {
        return this.nombreObra;
    }
    
    

}
