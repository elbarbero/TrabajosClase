/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Mario
 */
public class Curso {

    String codCurso;
    String denominacion;
    int nPlazasDisp;

    public Curso(String codCurso, String denominacion, int nPlazasDisp) {
        this.codCurso = codCurso;
        this.denominacion = denominacion;
        this.nPlazasDisp = nPlazasDisp;
    }

    public String getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(String codCurso) {
        this.codCurso = codCurso;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public int getnPlazasDisp() {
        return nPlazasDisp;
    }

    public void setnPlazasDisp(int nPlazasDisp) {
        this.nPlazasDisp = nPlazasDisp;
    }

    @Override
    public String toString() {
        /*Con el metodo toString nos muestra el nombre en vez de la direccion 
        de la memoria donde se guarda*/
        return denominacion;
    }

}
