/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registro.obras.Controlador;
import com.registro.obras.Modelo.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

/**
 *
 * @author Ceseo
 */
public class RegistroObras {
    
    
    private ColeccionObras coleccionObras;
    
    int contadorObras ;

    //constructores
    
    public RegistroObras(){
        this.coleccionObras = new ColeccionObras();
        this.contadorObras=0;
        
    }
    
    //metodos publicos
    public Obra retornarObra(int index){
        
        return this.coleccionObras.retornarObra(index);
    }
    
    public int retornarTipoObra(String nombreObra)
    {
        return this.coleccionObras.retornarTipoObra(nombreObra);
    }

    public Obra retornarObra(String nombreObra){                 
        return this.coleccionObras.retornarObra(nombreObra);            
    }
    
    public Obra retornarObra(String nombre, String nombreRegion)
    {
        return this.coleccionObras.retornarObra(nombre, nombreRegion);
    }
    
    
    public HashMap <String, TreeMap<String, Obra>> obtenerHashRegiones(){
        return this.coleccionObras.obtenerHashRegiones();
    }
    

    public void llenarComboBoxObras(JComboBox<Obra> comboBoxObra){
        this.coleccionObras.llenarComboBoxObras(comboBoxObra);
    }

    public void llenarComboBoxObrasInterfaz(JComboBox<ProyectoReportable> comboBoxObra){
        this.coleccionObras.llenarComboBoxObrasInterfaz(comboBoxObra);
    }
    
    public void llenarComboBoxObras(JComboBox<Obra> comboBoxObra, String region){
        
        this.coleccionObras.llenarComboBoxObras(comboBoxObra,region);
    }

    public void llenarComboBoxObrasInterfaz(JComboBox<ProyectoReportable> comboBoxObra, String region){
        
        this.coleccionObras.llenarComboBoxObrasInterfaz(comboBoxObra, region);
    }
    
    public void llenarComoBoxRegiones(JComboBox<String> comboBoxRegiones){
        
        this.coleccionObras.llenarComoBoxRegiones(comboBoxRegiones);
    }
    
    public void llenarComboBoxEmpleadosRegistro(JComboBox<Persona> comboBoxObra, String nombreObra){
                
        this.coleccionObras.llenarComboBoxEmpleadosRegistro(comboBoxObra, nombreObra, this.contadorObras);
    }
    
    public void llenarJTextAreaEmpleadosRegistro(JTextArea jTextArea, int valor, String nombreObra){
        this.coleccionObras.llenarJTextAreaEmpleadosRegistro(jTextArea, valor, nombreObra);
    }
    
    public long getGastosObra(Obra nombreObra)
    {
        long balance = nombreObra.gastosObra() ;
        return balance;
    }
    
    public boolean agregarObra(Obra obraAgregar){ //Listo
        
        if(this.coleccionObras.agregarObra(obraAgregar)){
            this.contadorObras++;
            return true;
        }
        return false;
    
    }
    
    public Obra[] filtrarObrasPresupuesto(long parametro, int opcion)
    {

        return this.coleccionObras.filtrarObrasPresupuesto(parametro, opcion);
    }
    
    public Obra filtrarObrasPresupuesto(int opcion)
    {
        return this.coleccionObras.filtrarObrasPresupuesto(opcion);
    }
            
    public int numeroObras(){
        return this.contadorObras;
    }
    
    public void eliminarObra(String nombreObra) throws IOException //Listo
    {
        //en el archivo se elimina la obra original y se vuelve a crear el registro sin esta
        int valor =this.coleccionObras.eliminarObra(nombreObra, this);
        if(-1 != valor ){
            this.contadorObras = valor;
        }
    }
                
    public void modificarObra(String nombreObra, String nuevoDato, int opcion, RegistroObras registroActual) throws IOException //Listo
    {
        this.coleccionObras.modificarObra(nombreObra, nuevoDato, opcion, registroActual);
        
    }
    
    
    public void presupuestoGeneral() //presupuesto total de la compañia
    {
        this.coleccionObras.presupuestoGeneral();
    }
    
    public long presupuestoGeneral(String nombreObra) //presupuesto particular de una obra
    {
        return this.coleccionObras.presupuestoGeneral(nombreObra);
    }
    
    public long gatosTotales()
    {
        return this.coleccionObras.gatosTotales();
    }
    
    public long ingresosTotales()
    {
        return this.coleccionObras.ingresosTotales();
    }

    
}
