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
public class Empleado {

    String nombre;
    int horasExtra;//Número de horas extra que realiza
    int CodCategoria;

    /**
     * Constructor de la clase Empleado
     *
     * @param nombre guarda el nombre del empleado
     * @param horasExtra guarda el número de horas extra realizadas
     * @param CodCategoria guarda el número de la categoría
     */
   /* public Empleado(String nombre, int horasExtra, int CodCategoria) {
        this.nombre = nombre;
        this.horasExtra = horasExtra;
        this.CodCategoria = CodCategoria;
    }*/

    /*public Empleado() {

    }*/

    /*En esta clase, ponemos set porque cada empleado tendrá un nombre,
     unas horas extra y una categoria diferentes*/

    public String getNombre() {
        return nombre;
    }

    public int getHorasExtra() {
        return horasExtra;
    }

    public int getCodCategoria() {
        return CodCategoria;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setHorasExtra(int horasExtra) {
        this.horasExtra = horasExtra;
    }

    public void setCodCategoria(int CodCategoria) {
        this.CodCategoria = CodCategoria;
    }

    /**
     * Método para calcular el sueldo total de cada empleado
     *
     * @param sueldoBase guarda el sueldo base dependiendo de cada categoría
     * @param precioHora guarda el precio de la hora dependiendo de cada
     * categoría
     * @return nos devuelve el sueldo ya calculado
     */
    public float SueldoTotal(float sueldoBase, float precioHora) {
        float total = 0;
        total = (horasExtra * precioHora) + sueldoBase;
        return total;
    }
}
