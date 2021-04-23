package proyecto;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;


public class RegistroTrabajadores {

    
    //private ArrayList<Persona> registroEmpleados;
    //private HashMap<String, Persona> registroPersonasNombre;
     
    private String[] especializaciones;
    private HashMap<String, TreeMap<Integer,Persona>> registroEspecializaciones; 
    
  /*  public RegistroTrabajadores(ArrayList<Persona> lista, HashMap<String, Persona> registroPersonasNombre) {
        this.registroPersonasNombre = registroPersonasNombre;
        this.registroEmpleados = lista;
    }*/

    public RegistroTrabajadores() {
       /* this.registroEmpleados = new ArrayList();
        this.registroPersonasNombre = new HashMap();*/
        
        this.registroEspecializaciones = new HashMap();
        
        this.especializaciones = new String[10];
        this.especializaciones[0]= new String("Ingeniero Civil");
        this.especializaciones[1]= new String("Arquitecto");
        this.especializaciones[2]= new String("Topografo");
        this.especializaciones[3]= new String("Ingeniero Ambiental");
        this.especializaciones[4]= new String("Prevencionista de Riesgos");
        this.especializaciones[5]= new String("Obrero");
        this.especializaciones[6]= new String("Ingeniero Constructor");
        this.especializaciones[7]= new String("Proyectista");
        this.especializaciones[8]= new String("Ingeniero Agrónomo");
        this.especializaciones[9]= new String("Informático");
        
        
        for(int i=0 ; i<=9; i++){
            
            this.registroEspecializaciones.put(this.especializaciones[i], new TreeMap());
        } 
    }
    
    public void agregarEspecialista(Persona trabajador){
            
        if (this.registroEspecializaciones.get(trabajador.getLaborProfesional()) == null){
            System.out.println("Esa especialidad no existe");
            return;
        
        }
        (this.registroEspecializaciones.get(trabajador.getLaborProfesional())).put(trabajador.getRut(), trabajador);
        //System.out.println("Esa especialidad si existe");
        
        
    }
    
    public void eliminarEspecialista(String especialidad, int rut){
        
    }
    
    public void eliminarEspecialista(Persona especialista){
        
    }
    
    
    
    public Persona buscarEspecialista(String especialidad, int rut){
        
        if (this.registroEspecializaciones.get(especialidad) == null){
            //System.out.println("Esa especialidad no existe");
        }
        Persona valor = (this.registroEspecializaciones.get(especialidad)).get(rut);
        if(valor == null){
            System.out.println("No existe tal persona");
            return null;
        }
        System.out.println(valor.getNombre());
        return valor;
    }
    
    public void mostrarEspecialistas(String especialidad){
        TreeMap<Integer,Persona> especialistas = this.registroEspecializaciones.get(especialidad);
        if(especialistas == null){
            System.out.println("No existe Tal Especialidad");
            return;
        }
        
        
        for(Map.Entry<Integer,Persona> entry : especialistas.entrySet()){
            //Integer llave = entry.getKey();
            Persona current = entry.getValue();
            System.out.println("Nombre: "+current.getNombre());
            System.out.println("Profesión: "+current.getLaborProfesional());
            System.out.println("Rut: "+current.getRut());
            System.out.println("Saldo: "+current.getSueldo());
        }
    }

/* 

    
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
    }*/
}
