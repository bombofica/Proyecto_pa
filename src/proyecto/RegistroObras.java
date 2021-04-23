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
    
    //variables de instancia
    private HashMap <String, HashMap<String, Obra>> regiones;
    private HashMap <String, Obra> registro ;
    private ArrayList<Obra> listaCompleta;
    private ArrayList<String> listadoRegiones;
    int contadorObras ;

    //constructores
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
    
    //metodos publicos
    public Obra retornarObra(int index){
        return listaCompleta.get(index);
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
    
    public void mostrarObras(String region){ //Editar
        /*System.out.println("region para filtrar");
        Scanner scannerStrings = new Scanner(System.in) ;
        String region;
        region = scannerStrings.nextLine();*/
        
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
    
    public void mostrarObras()
    {
        for(int i = 0 ; i< listaCompleta.size() ; i++)
        {
            System.out.println(listaCompleta.get(i).getNombreObra());
        }
    }
    
    public void agregarObra(Obra obraAgregar){//Andres
        
        if(existenciaObra(obraAgregar.getNombreObra()))
        {
            System.out.println("ERROR El nombre de la obra ya existe");
            return;
        }
        
        //HashMap<String, Obra> region = this.regiones.get(obraAgregar.getNombreLugar());
        
        if(this.regiones.get(obraAgregar.getNombreLugar()) != null)
        {
            
            System.out.println("Region ingresada correctamente");
            this.registro.put(obraAgregar.getNombreObra(), obraAgregar);
            this.regiones.get(obraAgregar.getNombreLugar()).put(obraAgregar.getNombreObra(), obraAgregar) ;
            this.contadorObras++;
            
        }
        else
        {
            System.out.println("La Región No Existe");
        }
    }
    
    public int numeroObras(){
        return this.contadorObras;
    }
    
    public void eliminarObra(String nombreObra)
    {
        if(existenciaObra(nombreObra))
        {
            String lugar = this.registro.get(nombreObra).getNombreLugar() ;
            this.registro.remove(nombreObra) ;
            this.regiones.get(lugar).remove(nombreObra) ;
        }
    }
                
    public void modificarObra(String nombreObra, String nuevoDato, int opcion)
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
                    this.registro.put(remplazo.getNombreObra(), remplazo) ;
                    this.regiones.get(lugar).remove(nombreObra) ;
                    this.regiones.get(lugar).put(remplazo.getNombreLugar(), remplazo) ; 
                    return;
                }
                case 2: //Cambiar region
                {
                    remplazo.setNombreLugar(nuevoDato) ;
                    this.registro.remove(nombreObra) ;
                    this.registro.put(remplazo.getNombreObra(), remplazo) ;
                    this.regiones.get(lugar).remove(nombreObra) ;
                    this.regiones.get(nuevoDato).put(nombreObra, remplazo) ;
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
            this.registro.put(nombreObra, remplazo) ;
            this.regiones.get(lugar).remove(nombreObra) ;
            this.regiones.get(lugar).put(nombreObra, remplazo) ;
        }
    }
    
    public Boolean existenciaObra(String obra)
    {
        Obra verificador = this.registro.get(obra) ;
        if(verificador == null)
        {
            System.out.println("ERROR La obra ingresada no existe");
            return false ;
        }
        return true ;
    }
    
    //metodos privados
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
