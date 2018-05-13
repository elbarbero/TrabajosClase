/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen.programacion.pkg9_3_2017;

import Utilidades.Caracteres;
import Utilidades.Numeros;

/**
 *
 * @author Mario
 */
public class Empresa {

    Clientes[] miCliente;
    Vencimiento[] miVencimiento;

    public Empresa(int nEmple) {
        miCliente = new Clientes[nEmple];
        crearClientes();
        miVencimiento = new Vencimiento[5];
        crearVencimiento();
    }

    public void crearClientes() {
        for (int nEmple = 0; nEmple < miCliente.length; nEmple++) {
            miCliente[nEmple] = new Clientes();
        }
    }

    public void crearVencimiento() {
        miVencimiento[0] = new Vencimiento(30, 0.10f);
        miVencimiento[1] = new Vencimiento(90, 0.07f);
        miVencimiento[2] = new Vencimiento(120, 0.05f);
        miVencimiento[3] = new Vencimiento(180, 0.02f);
        miVencimiento[4] = new Vencimiento(Integer.MAX_VALUE, 0);
    }

    private int busquedaDesc(int diasVen) {
        int pos = 0;
        boolean encontrado = false;
        while (!encontrado && pos < miVencimiento.length) {
            if (diasVen <= miVencimiento[pos].getDias()) {
                encontrado = true;
            } else {
                pos++;
            }
        }
        return pos;
    }

    public void pedirDatos() {
        Fechas fActual = new Fechas();
        Numeros numero = new Numeros();
        Caracteres caracter = new Caracteres();
        int d = 0, m = 0, a = 0, resultado = 1;
        float importe = 0;
        for (int nEmple = 0; nEmple < miCliente.length; nEmple++) {
            Fechas fFac = new Fechas();
            miCliente[nEmple].setCif(caracter.pedirString("Introduce el CIF: "));
            miCliente[nEmple].setNombre(caracter.pedirString("Introduce el nombre: "));
            while (resultado == 1) {
                d = numero.pedirNumeroEntero("DÍA DE LA FACTURA: ", 1, 31);
                m = numero.pedirNumeroEntero("MES DE LA FACTURA: ", 1, 12);
                a = numero.pedirNumeroEntero("AÑO DE LA FACTURA: ", 1900, 2100);
                if (!fFac.comprobarFecha(a, m, d)) {
                    System.out.println("VUELVE A INTRODUCIR FECHA");
                } else {
                    resultado = fFac.compararFechas(fActual);
                }
            }
            miCliente[nEmple].setfFac(fFac);
            resultado = 1;
            miCliente[nEmple].setDiasVen(numero.pedirNumeroEntero("Indroduce los días de vencimiento: ", 0));
            miCliente[nEmple].setImporteFac(numero.pedirNumeroEntero("Importe de la factura: ", 0));
        }
    }

    public void informe() {
        int posPorc = 0, diasVen = 0, contador = 0;
        float importeNeto = 0, porcentaje = 0, calcDescuento = 0, totalNetos = 0;
        Fechas fActual = new Fechas();
        Fechas fVen = new Fechas();
        System.out.println("-------------------IMPORTE DE FACTURAS------------------");
        System.out.println("---------------" + fActual.visualizar() + "---------------");
        System.out.println("CIF" + "\t" + "\t" + "NOMBRE" + "\t" + "\t" + "FECHA FACTURA" + "\t" + "\t"
                + "FECHA VENCIMIENTO" + "\t" + "\t" + "IMPORTE BRUTO" + "\t" + "\t" + "IMPORTE NETO");
        System.out.println("--------------------------------------------------------------------------------------");
        for (int nEmple = 0; nEmple < miCliente.length; nEmple++) {
            diasVen = miCliente[nEmple].getDiasVen();//GUARDAS LOS DIAS DE VENCIMIENTO DEL CLIENTE
            posPorc = busquedaDesc(diasVen);//GUARDA LA POSICION DEL PORCENTAJE CORRECTO
            porcentaje = miVencimiento[posPorc].getDescuento();//GUARDA EL DESCUENTO DEL VENCIMIENTO
            calcDescuento = miCliente[nEmple].calculoDescuento(porcentaje);
            importeNeto = miCliente[nEmple].calculoNeto(calcDescuento);
            fVen = fActual.obtenerFechaVencimiento(miCliente[nEmple].getfFac(), diasVen);
            if (fVen.getMes() == (fActual.getMes() + 1)) {
                System.out.println(miCliente[nEmple].getCif() + miCliente[nEmple].getNombre() + miCliente[nEmple].getfFac().visualizar()
                        + fVen.visualizar() + miCliente[nEmple].getImporteFac() + importeNeto);
                contador++;
            }
            totalNetos = totalNetos + importeNeto;
        }
        if (contador == 0) {
            System.out.println("NADIE CUMPLE LOS REQUISITOS");
        }
        System.out.println("La suma de todos los importes netos es " + totalNetos + " €");
    }
}
