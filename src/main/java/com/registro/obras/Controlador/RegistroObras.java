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
//    private HashMap <String, TreeMap<String, Obra>> regiones;

    private ColeccionNacionalObra coleccionNacionalObra;
    private ColeccionGeneralObra coleccionGeneralObra;

    //private HashMap<String, Obra> registro;
    //private ArrayList<Obra> listaCompleta;

    private ArrayList<String> listadoRegiones;

    public ArrayList<ProyectoReportable> listaCompletaInterfaz;

    // modificar
    public RegistroObras() {
        this.listadoRegiones = new ArrayList();
        //this.registro = new HashMap();
        //this.listaCompleta = new ArrayList();
        this.listaCompletaInterfaz = new ArrayList();
//        this.regiones = new HashMap();

        this.coleccionNacionalObra = new ColeccionNacionalObra();
        this.coleccionGeneralObra = new ColeccionGeneralObra();
        llenarArray();

        for (int i = 0; i < listadoRegiones.size(); i++) {
            this.coleccionNacionalObra.agregarColeccionRegional(listadoRegiones.get(i));

        }
    }

// modificar    
    public Obra retornarObra(int index) {

        return this.coleccionGeneralObra.retornarObra(index);//listaCompleta.get(index);
    }

// modificar    
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

    //public HashMap <String, TreeMap<String, Obra>> obtenerHashRegiones(){
    //    return this.regiones;}
    public ColeccionRegionalObra[] obtenerColeccionNacionalArray() {
        return this.coleccionNacionalObra.retornarColeccionNacional();
    }

    public void llenarComboBoxObras(JComboBox<Obra> comboBoxObra, boolean bandera) {
        comboBoxObra.removeAllItems();

        if (bandera == true) {
            comboBoxObra.addItem(new ProyectoConstruccion("Sin Obra", "Metropolitana", "25-11-2056", 556));
        }

        Obra current;
        for (int i = 0; i < this.numeroObras(); i++) {
            current = this.coleccionGeneralObra.retornarObra(i);//listaCompleta.get(i);
            comboBoxObra.addItem(current);
        }
    }

// modificar    
    public void llenarComboBoxObrasInterfaz(JComboBox<ProyectoReportable> comboBoxObra) {
        comboBoxObra.removeAllItems();
        ProyectoReportable current;
        for (int i = 0; i < listaCompletaInterfaz.size(); i++) {
            current = listaCompletaInterfaz.get(i);
            comboBoxObra.addItem((ProyectoReportable) current);
        }
    }

    public void llenarComboBoxObras(JComboBox<Obra> comboBoxObra, String region, boolean bandera) {

        if (region == null || region.equals("Todas las regiones")) {
            llenarComboBoxObras(comboBoxObra, bandera);
            return;
        }

        //TreeMap<String, Obra> registroRegional = this.regiones.get(region) ;
        ColeccionRegionalObra registroREgional = this.coleccionNacionalObra.obtenerColeccionRegion(region);

        comboBoxObra.removeAllItems();

        registroREgional.llenarComboBoxObra(comboBoxObra);
    }

//modificar    
    public void llenarComboBoxObrasInterfaz(JComboBox<ProyectoReportable> comboBoxObra, String region) {

        if (region.equals("Todas las regiones") || (region == null)) {
            llenarComboBoxObrasInterfaz(comboBoxObra);
            return;
        }
//        TreeMap<String, Obra> registroRegional = this.regiones.get(region) ;

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
            obraSeleccionada = this.coleccionGeneralObra.retornarObra(0) ;//listaCompleta.get(0);
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

            if(!this.coleccionGeneralObra.agregarObra(obraAgregar)){
                return false;
            }
            
            if(!this.coleccionNacionalObra.agregarObra(obraAgregar)){
                return false;
            }

            if (obraAgregar.getCodigo() != 3) {
                switch (obraAgregar.getCodigo()) {
                    case 1:
                        if (FechaHoy.verificarEstructura(((ProyectoConstruccion) obraAgregar).getTiempoRestante().toCharArray())) {
                            this.listaCompletaInterfaz.add((ProyectoConstruccion) obraAgregar);
                        }
                        break;

                    case 2:
                        if (FechaHoy.verificarEstructura(((ProyectoRestauracion) obraAgregar).getTiempoRestante().toCharArray())) {
                            this.listaCompletaInterfaz.add((ProyectoRestauracion) obraAgregar);
                        }
                        break;
                }
            }
            
            return true;   
        }
        return false;
    }

    public Obra[] filtrarObrasPresupuesto(long parametro, int opcion) {
        
        /*
        ArrayList<Obra> filtrador = new ArrayList();
        int i;
        if (opcion == 0) //menor que
        {
            for (i = 0; i < this.listaCompleta.size(); i++) {
                if ((listaCompleta.get(i).getCodigo() == 1) && ((ProyectoConstruccion) (listaCompleta.get(i))).getPresupuesto() < parametro) {
                    filtrador.add(listaCompleta.get(i));
                }
                if ((listaCompleta.get(i).getCodigo() == 2) && ((ProyectoRestauracion) (listaCompleta.get(i))).getPresupuesto() < parametro) {
                    filtrador.add(listaCompleta.get(i));
                }
            }
            Obra[] listadoFiltrado = new Obra[filtrador.size()];
            for (i = 0; i < filtrador.size(); i++) {
                listadoFiltrado[i] = filtrador.get(i);
            }
            return listadoFiltrado;
        }
        if (opcion == 1) //mayor que
        {
            for (i = 0; i < this.listaCompleta.size(); i++) {
                if ((listaCompleta.get(i).getCodigo() == 1) && ((ProyectoConstruccion) (listaCompleta.get(i))).getPresupuesto() > parametro) {
                    filtrador.add(listaCompleta.get(i));
                }
                if ((listaCompleta.get(i).getCodigo() == 2) && ((ProyectoRestauracion) (listaCompleta.get(i))).getPresupuesto() > parametro) {
                    filtrador.add(listaCompleta.get(i));
                }
            }
            Obra[] listadoFiltrado = new Obra[filtrador.size()];
            for (i = 0; i < filtrador.size(); i++) {
                listadoFiltrado[i] = filtrador.get(i);
            }
            return listadoFiltrado;
        }
        return null;*/
        return this.coleccionGeneralObra.filtrarObrasPresupuesto(parametro, opcion);
    }

    public Obra filtrarObrasPresupuesto(int opcion) {
/*        int i;
        Obra obraSeleccionada = null;
        for (i = 0; i < this.listaCompleta.size(); i++) {
            if (this.listaCompleta.get(i).getCodigo() == 1) {
                obraSeleccionada = retornarObra(i);
                break;
            }
            if (this.listaCompleta.get(i).getCodigo() == 1) {
                obraSeleccionada = retornarObra(i);
                break;
            }
        }
        if (obraSeleccionada != null) {
            if (opcion == 2) //maximo
            {
                int codigo;
                for (i = 0; i < this.listaCompleta.size(); i++) {
                    codigo = obraSeleccionada.getCodigo();
                    if (codigo == 1) {
                        if (this.listaCompleta.get(i).getCodigo() == 1) {
                            if (((ProyectoConstruccion) (obraSeleccionada)).getPresupuesto() < ((ProyectoConstruccion) (this.listaCompleta.get(i))).getPresupuesto()) {
                                obraSeleccionada = this.listaCompleta.get(i);
                                continue;
                            }
                        }
                        if (this.listaCompleta.get(i).getCodigo() == 2) {
                            if (((ProyectoConstruccion) (obraSeleccionada)).getPresupuesto() < ((ProyectoRestauracion) (this.listaCompleta.get(i))).getPresupuesto()) {
                                obraSeleccionada = this.listaCompleta.get(i);
                                continue;
                            }
                        }
                    }
                    if (codigo == 2) {
                        if (this.listaCompleta.get(i).getCodigo() == 1) {
                            if (((ProyectoRestauracion) (obraSeleccionada)).getPresupuesto() < ((ProyectoConstruccion) (this.listaCompleta.get(i))).getPresupuesto()) {
                                obraSeleccionada = this.listaCompleta.get(i);
                                continue;
                            }
                        }
                        if (this.listaCompleta.get(i).getCodigo() == 2) {
                            if (((ProyectoRestauracion) (obraSeleccionada)).getPresupuesto() < ((ProyectoRestauracion) (this.listaCompleta.get(i))).getPresupuesto()) {
                                obraSeleccionada = this.listaCompleta.get(i);
                            }
                        }
                    }
                }
                return obraSeleccionada;
            }
            if (opcion == 3) //minimo
            {
                int codigo;
                for (i = 0; i < this.listaCompleta.size(); i++) {
                    codigo = obraSeleccionada.getCodigo();
                    if (codigo == 1) {
                        if (this.listaCompleta.get(i).getCodigo() == 1) {
                            if (((ProyectoConstruccion) (obraSeleccionada)).getPresupuesto() > ((ProyectoConstruccion) (this.listaCompleta.get(i))).getPresupuesto()) {
                                obraSeleccionada = this.listaCompleta.get(i);
                                continue;
                            }
                        }
                        if (this.listaCompleta.get(i).getCodigo() == 2) {
                            if (((ProyectoConstruccion) (obraSeleccionada)).getPresupuesto() > ((ProyectoRestauracion) (this.listaCompleta.get(i))).getPresupuesto()) {
                                obraSeleccionada = this.listaCompleta.get(i);
                                continue;
                            }
                        }
                    }
                    if (codigo == 2) {
                        if (this.listaCompleta.get(i).getCodigo() == 1) {
                            if (((ProyectoRestauracion) (obraSeleccionada)).getPresupuesto() > ((ProyectoConstruccion) (this.listaCompleta.get(i))).getPresupuesto()) {
                                obraSeleccionada = this.listaCompleta.get(i);
                                continue;
                            }
                        }
                        if (this.listaCompleta.get(i).getCodigo() == 2) {
                            if (((ProyectoRestauracion) (obraSeleccionada)).getPresupuesto() > ((ProyectoRestauracion) (this.listaCompleta.get(i))).getPresupuesto()) {
                                obraSeleccionada = this.listaCompleta.get(i);
                            }
                        }
                    }
                }
                return obraSeleccionada;
            }
        }

        return null;*/
        return this.coleccionGeneralObra.filtrarObrasPresupuesto(opcion);
    }

    public int eliminarObra(String nombreObra, RegistroObras registroObras) throws IOException //Listo
    {
        //en el archivo se elimina la obra original y se vuelve a crear el registro sin esta
        if (existenciaObra(nombreObra)) {
            
            Obra ObraEliminar = this.coleccionGeneralObra.retornarObra(nombreObra);//registro.get(nombreObra);
            ObraEliminar.eliminarObra();  
            //this.registro.remove(nombreObra);
            
            coleccionNacionalObra.eliminarObra(ObraEliminar);
            this.coleccionGeneralObra.eliminarObra(ObraEliminar);
            

            //this.regiones.get(lugar).remove(nombreObra) ;
            //this.listaCompleta.remove(ObraEliminar);
            
            this.listaCompletaInterfaz.remove((ProyectoReportable) ObraEliminar);

            WriteFile.eliminarDefinitivo(new File("RegistroObras//" + ObraEliminar.getNombreLugar() + "//" + ObraEliminar.getNombreObra()));
            WriteFile.escribirObras(',', registroObras);

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
         
                    //this.registro.remove(nombreObra);
                    this.coleccionGeneralObra.eliminarObra(remplazo);
                    
                    this.coleccionNacionalObra.eliminarObra(remplazo);
                    
                    remplazo.setNombreObra(nuevoDato);
                    
                    this.coleccionNacionalObra.agregarObra(remplazo);
                    this.coleccionGeneralObra.agregarObra(remplazo);

                    //this.regiones.get(lugar).remove(nombreObra) ;
                    //this.regiones.get(lugar).put(remplazo.getNombreLugar(), remplazo) ; 
                    //this.registro.put(remplazo.getNombreObra(), remplazo);
                    remplazo.cambiarNombre();
                    WriteFile.eliminarDefinitivo(new File("RegistroObras//" + lugar + "//" + nombreObra));
                    WriteFile.escribirObras(',', registroActual);
                    return true;
                }
                case 2: //Cambiar region
                {
                    //verificador = regiones.get(lugar) ;

                    //this.coleccionNacionalObra.obtenerColeccionRegion(lugar).eliminarObra(registro.get(nombreObra));
                    this.coleccionGeneralObra.eliminarObra(remplazo);
                    
                    this.coleccionNacionalObra.eliminarObra(remplazo);
                    
                    remplazo.setNombreLugar(nuevoDato);
                    
                    this.coleccionNacionalObra.agregarObra(remplazo);
                    this.coleccionGeneralObra.agregarObra(remplazo);
                    //this.registro.remove(nombreObra);

                    //                 this.regiones.get(lugar).remove(nombreObra) ;
                    //this.registro.put(remplazo.getNombreObra(), remplazo);
                    //                 this.regiones.get(nuevoDato).put(nombreObra, remplazo) ;
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

            }
            //this.registro.remove(nombreObra);
            //this.regiones.get(lugar).remove(nombreObra) ;

            //this.coleccionNacionalObra.eliminarObra(registro.get(nombreObra));
            //this.coleccionNacionalObra.agregarObra(remplazo);

            //this.registro.put(nombreObra, remplazo);
            //this.regiones.get(lugar).put(nombreObra, remplazo) ;

            WriteFile.eliminarDefinitivo(new File("RegistroObras//" + lugar + "//" + nombreObra));
            WriteFile.escribirObras(',', registroActual);
            return true;
        }
        return false;
    }

    public void presupuestoGeneral() //presupuesto total de la compañia
    {
        this.coleccionGeneralObra.presupuestoGeneral();
        /*Obra obraActual;
        long balanceObra;
        long balanceTotal = 0;
        for (int i = 0; i < listaCompleta.size(); i++) {
            obraActual = listaCompleta.get(i);
            balanceObra = presupuestoGeneral(obraActual.getNombreObra());
            balanceTotal += balanceObra;
        }
        System.out.println(balanceTotal);*/
    }


// modificar    
    public long gatosTotales() {
        
        return this.coleccionGeneralObra.gatosTotales();
        /*long gastos = 0;
        for (int i = 0; i < listaCompleta.size(); i++) {
            gastos += listaCompleta.get(i).getSumaSueldos();
        }
        return gastos;*/
    }

    public long ingresosTotales() {
        return this.coleccionGeneralObra.ingresosTotales();
        
       /* long ingresos = 0;
        for (int i = 0; i < listaCompleta.size(); i++) {
            //ingresos += listaCompleta.get(i).getPresupuestoObra() ;
        }
        return ingresos;*/
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
