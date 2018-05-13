/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Admin
 */
public class Curso {
    private String nombre;
    private float precio;

    public Curso(String nombre, float precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public float getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString(){   //CUANDO TIENES UN OBJETO SI NO PONES NADA MAS, EN VEZ DE SACAR LA DIRECCION EN MEMORIA.
       return nombre;           //SOBREESCRIBE EL NOMBRE, PERO LLEVA TODO EL OBJETO EN VEZ DE LA DIRECCION.
    }

}
