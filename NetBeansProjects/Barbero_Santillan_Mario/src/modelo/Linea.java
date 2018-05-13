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
public class Linea {

    String codigo;
    String denominacion;
    String frecuencia;
    String primeraParada;
    String ultimaParada;
    String paradasIntermedias;
    ArrayList<Paradas> parada;

    public Linea(String codigo, String denominacion, String frecuencia, String primeraParada, String ultimaParada, String paradasIntermedias) {
        this.codigo = codigo;
        this.denominacion = denominacion;
        this.frecuencia = frecuencia;
        this.primeraParada = primeraParada;
        this.ultimaParada = ultimaParada;
        this.paradasIntermedias = paradasIntermedias;
        this.parada = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public String getPrimeraParada() {
        return primeraParada;
    }

    public String getUltimaParada() {
        return ultimaParada;
    }

    public String getParadasIntermedias() {
        return paradasIntermedias;
    }

    public ArrayList<Paradas> getParadas() {
        return parada;
    }

    public Paradas getUnaParada(int posicion) {
        return parada.get(posicion);
    }
    @Override
    public String toString() {
        return denominacion;
    }
}
