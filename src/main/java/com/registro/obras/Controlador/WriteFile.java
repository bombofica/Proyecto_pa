package com.registro.obras.Controlador;

//import java.io.FileReader;
import com.registro.obras.Modelo.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

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
        int cont = 1;
        ColeccionRegionalObra[] coleccionNacional = registroObras.obtenerColeccionNacionalArray();
        
        for(int indexi = 0; indexi < coleccionNacional.length; indexi++){
            
            System.out.println("Nombre Region:" + coleccionNacional[indexi].getNombreRegion());
                
            Obra[] pepillo =coleccionNacional[indexi].retornarArray();
            
            
            for(int indexj = 0; indexj < pepillo.length ; indexj++){
                System.out.println('\t'+"Nombre Obra: "+pepillo[indexj].getNombreObra());
                    Obra currentObra = pepillo[indexj];
                    int valor = currentObra.getCodigo();
                    
                    if (cont < registroObras.numeroObras()){
                         
                       switch(valor){
                            case 1:
                                ProyectoConstruccion obraActual = (ProyectoConstruccion) currentObra;
                                Escritor.write("1,"+obraActual.getNombreObra()+','+obraActual.getNombreLugar()+','+
                                obraActual.getPresupuesto()+','+obraActual.getTiempoRestante()+','+obraActual.getFase()+','+'\n');
                                break;
                            case 2:
                                ProyectoRestauracion obraActual2 = (ProyectoRestauracion) currentObra;
                                Escritor.write("2,"+obraActual2.getNombreObra()+','+obraActual2.getNombreLugar()+','+
                                obraActual2.getPresupuesto()+','+obraActual2.getTiempoRestante()+','+obraActual2.getFase()+','+'\n');                                
                                break;
                            case 3:
                                ServicioMantencion obraActual3 = (ServicioMantencion) currentObra;
                                Escritor.write("3,"+obraActual3.getNombreObra()+','+obraActual3.getNombreLugar()+','+
                                obraActual3.getMantenimientoMonetarioAnual()+','+
                                obraActual3.getInteresAnual()+','+obraActual3.isOperativo()+','+'\n');                                
                                break;
                        }
                        
                            //Escritor.write(currentObra.getNombreObra()+','+currentObra.getNombreLugar()+','+
                                //currentObra.getPresupuestoObra()+','+currentObra.getTiempoParaTerminarObra()+','+'\n');
                    }
                    else
                    {
                        switch(valor){
                            case 1:
                                ProyectoConstruccion obraActual = (ProyectoConstruccion) currentObra;
                                Escritor.write("1,"+obraActual.getNombreObra()+','+obraActual.getNombreLugar()+','+
                                obraActual.getPresupuesto()+','+obraActual.getTiempoRestante()+','+obraActual.getFase()+',');
                                break;
                            case 2:
                                ProyectoRestauracion obraActual2 = (ProyectoRestauracion) currentObra;
                                Escritor.write("2,"+obraActual2.getNombreObra()+','+obraActual2.getNombreLugar()+','+
                                obraActual2.getPresupuesto()+','+obraActual2.getTiempoRestante()+','+obraActual2.getFase()+',');                                
                                break;
                            case 3:
                                ServicioMantencion obraActual3 = (ServicioMantencion) currentObra;
                                Escritor.write("3,"+obraActual3.getNombreObra()+','+obraActual3.getNombreLugar()+','+
                                obraActual3.getMantenimientoMonetarioAnual()+','+                                
                                obraActual3.getInteresAnual()+','+obraActual3.isOperativo()+',');                                
                                break;
                        }
                        
                            //Escritor.write(currentObra.getNombreObra()+','+currentObra.getNombreLugar()+','+
                            //    currentObra.getPresupuestoObra()+','+currentObra.getTiempoParaTerminarObra()+',');
                        
                    }
                    cont++;                

            }
            }
        }catch(Exception e){
            System.out.println("Error, WriteFile.escribirObras falla");
        }

        //try (FileWriter Escritor = new FileWriter("RegistroObras//RegistroObras.txt")) {
      
            /*Imprime en "RegistroObras.txt" los datos correspondientes a cada obra que se encuentra en un Objeto de tipo "RegistroObras",
                más específicamente en el ArrayList de RegistroObras*/ 
            
           /* HashMap <String, TreeMap<String, Obra>> regiones = registroObras.obtenerHashRegiones();
 
                
            int cont = 1;
            for (Map.Entry HashObras : regiones.entrySet()) {
                
                TreeMap<String, Obra> currentHashObras =(TreeMap) HashObras.getValue();
                
                for (Map.Entry obra : currentHashObras.entrySet()) {
                    Obra currentObra = (Obra) obra.getValue();
                    int valor = currentObra.getCodigo();
                    if (cont < registroObras.numeroObras()){
                         
                       switch(valor){
                            case 1:
                                ProyectoConstruccion obraActual = (ProyectoConstruccion) currentObra;
                                Escritor.write("1,"+obraActual.getNombreObra()+','+obraActual.getNombreLugar()+','+
                                obraActual.getPresupuesto()+','+obraActual.getTiempoRestante()+','+obraActual.getFase()+','+'\n');
                                break;
                            case 2:
                                ProyectoRestauracion obraActual2 = (ProyectoRestauracion) currentObra;
                                Escritor.write("2,"+obraActual2.getNombreObra()+','+obraActual2.getNombreLugar()+','+
                                obraActual2.getPresupuesto()+','+obraActual2.getTiempoRestante()+','+obraActual2.getFase()+','+'\n');                                
                                break;
                            case 3:
                                ServicioMantencion obraActual3 = (ServicioMantencion) currentObra;
                                Escritor.write("3,"+obraActual3.getNombreObra()+','+obraActual3.getNombreLugar()+','+
                                obraActual3.getMantenimientoMonetarioAnual()+','+
                                obraActual3.getInteresAnual()+','+obraActual3.isOperativo()+','+'\n');                                
                                break;
                        }
                        
                            //Escritor.write(currentObra.getNombreObra()+','+currentObra.getNombreLugar()+','+
                                //currentObra.getPresupuestoObra()+','+currentObra.getTiempoParaTerminarObra()+','+'\n');
                    }
                    else
                    {
                        switch(valor){
                            case 1:
                                ProyectoConstruccion obraActual = (ProyectoConstruccion) currentObra;
                                Escritor.write("1,"+obraActual.getNombreObra()+','+obraActual.getNombreLugar()+','+
                                obraActual.getPresupuesto()+','+obraActual.getTiempoRestante()+','+obraActual.getFase()+',');
                                break;
                            case 2:
                                ProyectoRestauracion obraActual2 = (ProyectoRestauracion) currentObra;
                                Escritor.write("2,"+obraActual2.getNombreObra()+','+obraActual2.getNombreLugar()+','+
                                obraActual2.getPresupuesto()+','+obraActual2.getTiempoRestante()+','+obraActual2.getFase()+',');                                
                                break;
                            case 3:
                                ServicioMantencion obraActual3 = (ServicioMantencion) currentObra;
                                Escritor.write("3,"+obraActual3.getNombreObra()+','+obraActual3.getNombreLugar()+','+
                                obraActual3.getMantenimientoMonetarioAnual()+','+                                
                                obraActual3.getInteresAnual()+','+obraActual3.isOperativo()+',');                                
                                break;
                        }
                        
                            //Escritor.write(currentObra.getNombreObra()+','+currentObra.getNombreLugar()+','+
                            //    currentObra.getPresupuestoObra()+','+currentObra.getTiempoParaTerminarObra()+',');
                        
                    }
                    cont++;

                }                

            }
           Escritor.close();
        } catch (IOException e) {
            System.out.println("Error, el fichero no existe");
        }
        
        int cont = 1;
        HashMap <String, TreeMap<String, Obra>> regiones = registroObras.obtenerHashRegiones();
        
        for (Map.Entry HashObras : regiones.entrySet()) {
            
            TreeMap<String, Obra> currentHashObras =(TreeMap) HashObras.getValue();
            for (Map.Entry obra : currentHashObras.entrySet()) {
                Obra currentObra = (Obra) obra.getValue();      
                
                addExistenciaDirectorioObra(currentObra);
            // terminar estoooooooooooooooooo
                
                
                try (FileWriter Escritor = new FileWriter("RegistroObras//"+currentObra.getNombreLugar()+"//"+currentObra.getNombreObra()+"//Empleados.txt")) {
                
                    Trabajador currentPersona;
                
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
                System.out.println("Error, el fichero no existe 45");
            }       
                
                }                
            //System.out.println("Key: "+me.getKey() + " & Value: " + me.getValue());
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
    
    
    
    public static void imprimirTodasLasPersonas(RegistroTrabajadores registroTrabajadores){ // terminar este metodo
        
        
            
            try (FileWriter Escritor = new FileWriter("RegistroObras//RegistroTrabajadores.txt")) {
                
                Trabajador current;
                
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
    
    public static boolean generarReporte(String ruta,String nombre, RegistroTrabajadores registroTra, RegistroObras registroObr)
    {
        ruta = ruta.concat("\\"+nombre+".txt");
        try(FileWriter Escritor = new FileWriter(ruta))
        {
           // Trabajador empleado;

            
            
            Obra obraActual;
            int i ;
            int j ;
            
            for(i = 0; i < registroObr.numeroObras(); i++)
            {
                obraActual = registroObr.retornarObra(i) ;
                Trabajador[] listaEmpleados = new Trabajador[obraActual.getNumeroEmpleados()] ;
                obraActual.getListadoPersonas(listaEmpleados);
                
                Escritor.write("Obra:"+obraActual.getNombreObra()+":\n");
                if(obraActual.getNumeroEmpleados() == 0){
                    Escritor.write("\tEsta Obra no tiene empleados\n");
                }
                
                for(j = 0; j < listaEmpleados.length; j++)
                {
                    if (i == obraActual.getNumeroEmpleados() -1) //sin salto de linea
                    {
                        Escritor.write('\t'+listaEmpleados[j].getNombre());
                    }
                    else //con salto de linea
                    {
                        Escritor.write('\t'+listaEmpleados[j].getNombre()+"\n");
                    }
                }
                Escritor.write('\n');
                
            }
            Escritor.close();
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
}
