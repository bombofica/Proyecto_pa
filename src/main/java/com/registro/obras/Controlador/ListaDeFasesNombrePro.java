
package com.registro.obras.Controlador;

import java.util.ArrayList;

public class ListaDeFasesNombrePro {
    private ArrayList<String> listaDeFases;

    public ListaDeFasesNombrePro() {
        this.listaDeFases = new ArrayList();
    }

    public void agregarNombreFase(String nombre) {
        this.listaDeFases.add(nombre);
    }

    public String retornarFasei(int i) {
        return this.listaDeFases.get(i);
    }

    public long size() {
        return this.listaDeFases.size();
    }

    public boolean contains(String nuevoDato) {
        return this.listaDeFases.contains(nuevoDato);
    }
}
