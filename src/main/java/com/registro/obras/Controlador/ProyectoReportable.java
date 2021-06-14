package com.registro.obras.Controlador;

public interface ProyectoReportable {

    void crearInforme(String opcional);

    double calcularPresupuestoGastadoMensual();

    int calcularFase();

    void crearGrafico();
}
