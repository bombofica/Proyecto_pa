/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FechaHoy {
    
    private Date fecha;
    private SimpleDateFormat formato;

    public FechaHoy() {
        this.fecha = new Date();
        this.formato = new SimpleDateFormat("dd-MM-yyyy") ;
    }
    
    public void obterFecha(char[] fechaComparar)
    {
        char[] xd = formato.format(fecha).toCharArray();

        int year = obtenerYear(xd);
        int anoComparar = obtenerYear(fechaComparar);
        
        year = anoComparar - year;
        System.out.println("quedan:" + year + "años");

        int mes;
        int dia;
        
        
    }
    private int obtenerYear(char[] xd)
    {
        int i;
        int j;
        int year = 0;
        for(i = 9, j = 1; i > 5 ; i--,j = j*10)
        {
            year = (Integer.parseInt(String.valueOf(xd[i])) * j) + year;
        }
        return year;
    }
}
