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
        } catch (IOException e) {
            System.out.println("El fichero no existe");
        }
    }
    
    /* El método "tomarContenidosPersonas" lee el archivo que corresponde a los empleados de una Obra o de la lista con 
       con todos los empleados(RegistroTrabajadores.txt) con todos sus datos respectivos.
       El formato(txt separado por comas) en el que se encuentran las obras es el siguiente:
       Nombre_Persona,Labor,Sueldo,Rut,Estado(Trabajando o no),
    */

    public static Object[] tomarContenidosPersonas(char separador, int num, String direccion){//, ArrayList<Persona> lista) {
        String[] valores = new String[num];// para almacenar los datos que se encuentran en una linea
        Persona current;
        int cont = 0;
        
        Object[] contenedorDatos = new Object[3];
        
        ArrayList<Persona> lista = new ArrayList();
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
                    lista.add(current);
                    hashPersonaNombre.put(current.getNombre(), current);
                    hashPersonaRut.put(current.getRut(), current);
                    valores = new String[num];
                    cont = 0;
                }
            } while (c != -1);
        } catch (IOException e) {
            System.out.println("El fichero no existe");
        }
        
        
        contenedorDatos[0] = hashPersonaNombre;
        contenedorDatos[1] = hashPersonaRut;
        contenedorDatos[2] = lista;
        return contenedorDatos;
    }
    
    
    /* El método "traerObras" lee el archivo "RegistroObras.txt" que contiene las obras y sus datos.
       El formato(txt separado por comas) en el que se encuentran las obras es el siguiente:
       Nombre_Obra,Nombre_Lugar,Presupuesto,Tiempo_para_terminar_la_obra,
       Luego de leer y guardar los datos básicos de las obras, se procede a integrar a los empleados
       cada lista de empleados de una obra se encuentra en una carpeta con el nombre de la Obra correspondiente
       Y esta carpeta posee un archivo de texto de nombre "Empleados.txt"

    */
    public static RegistroObras traerObras (char separador, int num, String direccion){
        
        /* Se crean las variables correspondientes*/

        String[] valores = new String[num]; // para almacenar los datos que se encuentran en una linea
        RegistroObras todasLasObras = new RegistroObras(); // para almacenar las obras
        Object[] contenedorDatos; //contendrá variables de tipo HashMap<String, Persona> y HashMap<Integer, Persona>
        
        HashMap<String, Persona> hashPersonaNombre;// HashMap que se asociará con "tablaPersonasNombre" de la obra respectiva
        HashMap<Integer, Persona> hashPersonaRut; // HashMap que se asociará con "tablaPersonasRut" de la obra respectiva
        ArrayList<Persona> lista = new ArrayList(); // ArrayList que se asociará con "registroEmpleados" del registro de Trabajadores
        
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
                    currentObra = new Obra(valores[0], valores[1], Double.parseDouble(valores[2]), Double.parseDouble(valores[3]));
                    contenedorDatos = ReadFile.tomarContenidosPersonas(',',5,"RegistroObras//"+currentObra.getNombreObra()+"//Empleados.txt");
                    
                    hashPersonaNombre = (HashMap<String,Persona>)contenedorDatos[0];
                    hashPersonaRut = (HashMap<Integer,Persona>)contenedorDatos[1];
                    //lista = (ArrayList<Persona>)contenedorDatos[2];
                                  
                    currentObra.setTablaPersonasNombre(hashPersonaNombre);
                    currentObra.setTablaPersonasRut(hashPersonaRut);
                    
                    todasLasObras.agregarObra(currentObra);
                    
                    
                    valores = new String[num];
                    cont = 0;
                }                
                

            } while (c != -1);
        } catch (IOException e) {
            System.out.println("El fichero no existe2");
        }

        return todasLasObras;
    }

}
