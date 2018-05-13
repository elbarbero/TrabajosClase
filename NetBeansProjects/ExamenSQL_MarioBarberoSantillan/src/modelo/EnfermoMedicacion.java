/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author 203pc19
 */
public class EnfermoMedicacion {
        String numSegSocial;
            String codMedicacion;

    public EnfermoMedicacion(String numSegSocial, String codMedicacion) {
        this.numSegSocial = numSegSocial;
        this.codMedicacion = codMedicacion;
    }

    public String getNumSegSocial() {
        return numSegSocial;
    }

    public String getCodMedicacion() {
        return codMedicacion;
    }
            
}
