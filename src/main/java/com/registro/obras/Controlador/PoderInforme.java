/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registro.obras.Controlador;

/**
 *
 * @author Benjamín
 */

public interface PoderInforme {
    void crearInforme();
    double calcularPresupuestoGastadoMensual();
    int calcularFase();
    void crearGrafico();
}
