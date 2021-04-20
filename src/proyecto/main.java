
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
import java.text.SimpleDateFormat;


public class main{
    public static void main(String args[]) throws IOException
    {
        
        ArrayList <Persona> arrayxd;      
        Object[] pulpa_de_frutilla = ReadFile.tomarContenidosPersonas(',',5,"RegistroTrabajadores.txt");
        
        arrayxd =(ArrayList <Persona>) pulpa_de_frutilla[2];
        HashMap<String,Persona> hashpersonaxd =(HashMap <String,Persona>) pulpa_de_frutilla[2];
        
        RegistroTrabajadores registroPersonas = new RegistroTrabajadores(arrayxd,hashpersonaxd);
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
                if(menu == 1)//Gestion de obras
                {
                    //esta previsto que existan mas funciones
                    System.out.println("1. Añadir obra") ;
                    System.out.println("2. Mostrar todas las obras") ;
                    System.out.println("3. Obra terminada") ; // esta opción no está disponible
                    System.out.println("4. Cambiar presupuesto"); // Esta no está terminada
                    System.out.println("5. Tiempo restante de una obra");
                    System.out.println("6. Gastos totales");
                    try
                    {
                        menu = scannerEnterosFlotantes.nextInt() ;
                        if(menu == 1) //Añadir obra
                        {
                            añadirObra(scannerStrings, scannerEnterosFlotantes, registroObras);
                            menu = 0 ;
                            continue;
                        }
                        if(menu == 2)//Mostrar todas las obras
                        {
                            registroObras.mostrarObras() ;
                            menu = 0;
                            continue;
                        }
                        if(menu == 3)//Obra terminada
                        {
                            //eliminar obra de RegistroObra
                            //Poner a las personas
                            menu = 0;
                            continue;
                        }
                        if(menu == 4) //Cambiar presupuesto
                        {
                            /*String nombre;
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
                            continue;*/
                        }
                        if(menu == 5)//Tiempo restante de una obra
                        {
                            /*String formato = "dd-MM-yyyy";
                            SimpleDateFormat asd = new SimpleDateFormat(formato);
                            String hoy;*/
                            /*String jejeje = "05-06-2022" ;
                            char[] q = new char[10] ;
                            q = jejeje.toCharArray();
                            FechaHoy fecha = new FechaHoy();
                            fecha.obterFecha(q);
                            //System.out.println(hoy);
                            menu = 0;
                            continue;*/
                        }
                        if(menu == 6)//gastos totales
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
                if(menu == 2)//Gestion de personas
                {
                    //esta previsto que existan mas funciones
                    System.out.println("1. Añadir empleado a la plataforma") ;
                    System.out.println("2. Mostrar empleados de una obra") ; // Esta opción no funciona
                    System.out.println("3. Mostrar todos los empleados") ;
                    System.out.println("4. mover empleados") ;
                    System.out.println("5. Despedir empleado"); // Esta opción no funciona
                    System.out.println("6. Eliminar empleado de la plataforma");
                    System.out.println("7. Cambiar sueldo de un empleado");
                    try
                    {
                        menu = scannerEnterosFlotantes.nextInt() ;
                        if(menu == 1) //Añadir empleado a la plataforma
                        {
                            añadirEmpleados(scannerStrings, scannerEnterosFlotantes, registroPersonas);
                            menu = 0 ;
                            continue ;
                                    
                        }
                        if(menu == 2)//mostrar empleados de una obra
                        {
                            
                        }
                        if(menu == 3) // Mostrar todos los empleados
                        {
                            System.out.println("Desea filtrar los datos?");
                            System.out.println("1. Por profesión");
                            System.out.println("2. Por sueldo");
                            System.out.println("3. Mostrar no asignados y asignados");
                            System.out.println("4. Mostrar sin filtro");
                            try{
                                listaPersonas(scannerStrings, scannerEnterosFlotantes, registroPersonas);
                                menu = 0;
                                continue ;
                            }
                            catch(Exception e)
                            {
                                System.out.println("Error opción no disponible volviendo al menú") ;
                                menu = 0;
                                continue;
                            }
                            
                        }
                        if(menu == 4)//Mover empleados
                        {
                            menu = 0;
                            continue;
                        }
                        if(menu == 5)//Despedir empleado
                        {
                            menu = 0;
                            continue;
                        }
                        if(menu == 6)//Eliminar empleado de la plataforma
                        {
                            String nombre ;
                            System.out.println("ingrese el nombre de la persona") ;
                            nombre = scannerStrings.nextLine() ;
                            registroPersonas.eliminarPersona(nombre);
                            
                            menu = 0 ;
                            continue ;
                        }
                        if(menu == 7)//Modificar un sueldo
                        {
                            menu = 0;
                        }
                    }
                    catch(Exception e) 
                    {
                        System.out.println("Error opción no disponible volviendo al menú") ;
                        menu = 0;
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println("Error opción no disponible volviendo al menú") ;
                menu = 0;
            }
            
        }while(menu != 3);
    }
    
    private static void añadirObra(Scanner scannerStrings, Scanner scannerEnterosFlotantes, RegistroObras registroObras) throws IOException
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
    }
    
    private static void añadirEmpleados(Scanner scannerStrings, Scanner scannerEnterosFlotantes, RegistroTrabajadores registroPersonas)
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

    private static void listaPersonas(Scanner scannerStrings, Scanner scannerEnterosFlotantes, RegistroTrabajadores registroPersonas) {
        int menu ;
        menu = scannerEnterosFlotantes.nextInt();
        if(menu == 1)//Por profecion 
        {
            String filtro;
            System.out.println("ingrese profesión");
            filtro = scannerStrings.nextLine();
            System.out.println("El filtro es: "+filtro);
            registroPersonas.mostrarPersona(filtro);
            return ;
        }
        if(menu == 2)//Por sueldo
        {
            int filtro;
            System.out.println("Ingrese sueldo");
            filtro = scannerEnterosFlotantes.nextInt();
            System.out.println("El filtro es: "+filtro);
            registroPersonas.mostrarPersona(filtro);
            return ;
        }
        if(menu == 3)//Asignado o no
        {                                   
            System.out.println("Desea ver los empleados asignados a una obra o los no asignados");
            System.out.println("1. asignados") ;
            System.out.println("2. no asignados") ;
            menu = scannerEnterosFlotantes.nextInt();
            if(menu == 1)
            {
                registroPersonas.mostrarPersona(true);
                return ;
            }
            else
            {
                registroPersonas.mostrarPersona(false);
                return ;
            }  
        }
        if(menu == 4)//Todos los empleados
        {
            registroPersonas.mostrarPersona();
        }
    }
}
    