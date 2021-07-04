
package com.registro.obras.Controlador;

import com.registro.obras.Modelo.Obra;
import com.registro.obras.Modelo.Trabajador;
import java.io.FileWriter;

public class FormatoSoloProyecto implements ListaImprimible {

    @Override
    public void imprimirDatos(RegistroObras registroObras, String ruta, String nombre) {
        ruta = ruta.concat("\\" + nombre + ".txt");
        try (FileWriter Escritor = new FileWriter(ruta)) {
            // Trabajador empleado;
            Obra obraActual;
            int i;

            for (i = 0; i < registroObras.numeroObras(); i++) {
                obraActual = registroObras.retornarObra(i);
                if (obraActual.getCodigo() == 1 || obraActual.getCodigo() == 2) {
                    Escritor.write("Obra:" + obraActual.getNombreObra() + '\n');
                }

            }
            Escritor.close();
        } catch (Exception e) {
            System.out.println("Falla");
        }
    }

}
