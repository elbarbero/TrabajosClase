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
public class Categoria {

    private String tarifa;
    private float sBase;
    private float extras;

    /**
     *
     * @param tarifa Nombre de la tarifa.
     * @param sBase Salario Base.
     * @param extras Horas Extras.
     */
    public Categoria(String tarifa, float sBase, float extras) {
        this.tarifa = tarifa;
        this.sBase = sBase;
        this.extras = extras;
    }

    /**
     *
     * @return tarifa
     */
    public String getTarifa() {
        return tarifa;
    }

    /**
     *
     * @return sBase
     */
    public float getsBase() {
        return sBase;
    }

    /**
     *
     * @return extras
     */
    public float getExtras() {
        return extras;
    }

}
