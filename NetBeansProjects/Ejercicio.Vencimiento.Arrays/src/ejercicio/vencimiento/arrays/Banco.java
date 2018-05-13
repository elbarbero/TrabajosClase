/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio.vencimiento.arrays;

import Utilidades.Numeros;

/**
 *
 * @author 203pc19
 */
public class Banco {

    public void pedirDatos() {
        Numeros numero = new Numeros();
        Fecha f = new Fecha();
         Fecha f2 = new Fecha();
          Fecha f3 = new Fecha();
        Fecha fVenc = new Fecha();
        Fecha fActual = new Fecha();
        int d = 0, diasVen, m, a;
        int resultado = 1;

        while (resultado == 1) {
            d = numero.pedirNumeroEntero("DIAS: ", 1);
            m = numero.pedirNumeroEntero("MES: ", 1, 12);
            a = numero.pedirNumeroEntero("AÑO: ", 1900, 2100);
            if (!f.comprobarFechas(a, m, d)) {
                System.out.println("ERROR");
                resultado = 1;
            } else {
                f.setDia(d);
                f.setMes(m);
                f.setAnno(a);
                resultado=-1;
            }
        }
        diasVen = numero.pedirNumeroEntero("DIAS DE VENCIMIENTO: ", 0);
        // System.out.println("PARTIENDO DESDE LA FECHA ACTUAL DENTRO DEL MISMO AÑO");
        //System.out.println(f.calcularLaFechaEntreFechas());
        System.out.println("PARTIENDO DESDE LA FECHA INTRODUCIDA");
        System.out.println(f.obtenerFechaVencimiento3(diasVen));// no hace falta visualizar xk ya nos devuelve la fecha en formato string
        
           System.out.println("Lo que guarda f antes de modificar");
        System.out.println(f.visualizar());
        /*f2=*/f.obtenerFechaVencimiento2(diasVen);//xk el metodo es de tipo fecha, por eso llamamos a visualizar
        f3.setDia(f.getDia());
        System.out.println("Lo que guarda f despues de");
        System.out.println(f.visualizar());
        System.out.println("Lo que guarda f2");
        System.out.println(f2.visualizar());
        System.out.println("El día que guarda f3");
        System.out.println(f3.getDia());
        
        //fVenc guarda la fecha actual
        fVenc.obtenerFechaVencimientoDeFacturas(f, diasVen);//xk el metodo es de tipo fecha, por eso llamamos a visualizar mas adelante
        // con este método modificamos f,la que está entre los parentesis.

        if(f.getMes()==fVenc.getMes()){
            //para sacar si el mes el mismo que cuando caducan las facturas
            System.out.println("TU CONTRATO HA EXPIRADO");
        }else{
            System.out.println(f.visualizar());
        }
    }
}
