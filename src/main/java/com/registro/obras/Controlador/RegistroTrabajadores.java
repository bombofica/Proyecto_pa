package com.registro.obras.Controlador;

import com.registro.obras.Modelo.*;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class RegistroTrabajadores {
    
    //Variables de instancia
    private String[] especializaciones;
    private ListaTrabajadores listadoTrabajadores ; //encapsulacion del ArrayList que contiene todos los trabajadores de la plataforma
    private ColeccionTrabajadores coleccionTrabajadores; //HashMap que contiene los trabajadores filtrados por profecion

    //constructor
    public RegistroTrabajadores() {

        this.listadoTrabajadores = new ListaTrabajadores() ;
        this.coleccionTrabajadores = new ColeccionTrabajadores() ;
        
        //listado con todas las especializaciones
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

    //Metodos privados
    public boolean agregarEspecialista(Trabajador trabajador) {
        if (trabajador == null) {
            return false;
        }
        if(!this.coleccionTrabajadores.existenciaEmpleado(trabajador)){
            this.coleccionTrabajadores.agregarEspecialista(trabajador);
            this.listadoTrabajadores.agregarTrabajador(trabajador) ;
            return true ;

        }
        

        return false ;
    }

    public boolean modificarEspecialistaNombre(Trabajador especialista, String nuevoNombre) {
        
        //Primero se verifica la existencia del empleado
        int rut = especialista.getRut();
        ColeccionPorProfesion filtradoProfesion;
        filtradoProfesion = this.coleccionTrabajadores.getFiltradoPorProfesion(especialista.getLaborProfesional());
        
        Trabajador empleado = filtradoProfesion.getEmpleado(rut);
        if (empleado == null) {
            return false;
        }        
        //Luego se modifica en la aplicacion
        empleado.setNombre(nuevoNombre);
        filtradoProfesion.setEmpleado(empleado);
        
        return true;
    }

    public boolean modificarEspecialistaLaborProfesional(Trabajador especialista, String especialidadNueva) {

        //Se verifica la existencia de la especializacion
        if (!this.coleccionTrabajadores.existenciaEspecializacion(especialidadNueva) && this.coleccionTrabajadores.existenciaEmpleado(especialista)) {
            return false;
        }
        //se aplican los cambios
        this.coleccionTrabajadores.eliminarEmpleado(especialista);
        especialista.setLaborProfesional(especialidadNueva);
        this.coleccionTrabajadores.agregarEspecialista(especialista);
        
        return true;
    }

    public boolean modificarEspecialistaSueldo(Trabajador especialista, int nuevoSueldo) {

        //Primero se verifica la existencia del empleado
        int rut = especialista.getRut();
        ColeccionPorProfesion filtradoProfesion;
        filtradoProfesion = this.coleccionTrabajadores.getFiltradoPorProfesion(especialista.getLaborProfesional());

        Trabajador empleado = filtradoProfesion.getEmpleado(rut);
        if (empleado == null) {
            return false;
        }
        //Luego se modifica en la aplicacion
        empleado.setSueldo(nuevoSueldo);
        filtradoProfesion.setEmpleado(empleado);

        return true;
    }

    public Trabajador buscarEspecialista(String especialidad, int rut) {
        //Se busca al empleado
        ColeccionPorProfesion listadoEmpleados = this.coleccionTrabajadores.getFiltradoPorProfesion(especialidad);
        Trabajador empleado = listadoEmpleados.getEmpleado(rut);

        if (empleado == null) {
            return null;
        }
        //se retorna al empleado
        return empleado;
    }

    public Trabajador devolverPersona(int index) { //Busca en el listado general
        return this.listadoTrabajadores.retornarIndex(index) ;
    }

    public int numeroDeTrabajadores() { //Busca en el listado general
        return this.listadoTrabajadores.retornarNumeroTrabajadores() ;
    }

    public void llenarComboBoxDePersonas(JComboBox comboBox, boolean estado){ //Busca en el listado general
        this.listadoTrabajadores.llenarComboBoxDePersonas(comboBox, estado) ;       
    }

    public void despedirEmpleadoRegistro(Obra obraActual, Trabajador empleadoActual){
        //inicialmente se despide al empleado de la obra
        obraActual.despedirEmpleadoObra(empleadoActual.getRut());
        //Se debe modificar cada una de la estructuras que poseean a este empleado
        ColeccionPorProfesion listadoEmpleados = this.coleccionTrabajadores.getFiltradoPorProfesion(empleadoActual.getLaborProfesional());
        empleadoActual.setTrabajando(false);
        listadoEmpleados.setEmpleado(empleadoActual);
        
        this.listadoTrabajadores.despedirEmpleado(empleadoActual) ;
        
    }

    public void eliminarEmpleado(Obra obraActual, Trabajador empleadoActual){
        //inicialmente se despide al empleado de la obra
        obraActual.despedirEmpleadoObra(empleadoActual.getRut());
        //Luego este empleado es eliminado de la plataforma
        this.coleccionTrabajadores.eliminarEmpleado(empleadoActual);
        this.listadoTrabajadores.eliminarEmpleado(empleadoActual) ;
        
    }

    public Trabajador[] filtrarPersonas(Obra obraActual, int opcion, long parametro){
        //Inicialmente se crea un ArrayList que guardara a los empleados filtrados
        ArrayList<Trabajador> listadoEmpleadosPorParametro = new ArrayList();
        //Se consigue la lista de empleados de la obra
        Trabajador[] listaEmpleadosObra = new Trabajador[obraActual.getNumeroEmpleados()];
        obraActual.getListadoPersonas(listaEmpleadosObra);
        int i;
        //luego se comienzan a plicar los filtros al sueldo ya sea mayor o menor al parametro ingresado
        if (opcion == 0) //menor que
        {
            //Se recorre el arreglo y se añade al ArrayList los empleados que cumplan la condicion
            for (i = 0; i < listaEmpleadosObra.length; i++) {
                if (listaEmpleadosObra[i].getSueldo() < parametro) {
                    listadoEmpleadosPorParametro.add(listaEmpleadosObra[i]);
                }
            }
            //Se crea el arreglo que se retornara
            Trabajador[] EmpleadosFiltrados = new Trabajador[listadoEmpleadosPorParametro.size()];
            //Se llena el arreglo
            for (i = 0; i < listadoEmpleadosPorParametro.size(); i++) {
                EmpleadosFiltrados[i] = listadoEmpleadosPorParametro.get(i);
            }
            //retorno
            return EmpleadosFiltrados;
        }
        if (opcion == 1)//mayor que
        {
            //Se recorre el arreglo y se añade al ArrayList los empleados que cumplan la condicion
            for (i = 0; i < listaEmpleadosObra.length; i++) {
                if (listaEmpleadosObra[i].getSueldo() > parametro) {
                    listadoEmpleadosPorParametro.add(listaEmpleadosObra[i]);
                }
            }
            //Se crea el arreglo que se retornara
            Trabajador[] EmpleadosFiltrados = new Trabajador[listadoEmpleadosPorParametro.size()];
            //Se llena el arreglo
            for (i = 0; i < listadoEmpleadosPorParametro.size(); i++) {
                EmpleadosFiltrados[i] = listadoEmpleadosPorParametro.get(i);
            }
            //retorno
            return EmpleadosFiltrados;
        }
        return null;
    }

    public Trabajador filtrarPersonas(Obra obraSeleccionada, int opcion){
        //Se necesita de la lista completa de empleados de una obra
        Trabajador[] listaEmpleados = new Trabajador[obraSeleccionada.getNumeroEmpleados()];
        obraSeleccionada.getListadoPersonas(listaEmpleados);
        Trabajador empleadoSeleccionado = listaEmpleados[0];
        int i;
        if (opcion == 2) //maximo
        {
            //Se busca el empleado con el maximo sueldo dentro de quien trabaja en esta obra
            for (i = 1; i < listaEmpleados.length; i++) {
                if (empleadoSeleccionado.getSueldo() < listaEmpleados[i].getSueldo()) {
                    empleadoSeleccionado = listaEmpleados[i];
                }
            }            
            return empleadoSeleccionado;
        }
        if (opcion == 3) //minimo
        {
            //Se busca el empleado con el minimo sueldo dentro de quien trabaja en esta obra
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
