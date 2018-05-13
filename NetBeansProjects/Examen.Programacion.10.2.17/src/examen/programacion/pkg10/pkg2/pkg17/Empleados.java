/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen.programacion.pkg10.pkg2.pkg17;

/**
 *
 * @author Mario
 */
public class Empleados {

    String nombre;
    String provincia;
    float ventas;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public float getVentas() {
        return ventas;
    }

    public void setVentas(float ventas) {
        this.ventas = ventas;
    }

    public float calculoSueldo(int sBase, float porcentajeCalc) {
        float total;
        total = sBase + porcentajeCalc;
        return total;
    }

    public float calculoPorcentaje(float porcentaje) {
        float total;
        total = ventas * porcentaje;
        return total;
    }
}
