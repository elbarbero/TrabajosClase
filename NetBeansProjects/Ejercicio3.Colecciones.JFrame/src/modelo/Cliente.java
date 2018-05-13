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
public class Cliente {

    String cif;
    String nombre;
    String direccion;
    String poblacion;
    ArrayList<Sala> alquiladas;

    public Cliente(String cif, String nombre, String direccion, String poblacion) {
        this.cif = cif;
        this.nombre = nombre;
        this.direccion = direccion;
        this.poblacion = poblacion;
        alquiladas = new ArrayList<>();/*Así reservamos un espacio para cuando el 
         cliente reserve una o más salas*/

    }

    public String getCif() {
        return cif;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public ArrayList<Sala> getAlquiladas() {//me devuelve todas las salas que tengo alquiladas
        return alquiladas;
    }

    public Sala getunAlquiler(int pos) {//me devuelve una sala alquilada. La que ocupe dicha posicion (pos)
        return alquiladas.get(pos);
    }

    public void anadirNuevoAlquiler(Sala s) {
        alquiladas.add(s);
    }

    @Override
    public String toString() {
        return nombre;
    }
}
