/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen.programacion.pkg9_3_2017;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Mario
 */
public class Fechas {

    private int dia;
    private int mes;
    private int anno;
    private static int[] diasMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
        "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

    public Fechas(int d, int m, int a) {//CONSTRUCTOR PARA LA FECHA QUE INTRODUZCA EL USUARIO
        this.dia = d;
        this.mes = m;
        this.anno = a;
    }

    public Fechas() {//CONSTRUCTOR PARA LA FECHA ACTUAL
        Calendar c = new GregorianCalendar();
        dia = c.get(Calendar.DAY_OF_MONTH);
        mes = c.get(Calendar.MONTH) + 1;//PONEMOS +1 POR FEBRERO. PARA QUE PONGA EN VEZ DE MES 1, MES 2
        anno = c.get(Calendar.YEAR);
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

    public void bisiesto() {
        if ((anno % 4 == 0 && anno % 100 != 0 || anno % 400 == 0)) {
            diasMes[1] = 29;
        } else {
            diasMes[1] = 28;
        }
    }

    public void bisiesto(int anno) {
        if ((anno % 4 == 0 && anno % 100 != 0 || anno % 400 == 0)) {
            diasMes[1] = 29;
        } else {
            diasMes[1] = 28;
        }
    }

    /**
     * Comprueba si la fecha es correcta
     *
     * @param d es el día del mes
     * @param m es el mes del año
     * @param a es el año
     * @return nos devuelve si es correcto o no
     */
    public boolean comprobarFecha(int a, int m, int d) {
        boolean resultado = false;
        if (a > 1900 && a < 2100) {
            bisiesto(a);
            if (m >= 1 && m <= 12) {
                /*Ponemos ",-1" porque el array va desde la posición 0 a la 11, es decir,
                 que si metemos la fecha 12-2-2015, nos va a llevar a la posción 3
                 del array que corresponde al mes Marzo. Por eso restamos -1, para que si ponemos mes 2,
                 nos diga que es febreoo y no marzo*/
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

    /**
     * Te compara dos fechas. Te compara el dia, mes y año de cada fecha
     *
     * @param f objeto de tipo clase Fechas
     * @return devuelve el rsultado final de la comparación
     */
    public int compararFechas(Fechas f) {
        int resultado;
        if (anno > f.getAnno()) {
            resultado = 1;
            /*anno=año que introduce el usuario. Corresponde al constructor de la fecha de alta
             fecha.getAnno= fecha actual. Corresponde al constructor de la fecha actual*/
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

    /**
     * Te visualiza la fecha en formato dd/mm/aaaa con el mes en letra
     *
     * @return la fecha completa con el mes en letra
     */
    public String visualizar() {//DEVUELVE LA FECHA COMPLETA INTRODUCIDA POR EL EMPLEADO EN LETRA
        return dia + "-" + meses[mes - 1] + "-" + anno;
    }

    public Fechas obtenerFechaVencimiento(Fechas f, int diasVen) {
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
}
