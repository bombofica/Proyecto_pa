/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

/**
 *
 * @author Benjamín
 */

import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
    public static void escribirFichero(int valor) throws IOException{
        try(FileWriter Escritor = new FileWriter("D:\\Escritorio Real\\ProyectoPA\\proyecto\\proyecto\\src\\proyecto\\pepito.txt")){
            
            for(int i = 0; i < valor; i++)
            {
                Escritor.write("Hola");
            }
            Escritor.close();
        }
        catch(IOException e){
            
        }
    }
}
