/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registro.obras.Controlador;
import com.registro.obras.Modelo.Obra;
import com.registro.obras.Modelo.ObraConstruccion;
import com.registro.obras.Modelo.ObraMantencion;
import com.registro.obras.Modelo.ObraRestauracion;
import com.registro.obras.Modelo.Persona;
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
    
    private HashMap <String, TreeMap<String, Obra>> regiones;
    private HashMap <String, Obra> registro ;
    private ArrayList<Obra> listaCompleta;
    private ArrayList<String> listadoRegiones;
    
    int contadorObras ;

    //constructores
    
    public RegistroObras(){
        this.listadoRegiones = new ArrayList();
        this.registro = new HashMap();
        this.listaCompleta = new ArrayList() ;
        this.contadorObras=0;
        this.regiones = new HashMap(); 
        llenarArray();
        
        for(int i = 0; i < listadoRegiones.size(); i++)
        {
            this.regiones.put(listadoRegiones.get(i), new TreeMap()) ;
        }
    }
    
    //metodos publicos
    public Obra retornarObra(int index){
        return listaCompleta.get(index);
    }
    
    public int retornarTipoObra(String nombreObra)
    {
        Obra obraEvaluar = registro.get(nombreObra) ;
        return obraEvaluar.getCodigo();
    }

    public Obra retornarObra(String nombreObra){
        
            if(this.existenciaObra(nombreObra)){
                Obra obraPedida = this.registro.get(nombreObra); 
                return obraPedida;
            }
            
        return null;
            
    }
    
    public Obra retornarObra(String nombre, String nombreRegion)
    {
        if(existenciaObra(nombre))
        {
            TreeMap<String,Obra> region  = regiones.get(nombreRegion);
            if(region == null){
                System.out.println("No existe la región");
                return null;
            }
            Obra obraRetornar = region.get(nombre);
            return obraRetornar ;
        }
        return null;
    }
    
    
    public HashMap <String, TreeMap<String, Obra>> obtenerHashRegiones(){
        return this.regiones;
    }
    

    public void llenarComboBoxObras(JComboBox<Obra> comboBoxObra){
        comboBoxObra.removeAllItems();
        Obra current ;
        for(int i = 0 ; i< listaCompleta.size() ; i++)
        {
            current = listaCompleta.get(i);
            comboBoxObra.addItem(current);
        }
    }
    
    public void llenarComboBoxObras(JComboBox<Obra> comboBoxObra, String region){
        
        if(region.equals("Todas las regiones") || (region == null))
        {
            llenarComboBoxObras(comboBoxObra) ;
            return ;
        }
        
        TreeMap<String, Obra> registroRegional = this.regiones.get(region) ;
        comboBoxObra.removeAllItems();
        Obra current ;
        for(Map.Entry me : registroRegional.entrySet())
        {
            
            current = (Obra)me.getValue();
            comboBoxObra.addItem(current);
        }
    }
    
    public void llenarComoBoxRegiones(JComboBox<String> comboBoxRegiones){
        
        comboBoxRegiones.removeAllItems();
        String regionActual ;
        comboBoxRegiones.addItem("Todas las regiones");
        for(int i = 0 ; i < this.listadoRegiones.size() ; i++)
        {
            regionActual = this.listadoRegiones.get(i) ;
            
            comboBoxRegiones.addItem(regionActual);
        }
    }
    
    public void llenarComboBoxEmpleadosRegistro(JComboBox<Persona> comboBoxObra, String nombreObra){
                
        Obra obraSeleccionada = this.registro.get(nombreObra);
        if(obraSeleccionada != null){
            System.out.println("Valido");
            obraSeleccionada.llenarComboBoxEmpleados(comboBoxObra);
        }
        
        //this.listaCompleta.ge
        
        if(this.contadorObras > 0 && obraSeleccionada == null){
            obraSeleccionada = this.listaCompleta.get(0);
            obraSeleccionada.llenarComboBoxEmpleados(comboBoxObra);
        }

    }
    
    public void llenarJTextAreaEmpleadosRegistro(JTextArea jTextArea, int valor, String nombreObra){
        Obra obraSeleccionada = this.registro.get(nombreObra);
        if(obraSeleccionada != null)
            obraSeleccionada.llenarJTextAreaEmpleados(jTextArea, valor);
    }
    
    public long getGastosObra(Obra nombreObra)
    {
        long balance = nombreObra.gastosObra() ;
        return balance;
    }
    
    /*public void mostrarObras(String region){ // listo

        TreeMap<String, Obra> listaFiltrada = regiones.get(region) ;
        
        if(listaFiltrada == null)
        {
            System.out.println("Region mal ingresada") ;
            return ;
        }
        Obra obraActual ;
        for (Map.Entry me : listaFiltrada.entrySet()) {
            obraActual = (Obra) me.getValue();
            System.out.println(obraActual.getNombreObra());
        }
    }
    
    
    public void mostrarObras() //Listo
    {
        
        for(int i = 0 ; i< listaCompleta.size() ; i++)
        {
            System.out.println(listaCompleta.get(i).getNombreObra());
        }
    }*/
    
    
    public boolean agregarObra(Obra obraAgregar){ //Listo
        
        if(obraAgregar.getCodigo() != 3)
        {
            if(obraAgregar.getCodigo() == 1)
            {
                ObraConstruccion obraC = (ObraConstruccion) obraAgregar;
                FechaHoy fechaObra = new FechaHoy();
                if(!fechaObra.verificarEstructura(obraC.getTiempoRestante().toCharArray()))
                {
                    return false ;
                }
            }
            if(obraAgregar.getCodigo() == 2)
            {
                ObraRestauracion obraR = (ObraRestauracion) obraAgregar;
                FechaHoy fechaObra = new FechaHoy();
                if(!fechaObra.verificarEstructura(obraR.getTiempoRestante().toCharArray()))
                {
                    return false ;
                }
            }
        }
        
        TreeMap<String, Obra> region = regiones.get(obraAgregar.getNombreLugar());
        this.listaCompleta.add(obraAgregar);
        this.registro.put(obraAgregar.getNombreObra(), obraAgregar);
        this.regiones.get(obraAgregar.getNombreLugar()).put(obraAgregar.getNombreObra(), obraAgregar) ;
        this.contadorObras++;
        return true;
    }
    
    
    public int numeroObras(){
        return this.contadorObras;
    }
    
    
    public void eliminarObra(String nombreObra) throws IOException //Listo
    {
        //en el archivo se elimina la obra original y se vuelve a crear el registro sin esta
        if(existenciaObra(nombreObra))
        {
            Obra ObraEliminar = registro.get(nombreObra) ;
            ObraEliminar.eliminarObra();
            String lugar = this.registro.get(nombreObra).getNombreLugar() ;
            this.registro.remove(nombreObra) ;
            this.regiones.get(lugar).remove(nombreObra) ;
            this.listaCompleta.remove(ObraEliminar);
            
            this.contadorObras=this.registro.size();
            
            WriteFile.eliminarDefinitivo(new File("RegistroObras//"+ObraEliminar.getNombreLugar()+"//"+ObraEliminar.getNombreObra()));
            WriteFile.escribirObras(',', this );
        }
    }
                
    public void modificarObra(String nombreObra, String nuevoDato, int opcion, RegistroObras registroActual) throws IOException //Listo
    {
        //en el archivo se elimina la obra anterior y se vuelve a crear esta pero con el dato cambiado
        
        //nombreObra es el nombre actual de la obra a editar
        //nuevoDato es el dato a editar que puedeser de cualquier atributo dentro del objeto Obra
        //opcion guardaria la hipotetica opcion a modificar por el usuario seleccionada en el menu
        System.out.println(nombreObra);
        if(existenciaObra(nombreObra))
        {

            String lugar = this.registro.get(nombreObra).getNombreLugar() ;
            Obra remplazo = this.registro.get(nombreObra) ;
            switch(opcion)
            {
                case 1: //Cambiar nombre
                {
                    
                    remplazo.setNombreObra(nuevoDato) ;
                    this.registro.remove(nombreObra) ;
                    this.regiones.get(lugar).remove(nombreObra) ;
                    
                    this.regiones.get(lugar).put(remplazo.getNombreLugar(), remplazo) ; 
                    this.registro.put(remplazo.getNombreObra(), remplazo) ;
                    remplazo.cambiarNombre();
                    WriteFile.eliminarDefinitivo(new File("RegistroObras//"+lugar+"//"+nombreObra));
                    WriteFile.escribirObras(',', registroActual );
                    return ;
                }
                case 2: //Cambiar region
                {
                    TreeMap<String, Obra> verificador = new TreeMap() ;
                    verificador = regiones.get(lugar) ;
                    
                    
                    remplazo.setNombreLugar(nuevoDato) ;
                    this.registro.remove(nombreObra) ;
                    this.regiones.get(lugar).remove(nombreObra) ;
                    
                    this.registro.put(remplazo.getNombreObra(), remplazo) ;
                    this.regiones.get(nuevoDato).put(nombreObra, remplazo) ;
                    WriteFile.eliminarDefinitivo(new File("RegistroObras//"+lugar+"//"+nombreObra));
                    WriteFile.escribirObras(',', registroActual );
                    return ;
                }
                case 3: //Cambiar tiempo restante y cambiar el interes
                {
                    //remplazo.setTiempoParaTerminarObra(nuevoDato) ;
                    int tipoObra = retornarTipoObra(nombreObra);
                    switch(tipoObra)
                    {
                        case 1:
                        {
                            ((ObraConstruccion)(remplazo)).setTiempoRestante(nuevoDato);
                            break;
                        }
                        case 2:
                        {
                            ((ObraRestauracion)(remplazo)).setTiempoRestante(nuevoDato);
                            break;
                        }
                        case 3:
                        {
                            try
                            {
                                double nuevoInteres = Double.parseDouble(nuevoDato) ;
                                ((ObraMantencion)(remplazo)).setInteresAnual(nuevoInteres);
                            }
                            catch(Exception e)
                            {
                                //ventana de error
                            }
                            
                        }
                        
                    }
                    break;
                }
                case 4: //Cambiar presupuesto y presupuesto anual
                {
                    int tipoObra = retornarTipoObra(nombreObra);
                    switch(tipoObra)
                    {
                        case 1:
                        {
                            try
                            {
                                long nuevoPresupuesto = Long.parseLong(nuevoDato) ;
                                ((ObraConstruccion)(remplazo)).setPresupuesto(nuevoPresupuesto);
                                break;
                            }
                            catch(Exception e)
                            {
                                //ventana de error
                            }
                            
                        }
                        case 2:
                        {
                            try
                            {
                                long nuevoPresupuesto = Long.parseLong(nuevoDato) ;
                                ((ObraRestauracion)(remplazo)).setPresupuesto(nuevoPresupuesto);
                                break;
                            }
                            catch(Exception e)
                            {
                                //ventana de error
                            }
                            
                        }
                        case 3:
                        {
                            try
                            {
                                long nuevoPresupuesto = Long.parseLong(nuevoDato) ;
                                ((ObraMantencion)(remplazo)).setMantenimientoMonetarioAnual(nuevoPresupuesto);
                                break;
                            }
                            catch(Exception e)
                            {
                                //ventana de error
                            }
                            
                        }
                        
                    }
                    break;
                }
                case 5:
                {
                    if(nuevoDato.equals("false"))
                    {
                        ((ObraMantencion)(remplazo)).setOperativo(false);
                    }
                    else
                    {
                        ((ObraMantencion)(remplazo)).setOperativo(true);
                    }
                }
                
            }
            this.registro.remove(nombreObra) ;
            this.regiones.get(lugar).remove(nombreObra) ;
            
            this.registro.put(nombreObra, remplazo) ;
            this.regiones.get(lugar).put(nombreObra, remplazo) ;
            WriteFile.eliminarDefinitivo(new File("RegistroObras//"+lugar+"//"+nombreObra));
            WriteFile.escribirObras(',', registroActual );
        }
    }
    
    
    
    public Boolean existenciaObra(String obra)
    {
        System.out.println(obra);
        Obra verificador = this.registro.get(obra) ;
        if(verificador == null)
        {
            //System.out.println("ERROR La obra ingresada no existe");
            return false ;
        }
        return true ;
    }
    
    public void presupuestoGeneral() //presupuesto total de la compañia
    {
        Obra obraActual ;
        long balanceObra = 0;
        long balanceTotal = 0;
        for(int i = 0 ; i < listaCompleta.size(); i++)
        {
            obraActual = listaCompleta.get(i) ;
            balanceObra = presupuestoGeneral(obraActual.getNombreObra());
            balanceTotal += balanceObra;
        }
        System.out.println(balanceTotal);
    }
    
    public long presupuestoGeneral(String nombreObra) //presupuesto particular de una obra
    {
        Obra obraEvaluar;
        long balance ;
        obraEvaluar = this.registro.get(nombreObra) ;
        balance = obraEvaluar.retornarSueldos() ;
        System.out.println(nombreObra) ;
        System.out.println(balance) ;
        //System.out.println(obraEvaluar.getPresupuestoObra()) ;
        //balance = (long) (obraEvaluar.getPresupuestoObra() - balance) ;
        return balance;
    }
    
    public long gatosTotales()
    {
        long gastos = 0;
        for(int i = 0; i < listaCompleta.size() ; i++)
        {
            gastos += listaCompleta.get(i).retornarSueldos() ;
        }
        return gastos;
    }
    
    public long ingresosTotales()
    {
        long ingresos = 0 ;
        for(int i = 0; i < listaCompleta.size() ; i++)
        {
            //ingresos += listaCompleta.get(i).getPresupuestoObra() ;
        }
        return ingresos;
    }
    //metodos privados
    private void llenarArray()
    {
        this.listadoRegiones.add("Tarapaca") ;
        this.listadoRegiones.add("Antofagasta") ;
        this.listadoRegiones.add("Atacama") ;
        this.listadoRegiones.add("Coquimbo") ;
        this.listadoRegiones.add("Valparaiso") ;
        this.listadoRegiones.add("O'higgins") ;
        this.listadoRegiones.add("Maule") ;
        this.listadoRegiones.add("Biobio") ;
        this.listadoRegiones.add("Araucania") ;
        this.listadoRegiones.add("Los Lagos") ;
        this.listadoRegiones.add("Aysen") ;
        this.listadoRegiones.add("Magallanes") ;
        this.listadoRegiones.add("Metropolitana") ;
        this.listadoRegiones.add("Los Rios") ;
        this.listadoRegiones.add("Arica y Parinacota") ;
        this.listadoRegiones.add("Ñuble") ;
    }
    
}
