package proyecto;



/**
 *Realizar los cambios desde  "Source Packages"
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

    
    public Obra(String nombreObra, String nombreLugar, int presupuestoObra, double tiempoNecesarioParaTerminarObra) {
        this.nombreObra = nombreObra;
        this.nombreLugar = nombreLugar;
        this.presupuestoObra = presupuestoObra;
        this.tiempoParaTerminarObra = tiempoNecesarioParaTerminarObra;
    }
    
    

    
}
