/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registro.obras.Controlador;

import com.registro.obras.Modelo.*;
import java.util.ArrayList;
import javax.swing.JComboBox;


public class ListaProyectoInterfaz {

    public ArrayList<ProyectoReportable> listaCompletaInterfaz;

    public ListaProyectoInterfaz() {
        this.listaCompletaInterfaz = new ArrayList();
    }

    public void llenarComboBoxObrasInterfaz(JComboBox<ProyectoReportable> comboBoxObra) {
        comboBoxObra.removeAllItems();
        ProyectoReportable current;
        for (int i = 0; i < listaCompletaInterfaz.size(); i++) {
            current = listaCompletaInterfaz.get(i);
            comboBoxObra.addItem((ProyectoReportable) current);
        }
    }

    public boolean agregarObra(ProyectoConstruccion obraAgregar) {
        if (obraAgregar != null) {
            this.listaCompletaInterfaz.add(obraAgregar);
            return true;
        }
        return false;
    }

    public void agregarObra(ProyectoRestauracion obraAgregar) {
        if (obraAgregar != null) {
            this.listaCompletaInterfaz.add(obraAgregar);
        }
    }

    public void eliminarObra(ProyectoReportable proyecto) {
        if (proyecto != null) {
            this.listaCompletaInterfaz.remove(proyecto);
        }
    }

}
