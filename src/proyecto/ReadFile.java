package proyecto;

import java.util.HashMap;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {
    
    /*El método "leerArchivo" solo lee e imprime por pantalla el contenido de un archivo de texto */

    public static void leerArchivo(String direccion) {
        try {
            FileReader entrada = new FileReader(direccion);
            int c = 5;
            while (c != -1) {
                c = entrada.read();
                char caracter = (char) c;
                System.out.print(caracter);
            }
            entrada.close();
        } catch (IOException e) {
            System.out.println("El fichero no existe");
        }
    }
    
    /* El método "tomarContenidosPersonas" lee el archivo que corresponde a los empleados de una Obra o de la lista con 
       con todos los empleados(RegistroTrabajadores.txt) con todos sus datos respectivos.
       El formato(txt separado por comas) en el que se encuentran las obras es el siguiente:
       NombrePersona,Labor,Sueldo,Rut,Estado(Trabajando o no),
    */

    public static Object[] tomarContenidosPersonas(char separador, int num, String direccion, RegistroTrabajadores registroTrabajadores) {
        String[] valores = new String[num];// para almacenar los datos que se encuentran en una linea
        Persona current;
        int cont = 0;
        
        Object[] contenedorDatos = new Object[3];
        
        //ArrayList<Persona> lista = new ArrayList();
        HashMap<String, Persona> hashPersonaNombre = new HashMap();
        HashMap<Integer, Persona> hashPersonaRut = new HashMap();
        
        try {
            FileReader entrada = new FileReader(direccion);
            int c;
            do {
                c = entrada.read();
                char caracter = (char) c;
                
                //En este if se verifica si el caracter es un salto de linea o se ha terminado el archivo
                if ((caracter == separador)) {
                    cont++;
                } else {
                    if (caracter != '\n' && c != -1) {
                        if (cont < num && valores[cont] == null) {
                            valores[cont] = String.valueOf(caracter);
                        } else {
                            if (cont < num)
                                valores[cont] += caracter;
                        }
                    }
                }
                
                /*
                    En el caso de que el caracter sea un salto de linea o sea el indicador de que el archivo ha terminado,
                    Se crea una persona que será agregada a las variables "hashPersonaNombre", "hashPersonaRut" y "lista"
                */
                if ((caracter == '\n' || c == -1)) {
                    current = new Persona(valores[0], valores[1], Integer.parseInt(valores[2]),Integer.parseInt(valores[3]), Boolean.parseBoolean(valores[4]));
                    
                    
                    if(registroTrabajadores.agregarEspecialista(current)){
                        System.out.println("Se agregó exitosamente el empleado");
                    }
                    else
                    {
                        System.out.println("El usuario No ha sido ingresado");
                    }
                    /*
                    System.out.println(current.getNombre());
                    System.out.println(current.getLaborProfesional());
                    System.out.println(current.getRut());
                    System.out.println(current.getSueldo());*/
                    //lista.add(current);
                    hashPersonaNombre.put(current.getNombre(), current);
                    hashPersonaRut.put(current.getRut(), current);
                    valores = new String[num];
                    cont = 0;
                }
            } while (c != -1);
            
            entrada.close();
        } catch (IOException e) {
            System.out.println("El fichero no existe");
        }
        
        
        contenedorDatos[0] = hashPersonaNombre;
        contenedorDatos[1] = hashPersonaRut;
        
        return contenedorDatos;
    }
    
    
    /* El método "traerObras" lee el archivo "RegistroObras.txt" que contiene las obras y sus datos.
       El formato(txt separado por comas) en el que se encuentran las obras es el siguiente:
       NombreObra,NombreLugar,Presupuesto,TiempoParaTerminarObra,
       Luego de leer y guardar los datos básicos de las obras, se procede a integrar a los empleados
       cada lista de empleados de una obra se encuentra en una carpeta con el nombre de la Obra correspondiente
       Y esta carpeta posee un archivo de texto de nombre "Empleados.txt"

    */
    public static void traerObras (char separador, int num, String direccion,RegistroTrabajadores registroTrabajadores, RegistroObras registroObras){
        
        /* Se crean las variables correspondientes*/

        String[] valores = new String[num]; // para almacenar los datos que se encuentran en una linea
        //RegistroObras todasLasObras = new RegistroObras(); // para almacenar las obras // No sirve
        
        Object[] contenedorDatos; //contendrá variables de tipo HashMap<String, Persona> y HashMap<Integer, Persona>
        
        HashMap<String, Persona> hashPersonaNombre;// HashMap que se asociará con "tablaPersonasNombre" de la obra respectiva
        HashMap<Integer, Persona> hashPersonaRut; // HashMap que se asociará con "tablaPersonasRut" de la obra respectiva
        
        Obra currentObra;
        int cont = 0;
        
        try{
            FileReader entrada = new FileReader(direccion+"//RegistroObras.txt");
            int c;
            do {
                
                c = entrada.read();
                char caracter = (char) c;
                
                // En este if se verifica que el caracter que se está leyendo del archivo sea util
                if ((caracter == separador)) {
                    cont++;
                } else {
                    if (caracter != '\n' && c != -1) {
                        if (cont < num && valores[cont] == null) {
                            valores[cont] = String.valueOf(caracter);
                        } else {
                            if (cont < num)
                                valores[cont] += caracter;
                        }
                    }
                }
                
                /* Si el caracter es un salto de linea, se guardan los datos de la obra que se encontraban en la linea
                   y con el método "ReadFile.tomarContenidosPersonas" se toma el archivo de los empleados de la obra
                   y se insertan en contenedorDatos para luego integrar los empleados en la Obra.
                
                */
                if (caracter == '\n' || c == -1) {
 
                    
                    System.out.println(valores[1]);                         // nombre_lugar(2)
                    contenedorDatos = ReadFile.tomarContenidosPersonas(',',5,"RegistroObras//"+valores[1]+"//"
                            +valores[0]+"//Empleados.txt",registroTrabajadores);
                             // nombre_Obra(1)
                    
                    
                    hashPersonaNombre = (HashMap<String,Persona>)contenedorDatos[0];
                    hashPersonaRut = (HashMap<Integer,Persona>)contenedorDatos[1];
                    
                    currentObra = new Obra(valores[0], valores[1], Double.parseDouble(valores[2]), valores[3],hashPersonaNombre,hashPersonaRut);
                    
                    registroObras.agregarObra(currentObra);//*************** benja ****************
                                        
                    valores = new String[num];
                    cont = 0;
                }            
                

            } while (c != -1);
            
            entrada.close();
        } catch (IOException e) {
            System.out.println("El fichero no existe2");
        }

        
    }
    
    public static void crearDirectorio(String[] regiones){
        
        int i ;
        for(i = 0; i<regiones.length;i++){
            WriteFile.addExistenciaDirectorioRegion(regiones[i]);
        }
    }

}
