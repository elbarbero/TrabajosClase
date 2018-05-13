/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen.entornos.junit;

/**
 *
 * @author 203pc19
 */
public class Articulo {

    String codBarras;
    String denominacion;
    int existencias;//LAS EXISTENCIAS ACTUALES QUE TENEMOS EN EL ALMCAEN
    int existenciasMinimas;
    float precioVenta;

    public Articulo(int existencias, int existenciasMinimas, float precioVenta) {
        this.existencias = existencias;
        this.existenciasMinimas = existenciasMinimas;
        this.precioVenta = precioVenta;
    }

    public boolean avisoCompra() {
        boolean comprar = false;
        if (existencias < existenciasMinimas) {
            comprar = true;
        }
        return comprar;
    }

    public void recepcionMercancias(int cantidad, float precioCompra) {
        precioVenta = ((existencias * precioVenta) + (cantidad * precioCompra * 1.1f)) / (existencias + cantidad);
        existencias = existencias + cantidad;
    }

}
