/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registro.obras.Controlador;

import java.util.ArrayList;

/**
 *
 * @author Benjamín
 */
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
