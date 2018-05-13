/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio28.libreria2;

/**
 *
 * @author 203pc19
 */
public class TipoLibro {

    private int contado;
    private int credito;
    private String nombre;

    public TipoLibro(String nombre) {
        this.nombre = nombre;
    }

    public int getContado() {
        return contado;
    }

    public int getCredito() {
        return credito;
    }

    public String getNombre() {
        return nombre;
    }

    public int totalLibros() {
        int total;
        total = contado + credito;
        return total;
    }

    public float porContado() {
        int total = totalLibros();
        float por = 0;
        try {
            por = (float) contado / totalLibros() * 100;
        } catch (ArithmeticException ex) {
        }
        return por;
    }

    public float porCredito() {
        int total = totalLibros();
        float por = 0;
        if (total != 0) {
            por = (float) credito / totalLibros() * 100;
        }
        return por;
    }

    public void acumularContado() {
        contado++;
    }

    public void acumularCredito() {
        credito++;
    }
}
