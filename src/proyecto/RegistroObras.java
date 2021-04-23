/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;
import java.util.*;

/**
 *
 * @author Ceseo
 */
public class RegistroObras {
    private HashMap <String, HashMap<String, Obra>> regiones;
    private HashMap <String, Obra> registro ;
    private ArrayList<Obra> listaCompleta;
    private ArrayList<String> listadoRegiones;
    int contadorObras ;

    public RegistroObras(HashMap<String,Obra> registro,ArrayList<Obra> listaCompleta, int contadorObras)
    {
        
        listadoRegiones = new ArrayList();
        
        llenarArray(listadoRegiones) ;
        this.registro = registro ;
        this.listaCompleta = listaCompleta ;
        this.contadorObras = contadorObras ;
        
        this.regiones = new HashMap();
        for(int i = 0; i < listadoRegiones.size(); i++)
        {
            this.regiones.put(listadoRegiones.get(i), new HashMap()) ;
        }
        
    }
    
    
    public RegistroObras(){
        
        listadoRegiones = new ArrayList();
        
        llenarArray(listadoRegiones);
        
        
        this.registro = new HashMap();
        this.listaCompleta = new ArrayList() ;
        this.contadorObras=0;
        
        this.regiones = new HashMap();
        for(int i = 0; i < listadoRegiones.size(); i++)
        {
            this.regiones.put(listadoRegiones.get(i), new HashMap()) ;
        }
    }
    
    
    public Obra retornarObra(int index){
        return listaCompleta.get(index);
    }
    
    public Obra retornarObra(String nombre, String nombreRegion)
    {
        HashMap<String,Obra> region  = regiones.get(nombreRegion);
        if(region == null){
            System.out.println("No existe la región");
            return null;
        }
        
        Obra obra = region.get(nombre);
        
        if(obra == null){
            System.out.println("No existe la Obra");
        }
    
        return obra ;
    }
    
    public HashMap <String, HashMap<String, Obra>> obtenerHashRegiones(){
        return this.regiones;
    }
    
    public void mostrarObras(){ //Editar
        System.out.println("region para filtrar");
        Scanner scannerStrings = new Scanner(System.in) ;
        String region;
        region = scannerStrings.nextLine();
        
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
        /*Obra current;
        int i;
        for(i =0; i < listaCompleta.size();i++){
            current=listaCompleta.get(i);
            System.out.println(current.getNombreObra());
            //current.mostrarEmpleados();
        }*/
    }
    
    public void agregarObra(Obra obra1){//Andres
        
        HashMap<String, Obra> region = regiones.get(obra1.getNombreLugar());
        if(region != null)
        {
            System.out.println("Region ingresada correctamente");
            region.put(obra1.getNombreObra(), obra1) ;
            this.contadorObras++;
        }
        /*this.registro.put(obra1.getNombreObra(), obra1);
        this.listaCompleta.add(obra1);
        this.contadorObras++;*/
    }
    
    /* No sirve
    
    public void eliminarObra(String nombreObra){
        Obra valor = registro.get(nombreObra);
        if(valor == null){
            System.out.println("Inválido");
            return;
        }
        
        registro.remove(nombreObra);
            
        Obra current;
        int i;
        for(i =0; i < listaCompleta.size();i++){
            current=this.listaCompleta.get(i);
            
            if(nombreObra.equals(current.getNombreObra())){
                this.listaCompleta.remove(i);
                break;
            }
            
            
            System.out.println(current.getNombreObra());
            //current.mostrarEmpleados();
        }
        this.contadorObras--;
        
    }*/
    private void llenarArray(ArrayList listaRegiones)
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
