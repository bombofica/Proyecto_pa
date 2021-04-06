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
    }
    public void mostrarObras(){
        Obra current;
        int i;
        for(i =0,current=listaCompleta.get(i) ; i < listaCompleta.size(); i++,current=listaCompleta.get(i)){
            System.out.println(current.getNombreObra());
        }
    }
    public Obra retornarObra(String nombre)
    {
        return null;
    }
    
}
