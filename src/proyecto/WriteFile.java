package proyecto;

//import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

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
      Nombre_Obra,Lugar,Presupuesto_estimado,Tiempo_estimado,
 
        Luego de escribir en "RegistroObras.txt", imprime en las direcciones "RegistroObras/Nombre_obra/empleados.txt" correspondiente a cada Obra
        donde se imprimen los datos correspondientes a cada empleado
    */
    public static void escribirObras(char separador, RegistroObras registroObras) throws IOException{
                
        try (FileWriter Escritor = new FileWriter("RegistroObras//RegistroObras.txt")) { 
            
            
            /*Imprime en "RegistroObras.txt" los datos correspondientes a cada obra que se encuentra en un Objeto de tipo "RegistroObras",
                más específicamente en el ArrayList de RegistroObras*/ 
            Obra current;
            for(int i =0; i < registroObras.contadorObras;i++){
                current=registroObras.retornarObra(i);
                
                if(i == registroObras.contadorObras-1){
                    Escritor.write(current.getNombreObra()+','+current.getNombreLugar()+','+current.getPresupuestoObra()+','+current.getTiempoParaTerminarObra()+',');
                }
                else
                {
                    Escritor.write(current.getNombreObra()+','+current.getNombreLugar()+','+current.getPresupuestoObra()+','+current.getTiempoParaTerminarObra()+','+'\n');
                    
                }

            }
            
            
            Escritor.close();
        } catch (IOException e) {
            System.out.println("Error, el fichero no existe");
        }
        
        
        Obra currentObra;
        for(int i =0; i < registroObras.contadorObras;i++){
            currentObra=registroObras.retornarObra(i);
                
            WriteFile.existenciaDirectorio(currentObra);
            
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
        }
    }
    
    public static void existenciaDirectorio(Obra currentObra){ // verifica si existe la carpeta
            File directorio = new File("RegistroObras//"+currentObra.getNombreObra());
            
            if(!directorio.exists()){ // si no existe, crea una
                if(!directorio.mkdirs()) // si no se crea, se imprime un error
                {
                    System.out.println("Error al crear el directorio");
                }
            }        
    }
    
    
    public static void imprimirTodasLasPersonas(RegistroTrabajadores registroTrabajadores){
        
        
            
            try (FileWriter Escritor = new FileWriter("RegistroTrabajadores.txt")) {
                
                Persona current;
                
                //System.out.println(currentObra.getNumeroEmpleados());
                
                for(int j=0; j < registroTrabajadores.devolverNumeroPersonas(); j++){
                    current = registroTrabajadores.getPersona(j);
                    
                    if (j == registroTrabajadores.devolverNumeroPersonas()-1){
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
