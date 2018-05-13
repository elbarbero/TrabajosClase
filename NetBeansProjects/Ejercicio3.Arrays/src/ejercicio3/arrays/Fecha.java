/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3.arrays;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Mario
 */
public class Fecha {

    private int dia;
    private int mes;
    private int anno;
    /*  un atributo estatico cambia cambia el valor que diagos en todos los objetos de la misma clase.
     Comparten esa información.*/
    private static int[] diasMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
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

    public static int[] getDiasMes() {
        return diasMes;
    }

    public static String[] getMeses() {
        return meses;
    }

    public void bisiesto() {
        if (anno % 4 == 0 && anno % 100 != 0 || anno % 400 == 0) {
            diasMes[1] = 29;
        } else {
            diasMes[1] = 28;
        }
    }

    public void bisiesto(int annos) {
        if (annos % 4 == 0 && annos % 100 != 0 || annos % 400 == 0) {
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
     * @param fecha objeto de tipo clase LasFechas
     * @return devuelve el rsultado final de la comparación
     */
    public int compararFechas(Fecha fecha) {
        int resultado;
        if (anno > fecha.getAnno()) {
            resultado = 1;
            /*fecha.* es la fecha actual y anno es la fecha que introduce el usuario*/
        } else if (anno < fecha.getAnno()) {
            resultado = -1;
        } else if (mes > fecha.getMes()) {
            resultado = 1;
        } else if (mes < fecha.getMes()) {
            resultado = -1;
        } else if (dia > fecha.getDia()) {
            resultado = 1;
        } else {
            resultado = -1;
        }
        return resultado;
    }

    public String visualizar() {//DEVUELVE LA FECHA COMPLETA INTRODUCIDA POR EL EMPLEADO
        return dia + "-" + mes + "-" + anno;
    }

    /**
     * Te calcula los días (de una fecha) que han pasado dentro del mismo año
     *
     * @return Devuelve la suma total de los días
     */
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
     * Te calcula los días que han pasado entre dos fechas cualquiera
     *
     * @param f objeto de tipo Fecha
     * @return te devuelve los dias que han pasado entre esas dos fechas
     */
    public int calcularOrdenEntreFechas(Fecha f) {
        int dias = 0;
        dias = diasMes[mes - 1] - dia;//LOS DATOS DEL QUE LLAMA AL METODO
        int m = 1;
        m = mes;
        m++;
        while (m < f.getMes()) {//F.GETMES() ES EL MES DEL DATO QUE ME PASAN
            dias = dias + diasMes[m - 1];
            m++;
        }
        dias = dias + f.getDia();//F.GETDIA() ES EL DIA DEL DATO QUE ME PASAN. EL QUE ESTÁ ENTRE PARENTESIS
        return dias;
    }

    /**
     * Te calcula los días que han pasado entre dos fechas
     *
     * @param f es la segunda fecha hasta la cual queremos saber cuantos días
     * faltan
     * @return me devuelve los días totales
     */
    public int calcularOrdenEntreFechasEntreAnnos(Fecha f) {
        int d = 0;
        int m = 1;
        d = diasMes[mes - 1] - dia;//LOS DATOS DEL QUE LLAMA AL METODO
        m = mes;
        //if (m < f.getMes()) {
        m++;
        //}
        int a = anno;
        if (m < f.getMes() || a < f.getAnno()) {
            while (m < f.getMes() || a < f.getAnno()) {//F.GETMES() ES EL MES DEL DATO QUE ME PASAN
                d = d + diasMes[m - 1];
                m++;
                if (m > 12) {
                    //d = d + diasMes[m - 1];
                    a++;
                    m = 1;
                    bisiesto(a);
                }
            }
            d = d + f.getDia();//F.GETDIA() ES EL DIA DEL DATO QUE ME PASAN
        } else {
            d = f.getDia() - dia;//EL MAYOR MENOS EL MENOR
        }
        return d;
    }

    /**
     * Te calcula si el año es bisiesto o no es bisiesto
     *
     * @return Te devuelve los dias totales que tiene el año
     */
    public int numeroDiasAnno() {
        int total;
        if (anno % 4 == 0 && anno % 100 != 0 || anno % 400 == 0) {
            total = 366;
        } else {
            total = 365;
        }
        return total;
    }

    /**
     * Te calcula si el año es bisiesto o no es bisiesto
     *
     * @param a variable referente al año que introduzcamos
     * @return Te devuelve los dias totales que tiene el año
     */
    public int numeroDiasAnno(int a) {
        int total;
        if (a % 4 == 0 && a % 100 != 0 || a % 400 == 0) {
            total = 366;
        } else {
            total = 365;
        }
        return total;
    }

    /**
     * Calcula los días que le quedan al año
     *
     * @return Te devuelve los dias restantes del año
     */
    public int diasHastaFinalAnno() {
        int quedan;
        quedan = numeroDiasAnno() - calcularOrden();
        return quedan;
    }
}
