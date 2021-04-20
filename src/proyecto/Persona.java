package proyecto;

public class Persona {

    private String nombre;

    private String laborProfesional;

    private int sueldo;

    private int rut;

    private boolean trabajando;

    public boolean isTrabajando() {
        return trabajando;
    }

    public void setTrabajando(boolean trabajando) {
        this.trabajando = trabajando;
    }

    public Persona() {
    }

    public Persona(String nombre, String laborProfecional, int sueldo, int rut, boolean estado) {
        this.nombre = nombre;
        this.laborProfesional = laborProfecional;
        this.sueldo = sueldo;
        this.rut = rut;
        this.trabajando = estado;
      
        if(Integer.toString(this.rut).length() < 8){
            System.out.println("Revisar las cifras que tiene el rut");
        }
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLaborProfesional() {
        return laborProfesional;
    }

    public void setLaborProfesional(String laborProfecional) {
        this.laborProfesional = laborProfecional;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        int digitos = Integer.toString(rut).length();
        if(digitos != 9){
            System.out.println("Tai cagao gancho");
        }
        this.rut = rut;
    }
}
