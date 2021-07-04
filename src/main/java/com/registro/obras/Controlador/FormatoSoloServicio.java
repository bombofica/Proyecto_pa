
package com.registro.obras.Controlador;

import com.registro.obras.Modelo.Obra;
import java.io.FileWriter;

public class FormatoSoloServicio implements ListaImprimible {

    @Override
    public void imprimirDatos(RegistroObras registroObras, String ruta, String nombre) {
        ruta = ruta.concat("\\" + nombre + ".txt");
        try (FileWriter Escritor = new FileWriter(ruta)) {
            // Trabajador empleado;
            Obra obraActual;
            int i;

            for (i = 0; i < registroObras.numeroObras(); i++) {
                obraActual = registroObras.retornarObra(i);
                if (obraActual.getCodigo() == 3) {
                    Escritor.write("Obra:" + obraActual.getNombreObra() + '\n');
                }

            }
            Escritor.close();
        } catch (Exception e) {
            System.out.println("Falla");
        }
    }

}
