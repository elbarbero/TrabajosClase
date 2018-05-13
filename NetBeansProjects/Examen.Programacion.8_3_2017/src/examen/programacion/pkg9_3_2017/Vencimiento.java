/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen.programacion.pkg9_3_2017;

/**
 *
 * @author Mario
 */
public class Vencimiento {
    int dias;
    float descuento;

    public Vencimiento(int dias, float descuento) {
        this.dias = dias;
        this.descuento = descuento;
    }

    public int getDias() {
        return dias;
    }

    public float getDescuento() {
        return descuento;
    }
    
}
