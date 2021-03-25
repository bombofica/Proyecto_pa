/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

/**
 *
 * @author Benjamín
 */
public class Nodo {
    private final Object current;
    private Nodo next;
    
    public Nodo(Object current){
        this.current = current;
        this.next=null;
    }
    
    public Object getCurrent(){
        return this.current;
    }
    
    public Nodo getNext(){
        return this.next;
    }
    
    public void setNext(Nodo next){
        this.next = next;
    }
    
}
