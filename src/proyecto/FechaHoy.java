/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FechaHoy {
    
    //Variables de instancia
    private Date fecha;
    private SimpleDateFormat formato;
    private ArrayList<Integer> meses;

    //Constructor
    public FechaHoy() {
        
        meses = new ArrayList();
        llenarMeses() ;
        this.fecha = new Date();
        this.formato = new SimpleDateFormat("dd-MM-yyyy") ;
        
    }
    
    //Metodos publicos
    public void obterFecha(char[] fechaComparar)
    {
        if(!verificarEstructura(fechaComparar)) return;
        
        char[] fechaHoy = formato.format(fecha).toCharArray(); //la funcion crea una variable con la fecha de hoy        
        
        //datos de la fecha de hoy
        int yearHoy = obtenerYear(fechaHoy);
        int mesHoy = obtenerMes(fechaHoy);
        int diaHoy = obtenerDia(fechaHoy);
        
        //datos de la fecha a comparar
        int yearComparar = obtenerYear(fechaComparar);
        int mesComparar = obtenerMes(fechaComparar);
        int diaComparar = obtenerDia(fechaComparar);
        
        if(verificarFechas(yearHoy, mesHoy, diaHoy, yearComparar, mesComparar, diaComparar))
        {
            int diasR = diasRestantes(diaHoy, mesHoy, diaComparar, mesComparar) ;
            int MesesR = mesesRestantes(mesHoy, mesComparar);
            int yearR = yearRestante(yearComparar, yearHoy, mesHoy, mesComparar);
            System.out.println("quedan: " + diasR + " dias");
            System.out.println("quedan: " + MesesR + " meses");
            System.out.println("quedan: " + yearR + " años");
        }
    }
    
    //Metodos privados
    private boolean verificarEstructura(char[] fechaComparar) //se debe verificar que se cumpla la estructura base dd-MM-yyyy
    {
        if((fechaComparar[2] != '-') || (fechaComparar[5] != '-'))
        {
            System.out.println("ERROR la estructura de la fecha no es valida");
            return false;
        }
        try
        {
            Integer.parseInt(String.valueOf(fechaComparar[0])) ;
            Integer.parseInt(String.valueOf(fechaComparar[1])) ;
            Integer.parseInt(String.valueOf(fechaComparar[3])) ;
            Integer.parseInt(String.valueOf(fechaComparar[4])) ;
            Integer.parseInt(String.valueOf(fechaComparar[6])) ;
            Integer.parseInt(String.valueOf(fechaComparar[7])) ;
            Integer.parseInt(String.valueOf(fechaComparar[8])) ;
            Integer.parseInt(String.valueOf(fechaComparar[9])) ;
        }
        catch(Exception e)
        {
            System.out.println("ERROR la estructura de la fecha no es valida");
            return false;
        }
        return true;
    }
    
    private boolean verificarFechas(int yearHoy, int mesHoy, int diaHoy, int yearComparar, int mesComparar, int diaComparar)//Verificar que las fechas sean comparables 
    {
        if(yearHoy > yearComparar)
        {
            System.out.println("La obra esta fuera de fecha");
            return false ;
        }
        if((yearHoy == yearComparar) && (mesHoy > mesComparar))
        {
            System.out.println("La obra esta fuera de fecha");
            return false;
        }
        if((yearHoy == yearComparar) && (mesHoy == mesComparar) && (diaHoy > diaComparar))
        {
            System.out.println("La obra esta fuera de fecha");
            return false;
        }
        return true;
    }
    
    private int obtenerYear(char[] fechaComparar)
    {
        int i;
        int j;
        int year = 0;
        for(i = 9, j = 1; i > 5 ; i--,j = j*10)
        {
            if(fechaComparar[i] == 0) continue;
            year = (Integer.parseInt(String.valueOf(fechaComparar[i])) * j) + year;
        }
        return year;
    }
    private int obtenerMes(char[] fechaComparar)
    {
        int i;
        int j;
        int mes = 0;
        for(i = 4, j = 1; i > 2 ; i--,j = j*10)
        {
            if(fechaComparar[i] == 0) continue;
            mes = (Integer.parseInt(String.valueOf(fechaComparar[i])) * j) + mes;
        }
        return mes;
    }
    private int obtenerDia(char[] fechaComparar)
    {
        int i;
        int j;
        int dia = 0;
        for(i = 1, j = 1; i > -1 ; i--,j = j*10)
        {
            if(fechaComparar[i] == 0) continue;
            dia = (Integer.parseInt(String.valueOf(fechaComparar[i])) * j) + dia;
        }
        return dia;
    }
    
    private int diasRestantes(int diaHoy, int mesHoy, int diaComparar, int mesComparar)
    {
        /*
            se calculan los dias que faltan para terminar el termino del mes de fechaHoy
            ej: si el dia de hoy es 21 de mayo faltan 10 dias para terminar el mes
            a su vez se calculan los dias que pasaron de fechaComparar
            ej: si la fecha a comparar es 19 de octubre han pasado 19 dias desde el comienzo del mes
            estos 2 valores se suman dando como resultado se suma dando 29 dias restantes
        */
        int contadorDias = 0;
        if((mesComparar == 2) && (diaComparar == 29))
        {
            contadorDias++;
        }
        int i ;
        for(i = diaHoy ; i < meses.get(mesHoy) ; i++)
        {
            contadorDias++;
        }
        for(i = diaComparar - 1 ; i > 0 ; i--)
        {
            contadorDias++;
        }
        if(contadorDias > 29) contadorDias = contadorDias - 30;
        return contadorDias;
    }
    
    private int mesesRestantes(int mesHoy, int mesComparar) {
        
        int mesesRestantes = mesComparar - mesHoy;
        if(mesesRestantes > 0)
        {
            mesesRestantes--;
        }
        if(mesesRestantes < 0)
        {
            mesComparar = mesComparar + 12 ;
            mesesRestantes = mesComparar - mesHoy;
        }
        
        return mesesRestantes;
    }
    private int yearRestante(int yearComparar, int yearHoy, int mesHoy, int mesComparar) {
        if(mesComparar - mesHoy < 0)
        {
            return yearComparar - yearHoy - 1 ;
        }
        return yearComparar - yearHoy;
    }
    private void llenarMeses() {
        this.meses.add(31) ;
        this.meses.add(28) ;
        this.meses.add(31) ;
        this.meses.add(30) ;
        this.meses.add(31) ;
        this.meses.add(30) ;
        this.meses.add(31) ;
        this.meses.add(31) ;
        this.meses.add(30) ;
        this.meses.add(31) ;
        this.meses.add(30) ;
        this.meses.add(31) ;
    }

    

    

    

    
}
