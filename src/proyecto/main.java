
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
//import java.text.SimpleDateFormat;


public class main{
    public static void main(String args[]) throws IOException
    {
        RegistroTrabajadores registroDeTrabajadores = new RegistroTrabajadores();
        
        RegistroObras registroObras = new RegistroObras();
        
        //ReadFile.crearDirectorio(regionesDeChile);
        
        ReadFile.traerObras(',', 4,"RegistroObras" , registroDeTrabajadores, registroObras);
        //registroDeTrabajadores.mostrarEspecialistas("Informático");
        //InterfazGrafica.main(new String[5]);
        InterfazGrafica interfaz = new InterfazGrafica(registroDeTrabajadores,registroObras);
        interfaz.setVisible(true);

        //Obra obra_nombre_valparaíso = registroObras.retornarObra("Nombre_Valparaíso", "Valparaiso");

        // probar la edición de obras por referencia
        //if(obra_nombre_valparaíso != null){
        //    Persona personaje = obra_nombre_valparaíso.buscarPersona("Gabriel Álvarez Chernobyl");
        //    if(personaje != null){
        //        System.out.println(personaje.getNombre());
        //    }            
        //}
        //else
       //{
        //    System.out.println("La Obra no existe");
        //}
        

        //personaje.setNombre("El gran Gabo Alvarez Chernoby");
        
        //Persona personaje2 = registroDeTrabajadores.buscarEspecialista(personaje.getLaborProfesional(),personaje.getRut());
        //personaje2.setNombre("Gabo alvarez quinta");
        //WriteFile.escribirObras(',', registroObras);
        
        inicio(registroDeTrabajadores, registroObras);

    }
    
    
    private static void inicio(RegistroTrabajadores registroPersonas, RegistroObras registroObras){
        
        ArrayList <Persona> arrayxd;      
        Object[] PulpaDeFrutilla = ReadFile.tomarContenidosPersonas(',',5,"RegistroTrabajadores.txt",registroPersonas);
        
        arrayxd =(ArrayList <Persona>) PulpaDeFrutilla[2];
        HashMap<String,Persona> hashpersonaxd =(HashMap <String,Persona>) PulpaDeFrutilla[0];
        
        //RegistroTrabajadores registroPersonas = new RegistroTrabajadores(arrayxd,hashpersonaxd);
        //RegistroObras registroObras = ReadFile.traerObras(',', 4, "RegistroObras",registroPersonas,registroObras); 
        
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
                //main.limpiarPantalla();
                
                if(menu == 1)//Gestion de obras
                {
                    //esta previsto que existan mas funciones
                    System.out.println("1. Añadir obra") ;
                    System.out.println("2. Mostrar todas las obras") ;
                    System.out.println("3. Obra terminada") ; //"Eliminar Obra"
                    System.out.println("4. Cambiar un dato de una obra"); 
                    System.out.println("5. Tiempo restante de una obra");
                    //System.out.println("6. Gastos totales");
                    try
                    {
                        menu = scannerEnterosFlotantes.nextInt() ;
                        if(menu == 1) //Añadir obra
                        {
                            agregarObra(scannerStrings, scannerEnterosFlotantes, registroObras);
                            menu = 0 ;
                            continue;
                        }
                        if(menu == 2)//Mostrar todas las obras
                        {
                            imprimirObras(scannerStrings, registroObras);
                            menu = 0;
                            continue;
                        }
                        if(menu == 3)//Obra terminada
                        {
                            obraTerminada(scannerStrings, registroObras) ;
                            menu = 0;
                            continue;
                        }
                        if(menu == 4) //Cambiar un dato
                        {
                            modificarDatos(scannerStrings, scannerEnterosFlotantes, registroObras) ;
                        }
                        if(menu == 5)//Tiempo restante de una obra
                        {
                            String fechaComparar =scannerStrings.nextLine() ;
                            char[] cadenaCaracteres = new char[10] ;
                            cadenaCaracteres = fechaComparar.toCharArray();
                            FechaHoy fecha = new FechaHoy();
                            fecha.obterFecha(cadenaCaracteres);
                            menu = 0;
                            continue;
                        }
                        if(menu == 6)//gastos totales
                        {
                            menu = 0;
                            continue;
                        }
                    }
                    catch(Exception e)
                    {
                        
                        System.out.println("Error!!! Opción no disponible volviendo al menú"+menu) ;
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
                            AgregarEmpleados(scannerStrings, scannerEnterosFlotantes, registroPersonas);
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
                            //registroPersonas.eliminarPersona(nombre); Agregar esta función
                            
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
    
    private static void agregarObra(Scanner scannerStrings, Scanner scannerEnterosFlotantes, RegistroObras registroObras) throws IOException
    {
        String nombre;
        String lugar;
        double presupuesto;
        String tiempoAsignado;
        System.out.println("Ingrese el nombre de la obra");
        nombre = scannerStrings.nextLine() ;
        if(registroObras.existenciaObra(nombre))
        {
                
            return;
        }
        System.out.println("Ingrese el lugar de la obra");
        lugar = scannerStrings.nextLine() ;
        System.out.println("Ingrese el presupuesto de la obra");
        presupuesto = scannerEnterosFlotantes.nextDouble() ;
        System.out.println("Ingrese el tiempo asignado de la obra");
        tiempoAsignado = scannerStrings.nextLine() ;
        Obra nuevaObra = new Obra(nombre, lugar, presupuesto, tiempoAsignado) ;
        registroObras.agregarObra(nuevaObra);
        WriteFile.escribirObras(',', registroObras);
        System.out.println("Obra agregada");
    }
    
    private static void imprimirObras(Scanner scannerStrings, RegistroObras registroObras)
    {
        System.out.println("Ingrese region para filtrar");
        System.out.println("Ingrese 1 si no desea filtrar");
        String filtro = scannerStrings.nextLine() ;
        if(filtro.equals("1"))
        {
            registroObras.mostrarObras() ;
        }
        else
        {
            registroObras.mostrarObras(filtro) ;
        }
    }
    
    private static void obraTerminada(Scanner scannerStrings, RegistroObras registroObras) {
        System.out.println("Ingrese el nombre de la obra finalizada");
        String nombreObra = scannerStrings.nextLine() ;
        registroObras.eliminarObra(nombreObra);
    }
    
    private static void modificarDatos(Scanner scannerStrings, Scanner scannerEnterosFlotantes, RegistroObras registroObras) {
        System.out.println("Ingrese el nombre de la obra a modificar");
        String nombreObra = scannerStrings.nextLine() ;
        System.out.println("Ingrese el atributo a modificar");
        System.out.println("1. Nombre de la obra");
        System.out.println("2. Region de la obra");
        System.out.println("3. Tiempo restante de la obra");
        System.out.println("4. Presupuesto asignado a la obra");
        int opcion = scannerEnterosFlotantes.nextInt() ;
        System.out.println("Ingrese el nuevo atributo");
        String nuevoDato = scannerStrings.nextLine() ;
        registroObras.modificarObra(nombreObra, nuevoDato, opcion);
    }
    
    private static void AgregarEmpleados(Scanner scannerStrings, Scanner scannerEnterosFlotantes, RegistroTrabajadores registroPersonas)
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
        //registroPersonas.agregarPersona(nuevoEmpleado); agregar esta funcion
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
            registroPersonas.mostrarEspecialistas(filtro);
            return ;
        }
        if(menu == 2)//Por sueldo
        {
            int filtro;
            System.out.println("Ingrese sueldo");
            filtro = scannerEnterosFlotantes.nextInt();
            System.out.println("El filtro es: "+filtro);
            //registroPersonas.mostrarPersona(filtro);Agregar esta función
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
                //registroPersonas.mostrarPersona(true); Agregar esta función
                return ;
            }
            else
            {
                // registroPersonas.mostrarPersona(false); Agregar esta función
                return ;
            }  
        }
        if(menu == 4)//Todos los empleados
        {
            //registroPersonas.mostrarPersona(); Agregar esta función
        }
    }
    
    public static void limpiarPantalla(){
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } catch (Exception e) {
            /*No hacer nada*/
        }
    }

    

    
    

}
    