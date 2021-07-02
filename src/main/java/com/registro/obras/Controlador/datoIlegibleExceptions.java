/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registro.obras.Controlador;

import javax.swing.JOptionPane;
import javax.swing.JRootPane;

/**
 *
 * @author andre
 */
public class datoIlegibleExceptions extends Exception{
    
    public datoIlegibleExceptions()
    {
        super("ERROR se a generado una excepcion por un dato inesperado") ;
    }
}
