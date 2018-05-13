/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleadosarray;

/**
 *
 * @author 203pc19
 */
public class Categoria {
    private String nomCategoria;
    private float tarifa;

    public Categoria(String nomCategoria, float tarifa) {
        /*Los contructores inicializan sus valores por defecto o a unos valores que nos interesan*/
        /*Esto es el constructor con las variables que necesitamos*/
        this.nomCategoria = nomCategoria;
        this.tarifa = tarifa;
    }

    public String getNomCategoria() {
        return nomCategoria;
    }

    public float getTarifa() {
        return tarifa;
    }
    
}
