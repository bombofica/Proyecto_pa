
/**
 * Programación Avanzada ICI3241-1
 * @author Benjamín Rojas
 * @author Andrés Vidal
 */


package com.registro.obras;
import com.registro.obras.Vista.*;
import com.registro.obras.Controlador.*;
import com.registro.obras.Modelo.ProyectoConstruccion;
import java.io.* ;
//import java.text.SimpleDateFormat;


public class main{
    public static void main(String params[]) throws IOException
    {

        //ReadFile.leerArchivo("RegistroObras//RegistroObras.txt");
        RegistroTrabajadores registroDeTrabajadores = new RegistroTrabajadores(); //registro de todos los trabajdores de la aplicacion
        RegistroObras registroObras = new RegistroObras();//registro de todas las obras de la aplicacion

        ReadFile.traerObras(',', 6,"RegistroObras" , registroDeTrabajadores, registroObras);//uso de archivos para obtener los datos
        ReadFile.tomarContenidosPersonas(',', 5, "RegistroObras//RegistroTrabajadores.txt", registroDeTrabajadores, null);
        //WriteFile.escribirObras(',', registroObras);
        //WriteFile.imprimirTodasLasPersonas(registroDeTrabajadores);
        //registroTrabajadores.mostrarEspecialistas("Informático");
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfazGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        InterfazGrafica interfaz = new InterfazGrafica(registroDeTrabajadores,registroObras);
        interfaz.setVisible(true);//llamado a la interfas grafica
        
        /*
        El resto del main son los llamados al menu por consola los cuales no se utilizan a menos que
        se le llamen con el metodo "inicio"
        */
        //inicio(registroDeTrabajadores, registroObras);
    }
}
    
