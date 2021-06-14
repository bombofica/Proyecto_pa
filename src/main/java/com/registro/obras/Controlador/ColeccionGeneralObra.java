/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registro.obras.Controlador;

import com.registro.obras.Modelo.Obra;
import com.registro.obras.Modelo.ProyectoConstruccion;
import com.registro.obras.Modelo.ProyectoRestauracion;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Benjamín
 */
public class ColeccionGeneralObra {

    private HashMap<String, Obra> registro;
    private ArrayList<Obra> listaCompleta;

    public ColeccionGeneralObra() {
        this.registro = new HashMap();
        this.listaCompleta = new ArrayList();
    }

    public Obra retornarObra(int index) {
        if (index > this.listaCompleta.size() || index < this.listaCompleta.size()) {
            return listaCompleta.get(index);
        }
        return null;
    }

    public Obra retornarObra(String nombreObra) {

        if (this.existenciaObra(nombreObra)) {
            Obra obraPedida = this.registro.get(nombreObra);
            return obraPedida;
        }
        return null;
    }

    public Boolean existenciaObra(String obra) {        
        return this.registro.containsKey(obra) ;
    }

    public boolean agregarObra(Obra obraAgregar) { //Listo

        if (obraAgregar != null) {
            this.listaCompleta.add(obraAgregar);
            this.registro.put(obraAgregar.getNombreObra(), obraAgregar);
        }
        return true;
    }

    public Obra[] filtrarObrasPresupuesto(long parametro, int opcion) {
        ArrayList<Obra> filtrador = new ArrayList();
        int i;
        if (opcion == 0) //menor que
        {
            for (i = 0; i < this.listaCompleta.size(); i++) {
                if ((listaCompleta.get(i).getCodigo() == 1) && ((ProyectoConstruccion) (listaCompleta.get(i))).getPresupuesto() < parametro) {
                    filtrador.add(listaCompleta.get(i));
                }
                if ((listaCompleta.get(i).getCodigo() == 2) && ((ProyectoRestauracion) (listaCompleta.get(i))).getPresupuesto() < parametro) {
                    filtrador.add(listaCompleta.get(i));
                }
            }
            Obra[] listadoFiltrado = new Obra[filtrador.size()];
            for (i = 0; i < filtrador.size(); i++) {
                listadoFiltrado[i] = filtrador.get(i);
            }
            return listadoFiltrado;
        }
        if (opcion == 1) //mayor que
        {
            for (i = 0; i < this.listaCompleta.size(); i++) {
                if ((listaCompleta.get(i).getCodigo() == 1) && ((ProyectoConstruccion) (listaCompleta.get(i))).getPresupuesto() > parametro) {
                    filtrador.add(listaCompleta.get(i));
                }
                if ((listaCompleta.get(i).getCodigo() == 2) && ((ProyectoRestauracion) (listaCompleta.get(i))).getPresupuesto() > parametro) {
                    filtrador.add(listaCompleta.get(i));
                }
            }
            Obra[] listadoFiltrado = new Obra[filtrador.size()];
            for (i = 0; i < filtrador.size(); i++) {
                listadoFiltrado[i] = filtrador.get(i);
            }
            return listadoFiltrado;
        }
        return null;
    }

    public Obra filtrarObrasPresupuesto(int opcion) {
        int i;
        Obra obraSeleccionada = null;
        for (i = 0; i < this.listaCompleta.size(); i++) {
            if (this.listaCompleta.get(i).getCodigo() == 1) {
                obraSeleccionada = retornarObra(i);
                break;
            }
            if (this.listaCompleta.get(i).getCodigo() == 1) {
                obraSeleccionada = retornarObra(i);
                break;
            }
        }
        if (obraSeleccionada != null) {
            if (opcion == 2) //maximo
            {
                int codigo;
                for (i = 0; i < this.listaCompleta.size(); i++) {
                    codigo = obraSeleccionada.getCodigo();
                    if (codigo == 1) {
                        if (this.listaCompleta.get(i).getCodigo() == 1) {
                            if (((ProyectoConstruccion) (obraSeleccionada)).getPresupuesto() < ((ProyectoConstruccion) (this.listaCompleta.get(i))).getPresupuesto()) {
                                obraSeleccionada = this.listaCompleta.get(i);
                                continue;
                            }
                        }
                        if (this.listaCompleta.get(i).getCodigo() == 2) {
                            if (((ProyectoConstruccion) (obraSeleccionada)).getPresupuesto() < ((ProyectoRestauracion) (this.listaCompleta.get(i))).getPresupuesto()) {
                                obraSeleccionada = this.listaCompleta.get(i);
                                continue;
                            }
                        }
                    }
                    if (codigo == 2) {
                        if (this.listaCompleta.get(i).getCodigo() == 1) {
                            if (((ProyectoRestauracion) (obraSeleccionada)).getPresupuesto() < ((ProyectoConstruccion) (this.listaCompleta.get(i))).getPresupuesto()) {
                                obraSeleccionada = this.listaCompleta.get(i);
                                continue;
                            }
                        }
                        if (this.listaCompleta.get(i).getCodigo() == 2) {
                            if (((ProyectoRestauracion) (obraSeleccionada)).getPresupuesto() < ((ProyectoRestauracion) (this.listaCompleta.get(i))).getPresupuesto()) {
                                obraSeleccionada = this.listaCompleta.get(i);
                            }
                        }
                    }
                }
                return obraSeleccionada;
            }
            if (opcion == 3) //minimo
            {
                int codigo;
                for (i = 0; i < this.listaCompleta.size(); i++) {
                    codigo = obraSeleccionada.getCodigo();
                    if (codigo == 1) {
                        if (this.listaCompleta.get(i).getCodigo() == 1) {
                            if (((ProyectoConstruccion) (obraSeleccionada)).getPresupuesto() > ((ProyectoConstruccion) (this.listaCompleta.get(i))).getPresupuesto()) {
                                obraSeleccionada = this.listaCompleta.get(i);
                                continue;
                            }
                        }
                        if (this.listaCompleta.get(i).getCodigo() == 2) {
                            if (((ProyectoConstruccion) (obraSeleccionada)).getPresupuesto() > ((ProyectoRestauracion) (this.listaCompleta.get(i))).getPresupuesto()) {
                                obraSeleccionada = this.listaCompleta.get(i);
                                continue;
                            }
                        }
                    }
                    if (codigo == 2) {
                        if (this.listaCompleta.get(i).getCodigo() == 1) {
                            if (((ProyectoRestauracion) (obraSeleccionada)).getPresupuesto() > ((ProyectoConstruccion) (this.listaCompleta.get(i))).getPresupuesto()) {
                                obraSeleccionada = this.listaCompleta.get(i);
                                continue;
                            }
                        }
                        if (this.listaCompleta.get(i).getCodigo() == 2) {
                            if (((ProyectoRestauracion) (obraSeleccionada)).getPresupuesto() > ((ProyectoRestauracion) (this.listaCompleta.get(i))).getPresupuesto()) {
                                obraSeleccionada = this.listaCompleta.get(i);
                            }
                        }
                    }
                }
                return obraSeleccionada;
            }
        }

        return null;
    }

    public int eliminarObra(Obra obraEliminar) throws IOException //Listo
    {
        //en el archivo se elimina la obra original y se vuelve a crear el registro sin esta
        if (existenciaObra(obraEliminar.getNombreObra())) {
            this.registro.remove(obraEliminar.getNombreObra());
            this.listaCompleta.remove(obraEliminar);
            return this.registro.size();
        }
        return -1;
    }

    public void presupuestoGeneral() //presupuesto total de la compañia
    {
        Obra obraActual;
        long balanceObra;
        long balanceTotal = 0;
        for (int i = 0; i < this.numeroObras(); i++) {
            obraActual = listaCompleta.get(i);
            balanceObra = presupuestoGeneral(obraActual.getNombreObra());
            balanceTotal += balanceObra;
        }
        System.out.println(balanceTotal);
    }

    public long presupuestoGeneral(String nombreObra) //presupuesto particular de una obra
    {
        Obra obraEvaluar;
        long balance;
        obraEvaluar = this.registro.get(nombreObra);
        balance = obraEvaluar.getSumaSueldos();
        System.out.println(nombreObra);
        System.out.println(balance);
        //System.out.println(obraEvaluar.getPresupuestoObra()) ;
        //balance = (long) (obraEvaluar.getPresupuestoObra() - balance) ;
        return balance;
    }

    public long gatosTotales() {
        long gastos = 0;
        for (int i = 0; i < listaCompleta.size(); i++) {
            gastos += listaCompleta.get(i).getSumaSueldos();
        }
        return gastos;
    }

    public long ingresosTotales() {
        long ingresos = 0;
        for (int i = 0; i < listaCompleta.size(); i++) {
            //ingresos += listaCompleta.get(i).getPresupuestoObra() ;
        }
        return ingresos;
    }

    public int numeroObras() {
        return this.registro.size();
    }

}
