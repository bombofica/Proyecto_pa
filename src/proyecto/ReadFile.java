package proyecto;

import java.util.HashMap;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {

    public static void leerArchivo(String direccion) {
        try {
            FileReader entrada = new FileReader
        ("D:\\Escritorio Real\\ProyectoPA\\proyecto\\proyecto\\src\\proyecto\\csvProyectoProgra.txt");
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

    public static Object[] tomarContenidos(char separador, int num, String direccion) {
        String[] valores = new String[num];
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
                if (caracter == '\n' || c == -1) {
                    current = new Persona(valores[0], valores[1], Integer.parseInt(valores[2]),
                            Integer.parseInt(valores[3]), Boolean.parseBoolean(valores[4]));
                    
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
    
    public static RegistroObras traerObras (char separador, int num, String direccion){

        String[] valores = new String[num];
        RegistroObras todasLasObras = new RegistroObras();
        Object[] contenedorDatos;
        
        Obra current;
        int cont = 0;
        
        try{
            FileReader entrada = new FileReader(direccion);
            int c;
            do {
                c = entrada.read();
                char caracter = (char) c;
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
                
                if (caracter == '\n' || c == -1) {
                    current = new Obra(valores[0], valores[1], Double.parseDouble(valores[2]), Double.parseDouble(valores[3]));
                    
                    contenedorDatos = tomarContenidos(',',4,"RegistroObras\\"+current.getNombreObra());
                    
                    valores = new String[num];
                    cont = 0;
                }                
                

            } while (c != -1);
        } catch (IOException e) {
            System.out.println("El fichero no existe");
        }

        return todasLasObras;
    }

}
