/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registro.obras.Controlador;

import com.registro.obras.Modelo.Trabajador;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Ceseo
 */
public class ColeccionPorProfecion {

    //hashmap(String, treemap) -> treemap (integer,trabajador)
    private String profecion;
    private TreeMap<Integer, Trabajador> listadoEmpleados;

    public ColeccionPorProfecion(String profecion) {
        this.profecion = profecion;
        this.listadoEmpleados = new TreeMap();
    }

    public Trabajador getEmpleado(Integer rut) {
        return this.listadoEmpleados.get(rut);
    }

    public void agregarEspecialista(Trabajador empleado) {
        this.listadoEmpleados.put(empleado.getRut(), empleado);
    }

    public Trabajador[] getListado() {
        if (this.listadoEmpleados.size() > 0) {
            Trabajador[] listadoEmpleados = new Trabajador[this.listadoEmpleados.size()];
            int i = 0;
            for (Map.Entry<Integer, Trabajador> entry : this.listadoEmpleados.entrySet()) {
                listadoEmpleados[i] = entry.getValue();
                i++;
            }
            return listadoEmpleados;
        }
        return null;
    }

    public void setEmpleado(Trabajador empleado) {
        this.listadoEmpleados.remove(empleado.getRut());
        this.listadoEmpleados.put(empleado.getRut(), empleado);
    }

    public void eliminarEmpleado(Trabajador empleado) {
        this.listadoEmpleados.remove(empleado.getRut());
    }

    boolean existenciaEmpleado(Trabajador empleado) {
        if (this.listadoEmpleados.containsKey(empleado.getRut())) {
            return true;
        }

        return false;
    }

}