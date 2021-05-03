
/**
 * Programación Avanzada ICI3241-1
 * @author Benjamín Rojas
 * @author Andrés Vidal
 */


package proyecto;
import java.io.* ;
import java.util.Scanner;
//import java.text.SimpleDateFormat;


public class main{
    public static void main(String params[]) throws IOException
    {
        RegistroTrabajadores registroDeTrabajadores = new RegistroTrabajadores(); //registro de todos los trabajdores de la aplicacion
        RegistroObras registroObras = new RegistroObras();//registro de todas las obras de la aplicacion
        ReadFile.traerObras(',', 4,"RegistroObras" , registroDeTrabajadores, registroObras);//uso de archivos para obtener los datos
        InterfazGrafica interfaz = new InterfazGrafica(registroDeTrabajadores,registroObras);
        interfaz.setVisible(true);//llamado a la interfas grafica
        
        /*
        El resto del main son los llamados al menu por consola los cuales no se utilizan a menos que
        se le llamen con el metodo "inicio"
        */
        inicio(registroDeTrabajadores, registroObras);
        
    }
    
    
    private static void inicio(RegistroTrabajadores registroPersonas, RegistroObras registroObras){
        
        /*ArrayList <Persona> arrayxd;      
        Object[] PulpaDeFrutilla = ReadFile.tomarContenidosPersonas(',',5,"RegistroObras//RegistroTrabajadores.txt",registroPersonas);
        
        arrayxd =(ArrayList <Persona>) PulpaDeFrutilla[2];
        HashMap<String,Persona> hashpersonaxd =(HashMap <String,Persona>) PulpaDeFrutilla[0];*/
        
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
                if(menu == 3)
                {
                    System.exit(0);
                    //break;
                }
                if(menu == 1)//Gestion de obras
                {
                    System.out.println("1. Añadir obra") ;
                    System.out.println("2. Mostrar todas las obras") ;
                    System.out.println("3. Obra terminada") ; //"Eliminar Obra"
                    System.out.println("4. Cambiar un dato de una obra"); 
                    System.out.println("5. Tiempo restante de una obra"); //esta funcion no esta lista ya que falta implementarlo con las obras
                    /*System.out.println("6. Gastos totales"); existe la opcion 6 la cual realiza esta funcion pero tenemos pensado
                                                               implementar un grafico*/
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
                            menu = 0;
                            continue;
                        }
                        if(menu == 5)//Tiempo restante de una obra
                        {
                            System.out.println("Ingrese la fecha acomparar");
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
                            registroObras.PresupuestoGeneral();
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
                    System.out.println("1. Añadir empleado a la plataforma") ;
                    //System.out.println("2. Mostrar empleados de una obra") ;
                    System.out.println("2. Mostrar empleados") ;
                    //System.out.println("4. mover empleados") ;
                    //System.out.println("5. Despedir empleado");
                    System.out.println("3. Eliminar empleado de la plataforma");
                    System.out.println("4. Cambiar un dato de un empleado");
                    try
                    {
                        menu = scannerEnterosFlotantes.nextInt() ;
                        if(menu == 1) //Añadir empleado a la plataforma
                        {
                            AgregarEmpleados(scannerStrings, scannerEnterosFlotantes, registroPersonas);
                            menu = 0 ;
                            continue ;
                        }
                        if(menu == 2) // Mostrar empleados
                        {
                            System.out.println("Ingrese profecion para filtrar");
                            String filtro = scannerStrings.nextLine() ;
                            registroPersonas.mostrarPersona(filtro);
                            menu = 0 ;
                            continue ;
                        }
                        if(menu == 3)//Eliminar empleado de la plataforma
                        {
                            
                            int rut ;
                            String profesion ;
                            System.out.println("ingrese el rut de la persona") ;
                            rut = scannerEnterosFlotantes.nextInt() ;
                            System.out.println(rut) ;
                            System.out.println("ingrese la profesion de la persona") ;
                            profesion = scannerStrings.nextLine() ;
                            Obra obraActual = registroObras.retornarObra(registroPersonas.buscarEspecialista(profesion, rut).getObraALaQuePertenece()) ;
                            registroPersonas.eliminarEspecialista(profesion, rut , obraActual) ;
                            WriteFile.escribirObras(',', registroObras);
                            menu = 0 ;
                            continue ;
                        }
                        if(menu == 4)//Modificar un sueldo
                        {
                            String nuevoDato;
                            System.out.println("Ingrese rut de la persona");
                            int rut = scannerEnterosFlotantes.nextInt() ;
                            System.out.println("Ingrese la profecion de la persona");
                            String profesion = scannerStrings.nextLine() ;
                            Persona sujetoModificar = registroPersonas.buscarEspecialista(profesion, rut) ;
                            System.out.println("Ingrese el atributo a modificar");
                            System.out.println("Ingrese el atributo a modificar");
                            System.out.println("1. Nombre del especialista");
                            System.out.println("2. Labor en la obra");
                            System.out.println("3. Sueldo");
                            int opcion = scannerEnterosFlotantes.nextInt() ;
                            switch(opcion)
                            {
                                case 1:
                                {
                                    System.out.println("Ingrese el nuevo nombre de la persona");
                                    nuevoDato = scannerStrings.nextLine() ;
                                    registroPersonas.modificarEspecialistaNombre(sujetoModificar, nuevoDato) ;
                                    WriteFile.escribirObras(',', registroObras);
                                    break;
                                }
                                case 2:
                                {
                                    System.out.println("Ingrese la nueva labor de la persona");
                                    nuevoDato = scannerStrings.nextLine() ;
                                    registroPersonas.modificarEspecialistaLaborProfesional(sujetoModificar, nuevoDato) ;
                                    WriteFile.escribirObras(',', registroObras);
                                    break ;
                                }
                                case 3:
                                {
                                    System.out.println("Ingrese la nueva labor de la persona");
                                    int nuevoSueldo = scannerEnterosFlotantes.nextInt() ;
                                    registroPersonas.modificarEspecialistaSueldo(sujetoModificar, nuevoSueldo) ;
                                    WriteFile.escribirObras(',', registroObras);
                                }
                                
                            }
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
        String Region;
        double presupuesto;
        String tiempoAsignado;
        
        System.out.println("Ingrese el nombre de la obra");
        
        nombre = scannerStrings.nextLine() ;
        
        if(registroObras.existenciaObra(nombre))
        {
            System.out.println("la obra ingresada ya existe") ;
            return;
        }
        System.out.println("Ingrese la region de la obra");
        Region = scannerStrings.nextLine() ;
        System.out.println("Ingrese el presupuesto de la obra");
        presupuesto = scannerEnterosFlotantes.nextDouble() ;
        System.out.println("Ingrese el tiempo asignado de la obra");
        System.out.println("ej: 28-04-2021");// verificar que esto se cumpla
        tiempoAsignado = scannerStrings.nextLine() ;
        Obra nuevaObra = new Obra(nombre, Region, presupuesto, tiempoAsignado) ;
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
    
    private static void obraTerminada(Scanner scannerStrings, RegistroObras registroObras) throws IOException {
        System.out.println("Ingrese el nombre de la obra finalizada");
        String nombreObra = scannerStrings.nextLine() ;
        registroObras.eliminarObra(nombreObra, registroObras);
    }
    
    private static void modificarDatos(Scanner scannerStrings, Scanner scannerEnterosFlotantes, RegistroObras registroObras) throws IOException {
        System.out.println("Ingrese el nombre de la obra a modificar");
        String nombreObra = scannerStrings.nextLine() ;
        if(!registroObras.existenciaObra(nombreObra)){
            System.out.println("ERROR la obra ingresada no existe");
            return;
        }
        System.out.println("Ingrese el atributo a modificar");
        System.out.println("1. Nombre de la obra");
        System.out.println("2. Region de la obra");
        System.out.println("3. Tiempo restante de la obra");
        System.out.println("4. Presupuesto asignado a la obra");
        int opcion = scannerEnterosFlotantes.nextInt() ;
        System.out.println("Ingrese el nuevo atributo");
        String nuevoDato = scannerStrings.nextLine() ;
        registroObras.modificarObra(nombreObra, nuevoDato, opcion, registroObras);
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
        Persona nuevoEmpleado = new Persona(nombre,labor,sueldo,rut,false,"") ;
        registroPersonas.agregarEspecialista(nuevoEmpleado);
        WriteFile.imprimirTodasLasPersonas(registroPersonas);
    }
    
    public static void limpiarPantalla(){
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } catch (Exception e) {
            /*No hacer nada*/
        }
    }
}
    
