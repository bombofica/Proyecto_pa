package com.registro.obras.Modelo;

public class Persona {

    private String nombre;
    private int rut;


    public Persona() {
    }
    
    public Persona(String nombre, int rut) {
        this.nombre = nombre;
        this.rut = rut;
    }
     
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        int digitos = Integer.toString(rut).length();
        if(digitos > 9){
            System.out.println("No es un numero válido");
        }
        this.rut = rut;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
    
    
    
}
