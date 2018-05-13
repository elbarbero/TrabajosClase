/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import vistas.pnInsertarEventAdmin;

/**
 *
 * @author 203pc19
 */
public class Fecha {

    Empresa miEmpresa;
    int dia;
    int mes;
    int anno;
    int hora;
    int minuto;
    int segundo;

    public Fecha() {
        Calendar c = new GregorianCalendar();
        dia = c.get(Calendar.DAY_OF_MONTH);
        mes = c.get(Calendar.MONTH) + 1;
        anno = c.get(Calendar.YEAR);

        hora = c.get(Calendar.HOUR_OF_DAY);
        minuto = c.get(Calendar.MINUTE);
        segundo = c.get(Calendar.SECOND);
    }
    private static int[] diasMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
        "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

    public Fecha(int d, int m, int a) {//CONSTRUCTOR PARA LA FECHA QUE INTRODUZCA EL USUARIO
        this.dia = d;
        this.mes = m;
        this.anno = a;
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

    public void bisiesto() {
        if ((anno % 4 == 0 && anno % 100 != 0 || anno % 400 == 0)) {
            diasMes[1] = 29;
        } else {
            diasMes[1] = 28;
        }
    }

    public int compararFechas(Fecha f) {
        int resultado;
        if (anno > f.getAnno()) {
            resultado = 1;
            /*anno=año que introduce el usuario. Corresponde al constructor de la fecha de alta
             f.getAnno= fecha actual. Corresponde al constructor de la fecha actual*/
        } else if (anno < f.getAnno()) {
            resultado = -1;
        } else if (mes > f.getMes()) {
            resultado = 1;
        } else if (mes < f.getMes()) {
            resultado = -1;
        } else if (dia > f.getDia()) {
            resultado = 1;
        } else {
            resultado = -1;
        }
        return resultado;
    }

    public int calcularDiaDelMes(int mes) {
        int dias;
        dias=diasMes[mes];
        return dias;
    }

    public String visualizar() {
        return dia + "-" + mes + "-" + anno;
    }

    public String visualizarHora() {
        return hora + ":" + minuto + ":" + segundo;
    }

    @Override
    public String toString() {
        return dia + "-" + mes + "-" + anno;
    }
}
