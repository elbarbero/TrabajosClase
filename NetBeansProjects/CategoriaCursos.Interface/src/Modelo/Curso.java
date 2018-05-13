/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author 203pc19
 */
public class Curso {

    private String nombre;
    private float importe;

    public Curso(String nombre, float importe) {
        this.nombre = nombre;
        this.importe = importe;
    }

    public String getNombre() {
        return nombre;
    }

    public float getImporte() {
        return importe;
    }

}
