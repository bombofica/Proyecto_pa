package proyecto;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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

    public static void tomarContenidosPersonas(char separador, int num, String direccion, RegistroTrabajadores registroTrabajadores, Obra currentObra) {
        String[] valores = new String[num];// para almacenar los datos que se encuentran en una linea
        Persona currentPersona;
        int cont = 0;
        
        // Verifica si el txt de los empleados de una obra tiene Personas, si no tiene
        // no realiza el proceso
        File direccionEnviada = new File(direccion);
        if(direccionEnviada.exists()){
            if(direccionEnviada.length() == 0){
                return;
            }
        }
        
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
                    
                    
                    if(currentObra != null){
                        currentPersona = new Persona(valores[0], valores[1], Integer.parseInt(valores[2]),
                                Integer.parseInt(valores[3]), Boolean.parseBoolean(valores[4]),
                                currentObra.getNombreObra());
                        currentObra.agregarPersona(currentPersona);
                    }
                    else
                    {
                        currentPersona = new Persona(valores[0], valores[1], Integer.parseInt(valores[2]),
                                Integer.parseInt(valores[3]), Boolean.parseBoolean(valores[4]),"");
                    }
                    
                    registroTrabajadores.agregarEspecialista(currentPersona);
                    

                    valores = new String[num];
                    cont = 0;
                }
            } while (c != -1);
            
            entrada.close();
        } catch (IOException e) {
            System.out.println("El fichero no existe");
        }
        
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
                    currentObra = new Obra(valores[0], valores[1], Double.parseDouble(valores[2]), valores[3]);
                    ReadFile.tomarContenidosPersonas(',',5,"RegistroObras//"+valores[1]+"//"
                            +valores[0]+"//Empleados.txt",registroTrabajadores,currentObra);
                             // nombre_Obra(1)
                    
                    //,hashPersonaNombre,hashPersonaRut,lista);
                    
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
