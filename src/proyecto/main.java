
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
        Scanner pupi = new Scanner(System.in) ;
        int menu = 0;
        //menu
        do
        {
            System.out.println("1. Gestion de obras") ;
            System.out.println("2. Gestion de empreados") ;
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
                    menu = pupi.nextInt() ;
                    try
                    {
                        if(menu == 1) // gestion de archivos xdxd
                        {
                            
                        }
                        if(menu == 2)
                        {
                            RegistroObras registro = new RegistroObras() ;
                            registro.mostrarObras() ;
                        }
                        if(menu == 3)
                        {
                            
                        }
                        if(menu == 4)
                        {
                            String nombre;
                            int nuevoPresupuesto;
                            RegistroObras registro = new RegistroObras() ;
                            registro.mostrarObras() ;
                            System.out.println("Ingrese el nombre de la obra");
                            nombre = pupi.nextLine() ;
                            Obra obraSeleccionada ;
                            obraSeleccionada = registro.retornarObra(nombre) ;
                            System.out.println("Ingrese el nuevo presupuesto");
                            nuevoPresupuesto = pupi.nextInt() ;
                            obraSeleccionada.cambiarPresupuesto(nuevoPresupuesto) ;
                        }
                        if(menu == 5) continue;
                    }
                    catch(Exception e)
                    {
                        System.out.println("payasito") ;
                    }
                }
                if(menu == 2)
                {
                    System.out.println("1. Añadir empleado a la plataforma") ;
                    System.out.println("2. Mostrar empleados de una obra") ;
                    System.out.println("3. Mostrar todos los empleados") ;
                    System.out.println("4. Despedir empleado");
                    System.out.println("");
                    System.out.println("4. Cancelar");
                    //memu = pupi.nextInt() ;
                    
                }
            }
            catch(Exception e)
            {
                System.out.println("lel") ;
            }
            menu = 0 ;
        }while(menu != 3);
    }
}
    