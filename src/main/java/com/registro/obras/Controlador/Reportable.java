package com.registro.obras.Controlador;

import java.io.File;

public interface Reportable {
    void crearInforme(String opcional);
    double calcularPresupuestoGastadoMensual();
    int calcularFase();
    void crearGrafico();
}
