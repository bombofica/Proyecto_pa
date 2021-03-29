/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

/**
 * Programación Avanzada ICI3241-1
 * @author Benjamín Rojas
 * @author Andrés Vidal
 */
public class ListaEnlazada {
    Nodo cabeza;
    int size;
    
    public ListaEnlazada(){
        this.cabeza = null;       
        this.size = 0;
    }
    
    public void addList(Object nuevo){
        
        if(this.cabeza == null){
            
            cabeza = new Nodo(nuevo);
        }
        else
        {
            Nodo temp = this.cabeza;
            Nodo nuevo2 = new Nodo(nuevo);
            nuevo2.setNext(temp);
            cabeza=nuevo2;
        }
        
        size++;
        
    }
    
    public Object getValue(int index){
        int cont = 0;
        Nodo temp = this.cabeza;
        while(cont < index){
            temp = temp.getNext();
            cont++;
        }
        return temp;
    }
    
    public int getSize(){
        return this.size;
    }
    
    public boolean estáVacio(){
        return (null == this.cabeza)?true:false;
    }
    
    public void delete(int index){
        
        if(index == 0){
            cabeza = cabeza.getNext();
        }
        else
        {
            int cont = 0;
            Nodo temp = cabeza;
            while(cont < index-1){
                temp = temp.getNext();
                cont++;
            }
            temp.setNext(temp.getNext().getNext());            
        }
        

    }
    
    public void deleteFirst(){
        cabeza = cabeza.getNext();
        size--;
    }
}
