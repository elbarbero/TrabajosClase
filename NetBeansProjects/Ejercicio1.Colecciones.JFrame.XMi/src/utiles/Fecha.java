/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;


import java.util.Calendar;
import java.util.GregorianCalendar;

public class Fecha {

    private int dia, mes, ano;
    private static int[] diasMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static String[] nombresMes = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

    public Fecha() { //Si no pasamos datos, pone la fecha de la maquina.
        Calendar calendario; //Declaramos un objeto de tipo calendar llamado calendario.
        calendario = new GregorianCalendar(); //Creamos un calendario Gregoriano llamado calendario.
        dia = calendario.get(Calendar.DAY_OF_MONTH);
        mes = calendario.get(Calendar.MONTH) + 1;// Enero lo posiciona en el 0.
        ano = calendario.get(Calendar.YEAR);
    }

    public Fecha(int d, int m, int a) {
        this.dia = d;
        this.mes = m;
        this.ano = a;
    }

    public void bisiesto() {
        if (ano % 4 == 0 && ano % 100 != 0 || ano % 400 == 0) {
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

    public int numeroDiasAno() {
        int numero = 365;
        if (ano % 4 == 0 && ano % 100 != 0 || ano % 400 == 0) {
            numero = 366;
        }
        return numero;
    }

    public int numeroDiasAno(int a) {
        int numero = 365;
        if (a % 4 == 0 && a % 100 != 0 || a % 400 == 0) {
            numero = 366;
        }
        return numero;
    }

    public boolean comprobarFecha(int d, int m, int a) {
        boolean resultado = false;
        if (a >= 1990 && a <= 2100) {                 //Revisa los años permitidos
            bisiesto(a);                            // Verifica si el año es bisiesto
            if (m >= 1 && m <= 12) {                // Revisa los meses
                if (d >= 1 && d <= diasMes[m - 1]) {// Verifica los dias del mes entre 1 y los dias maximos del mes (restando uno al mes para cuadrar la posicion del array)
                    resultado = true;
                    dia = d;
                    mes = m;
                    ano = a;
                }
            }
        }
        return resultado;
    }

    public int compararFecha(Fecha f) {
        int comparacion;
        if (this.ano > f.getAno()) {
            comparacion = 1;
        } else if (this.ano < f.getAno()) {
            comparacion = -1;
        } else if (this.mes > f.getMes()) {
            comparacion = 1;
        } else if (this.mes < f.getMes()) {
            comparacion = -1;
        } else if (this.dia > f.getDia()) {
            comparacion = 1;
        } else if (this.dia < f.getDia()) {
            comparacion = -1;
        } else {
            comparacion = 0;
        }
        return comparacion;
    }

    public int calcularAnos() {
        Fecha f = new Fecha();
        int anos = f.getAno() - ano;
        if (f.getMes() < mes || f.getMes() == mes && f.getDia() < dia) {
            anos--;
        }
        return anos;
    }

    public int calcularTrienios() {
        int anos = calcularAnos();
        int trienios = anos / 3;
        return trienios;
    }

    public int calcularOrden() {
        int dias = 0;
        bisiesto();
        int mesAuxiliar = 1;
        while (mesAuxiliar > mes) {
            dias = dias + diasMes[mesAuxiliar - 1];
            mesAuxiliar++;
            dias = dias + dia;
        }
        return dias;
    } // Dias restantes del mes

    public int calcularOrdenEntreFechas(Fecha f) {
        int dias;
        bisiesto();
        dias = diasMes[mes - 1] - dia; //Calcula el resto de los dias del mes - el dia

        int m = mes++;// Crea variable del mes (m) e incrementamos 1 para pasar al mes siguiente.

        while (m < f.getMes()) {
            dias = dias + diasMes[m - 1]; //Calcula los dias + los dias del mes siguiente al completo. 0-31 1-28 2-31 Restamos-1 en el array
            m++;
        }
        dias = dias + f.getDia(); //Dias + los dias que tenga en la fecha 

        return dias;
    }

    public int diasFinalAno() {
        int quedan = numeroDiasAno() - calcularOrden();
        return quedan;
    }

    public String visualizar() {
        return dia + " de " + nombresMes[mes - 1] + " de " + ano;
    }

    ///////////////////
    public Fecha pedirFecha() {
        Fecha f = new Fecha();
        int dia, mes, ano;
        Numeros numero = new Numeros();

        ano = numero.pedirnumeroEntero("AÑO:", 1990, 2100);
        mes = numero.pedirnumeroEntero("MES:", 1, 12);
        dia = numero.pedirnumeroEntero("DIA:", 1, 31);

        while (!f.comprobarFecha(dia, mes, ano)) {
            System.out.println("FECHA INCORRECTA");
            ano = numero.pedirnumeroEntero("AÑO:", 1990, 2100);
            mes = numero.pedirnumeroEntero("MES:", 1, 12);
            dia = numero.pedirnumeroEntero("DIA:", 1, 31);
        }

        return f;
    }
    ///////////////////

    public Fecha obtenerFechaVencimiento(int diasVencimiento) {
        
        Fecha fVen= new Fecha();

        dia = dia + diasVencimiento;        //Suma los dias a los de diasVencimiento
        while (dia > diasMes[mes - 1]) {    //Mientras dia sea mayor a los dias del mes. 
            dia = dia - diasMes[mes - 1];   //Resta a dia los dias del Mes.
            mes++;                          //Suma 1 al mes
            if (mes > 12) {                 //Si el mes es mayor a 12
                mes = 1;                    //Pone el mes a Enero
                ano++;                      // Suma 1 al año.
            }
        }

        return fVen;
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

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public static int[] getDiasMes() {
        return diasMes;
    }

    public static void setDiasMes(int[] aDiasMes) {
        diasMes = aDiasMes;
    }

    public static String[] getNombresMes() {
        return nombresMes;
    }

    public static void setNombresMes(String[] aNombresMes) {
        nombresMes = aNombresMes;
    }
}
