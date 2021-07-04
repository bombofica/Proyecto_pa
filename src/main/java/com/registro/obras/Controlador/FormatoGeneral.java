package com.registro.obras.Controlador;

import com.registro.obras.Modelo.Obra;
import com.registro.obras.Modelo.Trabajador;
import java.io.FileWriter;

public class FormatoGeneral implements ListaImprimible{

    @Override
    public void imprimirDatos(RegistroObras registroObras, String ruta, String nombre) {
        ruta = ruta.concat("\\" + nombre + ".txt");
        try (FileWriter Escritor = new FileWriter(ruta)) {
            // Trabajador empleado;

            Obra obraActual;
            int i;
            int j;

            for (i = 0; i < registroObras.numeroObras(); i++) {
                obraActual = registroObras.retornarObra(i);
                Trabajador[] listaEmpleados = new Trabajador[obraActual.getNumeroEmpleados()];
                obraActual.getListadoPersonas(listaEmpleados);

                Escritor.write("Obra:" + obraActual.getNombreObra() + ":\n");
                if (obraActual.getNumeroEmpleados() == 0) {
                    Escritor.write("\tEsta Obra no tiene empleados\n");
                }

                for (j = 0; j < listaEmpleados.length; j++) {
                    if (i == obraActual.getNumeroEmpleados() - 1) //sin salto de linea
                    {
                        Escritor.write('\t' + listaEmpleados[j].getNombre());
                    } else //con salto de linea
                    {
                        Escritor.write('\t' + listaEmpleados[j].getNombre() + "\n");
                    }
                }
                Escritor.write('\n');

            }
            Escritor.close();
        } catch (Exception e) {
            System.out.println("Falla");
        }

    }
    
}
