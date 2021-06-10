package com.registro.obras.Controlador;

import com.registro.obras.Modelo.Persona;
import com.registro.obras.Modelo.Obra;
import com.registro.obras.Modelo.Trabajador;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JComboBox;
import javax.swing.JTextArea;


public class RegistroTrabajadores {

    private ArrayList<Trabajador> arrayEmpleados; 
    private String[] especializaciones;
    private HashMap<String, TreeMap<Integer,Trabajador>> registroEspecializaciones;
    
    public RegistroTrabajadores() {
        
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

        TreeMap<Integer,Trabajador> especialistas = this.registroEspecializaciones.get(especialidad);
        if(especialistas == null){
            System.out.println("No existe Tal Especialidad");
            return;
        }
        
        
        for(Map.Entry<Integer,Trabajador> entry : especialistas.entrySet()){
            //Integer llave = entry.getKey();
            Trabajador current = entry.getValue();
            
            
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
    
        public void llenarJTextAreaEmpleados(JTextArea jTextArea, boolean bandera){
        
        jTextArea.setText("");
        if(this.arrayEmpleados.size() > 0){
            for(int i = 0 ; i< this.arrayEmpleados.size() ; i++)
            {
                Trabajador current= this.arrayEmpleados.get(i);
                if(bandera){
                    
                    jTextArea.append(current.descripcion());
                }
                else
                {
                    if(!current.isTrabajando())
                        jTextArea.append(current.descripcion());
                }
            
            }
        } 
            
    }
    

    
    public boolean agregarEspecialista(Trabajador trabajador){
            
        if (this.registroEspecializaciones.get(trabajador.getLaborProfesional()) == null){
            //System.out.println("Esa especialidad no existe");  
            return false;  
        }
        
        if(this.registroEspecializaciones.get(trabajador.getLaborProfesional()).containsKey(trabajador.getRut())){
            //System.out.println("El usuario ya se encuentra");
            return false;
        }
        
        (this.registroEspecializaciones.get(trabajador.getLaborProfesional())).put(trabajador.getRut(), trabajador);
        this.arrayEmpleados.add(trabajador);
        
        return true;
        //System.out.println("Esa especialidad si existe");
         
    }
    
    /*public boolean eliminarEspecialista(String especialidad, int rut, Obra currentObra){
        TreeMap<Integer,Trabajador> mapaEspecialidades = this.registroEspecializaciones.get(especialidad);
        Persona empleado = mapaEspecialidades.get(rut);
        
        mapaEspecialidades.remove(rut);
        
        if(currentObra != null){
            currentObra.despedirEmpleado(rut);
        }
        /*if(mapaEspecialidades == null){
            System.out.println("No existe esa especialización");
            return false;
        }
        /*if(empleado == null){
            System.out.println("El empleado No existe");
            return false;
        }
        return true;
    }
    
    public boolean eliminarEspecialista(Trabajador especialista, Obra currentObra){
        
        String especialidad = especialista.getLaborProfesional();
        int rut = especialista.getRut();
        
        TreeMap<Integer,Trabajador> mapaEspecialidades = this.registroEspecializaciones.get(especialidad);
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
        
        for (int i = 0; i < this.arrayEmpleados.size(); i++){
            if(arrayEmpleados.get(i).getRut() == empleado.getRut()){
                arrayEmpleados.remove(i);
            }
        }
        
        return true;
    }*/
    
    public boolean modificarEspecialistaNombre(Trabajador especialista, String nombre){
        
        String especialidad = especialista.getLaborProfesional();
        int rut = especialista.getRut();
        
        TreeMap<Integer,Trabajador> mapaEspecialidades = this.registroEspecializaciones.get(especialidad);
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

    public boolean modificarEspecialistaLaborProfesional(Trabajador especialista, String especialidadNueva){
        
        String especialidad = especialista.getLaborProfesional();
        int rut = especialista.getRut();
        
        TreeMap<Integer,Trabajador> mapaEspecialidades = this.registroEspecializaciones.get(especialidad);
        if(mapaEspecialidades == null){
            System.out.println("No existe esa especialización");
            return false;
        }
        
        Trabajador empleado = mapaEspecialidades.get(rut);
        
        if(empleado == null){
            System.out.println("El empleado No existe");
            return false;
        }
        
//        this.eliminarEspecialista(especialista,null);
        
        empleado.setLaborProfesional(especialidadNueva);
        
        this.agregarEspecialista(empleado);
        System.out.println("Especialidad del empleado editada con exito");
        
        return true;
    }

    public boolean modificarEspecialistaSueldo(Trabajador especialista, int sueldo){
        
        String especialidad = especialista.getLaborProfesional();
        int rut = especialista.getRut();
        
        TreeMap<Integer,Trabajador> mapaEspecialidades = this.registroEspecializaciones.get(especialidad);
        if(mapaEspecialidades == null){
            System.out.println("No existe esa especialización");
            return false;
        }
        
        Trabajador empleado = mapaEspecialidades.get(rut);
        
        if(empleado == null){
            System.out.println("El empleado No existe");
            return false;
        }
        
        empleado.setSueldo(sueldo);
        System.out.println("Sueldo del empleado editado con exito");        
              
        return true;
    }

    public boolean modificarEspecialistaEstadoDeTrabajo(Trabajador especialista, boolean estado){
        
        String especialidad = especialista.getLaborProfesional();
        int rut = especialista.getRut();
        
        TreeMap<Integer,Trabajador> mapaEspecialidades = this.registroEspecializaciones.get(especialidad);
        if(mapaEspecialidades == null){
            System.out.println("No existe esa especialización");
            return false;
        }
        
        Trabajador empleado = mapaEspecialidades.get(rut);
        
        if(empleado == null){
            System.out.println("El empleado No existe");
            return false;
        }
        
        empleado.setTrabajando(estado);
        
        return true;
    }
    
    
    public Trabajador buscarEspecialista(String especialidad, int rut){
        
        if (this.registroEspecializaciones.get(especialidad) == null){
            
            System.out.println("Esa especialidad no existe");
            return null;
            
        }
        Trabajador valor = (this.registroEspecializaciones.get(especialidad)).get(rut);
        if(valor == null){
            System.out.println("No existe tal persona");
            return null;
        }
        System.out.println(valor.getNombre());
        return valor;
    }
    
    public void mostrarPersona(String especialidad){
        TreeMap<Integer,Trabajador> especialistas = this.registroEspecializaciones.get(especialidad);
        if(especialistas == null){
            System.out.println("No existe Tal Especialidad");
            return;
        }
        
        
        for(Map.Entry<Integer,Trabajador> entry : especialistas.entrySet()){
            //Integer llave = entry.getKey();
            Trabajador current = entry.getValue();
            System.out.println("Nombre: "+current.getNombre());
            System.out.println("Profesión: "+current.getLaborProfesional());
            System.out.println("Rut: "+current.getRut());
            System.out.println("Saldo: "+current.getSueldo());
            System.out.println("Obra: "+current.getObraALaQuePertenece());
        }
    }
    
    public void mostrarPersona(int rut, String profesion)
    {
        TreeMap<Integer,Trabajador> especialistas = this.registroEspecializaciones.get(profesion);
        if(especialistas == null){
            System.out.println("No existe Tal Especialidad");
            return;
        }
        Trabajador current = especialistas.get(rut);
        if(current != null){
            System.out.println("Nombre: "+current.getNombre());
            System.out.println("Profesión: "+current.getLaborProfesional());
            System.out.println("Rut: "+current.getRut());
            System.out.println("Saldo: "+current.getSueldo());
        }

    }
    public Trabajador devolverPersona(int index){
        return this.arrayEmpleados.get(index);
    }
    
    public int numeroDeTrabajadores(){
        return this.arrayEmpleados.size();
    }
      
    public void llenarComboBoxDePersonas(JComboBox comboBox, boolean estado){
        
        comboBox.removeAllItems();
        for(int i = 0 ; i< this.arrayEmpleados.size() ; i++)
        {
            
            Persona current=this.arrayEmpleados.get(i);
            if((estado == false && !((Trabajador) current).isTrabajando())){
                comboBox.addItem(current);
            }
            else
                if(estado == true){
                    comboBox.addItem(current);
            }
        
        }   
        
    }
    
    public void despedirEmpleadoRegistro(Obra obraActual, Trabajador empleadoActual)
    {
        obraActual.despedirEmpleadoObra(empleadoActual.getRut());
        
        TreeMap<Integer, Trabajador> mapaEspecializaciones = new TreeMap() ;
        mapaEspecializaciones = this.registroEspecializaciones.get(empleadoActual.getLaborProfesional()) ;
        mapaEspecializaciones.get(empleadoActual.getRut()).setTrabajando(false);
        
        for(int i = 0 ; i < this.arrayEmpleados.size() ; i++)
        {
            if(empleadoActual.getRut() == this.arrayEmpleados.get(i).getRut())
            {
                this.arrayEmpleados.get(i).setTrabajando(false);
                break ;
            }
        }
    }

    public void eliminarEmpleado(Obra obraActual, Trabajador empleadoActual)
    {  
        
        obraActual.despedirEmpleadoObra(empleadoActual.getRut());
        
        this.registroEspecializaciones.get(empleadoActual.getLaborProfesional()).remove(empleadoActual.getRut()) ;
        for(int i = 0 ; i < this.arrayEmpleados.size() ; i++)
        {
            if(empleadoActual.getRut() == this.arrayEmpleados.get(i).getRut())
            {
                this.arrayEmpleados.remove(i) ;
                break ;
            }
        }
    }
    
    public Trabajador[] filtrarPersonas(Obra obraActual, int opcion, long parametro) {
        ArrayList<Trabajador> listadoEmpleadosPorParametro = new ArrayList() ;
        Trabajador[] listaEmpleadosObra = new Trabajador[obraActual.getNumeroEmpleados()] ;
        obraActual.getListadoPersonas(listaEmpleadosObra) ;
        int i ;
        if(opcion == 0) //menor que
        {
            for(i = 0; i < listaEmpleadosObra.length ; i++)
            {
                if(listaEmpleadosObra[i].getSueldo() < parametro)
                {
                    listadoEmpleadosPorParametro.add(listaEmpleadosObra[i]) ;
                }
            }
            Trabajador[] EmpleadosFiltrados = new Trabajador[listadoEmpleadosPorParametro.size()] ;
            
            for(i = 0 ; i < listadoEmpleadosPorParametro.size() ; i++)
            {
                EmpleadosFiltrados[i] = listadoEmpleadosPorParametro.get(i) ;
            }
            return EmpleadosFiltrados ;
        }
        if(opcion == 1)//mayor que
        {
            for(i = 0; i < listaEmpleadosObra.length ; i++)
            {
                if(listaEmpleadosObra[i].getSueldo() > parametro)
                {
                    listadoEmpleadosPorParametro.add(listaEmpleadosObra[i]) ;
                }
            }
            Trabajador[] EmpleadosFiltrados = new Trabajador[listadoEmpleadosPorParametro.size()] ;
            
            for(i = 0 ; i < listadoEmpleadosPorParametro.size() ; i++)
            {
                EmpleadosFiltrados[i] = listadoEmpleadosPorParametro.get(i) ;
            }
            return EmpleadosFiltrados ;
        }
        return null ;
    }
    
    public Trabajador filtrarPersonas(Obra obraSeleccionada, int opcion)
    {
        int i ;
        Trabajador[] listaEmpleados = new Trabajador[obraSeleccionada.getNumeroEmpleados()] ;
        obraSeleccionada.getListadoPersonas(listaEmpleados);
        Trabajador empleadoSeleccionado = listaEmpleados[0] ;
        
        if(opcion == 2) //maximo
        {
            for(i = 1; i < listaEmpleados.length ; i++)
            {
                if(empleadoSeleccionado.getSueldo() < listaEmpleados[i].getSueldo())
                {
                    empleadoSeleccionado = listaEmpleados[i] ;
                }
            }
            return empleadoSeleccionado ;
        }
        if(opcion == 3) //minimo
        {
            for(i = 1; i < listaEmpleados.length ; i++)
            {
                if(empleadoSeleccionado.getSueldo() > listaEmpleados[i].getSueldo())
                {
                    empleadoSeleccionado = listaEmpleados[i] ;
                }
            }
            return empleadoSeleccionado ;
        }
        
        return null ;
    }
    /*public void cambiarNombre(Obra obraActual)
    {
        int i;
        Trabajador[] listaEmpleados = new Trabajador[obraActual.getNumeroEmpleados()];
        obraActual.getListadoPersonas(listaEmpleados);
        for(i = 0 ; i < listaEmpleados.length ; i++)
        {
            listaEmpleados[i].setObraALaQuePertenece(obraActual.getNombreObra());
            obraActual.setListadoPersonas(listaEmpleados);

        }
        
    }*/
}
