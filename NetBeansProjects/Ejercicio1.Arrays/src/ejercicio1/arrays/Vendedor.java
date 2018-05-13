/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1.arrays;

/**
 *
 * @author 203pc19
 */
public class Vendedor {

    float ventas;
    String nombre;
    int codigoVendedor;

    public float getVentas() {
        return ventas;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCodigoVendedor() {
        return codigoVendedor;
    }

    public void setCodigoVendedor(int codigoVendedor) {
        this.codigoVendedor = codigoVendedor;
    }

    public void setVentas(float ventas) {
        this.ventas = ventas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método que me suma las ventas de un mismo vendedor
     *
     * @param importe recoge las ventas de cada vendedor
     */
    public void acumularVentas(float importe) {
        ventas = ventas + importe;
    }

    /* public float acumularVentas(float importe) {
        ventas = 0;
        ventas = ventas + importe;
        return ventas;
    }*/
    /**
     * Método que me calcula el total con la comisión aplicada
     *
     * @param porcentaje la comisón de cada categoría
     * @return devuelve el total con el porcentaje aplicado
     */
    public float CalcularComision(float porcentaje) {
        float total = 0;
        total = ventas * porcentaje;
        return total;
    }
}
