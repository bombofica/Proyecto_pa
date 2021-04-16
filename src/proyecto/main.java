
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
        RegistroObras registroObras = ReadFile.traerObras(',', 4, "RegistroObras");     
        
        Scanner scannerEnterosFlotantes = new Scanner(System.in) ;
        Scanner scannerStrings = new Scanner(System.in) ;
        int menu;
        
        
        //menu
        do
        {
            //el menu no es perfecto y es sencible a opciones no disponibles
            System.out.println("1. Gestión de obras") ;
            System.out.println("2. Gestión de empleados") ;
            System.out.println("3. Salir") ;
            
            try
            {
                menu = scannerEnterosFlotantes.nextInt() ;
                if(menu == 1)
                {
                    //esta previsto que existan mas funciones
                    System.out.println("1. Añadir obra") ;
                    System.out.println("2. Mostrar todas las obras") ;
                    System.out.println("3. Obra terminada") ; // esta opción no está disponible
                    System.out.println("4. Cambiar presupuesto"); // Esta no está terminada
                    System.out.println("5. Cancelar");
                    try
                    {
                        menu = scannerEnterosFlotantes.nextInt() ;
                        if(menu == 1)
                        {
                            String nombre;
                            String lugar;
                            double presupuesto;
                            double tiempoAsignado;
                            System.out.println("Ingrese el nombre de la obra");
                            nombre = scannerStrings.nextLine() ;
                            System.out.println("Ingrese el lugar de la obra");
                            lugar = scannerStrings.nextLine() ;
                            System.out.println("Ingrese el presupuesto de la obra");
                            presupuesto = scannerEnterosFlotantes.nextDouble() ;
                            System.out.println("Ingrese el tiempo asignado de la obra");
                            tiempoAsignado = scannerEnterosFlotantes.nextDouble() ;
                            Obra nuevaObra = new Obra(nombre, lugar, presupuesto, tiempoAsignado) ;
                            registroObras.agregarObra(nuevaObra);
                            WriteFile.escribirObras(',', registroObras);
                            System.out.println("Obra agregada");
                            menu = 0 ;
                        }
                        if(menu == 2)
                        {

                            registroObras.mostrarObras() ;
                            menu = scannerEnterosFlotantes.nextInt();
                            menu = 0;
                            continue;
                        }
                        if(menu == 3)
                        {
                            
                        }
                        if(menu == 4) //no esta verificado que esta opcion funcione
                        {
                            String nombre;
                            int nuevoPresupuesto;
                            registroObras.mostrarObras() ;
                            System.out.println("Ingrese el nombre de la obra");
                            nombre = scannerEnterosFlotantes.nextLine() ;
                            Obra obraSeleccionada ;
                            obraSeleccionada = registroObras.retornarObra(nombre) ;
                            System.out.println("Ingrese el nuevo presupuesto");
                            nuevoPresupuesto = scannerEnterosFlotantes.nextInt() ;
                            obraSeleccionada.cambiarPresupuesto(nuevoPresupuesto) ;
                            System.out.println("Presupuesto cambiado");
                            menu = scannerEnterosFlotantes.nextInt() ;
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
                        System.out.println("Error!!! Opción no disponible volviendo al menú") ;
                        menu = 0;
                        continue;
                    }
                }
                if(menu == 2)
                {
                    //esta previsto que existan mas funciones
                    System.out.println("1. Añadir empleado a la plataforma") ;
                    System.out.println("2. Mostrar empleados de una obra") ; // Esta opción no funciona
                    System.out.println("3. Mostrar todos los empleados") ;
                    System.out.println("4. Despedir empleado"); // Esta opción no funciona
                    menu = scannerEnterosFlotantes.nextInt() ;
                    try
                    {
                        if(menu == 1)
                        {
                            String nombre;
                            String labor;
                            int sueldo;
                            int rut;
                            System.out.println("Ingrese el nombre");
                            nombre = scannerStrings.nextLine() ;
                            System.out.println("Ingrese la labor");
                            labor = scannerStrings.nextLine() ;
                            System.out.println("Ingrese el sueldo");
                            sueldo = scannerEnterosFlotantes.nextInt() ;
                            System.out.println("Ingrese el rut");
                            rut = scannerEnterosFlotantes.nextInt() ;
                            Persona nuevoEmpleado = new Persona(nombre,labor,sueldo,rut,false) ;
                            registroPersonas.agregarPersona(nuevoEmpleado);
                            WriteFile.imprimirTodasLasPersonas(registroPersonas);
                        }
                        if(menu == 2)
                        {
                            
                        }
                        if(menu == 3) // llenar los datos de los trabajadores con el archivo 
                        {
                            System.out.println("Desea filtrar los datos?");
                            System.out.println("1. Por profesión");
                            System.out.println("2. Por sueldo");
                            System.out.println("3. Mostrar no asignados y asignados");
                            System.out.println("4. Mostrar sin filtro");
                            menu = 0;
                            try{
                                menu = scannerEnterosFlotantes.nextInt();
                                if(menu == 1)
                                 {
                                    String filtro;
                                    System.out.println("ingrese profesión");
                                    filtro = scannerStrings.nextLine();
                                    System.out.println("El filtro es: "+filtro);
                                    registroPersonas.mostrarPersona(filtro);
                                    menu = 0;
                                    continue;
                                }
                                if(menu == 2)
                                {
                                    String filtro;
                                    System.out.println("Ingrese sueldo");
                                    filtro = scannerStrings.nextLine();
                                    System.out.println("El filtro es: "+filtro);
                                    registroPersonas.mostrarPersona(filtro);
                                    menu = 0;
                                    continue;
                                }
                                if(menu == 3)
                                {                                   
                                    System.out.println("Desea ver los empleados asignados a una obra o los no asignados");
                                    System.out.println("1. asignados") ;
                                    System.out.println("2. no asignados") ;
                                    menu = scannerEnterosFlotantes.nextInt();
                                    if(menu == 1)
                                    {
                                        registroPersonas.mostrarPersona(true);
                                        menu = 0;
                                        continue;
                                    }
                                    else
                                    {
                                        registroPersonas.mostrarPersona(false);
                                        menu = 0;
                                        continue;
                                    }  
                                }
                                if(menu == 4)
                                {
                                    registroPersonas.mostrarPersona();
                                    menu = 0;
                                }
                            }
                            catch(Exception e)
                            {
                                System.out.println("Error opción no disponible volviendo al menú") ;
                                menu = 0;
                                continue;
                            }
                            
                        }
                    }
                    catch(Exception e) 
                    {
                        System.out.println("Error opción no disponible volviendo al menú") ;
                        menu = 0;
                        continue;
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println("Error opción no disponible volviendo al menú") ;
                menu = 0;
                continue;
            }
            
        }while(menu != 3);
    }
}
    