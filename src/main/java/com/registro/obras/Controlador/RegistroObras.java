/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registro.obras.Controlador;

import com.registro.obras.Modelo.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

/**
 *
 * @author Ceseo
 */
public class RegistroObras {

    int contadorObras;

    private ArrayList<String> listadoRegiones;
    private ColeccionNacionalObra coleccionNacionalObra;
    private ColeccionGeneralObra coleccionGeneralObra;
    public ListaProyectoInterfaz listaCompletaInterfaz;
    //public ArrayList<ProyectoReportable> listaCompletaInterfaz;

    public RegistroObras() {
        this.listadoRegiones = new ArrayList();
        this.listaCompletaInterfaz = new ListaProyectoInterfaz();
        //this.listaCompletaInterfaz = new ArrayList();
        this.coleccionNacionalObra = new ColeccionNacionalObra();
        this.coleccionGeneralObra = new ColeccionGeneralObra();
        llenarArray();

        for (int i = 0; i < listadoRegiones.size(); i++) {
            this.coleccionNacionalObra.agregarColeccionRegional(listadoRegiones.get(i));
        }
    }

    public Obra retornarObra(int index) {

        return this.coleccionGeneralObra.retornarObra(index);//listaCompleta.get(index);
    }

    public Obra retornarObra(String nombreObra) {

        if (this.existenciaObra(nombreObra)) {
            Obra obraPedida = this.coleccionGeneralObra.retornarObra(nombreObra);//this.registro.get(nombreObra);
            return obraPedida;
        }
        return null;
    }

    public Obra retornarObra(String nombre, String nombreRegion) {
        return this.coleccionNacionalObra.obtenerColeccionRegion(nombreRegion).obtenerObra(nombre);
    }

    public int retornarTipoObra(String nombreObra) {
        Obra obraEvaluar = this.retornarObra(nombreObra);
        return obraEvaluar.getCodigo();
    }

    public ColeccionRegionalObra[] obtenerColeccionNacionalArray() {
        return this.coleccionNacionalObra.retornarColeccionNacional();
    }

    public void llenarComboBoxObras(JComboBox<Obra> comboBoxObra, boolean bandera) {
        comboBoxObra.removeAllItems();

        if (bandera == true) {
            comboBoxObra.addItem(new ProyectoConstruccion("Sin Obra", "Metropolitana", "25-11-2056", 556,0));
        }

        Obra current;
        for (int i = 0; i < this.numeroObras(); i++) {
            current = this.coleccionGeneralObra.retornarObra(i);//listaCompleta.get(i);
            comboBoxObra.addItem(current);
        }
    }

// modificar    
    public void llenarComboBoxObrasInterfaz(JComboBox<ProyectoReportable> comboBoxObra) {

        this.listaCompletaInterfaz.llenarComboBoxObrasInterfaz(comboBoxObra);
        /*comboBoxObra.removeAllItems();
        ProyectoReportable current;
        for (int i = 0; i < listaCompletaInterfaz.size(); i++) {
            current = listaCompletaInterfaz.get(i);
            comboBoxObra.addItem((ProyectoReportable) current);
        }*/
    }

    public void llenarComboBoxObras(JComboBox<Obra> comboBoxObra, String region, boolean bandera) {

        if (region == null || region.equals("Todas las regiones")) {
            llenarComboBoxObras(comboBoxObra, bandera);
            return;
        }

        ColeccionRegionalObra registroRegional = this.coleccionNacionalObra.obtenerColeccionRegion(region);

        comboBoxObra.removeAllItems();

        registroRegional.llenarComboBoxObra(comboBoxObra);
    }

//modificar    
    public void llenarComboBoxObrasInterfaz(JComboBox<ProyectoReportable> comboBoxObra, String region) {

        if (region.equals("Todas las regiones") || (region == null)) {
            llenarComboBoxObrasInterfaz(comboBoxObra);
            return;
        }

        ColeccionRegionalObra coleccionRegional = this.coleccionNacionalObra.obtenerColeccionRegion(region);

        comboBoxObra.removeAllItems();

        coleccionRegional.llenarComboBoxObrasInterfaz(comboBoxObra);

    }

    public void llenarComoBoxRegiones(JComboBox<String> comboBoxRegiones) {

        comboBoxRegiones.removeAllItems();
        String regionActual;
        comboBoxRegiones.addItem("Todas las regiones");
        for (int i = 0; i < this.listadoRegiones.size(); i++) {
            regionActual = this.listadoRegiones.get(i);

            comboBoxRegiones.addItem(regionActual);
        }
    }

    public void llenarComboBoxEmpleadosRegistro(JComboBox<Persona> comboBoxObra, String nombreObra) {

        Obra obraSeleccionada = this.coleccionGeneralObra.retornarObra(nombreObra);//this.registro.get(nombreObra);
        if (obraSeleccionada != null) {
            System.out.println("Valido");
            obraSeleccionada.llenarComboBoxEmpleados(comboBoxObra);
        }

        //this.listaCompleta.ge
        if (this.contadorObras > 0 && obraSeleccionada == null) {
            obraSeleccionada = this.coleccionGeneralObra.retornarObra(nombreObra);//this.listaCompleta.get(0);
            obraSeleccionada.llenarComboBoxEmpleados(comboBoxObra);
        }

    }

    public Boolean existenciaObra(String obra) {
        //System.out.println(obra);        
        return this.coleccionGeneralObra.existenciaObra(obra);

    }

    public void llenarComboBoxEmpleadosRegistro(JComboBox<Persona> comboBoxObra, String nombreObra, int contadorObras) {

        Obra obraSeleccionada = this.coleccionGeneralObra.retornarObra(nombreObra);// this.registro.get(nombreObra);
        if (obraSeleccionada != null) {
            System.out.println("Valido");
            obraSeleccionada.llenarComboBoxEmpleados(comboBoxObra);
        }

        //this.listaCompleta.ge
        if (contadorObras > 0 && obraSeleccionada == null) {
            obraSeleccionada = this.coleccionGeneralObra.retornarObra(0);//listaCompleta.get(0);
            obraSeleccionada.llenarComboBoxEmpleados(comboBoxObra);
        }

    }

    public void llenarJTextAreaEmpleadosRegistro(JTextArea jTextArea, int valor, String nombreObra) {
        Obra obraSeleccionada = this.coleccionGeneralObra.retornarObra(nombreObra);//this.registro.get(nombreObra);
        if (obraSeleccionada != null) {
            obraSeleccionada.llenarJTextAreaEmpleados(jTextArea, valor);
        }
    }

    public long getGastosObra(Obra nombreObra) {
        return nombreObra.gastosObra();
    }

    public boolean agregarObra(Obra obraAgregar) { //Listo        

        if (obraAgregar != null && !existenciaObra(obraAgregar.getNombreObra())) {
            if (obraAgregar.getCodigo() != 3) {
                switch (obraAgregar.getCodigo()) {
                    case 1:
                        if (FechaHoy.verificarEstructura(((ProyectoConstruccion) obraAgregar).getTiempoRestante().toCharArray())) {
                            this.listaCompletaInterfaz.agregarObra((ProyectoConstruccion) obraAgregar);
                        }
                        else return false ; 
                        
                        break;

                    case 2:
                        if (FechaHoy.verificarEstructura(((ProyectoRestauracion) obraAgregar).getTiempoRestante().toCharArray())) {
                            this.listaCompletaInterfaz.agregarObra((ProyectoRestauracion) obraAgregar);
                        }
                        else return false ; 
                        
                        break;
                }
            }
            if (!this.coleccionGeneralObra.agregarObra(obraAgregar)) {
                return false;
            }

            if (!this.coleccionNacionalObra.agregarObra(obraAgregar)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public Obra[] filtrarObrasPresupuesto(long parametro, int opcion) {

        return this.coleccionGeneralObra.filtrarObrasPresupuesto(parametro, opcion);
    }

    public Obra filtrarObrasPresupuesto(int opcion) {

        return this.coleccionGeneralObra.filtrarObrasPresupuesto(opcion);
    }

    public int eliminarObra(String nombreObra, RegistroObras registroObras) throws IOException //Listo
    {
        //en el archivo se elimina la obra original y se vuelve a crear el registro sin esta
        if (existenciaObra(nombreObra)) {

            Obra ObraEliminar = this.coleccionGeneralObra.retornarObra(nombreObra);//registro.get(nombreObra);
            ObraEliminar.eliminarObra();

            coleccionNacionalObra.eliminarObra(ObraEliminar);
            this.coleccionGeneralObra.eliminarObra(ObraEliminar);
            this.listaCompletaInterfaz.eliminarObra((ProyectoReportable) ObraEliminar);
            //this.listaCompletaInterfaz.remove((ProyectoReportable) ObraEliminar);

            //WriteFile.eliminarDefinitivo(new File("RegistroObras//" + ObraEliminar.getNombreLugar() + "//" + ObraEliminar.getNombreObra()));
            //WriteFile.escribirObras(',', registroObras);

            //return this.registro.size();
            return this.coleccionGeneralObra.numeroObras();
        }
        return -1;
    }

    public boolean modificarObra(String nombreObra, String nuevoDato, int opcion, RegistroObras registroActual) throws IOException //Listo
    {
        //en el archivo se elimina la obra anterior y se vuelve a crear esta pero con el dato cambiado

        //nombreObra es el nombre actual de la obra a editar
        //nuevoDato es el dato a editar que puedeser de cualquier atributo dentro del objeto Obra
        //opcion guardaria la hipotetica opcion a modificar por el usuario seleccionada en el menu
        System.out.println(nombreObra);
        if (existenciaObra(nombreObra)) {

            String lugar = this.coleccionGeneralObra.retornarObra(nombreObra).getNombreLugar();//this.registro.get(nombreObra).getNombreLugar();
            Obra remplazo = this.coleccionGeneralObra.retornarObra(nombreObra);//this.registro.get(nombreObra);
            switch (opcion) {
                case 1: //Cambiar nombre
                {
                    if (this.existenciaObra(nuevoDato)) {
                        return false;
                    }
                    this.coleccionGeneralObra.eliminarObra(remplazo);
                    this.coleccionNacionalObra.eliminarObra(remplazo);

                    remplazo.setNombreObra(nuevoDato);
                    this.coleccionNacionalObra.agregarObra(remplazo);
                    this.coleccionGeneralObra.agregarObra(remplazo);
                    remplazo.cambiarNombre();
                    WriteFile.eliminarDefinitivo(new File("RegistroObras//" + lugar + "//" + nombreObra));
                    WriteFile.escribirObras(',', registroActual);

                    return true;
                }
                case 2: //Cambiar region
                {
                    if(!this.listadoRegiones.contains(nuevoDato)) return false ;
                    this.coleccionGeneralObra.eliminarObra(remplazo);
                    this.coleccionNacionalObra.eliminarObra(remplazo);
                    remplazo.setNombreLugar(nuevoDato);

                    if(this.coleccionNacionalObra.agregarObra(remplazo));
                    this.coleccionGeneralObra.agregarObra(remplazo);

                    this.coleccionNacionalObra.obtenerColeccionRegion(lugar).agregarObra(remplazo);

                    WriteFile.eliminarDefinitivo(new File("RegistroObras//" + lugar + "//" + nombreObra));
                    WriteFile.escribirObras(',', registroActual);
                    return true;
                }
                case 3: //Cambiar tiempo restante y cambiar el interes
                {
                    //remplazo.setTiempoParaTerminarObra(nuevoDato) ;
                    int tipoObra = retornarTipoObra(nombreObra);
                    switch (tipoObra) {
                        case 1: {
                            ((ProyectoConstruccion) (remplazo)).setTiempoRestante(nuevoDato);
                            break;
                        }
                        case 2: {
                            ((ProyectoRestauracion) (remplazo)).setTiempoRestante(nuevoDato);
                            break;
                        }
                        case 3: {
                            try {
                                double nuevoInteres = Double.parseDouble(nuevoDato);
                                ((ServicioMantencion) (remplazo)).setInteresAnual(nuevoInteres);
                            } catch (NumberFormatException e) {
                                System.out.println(e.getMessage());
                                //ventana de error
                            }

                        }

                    }
                    break;
                }
                case 4: //Cambiar presupuesto y presupuesto anual
                {
                    int tipoObra = retornarTipoObra(nombreObra);
                    switch (tipoObra) {
                        case 1: {
                            try {
                                long nuevoPresupuesto = Long.parseLong(nuevoDato);
                                ((ProyectoConstruccion) (remplazo)).setPresupuesto(nuevoPresupuesto);
                                break;
                            } catch (NumberFormatException e) {
                                //ventana de error
                            }

                        }
                        case 2: {
                            try {
                                long nuevoPresupuesto = Long.parseLong(nuevoDato);
                                ((ProyectoRestauracion) (remplazo)).setPresupuesto(nuevoPresupuesto);
                                break;
                            } catch (NumberFormatException e) {
                                return false;
                                //ventana de error
                            }

                        }
                        case 3: {
                            try {
                                long nuevoPresupuesto = Long.parseLong(nuevoDato);
                                ((ServicioMantencion) (remplazo)).setMantenimientoMonetarioAnual(nuevoPresupuesto);
                                break;
                            } catch (NumberFormatException e) {
                                return false;
                                //ventana de error
                            }

                        }

                    }
                    break;
                }
                case 5: {
                    if (nuevoDato.equals("false")) {
                        ((ServicioMantencion) (remplazo)).setOperativo(false);
                    } else {
                        ((ServicioMantencion) (remplazo)).setOperativo(true);
                    }
                }
                case 6:{
                    this.coleccionGeneralObra.eliminarObra(remplazo);
                    this.coleccionNacionalObra.eliminarObra(remplazo);

                    if(remplazo.getCodigo() == 1)
                    {
                        ((ProyectoConstruccion)(remplazo)).setFase();
                    }
                    if(remplazo.getCodigo() == 2)
                    {
                        ((ProyectoRestauracion)(remplazo)).setFase();
                    }
                    this.coleccionNacionalObra.agregarObra(remplazo);
                    this.coleccionGeneralObra.agregarObra(remplazo);
                    WriteFile.eliminarDefinitivo(new File("RegistroObras//" + lugar + "//" + nombreObra));
                    WriteFile.escribirObras(',', registroActual);
                    return true;
                }

            }

            WriteFile.eliminarDefinitivo(new File("RegistroObras//" + remplazo.getNombreLugar() + "//" + remplazo.getNombreObra()));
            WriteFile.escribirObras(',', registroActual);
            return true;
        }
        return false;
    }

    public void presupuestoGeneral() //presupuesto total de la compañia
    {
        this.coleccionGeneralObra.presupuestoGeneral();

    }

// modificar    
    public long gatosTotales() {

        return this.coleccionGeneralObra.gatosTotales();

    }

    public long ingresosTotales() {
        return this.coleccionGeneralObra.ingresosTotales();

    }

// eliminar    
    private void llenarArray() {
        this.listadoRegiones.add("Tarapaca");
        this.listadoRegiones.add("Antofagasta");
        this.listadoRegiones.add("Atacama");
        this.listadoRegiones.add("Coquimbo");
        this.listadoRegiones.add("Valparaiso");
        this.listadoRegiones.add("O'higgins");
        this.listadoRegiones.add("Maule");
        this.listadoRegiones.add("Biobio");
        this.listadoRegiones.add("Araucania");
        this.listadoRegiones.add("Los Lagos");
        this.listadoRegiones.add("Aysen");
        this.listadoRegiones.add("Magallanes");
        this.listadoRegiones.add("Metropolitana");
        this.listadoRegiones.add("Los Rios");
        this.listadoRegiones.add("Arica y Parinacota");
        this.listadoRegiones.add("Ñuble");
    }

    boolean existenciaRegion(String nombre) {
        for (int i = 0; i < this.listadoRegiones.size(); i++) {
            if (nombre.equals(this.listadoRegiones.get(i))) {
                //System.out.println(nombre +" "+ listadoRegiones.get(i));
                return true;
            }
        }
        return false;
    }

    long numeroObras() {
        //System.out.println(this.registro.size());
        return this.coleccionGeneralObra.numeroObras();
    }

    
}
