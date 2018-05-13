/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2.arrays;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Mario
 */
public class LasFechas {

    private int dia;
    private int mes;
    private int anno;
        /*  un atributo estatico cambia cambia el valor que digamos en todos los objetos de la misma clase.
     Comparten esa información.*/
    private static int[] diasMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
        "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

    public LasFechas(int d, int m, int a) {//CONSTRUCTOR PARA LA FECHA QUE INTRODUZCA EL USUARIO
        this.dia = d;
        this.mes = m;
        this.anno = a;
    }

    public LasFechas() { //CONSTRUCTOR PARA LA FECHA ACTUAL
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


    /* public void cambio() {
     diasMes[1] = 77;
     }*/
    
    /*public void bisiesto() {
        if (anno % 4 == 0 && anno % 100 != 0 || anno % 400 == 0) {
            diasMes[1] = 29;
        } else {
            diasMes[1] = 28;
        }
    }*/
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
                 nos diga que es febrero y no marzo*/
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
    public int compararFechas(LasFechas fecha) {
        int resultado;
        if (anno > fecha.getAnno()) {
            resultado = 1;
            /*anno=año que introduce el usuario. Corresponde al constructor de la fecha de alta
            fecha.getAnno= fecha actual. Corresponde al constructor de la fecha actual*/
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

    /**
     * Te calcula los años de alta con el actual
     *
     * @return te devuelve el calculo de los años
     */
    public int calcularAnnos() {
        int annos;
        LasFechas fecha = new LasFechas();
        //Te resta los años actuales menos los introducido por el usuario
        annos = fecha.getAnno() - anno;
        /*Se crea un objeto en esta clase para poder acceder al constructor de fecha actual*/
                    /*anno=año que introduce el usuario. Corresponde al constructor de la fecha de alta
            fecha.getAnno= fecha actual. Corresponde al constructor de la fecha actual*/
        if (fecha.getMes() < mes || fecha.getMes() == mes && fecha.getDia() < dia) {
            annos--;
        }
        return annos;
    }

    /**
     * Te calcula los trienios en función de la diferencia del año de alta con
     * el actual
     *
     * @return devuelve el número de trienios correspondiente
     */
    public int calcularTrienios() {
        int trienios;
        trienios = calcularAnnos() / 3;
        return trienios;
    }

    public String visualizar() {//DEVUELVE LA FECHA COMPLETA INTRODUCIDA POR EL EMPLEADO
        return dia + "-" + meses[mes-1] + "-" + anno;
    }
}
