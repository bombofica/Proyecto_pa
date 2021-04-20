/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;
import java.util.*;

/**
 *
 * @author Ceseo
 */
public class RegistroObras {
    private HashMap <String, Obra> registro ;
    private ArrayList<Obra> listaCompleta;
    int contadorObras ;

    public RegistroObras(HashMap<String,Obra> registro,ArrayList<Obra> listaCompleta, int contadorObras)
    {
        this.registro = registro ;
        this.listaCompleta = listaCompleta ;
        this.contadorObras = contadorObras ;
    }
    public RegistroObras(){
        this.registro = new HashMap();
        this.listaCompleta = new ArrayList() ;
        this.contadorObras=0;
    }
    public void mostrarObras(){
        Obra current;
        int i;
        for(i =0; i < listaCompleta.size();i++){
            current=listaCompleta.get(i);
            System.out.println(current.getNombreObra());
            //current.mostrarEmpleados();
        }
    }
    
    public Obra retornarObra(int index){
        return listaCompleta.get(index);
    }
    
    public Obra retornarObra(String nombre)
    {
        Obra obraRetorno ;
        obraRetorno = registro.get(nombre);
        return obraRetorno ;
    }
    
    public void agregarObra(Obra obra1){
        this.registro.put(obra1.getNombreObra(), obra1);
        this.listaCompleta.add(obra1);
        this.contadorObras++;
    }
    
    public void eliminarObra(String nombreObra){
        Obra valor = registro.get(nombreObra);
        if(valor == null){
            System.out.println("Inválido");
            return;
        }
        
        registro.remove(nombreObra);
        
        
        Obra current = null;
        int i;
        for(i =0; i < listaCompleta.size();i++){
            current=this.listaCompleta.get(i);
            
            if(nombreObra.equals(current.getNombreObra())){
                this.listaCompleta.remove(i);
                break;
            }
            
            
            System.out.println(current.getNombreObra());
            //current.mostrarEmpleados();
        }
        this.contadorObras--;
        
    }
    
}
