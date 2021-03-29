package proyecto;



/**
 * Programación Avanzada ICI3241-1
 * @author Benjamín Rojas
 * @author Andrés Vidal
 */
public class Obra {
    
    private String nombreObra;
    private String nombreLugar;
    private int presupuestoObra;
    private double tiempoParaTerminarObra;
    
    public Obra(){}
   
    public Obra(String nombreObra, String nombreLugar, int presupuestoObra, double tiempoNecesarioParaTerminarObra) {
        this.nombreObra = nombreObra;
        this.nombreLugar = nombreLugar;
        this.presupuestoObra = presupuestoObra;
        this.tiempoParaTerminarObra = tiempoNecesarioParaTerminarObra;
    }
    
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
    public void setPresupuestoObra(double presupuestoObra) {
        this.presupuestoObra = (int) presupuestoObra;
    }

    public double getTiempoParaTerminarObra() {
        return tiempoParaTerminarObra;
    }

    public void setTiempoParaTerminarObra(double tiempoParaTerminarObra) {
        this.tiempoParaTerminarObra = tiempoParaTerminarObra;
    }

    public void setTiempoParaTerminarObra(int tiempoParaTerminarObra) {
        this.tiempoParaTerminarObra = tiempoParaTerminarObra;
    }
        
       

    
}
