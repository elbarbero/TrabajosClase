/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen.programacion.pkg9_3_2017;

/**
 *
 * @author Mario
 */
public class Clientes {

    String cif;
    String nombre;
    Fechas fFac;
    int diasVen;
    float importeFac;

    public Clientes() {
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Fechas getfFac() {
        return fFac;
    }

    public void setfFac(Fechas fFac) {
        this.fFac = fFac;
    }

    public int getDiasVen() {
        return diasVen;
    }

    public void setDiasVen(int diasVen) {
        this.diasVen = diasVen;
    }

    public float getImporteFac() {
        return importeFac;
    }

    public void setImporteFac(float importeFac) {
        this.importeFac = importeFac;
    }
    
    public float calculoNeto(float descuento){
        float total;
        total=importeFac-descuento;
        return total;
    }
    
    public float calculoDescuento(float porcentaje){
        float total;
        total=importeFac*porcentaje;
        return total;
    }

}
