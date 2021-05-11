package com.registro.obras.Controlador;

//import java.io.FileReader;
import com.registro.obras.Controlador.RegistroTrabajadores;
import com.registro.obras.Controlador.RegistroObras;
import com.registro.obras.Modelo.Persona;
import com.registro.obras.Modelo.Obra;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class WriteFile {
    // Este método solo se creó para probar el funcionamiento de "FileWriter" 
    public static void escribirFichero(int valor) throws IOException {
        try (FileWriter Escritor = new FileWriter("D:\\Escritorio Real\\ProyectoPA\\proyecto\\proyecto\\src\\proyecto\\pepito.txt")) {
            for (int i = 0; i < valor; i++) {
                Escritor.write("Hola");
            }
            Escritor.close();
        } catch (IOException e) {
        }
    }
    
    /*Este método se encarga de escribir en "RegistroObras.txt" donde se imprimirá los datos correspondientes al a obra en el siguiente formato:
      NombreObra,Lugar,PresupuestoEstimado,TiempoEstimado,
 
        Luego de escribir en "RegistroObras.txt", imprime en las direcciones "RegistroObras/Nombre_obra/empleados.txt" correspondiente a cada Obra
        donde se imprimen los datos correspondientes a cada empleado
    */
    public static void escribirObras(char separador, RegistroObras registroObras) throws IOException{
        
                

        try (FileWriter Escritor = new FileWriter("RegistroObras//RegistroObras.txt")) {
      
            /*Imprime en "RegistroObras.txt" los datos correspondientes a cada obra que se encuentra en un Objeto de tipo "RegistroObras",
                más específicamente en el ArrayList de RegistroObras*/ 
            
            HashMap <String, HashMap<String, Obra>> regiones = registroObras.obtenerHashRegiones();
            
            
            int cont = 1;
            for (Map.Entry HashObras : regiones.entrySet()) {
                
                HashMap<String, Obra> currentHashObras =(HashMap) HashObras.getValue();
                for (Map.Entry obra : currentHashObras.entrySet()) {
                    Obra currentObra = (Obra) obra.getValue();
                    if (cont < registroObras.numeroObras()){
                        Escritor.write(currentObra.getNombreObra()+','+currentObra.getNombreLugar()+','+
                                currentObra.getPresupuestoObra()+','+currentObra.getTiempoParaTerminarObra()+','+'\n');
                    }
                    else
                    {
                        Escritor.write(currentObra.getNombreObra()+','+currentObra.getNombreLugar()+','+
                                currentObra.getPresupuestoObra()+','+currentObra.getTiempoParaTerminarObra()+',');
                        
                    }
                    cont++;
                    /*
                    System.out.print("Nombre: " + currentObra.getNombreObra());
                    System.out.print(" Nombre Lugar: " + currentObra.getNombreLugar());
                    System.out.print(" Presupuesto: " + currentObra.getPresupuestoObra());
                    System.out.println(" Tiempo Estimado: " + currentObra.getTiempoParaTerminarObra());        */
                }                
          //System.out.println("Key: "+me.getKey() + " & Value: " + me.getValue());
            }
            Escritor.close();
        } catch (IOException e) {
            System.out.println("Error, el fichero no existe");
        }
        
        int cont = 1;
        HashMap <String, HashMap<String, Obra>> regiones = registroObras.obtenerHashRegiones();
        for (Map.Entry HashObras : regiones.entrySet()) {
            HashMap<String, Obra> currentHashObras =(HashMap) HashObras.getValue();
            for (Map.Entry obra : currentHashObras.entrySet()) {
                Obra currentObra = (Obra) obra.getValue();      
                
            addExistenciaDirectorioObra(currentObra);
            try (FileWriter Escritor = new FileWriter("RegistroObras//"+currentObra.getNombreLugar()+"//"+currentObra.getNombreObra()+"//Empleados.txt")) {
                
                Persona currentPersona;
                
                //System.out.println(currentObra.getNumeroEmpleados());
                
                for(int j=0; j < currentObra.getNumeroEmpleados(); j++){
                    currentPersona = currentObra.devolverPersonaI(j);
                    if (j == currentObra.getNumeroEmpleados()-1){
                        Escritor.write(currentPersona.getNombre()+','+currentPersona.getLaborProfesional()+','+currentPersona.getSueldo()
                        +','+currentPersona.getRut()+','+currentPersona.isTrabajando()+',');                       
                    }
                    else
                    {
                        Escritor.write(currentPersona.getNombre()+','+currentPersona.getLaborProfesional()+','+currentPersona.getSueldo()
                        +','+currentPersona.getRut()+','+currentPersona.isTrabajando()+','+'\n');                        
                    }
                    
                    //System.out.println(currentPersona.getNombre());
                }
                
                Escritor.close();
            } catch (IOException e) {
                System.out.println("Error, el fichero no existe 4");
            }                
                
                
                
                
                
                }                
          //System.out.println("Key: "+me.getKey() + " & Value: " + me.getValue());
            }
        
        
        
        
        /*
        Obra currentObra;
        for(int i =0; i < registroObras.contadorObras;i++){
            currentObra=registroObras.retornarObra(i);
                
            WriteFile.addExistenciaDirectorioObra(currentObra);
            
            try (FileWriter Escritor = new FileWriter("RegistroObras//"+currentObra.getNombreObra()+"//Empleados.txt")) {
                
                Persona currentPersona;
                
                //System.out.println(currentObra.getNumeroEmpleados());
                
                for(int j=0; j < currentObra.getNumeroEmpleados(); j++){
                    currentPersona = currentObra.devolverPersonaI(j);
                    if (j == currentObra.getNumeroEmpleados()-1){
                        Escritor.write(currentPersona.getNombre()+','+currentPersona.getLaborProfesional()+','+currentPersona.getSueldo()
                        +','+currentPersona.getRut()+','+currentPersona.isTrabajando()+',');                       
                    }
                    else
                    {
                        Escritor.write(currentPersona.getNombre()+','+currentPersona.getLaborProfesional()+','+currentPersona.getSueldo()
                        +','+currentPersona.getRut()+','+currentPersona.isTrabajando()+','+'\n');                        
                    }
                    
                    //System.out.println(currentPersona.getNombre());
                }
                
                Escritor.close();
            } catch (IOException e) {
                System.out.println("Error, el fichero no existe 4");
            }
        }*/
    }
    
    public static void addExistenciaDirectorioObra(Obra currentObra){ // verifica si existe la carpeta

            File directorio = new File("RegistroObras//"+currentObra.getNombreLugar()+"//"+currentObra.getNombreObra());

            
            if(!directorio.exists()){ // si no existe, crea una
                if(!directorio.mkdirs()) // si no se crea, se imprime un error
                {
                    System.out.println("Error al crear el directorio");
                }
            }        
    }
    public static void addExistenciaDirectorioRegion(String nombreRegion){ // verifica si existe la carpeta
            File directorio = new File("RegistroObras//"+nombreRegion);
            
            if(!directorio.exists()){ // si no existe, crea una
                if(!directorio.mkdirs()) // si no se crea, se imprime un error
                {
                    System.out.println("Error al crear el directorio");
                }
            }        
    }
    
    public static void deleteDirectorio(File directorio){
        
        
        
            File[] ficheros = directorio.listFiles();
        
            for (int x=0;x < ficheros.length; x++){
                System.out.println("Nombre: "+ ficheros[x].getAbsolutePath());
                if(ficheros[x].exists()){
                    if (ficheros[x].isDirectory()) {
                        //System.out.println("El Archivo/Directorio No se ha eliminado");
                        WriteFile.deleteDirectorio(ficheros[x]);
                    }
                    
                    if(!ficheros[x].delete()){
                        System.out.println("Nombre: "+ ficheros[x].getAbsolutePath());
                        System.out.println("El Archivo/Directorio No se ha eliminado");
                    }
                }
                else
                {
                    System.out.println("No esxxiste 2");
                }
            }
   
    }
    
    public static void eliminarDefinitivo(File directorio){

        if(directorio.exists()) WriteFile.deleteDirectorio(directorio);
        
        if(directorio.exists()){

            if(directorio.delete()) // si no se elimina, se imprime un error
            {
                
                //System.out.println("Se eliminó correctamente");
            }
        }
        else
        {
            //System.out.print("La Obra No existe");
        }
    }
    
    
    
    public static void imprimirTodasLasPersonas(RegistroTrabajadores registroTrabajadores){
        
        
            
            try (FileWriter Escritor = new FileWriter("RegistroObras//RegistroTrabajadores.txt")) {
                
                Persona current;
                
                //System.out.println(currentObra.getNumeroEmpleados());
                
                for(int j=0; j < registroTrabajadores.numeroDeTrabajadores(); j++){
                    current = registroTrabajadores.devolverPersona(j);
                    
                    if (j == registroTrabajadores.numeroDeTrabajadores()-1){
                        Escritor.write(current.getNombre()+','+current.getLaborProfesional()+','+current.getSueldo()
                        +','+current.getRut()+','+current.isTrabajando()+',');                       
                    }
                    else
                    {
                        Escritor.write(current.getNombre()+','+current.getLaborProfesional()+','+current.getSueldo()
                        +','+current.getRut()+','+current.isTrabajando()+','+'\n');                        
                    }
                    
                }
                
                Escritor.close();
            } catch (IOException e) {
                System.out.println("Error, el fichero no existe 4");
            }
    }
}
