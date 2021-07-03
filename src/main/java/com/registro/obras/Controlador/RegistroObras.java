package com.registro.obras.Controlador;

import com.registro.obras.Modelo.datoIlegibleExceptions;
import com.registro.obras.Modelo.datoRepetidoException;
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

    //private ArrayList<String> listadoRegiones; // encapsular
    private ListaRegionesNombre listaDeRegiones;
    private ColeccionNacionalObra coleccionNacionalObra;
    private ColeccionGeneralObra coleccionGeneralObra;
    public ListaProyectoInterfaz listaCompletaInterfaz;
    public ListaImprimible formatoDeSalida;

    public ListaImprimible getFormatoDeSalida() {
        return formatoDeSalida;
    }


    public RegistroObras() {
        this.listaDeRegiones = new ListaRegionesNombre();
        this.listaCompletaInterfaz = new ListaProyectoInterfaz();
        this.coleccionNacionalObra = new ColeccionNacionalObra();
        this.coleccionGeneralObra = new ColeccionGeneralObra();
        llenarArray();

        for (int i = 0; i < listaDeRegiones.size(); i++) {
            this.coleccionNacionalObra.agregarColeccionRegional(listaDeRegiones.retornarRegioni(i));
        }
    }

// Las funciones retornarObra, retornan la Obra que ha sido pedida por el usuario o por el indice del "ArrayList" que 
// está en la clase ColeccionGeneral o por su nombre y región Correspondiente
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

    /* retorna el tipo de la Obra, puede tomar 3 valores
    1: si es un ProyectoConstruccion
    2: Si es un ProyectoRestauración
    3; si es un ServicioMantencion
    
     */
    public int retornarTipoObra(String nombreObra) {
        Obra obraEvaluar = this.retornarObra(nombreObra);
        return obraEvaluar.getCodigo();
    }

    /*Retorna un Array con todas las Obras, tiene como proposito que la Clase que esté utilizando 
    este metodo pueda acceder a todas las Obras de forma mas facil*/
    public ColeccionRegionalObra[] obtenerColeccionNacionalArray() {
        return this.coleccionNacionalObra.retornarColeccionNacional();
    }

    public void llenarComboBoxObras(JComboBox<Obra> comboBoxObra, boolean bandera) {
        comboBoxObra.removeAllItems();

        if (bandera == true) {
            comboBoxObra.addItem(new ProyectoConstruccion("Sin Obra", "Metropolitana", "25-11-2056", 556, 0));
        }

        Obra current;
        for (int i = 0; i < this.numeroObras(); i++) {
            current = this.coleccionGeneralObra.retornarObra(i);//listaCompleta.get(i);
            comboBoxObra.addItem(current);
        }
    }

// Las siguientes funciones llenan los combobox de la interfaz grafica   
    public void llenarComboBoxObrasInterfaz(JComboBox<ProyectoReportable> comboBoxObra) {

        this.listaCompletaInterfaz.llenarComboBoxObrasInterfaz(comboBoxObra);
    }
    
    public void llenarComboBoxObrasInterfaz(JComboBox<ProyectoReportable> comboBoxObra, String region) {

            if (region.equals("Todas las regiones") || (region == null)) {
                llenarComboBoxObrasInterfaz(comboBoxObra);
                return;
            }

            ColeccionRegionalObra coleccionRegional = this.coleccionNacionalObra.obtenerColeccionRegion(region);

            comboBoxObra.removeAllItems();

            coleccionRegional.llenarComboBoxObrasInterfaz(comboBoxObra);

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
    
    public void llenarComoBoxRegiones(JComboBox<String> comboBoxRegiones) {

        comboBoxRegiones.removeAllItems();
        String regionActual;
        comboBoxRegiones.addItem("Todas las regiones");
        for (int i = 0; i < this.listaDeRegiones.size(); i++) {
            regionActual = this.listaDeRegiones.retornarRegioni(i);

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

    // no se utiliza, pero es propensa a utilizarse

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
    /*retorna true si la obra ya existe en el Registro*/
    public Boolean existenciaObra(String obra) {
        //System.out.println(obra);        
        return this.coleccionGeneralObra.existenciaObra(obra);

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

    /* Agrega una obra al registroObras*/
    public boolean agregarObra(Obra obraAgregar) throws datoIlegibleExceptions, datoRepetidoException{  //Listo     j   

        if (obraAgregar != null && !existenciaObra(obraAgregar.getNombreObra())) 
        {
            if (obraAgregar.getCodigo() != 3) 
            {
                switch (obraAgregar.getCodigo()) 
                {
                    case 1:
                        if (FechaHoy.verificarEstructura(((ProyectoConstruccion) obraAgregar).getTiempoRestante().toCharArray())) 
                        {
                            this.listaCompletaInterfaz.agregarObra((ProyectoConstruccion) obraAgregar);
                        } 
                        else 
                        {
                            throw new datoIlegibleExceptions();
                        }

                        break;

                    case 2:
                        if (FechaHoy.verificarEstructura(((ProyectoRestauracion) obraAgregar).getTiempoRestante().toCharArray())) {
                            this.listaCompletaInterfaz.agregarObra((ProyectoRestauracion) obraAgregar);
                        } else {
                            throw new datoIlegibleExceptions();
                        }

                        break;
                }
            }
            
            if (!this.coleccionGeneralObra.agregarObra(obraAgregar)) {
                return false;
            }

            if (!this.coleccionNacionalObra.agregarObra(obraAgregar)) {
                return false;
            }

            this.contadorObras++;
            return true;
        }
        else
        {
            throw new datoRepetidoException() ;
        }
    }

    /*Filtra un conjunto de obras, estas obras tienen que estar dentro de cierto rango*/
    public Obra[] filtrarObrasPresupuesto(long parametro, int opcion) {

        return this.coleccionGeneralObra.filtrarObrasPresupuesto(parametro, opcion);
    }

    /*Filtra un conjunto de obras, la obra escogida es la que tiene mayor o menor presupuesto, segun sea la opcion*/
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
            this.contadorObras--;
            return this.coleccionGeneralObra.numeroObras();
        }
        return -1;
    }

    public boolean modificarObra(String nombreObra, String nuevoDato, int opcion, RegistroObras registroActual) throws IOException, datoRepetidoException, datoIlegibleExceptions, NumberFormatException//Listo
    {
        //en el archivo se elimina la obra anterior y se vuelve a crear esta pero con el dato cambiado

        //nombreObra es el nombre actual de la obra a editar
        //nuevoDato es el dato a editar que puedeser de cualquier atributo dentro del objeto Obra
        //opcion guardaria la hipotetica opcion a modificar por el usuario seleccionada en el menu
        if (existenciaObra(nombreObra)) {

            String lugar = this.coleccionGeneralObra.retornarObra(nombreObra).getNombreLugar();//this.registro.get(nombreObra).getNombreLugar();
            Obra remplazo = this.coleccionGeneralObra.retornarObra(nombreObra);//this.registro.get(nombreObra);
            switch (opcion) {
                case 1: //Cambiar nombre
                {
                    if (this.existenciaObra(nuevoDato)) {
                        throw new datoRepetidoException();
                    }
                    this.coleccionGeneralObra.eliminarObra(remplazo);
                    this.coleccionNacionalObra.eliminarObra(remplazo);

                    remplazo.setNombreObra(nuevoDato);
                    this.coleccionNacionalObra.agregarObra(remplazo);
                    this.coleccionGeneralObra.agregarObra(remplazo);
                    remplazo.cambiarNombre();
                    WriteDataBase.eliminarDefinitivo(new File("RegistroObras//" + lugar + "//" + nombreObra));
                    WriteDataBase.escribirObras(',', registroActual);

                    return true;
                }
                case 2: //Cambiar region
                {
                    if (!this.listaDeRegiones.contains(nuevoDato)) {
                        throw new datoIlegibleExceptions();
                    }
                    this.coleccionGeneralObra.eliminarObra(remplazo);
                    this.coleccionNacionalObra.eliminarObra(remplazo);
                    remplazo.setNombreLugar(nuevoDato);

                    if (this.coleccionNacionalObra.agregarObra(remplazo));
                    this.coleccionGeneralObra.agregarObra(remplazo);

                    this.coleccionNacionalObra.obtenerColeccionRegion(lugar).agregarObra(remplazo);

                    WriteDataBase.eliminarDefinitivo(new File("RegistroObras//" + lugar + "//" + nombreObra));
                    WriteDataBase.escribirObras(',', registroActual);
                    return true;
                }
                case 3: //Cambiar tiempo restante y cambiar el interes
                {
                    int tipoObra = retornarTipoObra(nombreObra);
                    switch (tipoObra) {
                        case 1: {
                            if(!FechaHoy.verificarEstructura(((ProyectoConstruccion)(remplazo)).getTiempoRestante().toCharArray()))
                            {
                                throw new datoIlegibleExceptions();
                            }
                            ((ProyectoConstruccion) (remplazo)).setTiempoRestante(nuevoDato);
                            break;
                        }
                        case 2: {
                            if(!FechaHoy.verificarEstructura(((ProyectoRestauracion)(remplazo)).getTiempoRestante().toCharArray()))
                            {
                                throw new datoIlegibleExceptions();
                            }
                            ((ProyectoRestauracion) (remplazo)).setTiempoRestante(nuevoDato);
                            break;
                        }
                        case 3: {
                            try {
                                double nuevoInteres = Double.parseDouble(nuevoDato);
                                ((ServicioMantencion) (remplazo)).setInteresAnual(nuevoInteres);
                            } catch (NumberFormatException e) {
                                throw new NumberFormatException() ;
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
                                throw new NumberFormatException() ;
                            }
                        }
                        case 2: {
                            try {
                                long nuevoPresupuesto = Long.parseLong(nuevoDato);
                                ((ProyectoRestauracion) (remplazo)).setPresupuesto(nuevoPresupuesto);
                                break;
                            } catch (NumberFormatException e) {
                                throw new NumberFormatException() ;
                            }
                        }
                        case 3: {
                            try {
                                long nuevoPresupuesto = Long.parseLong(nuevoDato);
                                ((ServicioMantencion) (remplazo)).setMantenimientoMonetarioAnual(nuevoPresupuesto);
                                break;
                            } catch (NumberFormatException e) {
                                throw new NumberFormatException() ;
                            }
                        }
                    }
                    break;
                }
                case 5: {
                    if (nuevoDato.equals("false")){
                        ((ServicioMantencion) (remplazo)).setOperativo(false);
                        break;
                    } 
                    if (nuevoDato.equals("true")){
                        ((ServicioMantencion) (remplazo)).setOperativo(true);
                    }
                    break;
                }
                case 6: {
                    this.coleccionGeneralObra.eliminarObra(remplazo);
                    this.coleccionNacionalObra.eliminarObra(remplazo);

                    if (remplazo.getCodigo() == 1) {
                        ((ProyectoConstruccion) (remplazo)).setFase();
                    }
                    if (remplazo.getCodigo() == 2) {
                        ((ProyectoRestauracion) (remplazo)).setFase();
                    }
                    this.coleccionNacionalObra.agregarObra(remplazo);
                    this.coleccionGeneralObra.agregarObra(remplazo);
                    WriteDataBase.eliminarDefinitivo(new File("RegistroObras//" + lugar + "//" + nombreObra));
                    WriteDataBase.escribirObras(',', registroActual);
                    return true;
                }

            }
            /*Imprime en la base de datos para actualizar la informacion*/
            WriteDataBase.eliminarDefinitivo(new File("RegistroObras//" + remplazo.getNombreLugar() + "//" + remplazo.getNombreObra()));
            WriteDataBase.escribirObras(',', registroActual);
            return true;
        }
        return false;
    }

    public void presupuestoGeneral() //presupuesto total de la compañia
    {
        this.coleccionGeneralObra.presupuestoGeneral();

    }

    // Retorna los gastos previstos de una Obra, con la informacion que entrega se puede inferir más facilmente si una obra produce perdidas o ganancias
    public long gatosTotales() {

        return this.coleccionGeneralObra.gatosTotales();

    }

    public long ingresosTotales() {
        return this.coleccionGeneralObra.ingresosTotales();

    }

// eliminar    
    private void llenarArray() {
        this.listaDeRegiones.agregarNombre("Tarapaca");
        this.listaDeRegiones.agregarNombre("Antofagasta");
        this.listaDeRegiones.agregarNombre("Atacama");
        this.listaDeRegiones.agregarNombre("Coquimbo");
        this.listaDeRegiones.agregarNombre("Valparaiso");
        this.listaDeRegiones.agregarNombre("O'higgins");
        this.listaDeRegiones.agregarNombre("Maule");
        this.listaDeRegiones.agregarNombre("Biobio");
        this.listaDeRegiones.agregarNombre("Araucania");
        this.listaDeRegiones.agregarNombre("Los Lagos");
        this.listaDeRegiones.agregarNombre("Aysen");
        this.listaDeRegiones.agregarNombre("Magallanes");
        this.listaDeRegiones.agregarNombre("Metropolitana");
        this.listaDeRegiones.agregarNombre("Los Rios");
        this.listaDeRegiones.agregarNombre("Arica y Parinacota");
        this.listaDeRegiones.agregarNombre("Ñuble");
    }

    // verifica si existe la region que ha sido ingresada por el usuario
    public boolean existenciaRegion(String nombre) {
        for (int i = 0; i < this.listaDeRegiones.size(); i++) {
            if (nombre.equals(this.listaDeRegiones.retornarRegioni(i))) {
                return true;
            }
        }
        return false;
    }

    public long numeroObras() {
        return this.coleccionGeneralObra.numeroObras();
    }
    
    public void setFormatoDeSalida(ListaImprimible tipo){
        this.formatoDeSalida = tipo;
    }
    
    public void imprimir(String ruta, String nombre){
        this.formatoDeSalida.imprimirDatos(this, ruta, nombre);
    }

}
