package proyecto;

import java.io.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;

public class main {

    public static void main(String args[]) throws IOException {
        /*
        Scanner lector= new Scanner(System.in);
        
        String valor="528";
        int variable= lector.nextInt();
        System.out.println(variable);*/
        
        
        Obra obraAmiga = new Obra("Obra Maestra", "Santiago", 500, 2);
        Persona personaje1 = new Persona("Alberto", "Ingeniero", 3000, 3000, true);
        Persona personaje2 = new Persona("Pepegrillo", "Doctor", 5000, 4000, false);
        Persona personaje3 = new Persona("Huesillo", "Pintor", 6000, 9000, true);
        obraAmiga.agregarPersona(personaje1);
        obraAmiga.agregarPersona(personaje2);
        obraAmiga.agregarPersona(personaje3);
        Persona personaTest = obraAmiga.buscarPersona(personaje2.getNombre());
        System.out.println(personaTest.getNombre());
        Object[] cocodrilo = ReadFile.tomarContenidos(',', 5);
        HashMap<String, Persona> mapa1 = (HashMap) cocodrilo[0];
        HashMap<Integer, Persona> mapa2 = (HashMap) cocodrilo[1];
        ArrayList<Persona> lista = (ArrayList<Persona>) cocodrilo[2];
        RegistroTrabajadores registro = new RegistroTrabajadores(lista);
        registro.mostrarPersona("Informático");
        Persona nuevoPersonaje = mapa1.get("Matias Sosorio");
        System.out.println(nuevoPersonaje.getNombre());
        
        
       /* Persona x[] = new Persona[5] ;
        x[0] = new Persona("Patricio","ingeniero Civil",300000,20481905) ;
        
        x[1] = new Persona("Lukas","topografo",100000,300) ;
        
        String nombre = "Alfredo" ;
        String profesion = "prevencionista de riesgos" ;
        int sueldo = 200000;
        int rut = 800 ;
        x[2] = new Persona(nombre, profesion, sueldo, rut);
        
        nombre = "Samanta" ;
        profesion = "ingeniero en construccion" ;
        sueldo = 700000;
        rut = 900 ;
        x[3] = new Persona(nombre, profesion, sueldo, rut);
        
        BufferedReader sop = new BufferedReader(new InputStreamReader(System.in)) ;
        x[4] = new Persona() ;
        System.out.println("ingrese nombre:") ;
        x[4].setNombre(sop.readLine()) ;
        System.out.println("ingrese profecion:") ;
        x[4].setLaborProfesional(sop.readLine()) ; 
        System.out.println("ingrese sueldo:") ;
        x[4].setSueldo(Integer.parseInt(sop.readLine()));
        System.out.println("ingrese rut:") ;
        x[4].setRut(Integer.parseInt(sop.readLine()));
        //x[4] = new Persona(nombre, profesion, maquinaria, sueldo, rut);
        
        for (Persona x1 : x) {
            System.out.println(x1.getNombre());
            System.out.println(x1.getLaborProfesional());
            System.out.println(x1.getSueldo());
            System.out.println(x1.getRut());
    }*/

}
}
