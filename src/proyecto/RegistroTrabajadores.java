package proyecto;

import java.util.HashMap;
import java.util.ArrayList;

public class RegistroTrabajadores {

    
    private ArrayList<Persona> registroEmpleados;
    private HashMap<String, Persona> registroPersonasNombre;
    
    public RegistroTrabajadores(ArrayList<Persona> lista, HashMap<String, Persona> registroPersonasNombre) {
        this.registroPersonasNombre = registroPersonasNombre;
        this.registroEmpleados = lista;
    }

    public RegistroTrabajadores() {
        this.registroEmpleados = new ArrayList();
        this.registroPersonasNombre = new HashMap();
    }

    public void setRegistroEmpleados(ArrayList<Persona> lista) {
        this.registroEmpleados = lista;
    }
    
    public void setRegistroPersonasNombre(HashMap<String, Persona> registroPersonasNombre){
        this.registroPersonasNombre=registroPersonasNombre;
    }

    public void mostrarPersona(boolean persona) {
        System.out.println("El/Los Nombre/s son:");
        for (Persona actual : registroEmpleados) {
            if (actual.isTrabajando() == persona) {
                System.out.println(actual.getNombre());
            }
        }
    }

    public void mostrarPersona(int sueldo) {
        System.out.println("El/Los Nombre/s son:");
        for (Persona actual : registroEmpleados) {
            if (sueldo == actual.getSueldo()) {
                System.out.println(actual.getNombre());
            }
        }
    }
    
    public void mostrarPersona()
    {
        //Persona actual;
        for(Persona actual : registroEmpleados)
        {
            System.out.println(actual.getNombre());
        }
    }
    public void mostrarPersona(String profesion) {
        System.out.println("El/Los Nombre/s son:");
        for (Persona actual : registroEmpleados) {
            if (actual.getLaborProfesional().equals(profesion)) {
                System.out.println(actual.getNombre());
            }
        }
    } 
    // funcion agregada
    public void agregarPersona(Persona persona){
        
        this.registroEmpleados.add(persona);
        this.registroPersonasNombre.put(persona.getNombre(), persona);
        
    }
    
    public Persona getPersona(int index){
        
        int i = 0;
        
        for (Persona actual : registroEmpleados) {
            if (i == index) {
                return actual;
            }
            i++;
        }                
        
        return null;
    }
    
    public int devolverNumeroPersonas (){
        return registroEmpleados.size();
    }
    
    public void cambiarEstadoPersona(String nombre, boolean booleano){
        
        Persona valor = this.registroPersonasNombre.get(nombre);
        if(valor != null){
            valor.setTrabajando(booleano);
        }
    }
    public void eliminarPersona(String nombre)
    {
        for(Persona actual : registroEmpleados)
        {
            if(actual.getNombre().equals(nombre))
            {
                registroEmpleados.remove(actual) ;
            }
        }
        registroPersonasNombre.remove(nombre);
    }
}
