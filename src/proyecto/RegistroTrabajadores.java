package proyecto;

import java.util.ArrayList;

public class RegistroTrabajadores {

    private ArrayList<Persona> registroEmpleados;

    public RegistroTrabajadores(ArrayList<Persona> lista) {
        this.registroEmpleados = lista;
    }

    public RegistroTrabajadores(Boolean booleano) {
        this.registroEmpleados = new ArrayList();
    }

    public void setRegistroEmpleados(ArrayList<Persona> lista) {
        this.registroEmpleados = lista;
    }

    public void mostrarPersona(boolean persona) {
        System.out.println("El/Los Nombre/s son:");
        for (Persona actual : registroEmpleados) {
            if (actual.isTrabajando() == persona) {
                System.out.println(actual.getNombre());
            }
        }
    }

    public void mostrarPersona(int sueldo) {
        System.out.println("El/Los Nombre/s son:");
        for (Persona actual : registroEmpleados) {
            if (sueldo == actual.getSueldo()) {
                System.out.println(actual.getNombre());
            }
        }
    }

    public void mostrarPersona(String profesion) {
        System.out.println("El/Los Nombre/s son:");
        for (Persona actual : registroEmpleados) {
            if (actual.getLaborProfesional().equals(profesion)) {
                System.out.println(actual.getNombre());
            }
        }
    }
    
    
    // funcion agregada
    public void agregarPersona(Persona persona){
        registroEmpleados.add(persona);
    }
}
