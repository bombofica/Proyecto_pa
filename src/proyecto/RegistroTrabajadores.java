/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;
import java.util.ArrayList;


/**
 *
 * @author Benjamín
 */
public class RegistroTrabajadores {
    
    private ArrayList<Persona> registroEmpleados;
    
    public void RegistroTrabajadores(){
                
        this.registroEmpleados = new ArrayList();
        
    }
    
   /* public void RegistroTrabajadores(ArrayList lista){
                
        this.registroEmpleados = lista;
        
    }*/
    
    public void setRegistroEmpleados(ArrayList lista){
        this.registroEmpleados = lista;
    }
    
    public void mostrarPersona(boolean persona){
        System.out.println("El/Los Nombre/s son:");
        for (Persona actual : registroEmpleados) {
            if(actual.isTrabajando() == persona){
                System.out.println(actual.getNombre());
            }
        }
        
    }
            
    public void mostrarPersona(int sueldo){
        System.out.println("El/Los Nombre/s son:");
        for (Persona actual : registroEmpleados) {
            if(sueldo == actual.getSueldo()){
                System.out.println(actual.getNombre());
            }
        }        
    }
    
    public void mostrarPersona(String profesion){
        System.out.println("El/Los Nombre/s son:");
        for (Persona actual : registroEmpleados) {
            if(actual.getLaborProfesional().equals(profesion)){
                System.out.println(actual.getNombre());
            }
        }        
    }

    
    
    
}
