

package proyecto;
import java.io.* ;
public class main{
    public static void main(String args[]) throws IOException
    {
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
        
        BufferedReader sop = new BufferedReader(new InputStreamReader(System.in)) ;
        x[4] = new Persona() ;
        System.out.println("ingrese nombre:") ;
        x[4].setNombre(sop.readLine()) ;
        System.out.println("ingrese profecion:") ;
        x[4].setLaborProfecional(sop.readLine()) ; 
        System.out.println("ingrese uso de maquinaria:") ;
        x[4].setMaquinariaUtilizable(sop.readLine()) ;
        System.out.println("ingrese sueldo:") ;
        x[4].setSueldo(Integer.parseInt(sop.readLine()));
        System.out.println("ingrese rut:") ;
        x[4].setRut(Integer.parseInt(sop.readLine()));
        //x[4] = new Persona(nombre, profecion, maquinaria, sueldo, rut);
        
        for(int i = 0 ; i < x.length ; i++)
        {
            System.out.println(x[i].getNombre()) ;
            System.out.println(x[i].getLaborProfecional()) ;
            System.out.println(x[i].getMaquinariaUtilizable()) ;
            System.out.println(x[i].getSueldo()) ;
            System.out.println(x[i].getRut()) ;
        }
        //String prueba = x[0].getNombre() ;
        
    }   
}


