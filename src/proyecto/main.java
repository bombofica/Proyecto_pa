
/**
 * Programación Avanzada ICI3241-1
 * @author Benjamín Rojas
 * @author Andrés Vidal
 */


package proyecto;
import java.io.* ;
import java.util.HashMap;
import java.util.ArrayList;


public class main{
    public static void main(String args[]) throws IOException
    {
        
        Obra obraAmiga = new Obra("Japeninconja","Santiago",500,2);
        
        Persona personaje1 = new Persona("Alberto","Ingeniero",3000,3000,true);
        Persona personaje2 = new Persona("Pepegrillo","Doctor",5000,4000,false);
        Persona personaje3 = new Persona("Huesillo","Pintor",6000,9000,true);
        
        obraAmiga.agregarPersona(personaje1);
        obraAmiga.agregarPersona(personaje2);
        obraAmiga.agregarPersona(personaje3);
        
        Persona chucheta = obraAmiga.buscarPersona(personaje2.getNombre());
        System.out.println(chucheta.getNombre());
        
        Object[] cocodrilo = ReadFile.tomarContenidos(',', 5);
        
        HashMap<String,Persona> mapa1 =(HashMap) cocodrilo[0] ;//(ReadFile.tomarContenidos(',', 4))[0];
        HashMap<Integer,Persona> mapa2 = (HashMap) cocodrilo[1];//((HashMap[])ReadFile.tomarContenidos(',', 4))[1];
        ArrayList<Persona> lista = (ArrayList<Persona>) cocodrilo[2];
        
        RegistroTrabajadores registro = new RegistroTrabajadores(lista);//= new  RegistroTrabajadores();
        
        
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
        }
        
        String[] nombresObra = {"newñuñoa","newmaipú","newvalparaiso","new puente alto","newsantiago"};
        String[] nombre_lugar = {"ñuñoa","maipú","valparaiso","puente alto","santiago"};
        int[] presupuesto = {1000000,100000,100000,100,10000};
        double[] tiempo = {1.5,1.6,1.8,1.9,1.9};
        
        ListaEnlazada lista = new ListaEnlazada();
        
        for (int b = 0 ; b < 5;b++ ){
            
            Obra nuevaObra = new Obra(nombresObra[b],nombre_lugar[b],presupuesto[b],tiempo[b]);
            lista.addList(nuevaObra);
            
            //System.out.println("Nombre Obra: "+nombresObra[b]+"Nombre Lugar: "+nombre_lugar[b]+"Presupuesto: "+presupuesto[b]+"tiempo: "+tiempo[b]);
        }
        
        int contado = 0;
        for (Nodo current = lista.cabeza ; current != null; current = current.getNext()){
            System.out.println("Obra: "+contado);
            System.out.println("Nombre Obra: "+((Obra) current.getCurrent()).getNombreObra());
            System.out.println("Nombre Lugar: "+((Obra) current.getCurrent()).getNombreLugar());
            System.out.println("Presupuesto: "+((Obra) current.getCurrent()).getPresupuestoObra());
            System.out.println("Tiempo: "+((Obra) current.getCurrent()).getTiempoParaTerminarObra());
            contado++;
            
        }
        
        //ReadFile.leerArchivo("nada");
        ListaEnlazada listica = ReadFile.tomarContenidos(',', 4);
        for(Nodo nodito=listica.cabeza; nodito != null; nodito = nodito.getNext()){
            for(int index = 0; index <4 ; index ++){
                System.out.print(((String[]) nodito.getCurrent())[index]+" ");
            }
            System.out.println("");
        }*/
        
        //WriteFile.escribirFichero(5);
        
    }   
}


