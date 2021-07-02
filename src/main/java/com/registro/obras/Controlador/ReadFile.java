package com.registro.obras.Controlador;
import com.registro.obras.Modelo.*;
import java.io.BufferedReader;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class ReadFile {
    
    /*El método "leerArchivo" solo lee e imprime por pantalla el contenido de un archivo de texto */

    
    
    private static String[] obtenerValoresSeparados(String cadenaCompleta){
        
        String[] valores = cadenaCompleta.split(",");
        
        for(int i =0; i < valores.length; i++){
            System.out.println(valores[i]);
        }
        return valores;
    }
    
    public static void leerArchivo(String direccion) {
        ArrayList<String> texto = new ArrayList();
        try{
            BufferedReader lector;
            lector = new BufferedReader(new FileReader(direccion,StandardCharsets.ISO_8859_1)); // este charset permite leer las Ñ
            String linea;
            String temporal = "";
            while((linea = lector.readLine())!= null){
                texto.add(linea);
            }
        }
        catch(IOException e){
        
        }
        
        
        for(int i = 0 ; i< texto.size() ; i++)
        {
            ReadFile.obtenerValoresSeparados(texto.get(i));
            //System.out.println(texto.get(i));
        }

    }
    
    /* El método "tomarContenidosPersonas" lee el archivo que corresponde a los empleados de una Obra o de la lista con 
       con todos los empleados(RegistroTrabajadores.txt) con todos sus datos respectivos.
       El formato(txt separado por comas) en el que se encuentran las obras es el siguiente:
       NombrePersona,Labor,Sueldo,Rut,Estado(Trabajando o no),
    */

    public static void tomarContenidosPersonas(char separador, int num, String direccion, RegistroTrabajadores registroTrabajadores, Obra currentObra) throws IOException {
        String[] valores = new String[num];// para almacenar los datos que se encuentran en una linea
        Trabajador currentPersona;
        int cont = 0;

        
        try{
        // Verifica si el txt de los empleados de una obra tiene Personas, si no tiene
        // no realiza el proceso
        File direccionEnviada = new File(direccion);
        if(direccionEnviada.exists()){
            if(direccionEnviada.length() == 0){
                return;
            }
        }
     
            File ruta = new File(direccion);
        
            FileReader entrada = new FileReader(ruta, StandardCharsets.ISO_8859_1);
            
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
                        
                        currentPersona = new Trabajador(valores[0], valores[1], Integer.parseInt(valores[2]),
                                Integer.parseInt(valores[3]), Boolean.parseBoolean(valores[4]),
                                //currentObra.getNombreObra());                                
                        currentObra.toString());
                        System.out.println(currentPersona.getNombre()+" "+currentObra.getNombreObra());
                                currentObra.agregarPersona(currentPersona);
                    }
                    else
                    {
                        currentPersona = new Trabajador(valores[0], valores[1], Integer.parseInt(valores[2]),
                                Integer.parseInt(valores[3]), Boolean.parseBoolean(valores[4]),"");
                    }
                    
                    registroTrabajadores.agregarEspecialista(currentPersona);
                    

                    valores = new String[num];
                    cont = 0;
                }
            } while (c != -1);
            
            entrada.close();
        }
        catch(IOException e){
            System.out.println("Tomar contenidos personas, el fichero no existe");
        }

        
    }
    
    
    /* El método "traerObras" lee el archivo "RegistroObras.txt" que contiene las obras y sus datos.
       El formato(txt separado por comas) en el que se encuentran las obras es el siguiente:
       NombreObra,NombreLugar,Presupuesto,TiempoParaTerminarObra,
       Luego de leer y guardar los datos básicos de las obras, se procede a integrar a los empleados
       cada lista de empleados de una obra se encuentra en una carpeta con el nombre de la Obra correspondiente
       Y esta carpeta posee un archivo de texto de nombre "Empleados.txt"

    */
    public static void traerObras (char separador, int num, String direccion,RegistroTrabajadores registroTrabajadores, RegistroObras registroObras) throws datoIlegibleExceptions, datoRepetidoException{
        
        /* Se crean las variables correspondientes*/

        String[] valores = new String[num]; // para almacenar los datos que se encuentran en una linea
        //RegistroObras todasLasObras = new RegistroObras(); // para almacenar las obras // No sirve
        
        
        int cont = 0;
        
        try{
            Obra currentObra = null;

            FileReader entrada = new FileReader(direccion+"//RegistroObras.txt",StandardCharsets.ISO_8859_1);
            int c;
            do {
                
                c = entrada.read();
                char caracter =  (char) c;
                //System.out.println(caracter);
                
                
                
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
                    System.out.println(valores[0]+" "+ valores[1]+" "+valores[2]+" " + valores[3]+" "+valores[4]+" "+valores[5]);                       // nombre_lugar(2)
 
                    int valor = Integer.parseInt(valores[0]);
                    System.out.println(valores[0]+" "+ valores[1]+" "+valores[2]+" " + valores[3]+" "+valores[4]+" "+valores[5]);                       // nombre_lugar(2)
                    switch(valor){
                        case 1:
                            currentObra = new ProyectoConstruccion(valores[1], valores[2], valores[4],Long.parseLong(valores[3]),Integer.parseInt(valores[5]));
                            ReadFile.tomarContenidosPersonas(',',5,"RegistroObras//"+valores[2]+"//"
                            +valores[1]+"//Empleados.txt",registroTrabajadores,currentObra);
                            break;
                        case 2:
                            currentObra = new ProyectoRestauracion(valores[1], valores[2], valores[4], Long.parseLong(valores[3]),Integer.parseInt(valores[5]));
                            ReadFile.tomarContenidosPersonas(',',5,"RegistroObras//"+valores[2]+"//"
                            +valores[1]+"//Empleados.txt",registroTrabajadores,currentObra);                                
                            break;
                        case 3:
                            currentObra = new ServicioMantencion(valores[1], valores[2], Long.parseLong(valores[3]), Double.parseDouble(valores[4]),Boolean.parseBoolean(valores[5]));
                            ReadFile.tomarContenidosPersonas(',',5,"RegistroObras//"+valores[2]+"//"
                            +valores[1]+"//Empleados.txt",registroTrabajadores,currentObra);                              
                            break;
                    }
                    
                    if(null != currentObra.getNombreObra())
                        registroObras.agregarObra(currentObra);
                                        
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
            WriteDataBase.addExistenciaDirectorioRegion(regiones[i]);
        }
    }

}
