package Utilidades;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author 203pc19
 */
public class Fechas {

    private int dia;
    private int mes;
    private int anno;
    /*  un atributo estatico cambia cambia el valor que digamos en todos los objetos de la misma clase.
     Comparten esa información.*/
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

    public static int[] getDiasMes() {
        return diasMes;
    }

    public static String[] getMeses() {
        return meses;
    }


    /* public void cambio() {
     diasMes[1] = 77;
     }*/
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
     * Te calcula los años de alta con el actual
     *
     * @return te devuelve el calculo de los años
     */
    public int calcularAnnos() {
        int annos;
        Fechas f = new Fechas();
        //Te resta los años actuales menos los introducido por el usuario
        annos = f.getAnno() - anno;
        /*Se crea un objeto en esta clase para poder acceder al constructor de fecha actual*/
 /*anno=año que introduce el usuario. Corresponde al constructor de la fecha de alta
         fecha.getAnno= fecha actual. Corresponde al constructor de la fecha actual*/
        if (f.getMes() < mes || f.getMes() == mes && f.getDia() < dia) {
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

    /**
     * Te visualiza la fecha en formato dd/mm/aaaa en número
     *
     * @return la fecha completa en número
     */
    public String visualizar() {//DEVUELVE LA FECHA COMPLETA INTRODUCIDA POR EL EMPLEADO EN NÚMERO
        return dia + "-" + mes + "-" + anno;
    }

    /**
     * Te visualiza la fecha en formato dd/mm/aaaa con el mes en letra
     *
     * @return la fecha completa con el mes en letra
     */
    public String visualizar2() {//DEVUELVE LA FECHA COMPLETA INTRODUCIDA POR EL EMPLEADO EN LETRA
        return dia + "-" + meses[mes - 1] + "-" + anno;
    }

    /**
     * Te calcula los días que han pasado dentro del mismo año
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
     * Te calcula los días que han pasado entre dos fechas cualquiera dentro del
     * mismo año
     *
     * @param f objeto de tipo Fechas
     * @return te devuelve los dias que han pasado entre esas dos fechas
     */
    public int calcularOrdenEntreFechas(Fechas f) {
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

    /**
     * Te calcula los días que han pasado entre dos fechas
     *
     * @param f es la segunda fecha hasta la cual queremos saber cuantos días
     * faltan
     * @return me devuelve los días totales
     */
    public int calcularOrdenEntreFechasEntreAnnos(Fechas f) {
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
    public int numerodiasAnno() {
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
    public int numerodiasAnno(int a) {
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
        quedan = numerodiasAnno() - calcularOrden();
        return quedan;
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
     * Te calcula la nueva fecha partiendo de la fecha que le introducta el
     * usuario También te cambia de año si es necesario
     *
     * @param diasVen los días que se tiene de plazo introducidos por el usuario
     * @return devuelve la fecha nueva completa y la guarda en un objeto de tipo
     * Fechas
     */
    public Fechas obtenerFechaVencimiento2(int diasVen) {
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
        return new Fechas(d, m, a);
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
