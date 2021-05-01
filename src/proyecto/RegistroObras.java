/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;
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
    
    //variables de instancia
    private HashMap <String, HashMap<String, Obra>> regiones;
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
            this.regiones.put(listadoRegiones.get(i), new HashMap()) ;
        }
    }
    
    //metodos publicos
    public Obra retornarObra(int index){
        return listaCompleta.get(index);
    }
    

    public Obra retornarObra(String nombreObra){
        Obra obraPedida = this.registro.get(nombreObra);
        if(obraPedida == null){
            System.out.println("La obra no existe");
        }
        return obraPedida;
    }

    
    public Obra retornarObra(String nombre, String nombreRegion)
    {
        if(existenciaObra(nombre))
        {
            HashMap<String,Obra> region  = regiones.get(nombreRegion);
            if(region == null){
                System.out.println("No existe la región");
                return null;
            }
            Obra obraRetornar = region.get(nombre);
            return obraRetornar ;
        }
        return null;
    }
    
    
    public HashMap <String, HashMap<String, Obra>> obtenerHashRegiones(){
        return this.regiones;
    }
    

    public void llenarComboBoxObras(JComboBox<String> comboBoxObra){
        comboBoxObra.removeAllItems();
        for(int i = 0 ; i< listaCompleta.size() ; i++)
        {
            Obra current=listaCompleta.get(i);
            comboBoxObra.addItem(current.getNombreObra());
        }
        
    }
    
    public void llenarComboBoxEmpleadosRegistro(JComboBox<String> comboBoxObra, String nombreObra){
                
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
    
    
    
    public void mostrarObras(String region){ // listo

        HashMap<String, Obra> listaFiltrada = regiones.get(region) ;
        
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
    }
    
    
    public void agregarObra(Obra obraAgregar){ //Listo
        
        HashMap<String, Obra> region = regiones.get(obraAgregar.getNombreLugar());
        if(region != null)
        {
            this.listaCompleta.add(obraAgregar);
            this.registro.put(obraAgregar.getNombreObra(), obraAgregar);
            this.regiones.get(obraAgregar.getNombreLugar()).put(obraAgregar.getNombreObra(), obraAgregar) ;
            this.contadorObras++;
            
        }
        else
        {
            System.out.println("La Región No Existe recuerde que las regiones van con la primera letra");
            System.out.println("en matusculas ej: Valparaiso");
        }
    }
    
    
    public int numeroObras(){
        return this.contadorObras;
    }
    
    
    public void eliminarObra(String nombreObra, RegistroObras registroActual) throws IOException //Listo
    {
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
            WriteFile.escribirObras(',', registroActual );
        }
    }
                
    public void modificarObra(String nombreObra, String nuevoDato, int opcion, RegistroObras registroActual) throws IOException //Listo
    {
        //nombreObra es el nombre actual de la obra a editar
        //nuevoDato es el dato a editar que puedeser de cualquier atributo dentro del objeto Obra
        //opcion guardaria la hipotetica opcion a modificar por el usuario seleccionada en el menu
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
                    WriteFile.eliminarDefinitivo(new File("RegistroObras//"+lugar+"//"+nombreObra));
                    this.regiones.get(lugar).put(remplazo.getNombreLugar(), remplazo) ; 
                    this.registro.put(remplazo.getNombreObra(), remplazo) ;
                    WriteFile.escribirObras(',', registroActual );
                    return;
                }
                case 2: //Cambiar region
                {
                    remplazo.setNombreLugar(nuevoDato) ;
                    this.registro.remove(nombreObra) ;
                    this.regiones.get(lugar).remove(nombreObra) ;
                    WriteFile.eliminarDefinitivo(new File("RegistroObras//"+lugar+"//"+nombreObra));
                    this.registro.put(remplazo.getNombreObra(), remplazo) ;
                    this.regiones.get(nuevoDato).put(nombreObra, remplazo) ;
                    WriteFile.escribirObras(',', registroActual );
                    return;
                }
                case 3: //Cambiar tiempo restante
                {
                    remplazo.setTiempoParaTerminarObra(nuevoDato) ;
                    break;
                }
                case 4: //Cambiar presupuesto
                {
                    try
                    {
                        remplazo.setPresupuestoObra(Integer.parseInt(nuevoDato));
                    }
                    catch(Exception e)
                    {
                        System.out.println("ERROR valor no numerico");
                        return;
                    }
                } 
                
            }
            this.registro.remove(nombreObra) ;
            this.regiones.get(lugar).remove(nombreObra) ;
            WriteFile.eliminarDefinitivo(new File("RegistroObras//"+lugar+"//"+nombreObra));
            this.registro.put(nombreObra, remplazo) ;
            this.regiones.get(lugar).put(nombreObra, remplazo) ;
            WriteFile.escribirObras(',', registroActual );
        }
    }
    
    public Boolean existenciaObra(String obra)
    {
        Obra verificador = this.registro.get(obra) ;
        if(verificador == null)
        {
            //System.out.println("ERROR La obra ingresada no existe");
            return false ;
        }
        return true ;
    }
    
    public void PresupuestoGeneral() //presupuesto total de la compañia
    {
        Obra obraActual ;
        long balanceObra = 0;
        long balanceTotal = 0;
        for(int i = 0 ; i < listaCompleta.size(); i++)
        {
            obraActual = listaCompleta.get(i) ;
            balanceObra = PresupuestoGeneral(obraActual.getNombreObra());
            balanceTotal += balanceObra;
        }
        System.out.println(balanceTotal);
    }
    
    public long PresupuestoGeneral(String nombreObra) //presupuesto particular de una obra
    {
        Obra obraEvaluar;
        long balance ;
        obraEvaluar = this.registro.get(nombreObra) ;
        balance = obraEvaluar.retornarSueldos(obraEvaluar) ;
        System.out.println(nombreObra) ;
        System.out.println(balance) ;
        System.out.println(obraEvaluar.getPresupuestoObra()) ;
        balance = (long) (obraEvaluar.getPresupuestoObra() - balance) ;
        return balance;
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
