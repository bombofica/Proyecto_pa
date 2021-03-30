package proyecto;



/**
 * Programación Avanzada ICI3241-1
 * @author Benjamín Rojas
 * @author Andrés Vidal
 */

import java.util.HashMap;

public class Obra {
    
    private String nombreObra;
    private String nombreLugar;
    private double presupuestoObra;
    private double tiempoParaTerminarObra;
    private HashMap<String,Persona> tablaPersonasNombre;
    private HashMap<Integer,Persona> tablaPersonasRut;
    
    
    public Obra(){}
   
    public Obra(String nombreObra, String nombreLugar, int presupuestoObra, double tiempoNecesarioParaTerminarObra) {
        this.nombreObra = nombreObra;
        this.nombreLugar = nombreLugar;
        this.presupuestoObra = presupuestoObra;
        this.tiempoParaTerminarObra = tiempoNecesarioParaTerminarObra;
        this.tablaPersonasNombre = new HashMap();
        this.tablaPersonasRut = new HashMap();

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

    public double getTiempoParaTerminarObra() {
        return tiempoParaTerminarObra;
    }

    public void setTiempoParaTerminarObra(double tiempoParaTerminarObra) {
        this.tiempoParaTerminarObra = tiempoParaTerminarObra;
    }

    public void setTiempoParaTerminarObra(int tiempoParaTerminarObra) {
        this.tiempoParaTerminarObra = tiempoParaTerminarObra;
    }
    
    public void cambiarPresupuesto(double presupuestoObra){
        this.presupuestoObra = presupuestoObra;
    }
    
    public Persona buscarPersona(int rut){
        Persona valor = tablaPersonasRut.get(rut);
        return valor;
    }
    
    public Persona buscarPersona(String nombre){
        Persona valor = tablaPersonasNombre.get(nombre);
        return valor;
    }
    
    public void agregarPersona(Persona serHumano){
        tablaPersonasRut.put(serHumano.getRut(), serHumano);
        tablaPersonasNombre.put(serHumano.getNombre(), serHumano);

    }
    
    public void despedirEmpleado(int rut){
        Persona personaEliminada = tablaPersonasRut.get(rut);
        System.out.println("se a despedido a"+personaEliminada.getNombre()) ;
        tablaPersonasRut.remove(rut);
        tablaPersonasNombre.remove(personaEliminada.getNombre()) ;
    }
    
    public void despedirEmpleado(String nombre){
        Persona personaEliminada = tablaPersonasNombre.get(nombre);
        System.out.println("se a despedido a"+nombre) ;
        tablaPersonasNombre.remove(nombre);
        tablaPersonasRut.remove(personaEliminada.getRut());
    }
    
        
       

    
}
