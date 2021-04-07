package proyecto;

//import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class WriteFile {

    public static void escribirFichero(int valor) throws IOException {
        try (FileWriter Escritor = new FileWriter("D:\\Escritorio Real\\ProyectoPA\\proyecto\\proyecto\\src\\proyecto\\pepito.txt")) {
            for (int i = 0; i < valor; i++) {
                Escritor.write("Hola");
            }
            Escritor.close();
        } catch (IOException e) {
        }
    }
    
    public static void escribirObras(char separador, RegistroObras registroObras) throws IOException{
        /*try {
            FileReader entrada = new FileReader("RegistroObras\\RegistroObras.txt");
            
            String nombreObra="";
            Obra obra;
            int c;
            int cont =0;
            
            
            
            do {
                c = entrada.read();
                char caracter = (char) c;
                if ((caracter == separador)) {
                    cont++;
                }
                
                if(cont < 1){
                    nombreObra=nombreObra+caracter;
                }
                
                if ((caracter == '\n' || c == -1)) {
                    obra = registroObras.retornarObra(nombreObra);
                    if(obra == null){
                        System.out.println("La obra no existe");
                    }
                    else
                    {
                        System.out.println("La obra si existe y se llama: "+ nombreObra);
                    }
                    //System.out.println(nombreObra);
                    nombreObra="";
                    cont =0;
                }
            } while (c != -1);
        } catch (IOException e) {
            System.out.println("El fichero no existe3");
        }*/
        
        
        
        try (FileWriter Escritor = new FileWriter("RegistroObras//RegistroObras2.txt")) { 

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
                //System.out.println(current.getNombreObra());
                //current.mostrarEmpleados();
            }
            
            
            Escritor.close();
        } catch (IOException e) {
            System.out.println("Error, el fichero no existe");
        }
        
        
        Obra currentObra;
        for(int i =0; i < registroObras.contadorObras;i++){
            currentObra=registroObras.retornarObra(i);
                
            WriteFile.existenciaDirectorio(currentObra);
            
            try (FileWriter Escritor = new FileWriter("RegistroObras//"+currentObra.getNombreObra()+"//Empleados2.txt")) {
                
                Persona currentPersona;
                
                System.out.println(currentObra.getNumeroEmpleados());
                
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

                    
                    System.out.println(currentPersona.getNombre());
                }
                
                Escritor.close();
            } catch (IOException e) {
                System.out.println("Error, el fichero no existe 4");
            }
        }
    }
    
    public static void existenciaDirectorio(Obra currentObra){
            File directorio = new File("RegistroObras//"+currentObra.getNombreObra());
            
            if(!directorio.exists()){
                if(!directorio.mkdirs())
                {
                    System.out.println("Error al crear el directorio");
                }
            }        
    }
    
}
