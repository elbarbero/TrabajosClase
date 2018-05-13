/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen.prog2.pkg24_2_17;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Mario
 */
public class Fecha {

    int dia;
    int mes;
    int anno;
    private static int[] diasMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
        "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

    public Fecha(int dia, int mes, int anno) {
        this.dia = dia;
        this.mes = mes;
        this.anno = anno;
    }

    public Fecha() {
        Calendar c = new GregorianCalendar();
        dia = c.get(Calendar.DAY_OF_MONTH);
        mes = c.get(Calendar.MONTH) + 1;
        anno = c.get(Calendar.YEAR);
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public void bisiesto() {
        if (anno % 4 == 0 && anno % 100 != 0 || anno % 400 == 0) {
            diasMes[1] = 29;
        } else {
            diasMes[1] = 28;
        }
    }

    public void bisiesto(int a) {
        if (a % 4 == 0 && a % 100 != 0 || a % 400 == 0) {
            diasMes[1] = 29;
        } else {
            diasMes[1] = 28;
        }
    }

    public boolean comprobarFecha(int a, int m, int d) {
        boolean encontrado = false;
        if (a > 1900 && a < 2100) {
            bisiesto(a);
            if (m >= 1 && m <= 12) {
                if (d >= 1 && d <= diasMes[m - 1]) {
                    encontrado = true;
                    dia = d;
                    mes = m;
                    anno = a;
                }
            }
        }
        return encontrado;
    }

    public int compararFecha(Fecha f) {
        int resultado = 1;
        if (anno < f.getAnno()) {
            resultado = -1;
        } else if (anno > f.getAnno()) {
            resultado = 1;
        } else if (mes < f.getMes()) {
            resultado = -1;
        } else if (mes > f.getMes()) {
            resultado = 1;
        } else if (dia < f.getDia()) {
            resultado = -1;
        } else {
            resultado = 1;
        }
        return resultado;
    }

    public String visualizar() {
        return dia + "-" + meses[mes - 1] + "-" + anno;
    }

    public int calcularAnnos() {
        Fecha f = new Fecha();
        int a;
        a = f.getAnno() - anno;
        if (mes > f.getMes() || mes == f.getMes() && dia > f.getDia()) {
            a--;
        }
        return a;
    }
}
