/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;
import java.io.FileReader;
import java.io.IOException;

/**
 * Programación Avanzada ICI3241-1
 * @author Benjamín Rojas
 * @author Andrés Vidal
 */
public class ReadFile {
    
    public static void leerArchivo(String direccion){
        
        try{
            FileReader entrada = new FileReader("D:\\Escritorio Real\\ProyectoPA\\proyecto\\proyecto\\src\\proyecto\\csv_proyecto_progra.txt");
            int c=5;
            while(c!=-1){
                c=entrada.read();
                char caracter = (char) c;
                System.out.print(caracter);
            }
        }catch(IOException e){
            System.out.println("El fichero no existe");
        }
    }
    
    public static ListaEnlazada tomarContenidos(char separador, int num){
        String[] valores = new String[num];
        int cont=0;
        ListaEnlazada lista = new ListaEnlazada();
        
        try{
            FileReader entrada = new FileReader("D:\\Escritorio Real\\ProyectoPA\\proyecto\\proyecto\\src\\proyecto\\csv_proyecto_progra.txt");
            int c;
               
            do
            {
                c=entrada.read();
                char caracter = (char) c;
                
                if((caracter == separador)){
                    cont++;
                }
                else
                {
                    if(caracter !='\n' && c != -1 ){
                        if(cont < num && valores[cont] == null)
                        {
                            valores[cont]=String.valueOf(caracter);
                        }
                        else {
                            if(cont < num) valores[cont]+=caracter;
                        }
                    }
                }
                
                if(caracter == '\n' || c == -1){ 
                    lista.addList(valores);
                    valores = new String[num];
                    cont = 0;
                }
                            
            }while(c!=-1);
            
        }catch(IOException e){
            System.out.println("El fichero no existe");
        }
        return lista;
    }
    
}
