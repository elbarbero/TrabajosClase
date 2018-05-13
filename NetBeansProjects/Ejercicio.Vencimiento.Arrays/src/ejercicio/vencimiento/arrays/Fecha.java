/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio.vencimiento.arrays;

import java.util.Calendar;
import java.util.GregorianCalendar;
import Utilidades.Numeros;

/**
 *
 * @author 203pc19
 */
public class Fecha {

    int dia;
    int mes;
    int anno;
    private static int[] diasMes = {30, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
        "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

    public Fecha(int d, int m, int a) {
        this.dia = d;
        this.mes = m;
        this.anno = a;
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

    public int getMes() {
        return mes;
    }

    public int getAnno() {
        return anno;
    }

    public static int[] getDiasMes() {
        return diasMes;
    }

    public static String[] getMeses() {
        return meses;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
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

    public boolean comprobarFechas(int a, int m, int d) {
        boolean resultado = false;
        if (a > 1900 && a < 2100) {
            bisiesto(a);
            if (m >= 1 && m <= 12) {
                if (d >= 1 && d <= diasMes[m - 1]) {
                    resultado = true;
                    dia = d;
                    mes = m;
                    anno = a;
                }
            }
        }
        return resultado;
    }

    public int compararFechas(Fecha f) {
        int resultado = 0;
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

    public int calcularOrden() {
        int dias = 0;
        int m = 1;
        while (m < mes) {
            dias = dias + diasMes[m - 1];
            m++;
        }
        dias = dias + dia;
        return dias;
    }

    /**
     * Te calcula los días que han pasado entre dos fechas cualquiera dentro del
     * mismo año
     *
     * @param f objeto de tipo Fechas
     * @return te devuelve los dias que han pasado entre esas dos fechas
     */
    public int calcularOrdenEntreFechas(Fecha f) {
        int dias = 0;
        dias = diasMes[mes - 1] - dia;//LOS DATOS DEL QUE LLAMA AL METODO
        int m = 1;
        mes++;
        m = mes;
        while (m < f.getMes()) {//F.GETMES() ES EL MES DEL DATO QUE ME PASAN
            dias = dias + diasMes[m - 1];
            m++;
        }
        dias = dias + f.getDia();//F.GETDIA() ES EL DIA DEL DATO QUE ME PASAN
        return dias;
    }

    public String visualizar() {
        return dia + "-" + meses[mes - 1] + "-" + anno;
    }

    public String visualizar2(Fecha f) {
        return f.getDia() + "-" + meses[f.getMes() - 1] + "-" + f.getAnno();
    }

    /**
     * Te calcula la fecha partiendo de la fecha actual
     *
     * @return la nueva a partir de los dias introducidos
     */
    public String calcularLaFechaEntreFechas() {
        int d = 0;
        int m;
        d = dia;//dia del usuario
        Fecha f = new Fecha();//PARA EL AÑO ACTUAL
        m = f.getMes();
        while (m < f.getMes() - 1 || d > diasMes[m - 1]) {
            d = d - diasMes[m - 1];
            m++;
        }
        d = d + f.getDia();
        return d + "-" + meses[m - 1] + "-" + anno;
    }

    /**
     * Te calcula la nueva fecha partiendo de la fecha que le introducta el
     * usuario También te cambia de año si es necesario
     *
     * @param diasVen los días que se tiene de plazo introducidos por el usuario
     */
    public void obtenerFechaVencimiento(int diasVen) {
        dia = dia + diasVen;
        while (dia > diasMes[mes - 1]) {
            dia = dia - diasMes[mes - 1];
            mes++;
            if (mes > 12) {
                mes = 1;
                anno++;
            }
        }
    }

    /**
     * Te calcula la nueva fecha a partir de un fecha que le introduzcas
     *
     * @param f
     * @param diasVen
     */
    public Fecha obtenerFechaVencimientoDeFacturas(Fecha f, int diasVen) {
        int d = f.getDia();
        int m = f.getMes();
        int a = f.getAnno();
        d = d + diasVen;
        while (d > diasMes[m - 1]) {
            d = d - diasMes[m - 1];
            m++;
            if (m > 12) {
                m = 1;
                a++;
                bisiesto(a);
            }
        }
  
        return f;
    }

    /**
     * Te calcula la nueva fecha partiendo de la fecha que le introducta el
     * usuario También te cambia de año si es necesario
     *
     * @param diasVen los días que se tiene de plazo introducidos por el usuario
     * @return devuelve la fecha nueva completa y la guarda en un objeto de tipo
     * Fechas
     */
    public Fecha obtenerFechaVencimiento2(int diasVen) {
        int d = dia;
        int m = mes;
        int a = anno;
        d = d + diasVen;
        while (d > diasMes[m - 1]) {
            d = d - diasMes[m - 1];
            m++;
            if (m > 12) {
                m = 1;
                a++;
            }
        }
        dia=d;
        mes=m;
        anno=a;
        return new Fecha(dia, mes, anno);
    }

    /**
     * Te calcula la nueva fecha partiendo de la fecha que le introducta el
     * usuario También te cambia de año si es necesario
     *
     * @param diasVenc los días que se tiene de plazo introducidos por el
     * usuario
     * @return devuelve la fecha nueva completa ya visualizada
     */
    public String obtenerFechaVencimiento3(int diasVenc) {
        int d, m, a;
        d = dia;
        m = mes;
        a = anno;
        d = d + diasVenc;
        while (d > diasMes[m - 1]) {
            d = d - diasMes[m - 1];
            m++;
            if (m > 12) {
                a++;
                m = 1;
            }
        }
        return d + "-" + meses[m - 1] + "-" + a;
    }
}
