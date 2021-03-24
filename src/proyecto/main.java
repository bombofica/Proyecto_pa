

package proyecto;
public class main{
    public static void main(String args[])
    {
        int i = 10 ;
        Persona x[] = new Persona[5] ;
        x[0] = new Persona("Patricio","ingeniero Civil","ninguno",300000,20481905) ;
        
        x[1] = new Persona("Lukas","topografo","ninguno",100000,300) ;
        
        String nombre = "Alfredo" ;
        String profecion = "prevencionista de riesgos" ;
        String maquinaria = "ninguno" ;
        int sueldo = 200000;
        int rut = 800 ;
        x[2] = new Persona(nombre, profecion, maquinaria, sueldo, rut);
        
        nombre = "Samanta" ;
        profecion = "ingeniero en construccion" ;
        maquinaria = "ninguno" ;
        sueldo = 700000;
        rut = 900 ;
        x[3] = new Persona(nombre, profecion, maquinaria, sueldo, rut);
        
        x[4] = new Persona("Lukas","topografo","ninguno",100000,300) ;
        String prueba = x[0].getNombre() ;
        System.out.println(prueba) ;
    }   
}


