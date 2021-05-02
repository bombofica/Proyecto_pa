package proyecto;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JComboBox;
import javax.swing.JTextArea;


public class RegistroTrabajadores {

    
    //private ArrayList<Persona> registroEmpleados;
    //private HashMap<String, Persona> registroPersonasNombre;
    private ArrayList<Persona> arrayEmpleados; 
    private String[] especializaciones;
    private HashMap<String, TreeMap<Integer,Persona>> registroEspecializaciones; 
    
  /*  public RegistroTrabajadores(ArrayList<Persona> lista, HashMap<String, Persona> registroPersonasNombre) {
        this.registroPersonasNombre = registroPersonasNombre;
        this.registroEmpleados = lista;
    }*/

    public RegistroTrabajadores() {
       /* this.registroEmpleados = new ArrayList();
        this.registroPersonasNombre = new HashMap();*/
       
        this.arrayEmpleados = new ArrayList();
        
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
    
    //Aquí se hacen funciones para agregar información a las ventanas(combobox, jtext, etc...) 
    public void llenarComboBoxEspecialidad(JComboBox<String> comboBox){
        comboBox.removeAllItems();
        for(int i=0 ; i<=9; i++){
            
            comboBox.addItem(this.especializaciones[i]);
        } 
    }
    public void llenarJTextAreaEspecialidad(JTextArea jTextArea, String especialidad, int valor){

        TreeMap<Integer,Persona> especialistas = this.registroEspecializaciones.get(especialidad);
        if(especialistas == null){
            System.out.println("No existe Tal Especialidad");
            return;
        }
        
        
        for(Map.Entry<Integer,Persona> entry : especialistas.entrySet()){
            //Integer llave = entry.getKey();
            Persona current = entry.getValue();
            
            
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
            
            
            /*System.out.println("Nombre: "+current.getNombre());
            System.out.println("Profesión: "+current.getLaborProfesional());
            System.out.println("Rut: "+current.getRut());
            System.out.println("Saldo: "+current.getSueldo());*/
        }
    }
    
    
    public boolean agregarEspecialista(Persona trabajador){
            
        if (this.registroEspecializaciones.get(trabajador.getLaborProfesional()) == null){
            System.out.println("Esa especialidad no existe");  
            return false;  
        }
        
        if(this.registroEspecializaciones.get(trabajador.getLaborProfesional()).containsKey(trabajador.getRut())){
            System.out.println("El usuario ya se encuentra");
            return false;
        }
        
        (this.registroEspecializaciones.get(trabajador.getLaborProfesional())).put(trabajador.getRut(), trabajador);
        this.arrayEmpleados.add(trabajador);
        
        return true;
        //System.out.println("Esa especialidad si existe");
         
    }
    
    public boolean eliminarEspecialista(String especialidad, int rut, Obra currentObra){
        TreeMap<Integer,Persona> mapaEspecialidades = this.registroEspecializaciones.get(especialidad);
        if(mapaEspecialidades == null){
            System.out.println("No existe esa especialización");
            return false;
        }
        
        Persona empleado = mapaEspecialidades.get(rut);
        
        if(empleado == null){
            System.out.println("El empleado No existe");
            return false;
        }
        
        mapaEspecialidades.remove(rut);
        if(currentObra != null){
            currentObra.despedirEmpleado(rut);
        }
        
        
        return true;
    }
    
    public boolean eliminarEspecialista(Persona especialista, Obra currentObra){
        
        String especialidad = especialista.getLaborProfesional();
        int rut = especialista.getRut();
        
        TreeMap<Integer,Persona> mapaEspecialidades = this.registroEspecializaciones.get(especialidad);
        if(mapaEspecialidades == null){
            System.out.println("No existe esa especialización");
            return false;
        }
        
        Persona empleado = mapaEspecialidades.get(rut);
        
        if(empleado == null){
            System.out.println("El empleado No existe");
            return false;
        }

        mapaEspecialidades.remove(rut);
        if(currentObra != null){
            currentObra.despedirEmpleado(rut);
        }
        
        return true;
    }
    
    public boolean modificarEspecialistaNombre(Persona especialista, String nombre){
        
        String especialidad = especialista.getLaborProfesional();
        int rut = especialista.getRut();
        
        TreeMap<Integer,Persona> mapaEspecialidades = this.registroEspecializaciones.get(especialidad);
        if(mapaEspecialidades == null){
            System.out.println("No existe esa especialización");
            return false;
        }
        
        Persona empleado = mapaEspecialidades.get(rut);
        
        if(empleado == null){
            System.out.println("El empleado No existe");
            return false;
        }
       
        empleado.setNombre(nombre);
        System.out.println("Nombre del empleado editado con exito");
        
        return true;
    }

    public boolean modificarEspecialistaLaborProfesional(Persona especialista, String especialidadNueva){
        
        String especialidad = especialista.getLaborProfesional();
        int rut = especialista.getRut();
        
        TreeMap<Integer,Persona> mapaEspecialidades = this.registroEspecializaciones.get(especialidad);
        if(mapaEspecialidades == null){
            System.out.println("No existe esa especialización");
            return false;
        }
        
        Persona empleado = mapaEspecialidades.get(rut);
        
        if(empleado == null){
            System.out.println("El empleado No existe");
            return false;
        }
        
        this.eliminarEspecialista(especialista,null);
        
        empleado.setLaborProfesional(especialidadNueva);
        
        this.agregarEspecialista(empleado);
        System.out.println("Especialidad del empleado editada con exito");
        
        return true;
    }

    public boolean modificarEspecialistaSueldo(Persona especialista, int sueldo){
        
        String especialidad = especialista.getLaborProfesional();
        int rut = especialista.getRut();
        
        TreeMap<Integer,Persona> mapaEspecialidades = this.registroEspecializaciones.get(especialidad);
        if(mapaEspecialidades == null){
            System.out.println("No existe esa especialización");
            return false;
        }
        
        Persona empleado = mapaEspecialidades.get(rut);
        
        if(empleado == null){
            System.out.println("El empleado No existe");
            return false;
        }
        
        empleado.setSueldo(sueldo);
        System.out.println("Sueldo del empleado editado con exito");        
              
        return true;
    }

    public boolean modificarEspecialistaEstadoDeTrabajo(Persona especialista, boolean estado){
        
        String especialidad = especialista.getLaborProfesional();
        int rut = especialista.getRut();
        
        TreeMap<Integer,Persona> mapaEspecialidades = this.registroEspecializaciones.get(especialidad);
        if(mapaEspecialidades == null){
            System.out.println("No existe esa especialización");
            return false;
        }
        
        Persona empleado = mapaEspecialidades.get(rut);
        
        if(empleado == null){
            System.out.println("El empleado No existe");
            return false;
        }
        
        empleado.setTrabajando(estado);
        
        return true;
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
    
    public void mostrarPersona(int rut, String profesion)
    {
        TreeMap<Integer,Persona> especialistas = this.registroEspecializaciones.get(profesion);
        if(especialistas == null){
            System.out.println("No existe Tal Especialidad");
            return;
        }
        Persona current = especialistas.get(rut);
        if(current != null){
            System.out.println("Nombre: "+current.getNombre());
            System.out.println("Profesión: "+current.getLaborProfesional());
            System.out.println("Rut: "+current.getRut());
            System.out.println("Saldo: "+current.getSueldo());
        }

    }
    
    
    public void llenarComboBoxDePersonas(JComboBox comboBox){
        
        comboBox.removeAllItems();
        for(int i = 0 ; i< this.arrayEmpleados.size() ; i++)
        {
            Persona current=this.arrayEmpleados.get(i);
            comboBox.addItem(current);
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
