
package com.registro.obras.Controlador;

import com.registro.obras.Modelo.Obra;
import com.registro.obras.Modelo.Trabajador;
import java.io.FileWriter;

public class FormatoTrabajando implements ListaImprimible{

    @Override
    public void imprimirDatos(RegistroObras registroObras, String ruta, String nombre) {
        ruta = ruta.concat("\\" + nombre + ".txt");
        try (FileWriter Escritor = new FileWriter(ruta)) {

            Obra obraActual;
            int i;
            int j;

            for (i = 0; i < registroObras.numeroObras(); i++) {
                obraActual = registroObras.retornarObra(i);
                Trabajador[] listaEmpleados = new Trabajador[obraActual.getNumeroEmpleados()];
                obraActual.getListadoPersonas(listaEmpleados);

                for (j = 0; j < listaEmpleados.length; j++) {
                    if (i == obraActual.getNumeroEmpleados() - 1) //sin salto de linea
                    {
                        Escritor.write(listaEmpleados[j].getNombre());
                    } else //con salto de linea
                    {
                        Escritor.write(listaEmpleados[j].getNombre() + "\n");
                    }
                }

            }
            Escritor.close();
        } catch (Exception e) {
            System.out.println("Falla");
        }        
    }


    
}
