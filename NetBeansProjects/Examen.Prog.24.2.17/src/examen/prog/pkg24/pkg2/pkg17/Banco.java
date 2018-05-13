/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen.prog.pkg24.pkg2.pkg17;

import Utilidades.Numeros;
import Utilidades.Caracteres;

/**
 *
 * @author Mario
 */
public class Banco {

    Clientes[] miCliente;
    Gratificaciones[] miGratificacion;

    public Banco(int nEmple) {
        miCliente = new Clientes[nEmple];
        crearClientes();
        miGratificacion = new Gratificaciones[4];
        crearGratificaciones();
    }

    public void crearClientes() {
        for (int nEmple = 0; nEmple < miCliente.length; nEmple++) {
            miCliente[nEmple] = new Clientes();
        }
    }

    public void crearGratificaciones() {
        miGratificacion[0] = new Gratificaciones(10, 12);
        miGratificacion[1] = new Gratificaciones(12, 15);
        miGratificacion[2] = new Gratificaciones(14, 18);
        miGratificacion[3] = new Gratificaciones(16, 24);
    }

    public int busquedaEdad(int edad) {
        int pos = 0;
        boolean encontrado = false;
        while (!encontrado && pos < miGratificacion.length) {
            if (edad <= miGratificacion[pos].getEdad()) {
                encontrado = true;
            } else {
                pos++;
            }
        }
        return pos;
    }

    public void pedirDatos() {
        Numeros numero = new Numeros();
        Caracteres caracter = new Caracteres();
        Fecha fActual = new Fecha();
        int resultado = 1;
        int resultado2 = 1;
        int d = 0, m = 0, a = 0;
        int i = 0;
        for (int nEmple = 0; nEmple < miCliente.length; nEmple++) {
            Fecha fApertura = new Fecha();
            Fecha fNacim = new Fecha();
            System.out.println("--------------------" + (i + 1) + "º cliente---------------");
            miCliente[nEmple].setNombre(caracter.pedirString("INTRODUCIR NOMBRE: "));
            while (resultado == 1) {//PARA LA FECHA DE NACIMIENTO
                d = numero.pedirNumeroEntero("DÍA DE NACIMIENTO: ", 1, 31);
                m = numero.pedirNumeroEntero("MES DE NACIMIENTO: ", 1, 12);
                a = numero.pedirNumeroEntero("AÑO DE NACIMIENTO: ", 1900, 2100);
                if (!fNacim.comprobarFecha(a, m, d)) {
                    System.out.println("INCORRECTO");
                    resultado = 1;
                } else {
                    resultado = fNacim.compararFecha(fActual);
                }
            }
            miCliente[nEmple].setfNac(fNacim);
            while (resultado2 == 1) {//PARA LA FECHA DE APERTURA
                d = numero.pedirNumeroEntero("DÍA DE APERTURA: ", 1, 31);
                m = numero.pedirNumeroEntero("MES DE APERTURA: ", 1, 12);
                a = numero.pedirNumeroEntero("AÑO DE APERTURA: ", 1900, 2100);
                if (!fApertura.comprobarFecha(a, m, d)) {
                    System.out.println("INCORRECTO");
                    resultado2 = 1;
                } else {
                    resultado2 = fApertura.compararFecha(fActual);
                }
            }
            miCliente[nEmple].setfApert(fApertura);
            resultado = 1;
            resultado2 = 1;
            i++;
        }
    }

    public void informe() {
        int edad, fApertura, posEdad;
        int contador = 0;
        Fecha f = new Fecha();
        System.out.println("-----------------------------" + f.visualizar() + "-----------------------------");//TE DA LA FECHA ACTUAL
        System.out.println("NOMBRE" + "\t" + "\t" + "NACIMIENTO" + "\t" + "\t" + "EDAD" + "\t" + "\t" + "GRATIFICACIÓN");
        System.out.println("--------------------------------------------------------------------");
        for (int nEmple = 0; nEmple < miCliente.length; nEmple++) {
            edad = miCliente[nEmple].getfNac().calcularAnnos();
            fApertura = miCliente[nEmple].getfApert().getAnno();
            posEdad = busquedaEdad(edad);
            if (fApertura == f.getAnno() && edad <= 16) {
                System.out.println(miCliente[nEmple].getNombre() + "\t" + "\t" + miCliente[nEmple].getfNac().visualizar() + "\t" + "\t"
                        + edad + "\t" + "\t" + miGratificacion[posEdad].getCantidad() + "€");
                contador++;
            }
        }
        if (contador == 0) {
            System.out.println("NADIE CUMPLE LOS REQUISITOS");
        }
    }
}
