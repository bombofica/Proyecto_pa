package proyecto;

import java.util.HashMap;
import java.util.Map;

//import java.util.Iterator;

public class Obra {

    private String nombreObra;

    private String nombreLugar;

    private double presupuestoObra;

    private String tiempoParaTerminarObra;

    private HashMap<String, Persona> tablaPersonasNombre;

    private HashMap<Integer, Persona> tablaPersonasRut;
    
    private int numeroEmpleados;
    
    int codigo;

    public Obra() {
    }

    public Obra(String nombreObra, String nombreLugar, double presupuestoObra, String tiempoNecesarioParaTerminarObra) {
        this.nombreObra = nombreObra;
        this.nombreLugar = nombreLugar;
        this.presupuestoObra = presupuestoObra;
        this.tiempoParaTerminarObra = tiempoNecesarioParaTerminarObra;
        this.tablaPersonasNombre = new HashMap();
        this.tablaPersonasRut = new HashMap();
        this.numeroEmpleados = tablaPersonasNombre.size();
    }

    public Obra(String nombreObra, String nombreLugar, double presupuestoObra, String tiempoNecesarioParaTerminarObra, HashMap<String, Persona> tablaPersonasNombre, HashMap<Integer, Persona> tablaPersonasRut) {
        
        //esta variable debe ser enviada por el metodo y no declararce en esta linea
        RegistroObras registro = new RegistroObras();
        
        this.nombreObra = nombreObra;
        this.nombreLugar = nombreLugar;
        this.presupuestoObra = presupuestoObra;
        this.tiempoParaTerminarObra = tiempoNecesarioParaTerminarObra;
        this.tablaPersonasNombre = tablaPersonasNombre;
        this.tablaPersonasRut = tablaPersonasRut;
        this.numeroEmpleados = tablaPersonasNombre.size();
        this.codigo = registro.numeroObras() +1 ;
    }
    
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

    public double getPresupuestoObra() {
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
    }

    public void despedirEmpleado(String nombre) {
        Persona sujeto = tablaPersonasNombre.get(nombre);
        tablaPersonasNombre.remove(nombre);
        tablaPersonasRut.remove(sujeto.getRut());
        this.numeroEmpleados= tablaPersonasNombre.size();
        sujeto.setTrabajando(false);
        System.out.println("El sujeto ha sido eliminado");
    }

    public void despedirEmpleado(int rut) {
        Persona sujeto = tablaPersonasRut.get(rut);
        tablaPersonasRut.remove(rut);
        tablaPersonasNombre.remove(sujeto.getNombre());
        this.numeroEmpleados= tablaPersonasNombre.size();
        sujeto.setTrabajando(false);
        System.out.println("El sujeto ha sido eliminado");
    }

    public void cambiarPresupuesto(double presupuestoObra) {
        this.presupuestoObra = presupuestoObra;
    }

    public Persona buscarPersona(int rut) {
        Persona valor = tablaPersonasRut.get(rut);
        return valor;
    }

    public Persona buscarPersona(String nombre) {
        Persona valor = tablaPersonasNombre.get(nombre);
        return valor;
    }

    public void agregarPersona(Persona serHumano) {
        tablaPersonasRut.put(serHumano.getRut(), serHumano);
        tablaPersonasNombre.put(serHumano.getNombre(), serHumano);
        this.numeroEmpleados= this.tablaPersonasNombre.size();
        serHumano.setTrabajando(true);
    }
    
    public void mostrarEmpleados()
    {
        
        for (Map.Entry me : tablaPersonasRut.entrySet()) {
              
          //System.out.println("Key: "+me.getKey() + " & Value: " + me.getValue());
            Persona current = (Persona) me.getValue();
            System.out.print("Nombre: " + current.getNombre());
            System.out.print(" Rut: " + current.getRut());
            System.out.print(" Sueldo: " + current.getSueldo());
            System.out.println(" Labor: " + current.getLaborProfesional());
        }
    }
    
/*    void eliminarObra(RegistroTrabajadores registroTrabajadores, RegistroObras registroObras){ // editar esto
        
        Persona current;
        
        for (Map.Entry persona : tablaPersonasNombre.entrySet()) {

          //System.out.println("Key: "+me.getKey() + " & Value: " + me.getValue());
            current = (Persona) persona.getValue();
            //registroTrabajadores.cambiarEstadoPersona(current.getNombre(), false);         
        }
        
        registroObras.eliminarObra(this.nombreObra);
        
    }*/
    
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
    
    public void eliminarEmpleado(String nombre)
    {
        Persona personaEliminar = tablaPersonasNombre.get(nombre) ;
        if(personaEliminar == null) return;
            
        tablaPersonasNombre.remove(nombre) ;
        tablaPersonasRut.remove(personaEliminar.getRut()) ;
           
    }
}
