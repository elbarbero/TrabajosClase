/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.Fechas;

/**
 *
 * @author Mario
 */
public class MovGastos {
    String cocepto;
    Fechas fecha;
    int numMovimiento, numAlumno;
    double importe;

    public MovGastos(String cocepto, Fechas fecha, int numMovimiento, int numAlumno, double importe) {
        this.cocepto = cocepto;
        this.fecha = fecha;
        this.numMovimiento = numMovimiento;
        this.numAlumno = numAlumno;
        this.importe = importe;
    }

    public String getCocepto() {
        return cocepto;
    }

    public void setCocepto(String cocepto) {
        this.cocepto = cocepto;
    }

    public Fechas getFecha() {
        return fecha;
    }

    public void setFecha(Fechas fecha) {
        this.fecha = fecha;
    }

    public int getNumMovimiento() {
        return numMovimiento;
    }

    public void setNumMovimiento(int numMovimiento) {
        this.numMovimiento = numMovimiento;
    }

    public int getNumAlumno() {
        return numAlumno;
    }

    public void setNumAlumno(int numAlumno) {
        this.numAlumno = numAlumno;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
    
    
}
