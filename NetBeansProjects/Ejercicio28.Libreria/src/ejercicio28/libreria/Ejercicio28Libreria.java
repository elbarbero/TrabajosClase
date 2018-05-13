/*28.	Una librería especializada vende libros de Economía
e Informática. Se quiere realizar un programa que controle
las ventas. Por cada venta se pedirá al operador el tipo de
libro que desea y la forma de pago pidiéndose ser al contado
o con tarjeta de crédito.
El proceso de venta se repetirá mientras el operador no
pulse Fin como tipo de libro.
Finalizado el proceso de venta se quiere obtener el siguiente informe:
 */
package ejercicio28.libreria;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Ejercicio28Libreria {

    public static void main(String[] args) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        String libro = "", pago = "";
        int pagoContadoEco = 0, pagoTarjetaEco = 0, pagoContadoInf = 0, pagoTarjetaInf = 0;
        int conTotalEco = 0, conTotalInf = 0, totalContado = 0, totalTarjeta = 0;
        boolean correcto = false, correcto2 = false;
        while (!correcto) {
            try {
                System.out.print("Introduce libro (Eco o Inf): ");
                libro = teclado.readLine();
                if (libro.compareToIgnoreCase("eco") != 0 && libro.compareToIgnoreCase("inf") != 0 && libro.compareToIgnoreCase("fin") != 0) {
                    System.out.print("ERROR");
                } else {
                    correcto = true;
                }
            } catch (IOException e) {
                correcto = false;
            }
        }
        while (libro.compareToIgnoreCase("fin") != 0) {
            correcto2 = false;
            while (!correcto2) {
                try {
                    System.out.print("Modo de pago(contado o tarjeta): ");
                    pago = teclado.readLine();
                    if (pago.compareToIgnoreCase("c") != 0 && pago.compareToIgnoreCase("T") != 0) {
                        System.out.print("ERROR");
                    } else {
                        correcto2 = true;
                    }
                } catch (IOException e) {
                }
            }
            if (pago.compareToIgnoreCase("C") == 0 && libro.compareToIgnoreCase("eco") == 0) {
                pagoContadoEco++;
                conTotalEco++;
            } else if (libro.compareToIgnoreCase("eco") == 0) {
                pagoTarjetaEco++;
                conTotalEco++;
            }
            if (pago.compareToIgnoreCase("C") == 0 && libro.compareToIgnoreCase("inf") == 0) {
                pagoContadoInf++;
                conTotalInf++;
            } else if (libro.compareToIgnoreCase("inf") == 0) {
                pagoTarjetaInf++;
                conTotalInf++;
            }
            correcto = false;
            while (!correcto) {
                try {
                    System.out.print("Introduce libro (Eco o Inf): ");
                    libro = teclado.readLine();
                    if (libro.compareToIgnoreCase("eco") != 0 && libro.compareToIgnoreCase("inf") != 0 && libro.compareToIgnoreCase("fin") != 0) {
                        System.out.print("ERROR");
                    } else {
                        correcto = true;
                    }
                } catch (IOException e) {
                    correcto = false;
                }
            }
        }

        if (conTotalInf > 0 || conTotalEco > 0) {
            if (conTotalInf > conTotalEco) {
                System.out.println("El libro menos vendido es el libro de Economia");
            } else {
                System.out.println("El libro menos vendido es el libro de Informatica");
            }
            System.out.println("Libros de Economia pagados al contado: " + pagoContadoEco);
            System.out.println("Libros de Informatica pagados al contado: " + pagoContadoInf);
            System.out.println("Libros de totales pagados al contado: " + (pagoContadoEco + pagoContadoInf));
            System.out.println("Libros de Economia pagados con tarjeta: " + pagoTarjetaEco);
            System.out.println("Libros de Informatica pagadoscon tarjeta: " + pagoTarjetaInf);
            System.out.println("Libros de totales pagados con tarjeta: " + (pagoTarjetaEco + pagoTarjetaInf));
            System.out.println("LIbros totales de Economia vendidos: " + conTotalEco);
            System.out.println("LIbros totales de Informatica vendidos: " + conTotalInf);
            System.out.println("LIbros totales vendidos: " + (conTotalEco + conTotalInf));
        } else {
            System.out.print("ERROR. NO HAY DATOS");
        }
    }
}
