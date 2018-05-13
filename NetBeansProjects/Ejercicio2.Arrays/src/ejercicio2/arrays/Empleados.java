/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2.arrays;

/**
 *
 * @author 203pc19
 */
public class Empleados {

    String nombre;
    private LasFechas f;

    public Empleados() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LasFechas getF() {//OBJETO DE TIPO LASFECHAS
        //En la clase LasFechas tenemos el día, mes y año
        return f;
    }

    public void setF(LasFechas f) {//RECOGE LA FECHA COMPLETA DEL TRABAJADOR
        //objeto de tipo la clase LasFechas
        this.f = f;
    }

}
