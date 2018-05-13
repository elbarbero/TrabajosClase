/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3.arrays;

import Utilidades.Numeros;

/**
 *
 * @author Mario
 */
public class Principal {

    int i = 0;

    public void operaciones() {
        Fecha f1 = new Fecha();
        Fecha f2 = new Fecha();
        Fecha Fmayor = new Fecha();
        Fecha Fmenor = new Fecha();
        int dias, a;
        f1 = pedirFecha();
        f2 = pedirFecha();
        if (f1.compararFechas(f2) == 1) {//Nos dice cual es la fecha mayor y cual es la menor
            Fmayor = f1;
            Fmenor = f2;
        } else {
            Fmayor = f2;
            Fmenor = f1;
        }
        System.out.println("La fecha mayor es: " + Fmayor.visualizar());
        System.out.println("La fecha menor es: " + Fmenor.visualizar());
        /*if (Fmayor.getAnno() != Fmenor.getAnno()) {
            dias = Fmenor.diasHastaFinalAnno();//dias=diasTotalesAño-diasKHanPasadoDeEseAño=diasKLeKdanAlAño
            dias = dias + Fmayor.calcularOrden();//dias=dias-diasKHanPasadoDeEseAño
            a = Fmenor.getAnno() + 1;
            while (a < Fmayor.getAnno()) {
                dias = dias + Fmayor.numeroDiasAnno(a);
                a++;
            }
            // System.out.println("Total de días: " + dias);
        } else {
            if (Fmenor.getMes() == Fmayor.getMes()) {
                dias = Fmayor.getDia() - Fmenor.getDia();
                //System.out.println("Total de días: " + dias);
            } else {
                dias = Fmayor.calcularOrden() - Fmenor.calcularOrden();
                /*Te resta los dias que han pasado de la fecha mayor menos los dias que
                han pasado de la fecha menor*/
                dias = Fmenor.calcularOrdenEntreFechas(Fmayor);//HA LO MISMO QUE LO ANTERIOIR
                //System.out.println("Total de días: " + dias);
           /* }
        }*/
         //System.out.println("Total de días: " + dias);

        System.out.println("Total de días: " + Fmenor.calcularOrdenEntreFechasEntreAnnos(Fmayor));//es lo mismo que todo lo anterior

    }

    public Fecha pedirFecha() {
        /*Fecha f = new Fecha();
        int dia, mes, anno;
        Numeros numero = new Numeros();
        i++;
        System.out.println("Introduce la " + i + "ª" + " fecha");
        System.out.println("---------------------------");
        dia = numero.pedirNumeroEntero("DÍA: ", 1, 31);
        mes = numero.pedirNumeroEntero("MES: ", 1, 12);
        anno = numero.pedirNumeroEntero("AÑO: ", 1900, 2100);
        while (!f.comprobarFecha(anno, mes, dia)) {
            System.out.println("FECHA INCORRECTA");
            dia = numero.pedirNumeroEntero("DÍA: ", 1, 31);
            mes = numero.pedirNumeroEntero("MES: ", 1, 12);
            anno = numero.pedirNumeroEntero("AÑO: ", 1900, 2100);
        }*/
        //HACE LO MISMO QUE LO DE ARRIBA
        Fecha f = new Fecha();
        int dia, mes, anno;
        int resultado = 1;
        Numeros numero = new Numeros();
        while (resultado == 1) {
            i++;
            System.out.println("Introduce la " + i + "ª" + " fecha");
            System.out.println("---------------------------");
            dia = numero.pedirNumeroEntero("DÍA: ", 1, 31);
            mes = numero.pedirNumeroEntero("MES: ", 1, 12);
            anno = numero.pedirNumeroEntero("AÑO: ", 1900, 2100);
            if (!f.comprobarFecha(anno, mes, dia)) {
                System.out.println("VUELVE A INTRODUCIR FECHA");
                resultado = 1;
            } else {
                resultado = -1;
            }
        }
        /*Este do-while hace lo mismo que el while anterior*/
 /*do {
            System.out.println("Introduce la " + i + "ª" + " fecha");
            System.out.println("---------------------------");
            dia = numero.pedirNumeroEntero("DÍA DE ALTA: ", 1, 31);
            mes = numero.pedirNumeroEntero("MES DE ALTA: ", 1, 12);
            anno = numero.pedirNumeroEntero("AÑO DE ALTA: ", 1900, 2100);
        } while (!f.comprobarFecha(dia, mes, dia));*/
        return f;
    }
}
