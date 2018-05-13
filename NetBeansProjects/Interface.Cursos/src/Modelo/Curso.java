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

    private String denominacion;
    private float importe;

    public Curso(String denominacion, float importe) {
        this.denominacion = denominacion;
        this.importe = importe;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public float getImporte() {
        return importe;
    }

    @Override
    public String toString() {//Si se escribe el nombre del objet, devuelveme la denominacion del mismo
        //Si ese objeto (en este caso se llama "i") esta dentro de un for, muestra la denominacion de todos.
    /*Poniendo solo esto "modelo1.addElement(c[i]);" te muestra lo mismo que
         esto "modelo1.addElement(c[i].getDenominacion());"*/
        return denominacion;
    }

}
