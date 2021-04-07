
/**
 * Programación Avanzada ICI3241-1
 * @author Benjamín Rojas
 * @author Andrés Vidal
 */


package proyecto;
import java.io.* ;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;


public class main{
    public static void main(String args[]) throws IOException
    {
        
        Object[] pulpa_de_frutilla = ReadFile.tomarContenidos(',',5,"RegistroTrabajadores.txt");
        ArrayList <Persona> arrayxd = (ArrayList<Persona>) pulpa_de_frutilla[2];
        RegistroTrabajadores registroPersonas = new RegistroTrabajadores(arrayxd);
        
        registroPersonas.mostrarPersona();
                
        RegistroObras registro = ReadFile.traerObras(',', 4, "RegistroObras");        
        
        Obra newObra = new Obra("Obra_Prueba","Valpo",686.5,514.6);
        
        //allObras.agregarObra(newObra);
        
        newObra.agregarPersona(new Persona("Choro Maikol","Flaite",12345,5546215,true));
        newObra.agregarPersona(new Persona("Agua de uwu","Loco",8445,2125251,true));
        
        //allObras.mostrarObras();
        //newObra.mostrarEmpleados();
        //System.out.println(newObra.getNumeroEmpleados());
        //WriteFile.escribirObras(',',allObras);// separador , registroObras
        
        
        /*Scanner pupi = new Scanner(System.in) ;
        int menu;
        //menu
        do
        {
            System.out.println("1. Gestion de obras") ;
            System.out.println("2. Gestion de empleados") ;
            System.out.println("3. Salir") ;
            
            try
            {
                menu = pupi.nextInt() ;
                if(menu == 1)
                {
                    System.out.println("1. Añadir obra") ;
                    System.out.println("2. Mostrar todas las obras") ;
                    System.out.println("3. Obra terminada") ;
                    System.out.println("4. Cambiar presuspuesto");
                    System.out.println("5. Cancelar");
                    try
                    {
                        menu = pupi.nextInt() ;
                        if(menu == 1) // gestion de archivos xdxd
                        {
                            
                        }
                        if(menu == 2)
                        {

                            registro.mostrarObras() ;
                            menu = pupi.nextInt();
                            menu = 0;
                            continue;
                        }
                        if(menu == 3)
                        {
                            
                        }
                        if(menu == 4)
                        {
                            String nombre;
                            int nuevoPresupuesto;
                            registro.mostrarObras() ;
                            System.out.println("Ingrese el nombre de la obra");
                            nombre = pupi.nextLine() ;
                            Obra obraSeleccionada ;
                            obraSeleccionada = registro.retornarObra(nombre) ;
                            System.out.println("Ingrese el nuevo presupuesto");
                            nuevoPresupuesto = pupi.nextInt() ;
                            obraSeleccionada.cambiarPresupuesto(nuevoPresupuesto) ;
                            System.out.println("presupuesto cambiado");
                            menu = pupi.nextInt() ;
                            menu = 0;
                            continue;
                        }
                        if(menu == 5)
                        {
                            menu = 0;
                            continue;
                        }
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error opcion no disponible volviendo al menu") ;
                        menu = 0;
                        continue;
                    }
                }
                if(menu == 2)
                {
                    System.out.println("1. Añadir empleado a la plataforma") ;
                    System.out.println("2. Mostrar empleados de una obra") ;
                    System.out.println("3. Mostrar todos los empleados") ;
                    System.out.println("4. Despedir empleado");
                    //System.out.println("");
                    System.out.println("4. Cancelar");
                    menu = pupi.nextInt() ;
                    try
                    {
                        if(menu == 1)
                        {
                            
                        }
                        if(menu == 2)
                        {
                            
                        }
                        if(menu == 3) // llenar los datos de los trabajadores con el archivo 
                        {
                            System.out.println("desea filtrar los datos?");
                            System.out.println("1. por profecion");
                            System.out.println("2. por sueldo");
                            System.out.println("3. mostrar no asignados y asignados");
                            System.out.println("4. mostrar sin filtro");
                            try{
                                menu = pupi.nextInt();
                                if(menu == 1)
                                 {
                                    String filtro;
                                    System.out.println("ingrese profecion");
                                    filtro = pupi.nextLine();
                                    // obra.mostrarEmpleados()
                                    
                                    RegistroTrabajadores listaPersonas = new RegistroTrabajadores() ;
                                    listaPersonas.mostrarPersona(filtro);
                                    menu = pupi.nextInt() ;
                                    menu = 0;
                                    continue;
                                }
                                if(menu == 2)
                                {
                                    String filtro;
                                    System.out.println("ingrese sueldo");
                                    filtro = pupi.nextLine();
                                    RegistroTrabajadores listaPersonas = new RegistroTrabajadores() ;
                                    listaPersonas.mostrarPersona(filtro);
                                    menu = pupi.nextInt() ;
                                    menu = 0;
                                    continue;
                                }
                                if(menu == 3)
                                {                                   
                                    System.out.println("desea ver los empreados asignados a una obra o los no asignados");
                                    System.out.println("1. asignados") ;
                                    System.out.println("2. no asignados") ;
                                    menu = pupi.nextInt();
                                    if(menu == 1)
                                    {
                                        RegistroTrabajadores listaPersonas = new RegistroTrabajadores() ;
                                        listaPersonas.mostrarPersona(true);
                                        menu = pupi.nextInt() ;
                                        menu = 0;
                                        continue;
                                    }
                                    else
                                    {
                                        RegistroTrabajadores listaPersonas = new RegistroTrabajadores() ;
                                        listaPersonas.mostrarPersona(false);
                                        menu = pupi.nextInt() ;
                                        menu = 0;
                                        continue;
                                    }  
                                }
                                if(menu == 4)
                                {
                                    
                                    /*
                                    RegistroTrabajadores listaPersonas = new RegistroTrabajadores() ;
                                    listaPersonas.mostrarPersona();
                                    menu = pupi.nextInt() ;
                                    menu = 0;
                                    continue;
                                }
                            }
                            catch(Exception e)
                            {
                                System.out.println("Error opcion no disponible volviendo al menu") ;
                                menu = 0;
                                continue;
                            }
                            
                        }
                    }
                    catch(Exception e) 
                    {
                        System.out.println("Error opcion no disponible volviendo al menu") ;
                        menu = 0;
                        continue;
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println("Error opcion no disponible volviendo al menu") ;
                menu = 0;
                continue;
            }


            
        }while(menu != 3);*/
    }
}
    