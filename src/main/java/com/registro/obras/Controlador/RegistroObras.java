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
    
    private HashMap <String, TreeMap<String, Obra>> regiones;
    private HashMap <String, Obra> registro ;
    private ArrayList<Obra> listaCompleta;
    private ArrayList<String> listadoRegiones;
    public ArrayList<ProyectoReportable> listaCompletaInterfaz;
    
    int contadorObras ;

    //constructores
    
    public RegistroObras(){
        this.listadoRegiones = new ArrayList();
        this.registro = new HashMap();
        this.listaCompleta = new ArrayList() ;
        this.listaCompletaInterfaz = new ArrayList();
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

    public void llenarComboBoxObrasInterfaz(JComboBox<ProyectoReportable> comboBoxObra){
        comboBoxObra.removeAllItems();
        ProyectoReportable current ;
        for(int i = 0 ; i< listaCompletaInterfaz.size() ; i++)
        {  
            current = listaCompletaInterfaz.get(i);
            comboBoxObra.addItem((ProyectoReportable)current);
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

    public void llenarComboBoxObrasInterfaz(JComboBox<ProyectoReportable> comboBoxObra, String region){
        
        if(region.equals("Todas las regiones") || (region == null))
        {
            llenarComboBoxObrasInterfaz(comboBoxObra) ;
            return ;
        }
        
        TreeMap<String, Obra> registroRegional = this.regiones.get(region) ;
        comboBoxObra.removeAllItems();
        Obra current ;
        for(Map.Entry me : registroRegional.entrySet())
        {       
            current = (Obra)me.getValue();
            
            if( (current.getCodigo() == 1) || (current.getCodigo() == 2))
                comboBoxObra.addItem((ProyectoReportable)current);
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
                ProyectoConstruccion obraC = (ProyectoConstruccion) obraAgregar;
                FechaHoy fechaObra = new FechaHoy();
                if(!fechaObra.verificarEstructura(obraC.getTiempoRestante().toCharArray()))
                {
                    return false ;
                }
                this.listaCompletaInterfaz.add(obraC);
            }
            if(obraAgregar.getCodigo() == 2)
            {
                ProyectoRestauracion obraR = (ProyectoRestauracion) obraAgregar;
                FechaHoy fechaObra = new FechaHoy();
                if(!fechaObra.verificarEstructura(obraR.getTiempoRestante().toCharArray()))
                {
                    return false ;
                }
                this.listaCompletaInterfaz.add(obraR);
            }
        }
        
            
        TreeMap<String, Obra> region = regiones.get(obraAgregar.getNombreLugar());
            
        if(region != null){
            this.listaCompleta.add(obraAgregar);

            this.registro.put(obraAgregar.getNombreObra(), obraAgregar);
            this.regiones.get(obraAgregar.getNombreLugar()).put(obraAgregar.getNombreObra(), obraAgregar) ;
            this.contadorObras++;
            return true;
        }else
        {
            return false;
        }
    }
    
    public Obra[] filtrarObrasPresupuesto(long parametro, int opcion)
    {
        ArrayList<Obra> pupi = new ArrayList() ;
        int i ;
        if(opcion == 0) //menor que
        {
            for(i = 0; i < this.listaCompleta.size() ; i++)
            {
                if((listaCompleta.get(i).getCodigo() == 1) && ((ProyectoConstruccion)(listaCompleta.get(i))).getPresupuesto() < parametro)
                {
                    pupi.add(listaCompleta.get(i)) ;
                }
                if((listaCompleta.get(i).getCodigo() == 2) && ((ProyectoRestauracion)(listaCompleta.get(i))).getPresupuesto() < parametro)
                {
                    pupi.add(listaCompleta.get(i)) ;
                }
            }
            Obra[] listadoFiltrado = new Obra[pupi.size()] ;
            for(i = 0; i < pupi.size() ; i++)
            {
                listadoFiltrado[i] = pupi.get(i);
            }
            return listadoFiltrado ;
        }
        if(opcion == 1) //mayor que
        {
            for(i = 0; i < this.listaCompleta.size() ; i++)
            {
                if((listaCompleta.get(i).getCodigo() == 1) && ((ProyectoConstruccion)(listaCompleta.get(i))).getPresupuesto() > parametro)
                {
                    pupi.add(listaCompleta.get(i)) ;
                }
                if((listaCompleta.get(i).getCodigo() == 2) && ((ProyectoRestauracion)(listaCompleta.get(i))).getPresupuesto() > parametro)
                {
                    pupi.add(listaCompleta.get(i)) ;
                }
            }
            Obra[] listadoFiltrado = new Obra[pupi.size()] ;
            for(i = 0; i < pupi.size() ; i++)
            {
                listadoFiltrado[i] = pupi.get(i);
            }
            return listadoFiltrado ;
        }
        return null ;
    }
    
    public Obra filtrarObrasPresupuesto(int opcion)
    {
        int i ;
        Obra obraSeleccionada = null;
        for(i = 0; i < this.listaCompleta.size() ; i++)
        {
            if(this.listaCompleta.get(i).getCodigo() == 1)
            {
                obraSeleccionada = retornarObra(i) ;
                break;
            }
            if(this.listaCompleta.get(i).getCodigo() == 1)
            {
                obraSeleccionada = retornarObra(i) ;
                break;
            }
        }
        if(obraSeleccionada != null)
        {
            if(opcion == 2) //maximo
            {
                int codigo;
                for(i = 0; i < this.listaCompleta.size() ; i++)
                {
                    codigo = obraSeleccionada.getCodigo();
                    if(codigo == 1)
                    {
                        if(this.listaCompleta.get(i).getCodigo() == 1)
                        {
                            if(((ProyectoConstruccion)(obraSeleccionada)).getPresupuesto() < ((ProyectoConstruccion)(this.listaCompleta.get(i))).getPresupuesto())
                            {
                                obraSeleccionada = this.listaCompleta.get(i) ;
                                continue;
                            }
                        }
                        if(this.listaCompleta.get(i).getCodigo() == 2)
                        {
                            if(((ProyectoConstruccion)(obraSeleccionada)).getPresupuesto() < ((ProyectoRestauracion)(this.listaCompleta.get(i))).getPresupuesto())
                            {
                                obraSeleccionada = this.listaCompleta.get(i) ;
                                continue;
                            }
                        }
                    }
                    if(codigo == 2)
                    {
                        if(this.listaCompleta.get(i).getCodigo() == 1)
                        {
                            if(((ProyectoRestauracion)(obraSeleccionada)).getPresupuesto() < ((ProyectoConstruccion)(this.listaCompleta.get(i))).getPresupuesto())
                            {
                                obraSeleccionada = this.listaCompleta.get(i) ;
                                continue;
                            }
                        }
                        if(this.listaCompleta.get(i).getCodigo() == 2)
                        {
                            if(((ProyectoRestauracion)(obraSeleccionada)).getPresupuesto() < ((ProyectoRestauracion)(this.listaCompleta.get(i))).getPresupuesto())
                            {
                                obraSeleccionada = this.listaCompleta.get(i) ;
                            }
                        }
                    }
                }
                return obraSeleccionada;
            }
            if(opcion == 3) //minimo
            {
                int codigo;
                for(i = 0; i < this.listaCompleta.size() ; i++)
                {
                    codigo = obraSeleccionada.getCodigo();
                    if(codigo == 1)
                    {
                        if(this.listaCompleta.get(i).getCodigo() == 1)
                        {
                            if(((ProyectoConstruccion)(obraSeleccionada)).getPresupuesto() > ((ProyectoConstruccion)(this.listaCompleta.get(i))).getPresupuesto())
                            {
                                obraSeleccionada = this.listaCompleta.get(i) ;
                                continue;
                            }
                        }
                        if(this.listaCompleta.get(i).getCodigo() == 2)
                        {
                            if(((ProyectoConstruccion)(obraSeleccionada)).getPresupuesto() > ((ProyectoRestauracion)(this.listaCompleta.get(i))).getPresupuesto())
                            {
                                obraSeleccionada = this.listaCompleta.get(i) ;
                                continue;
                            }
                        }
                    }
                    if(codigo == 2)
                    {
                        if(this.listaCompleta.get(i).getCodigo() == 1)
                        {
                            if(((ProyectoRestauracion)(obraSeleccionada)).getPresupuesto() > ((ProyectoConstruccion)(this.listaCompleta.get(i))).getPresupuesto())
                            {
                                obraSeleccionada = this.listaCompleta.get(i) ;
                                continue;
                            }
                        }
                        if(this.listaCompleta.get(i).getCodigo() == 2)
                        {
                            if(((ProyectoRestauracion)(obraSeleccionada)).getPresupuesto() > ((ProyectoRestauracion)(this.listaCompleta.get(i))).getPresupuesto())
                            {
                                obraSeleccionada = this.listaCompleta.get(i) ;
                            }
                        }
                    }
                }
                return obraSeleccionada;
            }
        }
        
        return null ;
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
            this.listaCompletaInterfaz.remove( (ProyectoReportable) ObraEliminar);
            
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
                            ((ProyectoConstruccion)(remplazo)).setTiempoRestante(nuevoDato);
                            break;
                        }
                        case 2:
                        {
                            ((ProyectoRestauracion)(remplazo)).setTiempoRestante(nuevoDato);
                            break;
                        }
                        case 3:
                        {
                            try
                            {
                                double nuevoInteres = Double.parseDouble(nuevoDato) ;
                                ((ServicioMantencion)(remplazo)).setInteresAnual(nuevoInteres);
                            }
                            catch(NumberFormatException e)
                            {
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
                    switch(tipoObra)
                    {
                        case 1:
                        {
                            try
                            {
                                long nuevoPresupuesto = Long.parseLong(nuevoDato) ;
                                ((ProyectoConstruccion)(remplazo)).setPresupuesto(nuevoPresupuesto);
                                break;
                            }
                            catch(NumberFormatException e)
                            {
                                //ventana de error
                            }
                            
                        }
                        case 2:
                        {
                            try
                            {
                                long nuevoPresupuesto = Long.parseLong(nuevoDato) ;
                                ((ProyectoRestauracion)(remplazo)).setPresupuesto(nuevoPresupuesto);
                                break;
                            }
                            catch(NumberFormatException e)
                            {
                                //ventana de error
                            }
                            
                        }
                        case 3:
                        {
                            try
                            {
                                long nuevoPresupuesto = Long.parseLong(nuevoDato) ;
                                ((ServicioMantencion)(remplazo)).setMantenimientoMonetarioAnual(nuevoPresupuesto);
                                break;
                            }
                            catch(NumberFormatException e)
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
                        ((ServicioMantencion)(remplazo)).setOperativo(false);
                    }
                    else
                    {
                        ((ServicioMantencion)(remplazo)).setOperativo(true);
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
        return verificador != null ;
    }
    
    public void presupuestoGeneral() //presupuesto total de la compañia
    {
        Obra obraActual ;
        long balanceObra;
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
