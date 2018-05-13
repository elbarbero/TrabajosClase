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
public class Medicaciones {
    String codMedicacion;
    String denominacion;
    String Indicaciones;

    public Medicaciones(String codMedicacion, String denominacion, String Indicaciones) {
        this.codMedicacion = codMedicacion;
        this.denominacion = denominacion;
        this.Indicaciones = Indicaciones;
    }

    public String getCodMedicacion() {
        return codMedicacion;
    }

    public void setCodMedicacion(String codMedicacion) {
        this.codMedicacion = codMedicacion;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public String getIndicaciones() {
        return Indicaciones;
    }

    public void setIndicaciones(String Indicaciones) {
        this.Indicaciones = Indicaciones;
    }
    
        @Override
    public String toString() {
        return denominacion;
    }
}
