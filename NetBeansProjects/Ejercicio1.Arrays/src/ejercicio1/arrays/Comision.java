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
public class Comision {

    float importeHasta;
    float porcentaje;

    /*Ponemos el constructor para poder crear las comisiones en la clase Empresa*/
    public Comision(float importeHasta, float porcentaje) {
        this.importeHasta = importeHasta;
        this.porcentaje = porcentaje;
    }

    public float getImporteHasta() {
        return importeHasta;
    }

    public float getPorcentaje() {
        return porcentaje;
    }

}
