package com.registro.obras.Controlador;

import java.util.ArrayList;

public class ListaEspecialidades {

    private ArrayList<String> listaDeEspecialidades;

    public ListaEspecialidades() {
        this.listaDeEspecialidades = new ArrayList();
    }

    public void agregarEspecialidad(String nombre) {
        this.listaDeEspecialidades.add(nombre);
    }

    public String retornarEspecialidadi(int i) {
        return this.listaDeEspecialidades.get(i);
    }

    public long size() {
        return this.listaDeEspecialidades.size();
    }

    public boolean contains(String nuevoDato) {
        return this.listaDeEspecialidades.contains(nuevoDato);
    }
}
