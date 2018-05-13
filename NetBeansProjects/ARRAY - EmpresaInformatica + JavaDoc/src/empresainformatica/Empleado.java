/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresainformatica;

/**
 *
 * @author Admin R30
 */
public class Empleado {

    String nombre;
    int horas;
    int categoria;

    /**
     * Constructor del Empleado.
     *
     * @param nombre Nombre del Empleado.
     * @param horas Horas trabajadas.
     * @param categoria Categoria del trabajador.
     */
//    public Empleado(String nombre, int horas, int categoria) {
//        this.nombre = nombre;
//        this.horas = horas;
//        this.categoria = categoria;
//    }
    
    /**
     * Constructor de empleado.
     */
    public Empleado() {
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public int getHoras() {
        return horas;
    }

    /**
     *
     * @param horas
     */
    public void setHoras(int horas) {
        this.horas = horas;
    }

    /**
     *
     * @return
     */
    public int getCategoria() {
        return categoria;
    }

    /**
     *
     * @param categoria
     */
    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    /**
     * Calculo de salario empleado.
     *
     * @param extras Importe de la hora extra.
     * @param sBase Salario Base.
     * @return salario Salario calculado.
     */
    public float Salario(float extras, float sBase) {
        float salario = 0;
        salario = horas * extras + sBase; // extras y sBase lo paso desde empresa
        return salario;
    }

}
