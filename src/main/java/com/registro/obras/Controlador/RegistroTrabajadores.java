package com.registro.obras.Controlador;

import com.registro.obras.Modelo.Persona;
import com.registro.obras.Modelo.Obra;
import com.registro.obras.Modelo.Trabajador;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class RegistroTrabajadores {
    
    private String[] especializaciones;
    private ListaTrabajadores listadoTrabajadores ;
    private ColeccionTrabajadores coleccionTrabajadores;

    public RegistroTrabajadores() {

        this.listadoTrabajadores = new ListaTrabajadores() ;
        this.coleccionTrabajadores = new ColeccionTrabajadores() ;

        this.especializaciones = new String[10];
        this.especializaciones[0] = new String("Ingeniero Civil");
        this.especializaciones[1] = new String("Arquitecto");
        this.especializaciones[2] = new String("Topografo");
        this.especializaciones[3] = new String("Ingeniero Ambiental");
        this.especializaciones[4] = new String("Prevencionista de Riesgos");
        this.especializaciones[5] = new String("Obrero");
        this.especializaciones[6] = new String("Ingeniero Constructor");
        this.especializaciones[7] = new String("Proyectista");
        this.especializaciones[8] = new String("Ingeniero Agrónomo");
        this.especializaciones[9] = new String("Informático");

        for (int i = 0; i <= 9; i++) {
            this.coleccionTrabajadores.agregarColeccionPorProfesion(this.especializaciones[i]);
            //this.registroEspecializaciones.put(this.especializaciones[i], new TreeMap());
        }
    }

    //Aquí se hacen funciones para agregar información a las ventanas(combobox, jtext, etc...) 
    public void llenarComboBoxEspecialidad(JComboBox<String> comboBox) {
        comboBox.removeAllItems();
        for (int i = 0; i <= 9; i++) {

            comboBox.addItem(this.especializaciones[i]);
        }
    }

    public void llenarJTextAreaEspecialidad(JTextArea jTextArea, String especialidad, int valor) {

        ColeccionPorProfesion filtradoProfecion = this.coleccionTrabajadores.getFiltradoPorProfesion(especialidad);

        Trabajador[] listaEmpleados = filtradoProfecion.getListado();
        if (listaEmpleados != null) {
            for (int i = 0; i < listaEmpleados.length; i++) {
                switch (valor) {
                    case 0:
                        jTextArea.append(listaEmpleados[i].getNombre() + '\n');
                        break;
                    case 1:
                        jTextArea.append(String.valueOf(listaEmpleados[i].getRut()) + '\n');
                        break;
                    case 2:
                        jTextArea.append(String.valueOf(listaEmpleados[i].getSueldo()) + '\n');
                        break;
                    case 3:
                        //System.out.println(current.isTrabajando());

                        if (listaEmpleados[i].isTrabajando()) {
                            jTextArea.append("Trabajando" + '\n');
                        } else {
                            jTextArea.append("Desempleado" + '\n');
                        }

                        break;
                    default:
                }
            }
        }
    }

    public void llenarJTextAreaEmpleados(JTextArea jTextArea, boolean bandera) 
    {
        this.listadoTrabajadores.llenarJTextAreaEmpleados(jTextArea, bandera) ;
    }

    public boolean agregarEspecialista(Trabajador trabajador) {
        if (trabajador == null) {
            return false;
        }
        if(!this.coleccionTrabajadores.existenciaEmpleado(trabajador)){
            this.coleccionTrabajadores.agregarEspecialista(trabajador);
            this.listadoTrabajadores.agregarTrabajador(trabajador) ;
            return true ;
        }
        else
        {
            System.out.println("El usuario ya se encuentra papurri");
        }
        
        return false ;
    }

    public boolean modificarEspecialistaNombre(Trabajador especialista, String nuevoNombre) {

        int rut = especialista.getRut();
        ColeccionPorProfesion filtradoProfesion;
        filtradoProfesion = this.coleccionTrabajadores.getFiltradoPorProfesion(especialista.getLaborProfesional());

        Trabajador empleado = filtradoProfesion.getEmpleado(rut);
        if (empleado == null) {
            return false;
        }

        empleado.setNombre(nuevoNombre);
        filtradoProfesion.setEmpleado(empleado);
        
        //this.listadoTrabajadores.modificarEmpleado(empleado) ;
        return true;
    }

    public boolean modificarEspecialistaLaborProfesional(Trabajador especialista, String especialidadNueva) {

        if (!this.coleccionTrabajadores.existenciaEspecializacion(especialidadNueva) && this.coleccionTrabajadores.existenciaEmpleado(especialista)) {
            return false;
        }

        this.coleccionTrabajadores.eliminarEmpleado(especialista);
        especialista.setLaborProfesional(especialidadNueva);
        this.coleccionTrabajadores.agregarEspecialista(especialista);
        
        //this.listadoTrabajadores.modificarEmpleado(especialista) ;
        return true;
    }

    public boolean modificarEspecialistaSueldo(Trabajador especialista, int nuevoSueldo) {

        int rut = especialista.getRut();
        ColeccionPorProfesion filtradoProfesion;
        filtradoProfesion = this.coleccionTrabajadores.getFiltradoPorProfesion(especialista.getLaborProfesional());

        Trabajador empleado = filtradoProfesion.getEmpleado(rut);
        if (empleado == null) {
            return false;
        }

        empleado.setSueldo(nuevoSueldo);
        filtradoProfesion.setEmpleado(empleado);

        //this.listadoTrabajadores.modificarEmpleado(empleado) ;
        return true;
    }

    public Trabajador buscarEspecialista(String especialidad, int rut) {

        ColeccionPorProfesion listadoEmpleados = this.coleccionTrabajadores.getFiltradoPorProfesion(especialidad);
        Trabajador empleado = listadoEmpleados.getEmpleado(rut);

        if (empleado == null) {
            return null;
        }

        return empleado;
    }

    public Trabajador devolverPersona(int index) {
        return this.listadoTrabajadores.retornarIndex(index) ;
    }

    public int numeroDeTrabajadores() {
        return this.listadoTrabajadores.retornarNumeroTrabajadores() ;
    }

    public void llenarComboBoxDePersonas(JComboBox comboBox, boolean estado) {

        this.listadoTrabajadores.llenarComboBoxDePersonas(comboBox, estado) ;
        
    }

    public void despedirEmpleadoRegistro(Obra obraActual, Trabajador empleadoActual) {
        obraActual.despedirEmpleadoObra(empleadoActual.getRut());
        ColeccionPorProfesion listadoEmpleados = this.coleccionTrabajadores.getFiltradoPorProfesion(empleadoActual.getLaborProfesional());
        empleadoActual.setTrabajando(false);
        listadoEmpleados.setEmpleado(empleadoActual);
        
        this.listadoTrabajadores.despedirEmpleado(empleadoActual) ;
        
    }

    public void eliminarEmpleado(Obra obraActual, Trabajador empleadoActual) {

        obraActual.despedirEmpleadoObra(empleadoActual.getRut());

        this.coleccionTrabajadores.eliminarEmpleado(empleadoActual);
        this.listadoTrabajadores.eliminarEmpleado(empleadoActual) ;
        
    }

    public Trabajador[] filtrarPersonas(Obra obraActual, int opcion, long parametro) {
        ArrayList<Trabajador> listadoEmpleadosPorParametro = new ArrayList();
        Trabajador[] listaEmpleadosObra = new Trabajador[obraActual.getNumeroEmpleados()];
        obraActual.getListadoPersonas(listaEmpleadosObra);
        int i;
        if (opcion == 0) //menor que
        {
            for (i = 0; i < listaEmpleadosObra.length; i++) {
                if (listaEmpleadosObra[i].getSueldo() < parametro) {
                    listadoEmpleadosPorParametro.add(listaEmpleadosObra[i]);
                }
            }
            Trabajador[] EmpleadosFiltrados = new Trabajador[listadoEmpleadosPorParametro.size()];

            for (i = 0; i < listadoEmpleadosPorParametro.size(); i++) {
                EmpleadosFiltrados[i] = listadoEmpleadosPorParametro.get(i);
            }
            return EmpleadosFiltrados;
        }
        if (opcion == 1)//mayor que
        {
            for (i = 0; i < listaEmpleadosObra.length; i++) {
                if (listaEmpleadosObra[i].getSueldo() > parametro) {
                    listadoEmpleadosPorParametro.add(listaEmpleadosObra[i]);
                }
            }
            Trabajador[] EmpleadosFiltrados = new Trabajador[listadoEmpleadosPorParametro.size()];

            for (i = 0; i < listadoEmpleadosPorParametro.size(); i++) {
                EmpleadosFiltrados[i] = listadoEmpleadosPorParametro.get(i);
            }
            return EmpleadosFiltrados;
        }
        return null;
    }

    public Trabajador filtrarPersonas(Obra obraSeleccionada, int opcion) {
        int i;
        Trabajador[] listaEmpleados = new Trabajador[obraSeleccionada.getNumeroEmpleados()];
        obraSeleccionada.getListadoPersonas(listaEmpleados);
        Trabajador empleadoSeleccionado = listaEmpleados[0];

        if (opcion == 2) //maximo
        {
            for (i = 1; i < listaEmpleados.length; i++) {
                if (empleadoSeleccionado.getSueldo() < listaEmpleados[i].getSueldo()) {
                    empleadoSeleccionado = listaEmpleados[i];
                }
            }
            return empleadoSeleccionado;
        }
        if (opcion == 3) //minimo
        {
            for (i = 1; i < listaEmpleados.length; i++) {
                if (empleadoSeleccionado.getSueldo() > listaEmpleados[i].getSueldo()) {
                    empleadoSeleccionado = listaEmpleados[i];
                }
            }
            return empleadoSeleccionado;
        }

        return null;
    }
}
