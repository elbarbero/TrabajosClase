/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author 203pc19
 */
public class Paradas {

    String codigo;
    String denominacion;

    public Paradas(String codigo, String denominacion) {
        this.codigo = codigo;
        this.denominacion = denominacion;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDenominacion() {
        return denominacion;
    }
    
    @Override
    public String toString() {
        /*Con el metodo toString nos muestra el nombre en vez de la direccion 
         de la memoria donde se guarda*/
        return denominacion;
    }
}
