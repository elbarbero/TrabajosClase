/*24.-. Realiza un programa que introduzca la compañía
 de telefonía móvil de los diferentes usuarios de
 un centro comercial hasta que el operador introduzca *
 como compañía, por cada uno se le preguntará si lo
 tiene contratado por  contrato o por tarjeta.
 Finalizada la entrada de datos se mostrará en pantalla
 la siguiente información:*/
package ejercicio24compañiatelefonica2;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class EmpresaPrincipal {

    public static void main(String[] args) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        Compañia tipoCompañia;
        tipoCompañia=new Compañia();
        Compañia tipoContrato;
        tipoContrato=new Compañia();
        String operador;
        String contrato = "";
        String ConMasUsuarios = "";
        boolean correcto = false;
        int contContratoMov = 0, contTarjetaMov = 0, contContratoVod = 0, contTarjetaVod = 0;
        int contContratoOtras = 0, contTarjetaOtras = 0, conTotal = 0;
        int conTotalMov = 0, conTotalVod = 0, conTotalOtras = 0;
        float porcentaje = 0;

        operador = tipoCompañia.pedirOperador();
        while (operador.compareTo("*") != 0) {
            contrato = tipoContrato.pedirContrato();
            if (contrato.compareToIgnoreCase("c") == 0 && operador.compareToIgnoreCase("m") == 0) {
                contContratoMov++;
                conTotalMov++;
            } else if (contrato.compareToIgnoreCase("t") == 0 && operador.compareToIgnoreCase("m") == 0) {
                contTarjetaMov++;
                conTotalMov++;
            }
            if (contrato.compareToIgnoreCase("c") == 0 && operador.compareToIgnoreCase("v") == 0) {
                contContratoVod++;
                conTotalVod++;
            } else if (contrato.compareToIgnoreCase("t") == 0 && operador.compareToIgnoreCase("v") == 0) {
                contTarjetaVod++;
                conTotalVod++;
            }
            if (contrato.compareToIgnoreCase("c") == 0 && operador.compareToIgnoreCase("o") == 0) {
                contContratoOtras++;
                conTotalOtras++;
            } else if (contrato.compareToIgnoreCase("t") == 0 && operador.compareToIgnoreCase("o") == 0) {
                contTarjetaOtras++;
                conTotalOtras++;
            }
            conTotal++;
            operador = tipoCompañia.pedirOperador();
        }
        if (conTotalMov != 0 || conTotalVod != 0 || conTotalOtras != 0) {
            if (conTotalMov < conTotalVod) {
                System.out.println("Compañia con más usuarios es Vodafone");
            } else if (conTotalMov > conTotalOtras) {
                System.out.println("Compañia con más usuarios es Movistar");
            } else {
                System.out.println("Compañia con más usuarios es Otras");
            }
            porcentaje = ((float) contTarjetaMov + contTarjetaVod + contTarjetaOtras) / conTotal * 100;
            System.out.println("Porcentaje de mercado con tarjeta: " + porcentaje);
            porcentaje = ((float) contContratoMov + contContratoVod + contContratoOtras) / conTotal * 100;
            System.out.println("Porcentaje de mercado con contrato: " + porcentaje);
        } else {
            System.out.println("ERROR. NO HAY DATOS");
        }
    }
}
