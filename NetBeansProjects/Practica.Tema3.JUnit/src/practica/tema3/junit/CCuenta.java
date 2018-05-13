/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.tema3.junit;

/**
 *
 * @author 203pc19
 */
public class CCuenta {
    // Propiedades de la Clase Cuenta

    private String nombre;
    private String cuenta;
    private int saldo;
    private double tipoInteres;

    /* Constructor sin argumentos */
    public CCuenta() {
    }

    public CCuenta(String nom, String cue, int sal, double tipo) {
        nombre = nom;
        cuenta = cue;
        saldo = sal;
        tipoInteres = tipo;
    }

    public void asignarNombre(String nom) {
        nombre = nom;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public double estado() {
        return saldo;
    }

    public void ingresar(int cantidad) throws Exception {
        //Los métodos void no devuelven nada
        if (cantidad < 0) {
            System.out.println("no se puede ingresar una cantidad negativa");}
            saldo = saldo + cantidad;
        

    }

    public int retirar(int cantidad) throws Exception {
        if (cantidad < 0) {
            System.out.println("no se puede retirar una cantidad negativa");
        } else {
            if (estado() < cantidad) {
                System.out.println("No hay suficiente saldo");
            } else {
                saldo = saldo - cantidad;
            }
        }
        return cantidad;
    }

    public String obtenerCuenta() {
        return cuenta;
    }
}
