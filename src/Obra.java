/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Benjamín
 */
public class Obra {

    private String nombreObra;
    private String nombreLugar;
    private int presupuestoObra;
    private double tiempoParaTerminarObra;
    
    public String getNombreObra() {
        return nombreObra;
    }

    public void setNombreObra(String nombreObra) {
        this.nombreObra = nombreObra;
    }

    public String getNombreLugar() {
        return nombreLugar;
    }

    public void setNombreLugar(String nombreLugar) {
        this.nombreLugar = nombreLugar;
    }

    public int getPresupuestoObra() {
        return presupuestoObra;
    }

    public void setPresupuestoObra(int presupuestoObra) {
        this.presupuestoObra = presupuestoObra;
    }

    public double getTiempoParaTerminarObra() {
        return tiempoParaTerminarObra;
    }

    public void setTiempoParaTerminarObra(double tiempoParaTerminarObra) {
        this.tiempoParaTerminarObra = tiempoParaTerminarObra;
    }

    
    public Obra(String nombreObra, String nombreLugar, int presupuestoObra, double tiempoParaTerminarObra) {
        this.nombreObra = nombreObra;
        this.nombreLugar = nombreLugar;
        this.presupuestoObra = presupuestoObra;
        this.tiempoParaTerminarObra = tiempoParaTerminarObra;
    }
    
    

    
}
