/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam_prog_2015_empleados;

/**
 *
 * @author Mario Barbero
 */
public class Categoria {

    String nomCategoria;
    float precioHora;
    float sueldoBase;

    /**
     * Constructor de la clase Categoría
     *
     * @param nomCategoria Guarda el nombre de la categoría
     * @param precioHora guarda el precio a la que se paga cada hora
     * @param sueldoBase guarda el sueldo base de cada categoría
     */
    public Categoria(String nomCategoria, float precioHora, float sueldoBase) {
        this.nomCategoria = nomCategoria;
        this.precioHora = precioHora;
        this.sueldoBase = sueldoBase;
    }

    public String getNomCategoria() {
        return nomCategoria;
    }

    public float getPrecioHora() {
        return precioHora;
    }

    public float getSueldoBase() {
        return sueldoBase;
    }

}
