/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio15.billetes.autobus2;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Principal {

    public static void main(String[] args) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        int plazas, billetes, edad = 0;
        float suma1 = 0, suma2 = 0, suma3 = 0, suma4 = 0, sumaTotal = 0, porcentaje;
        int contMenosK6 = 0, contMenosK18 = 0, contMenosK65 = 0, contMasK65 = 0, conTotal = 0;
        int copiaPlazas;
        Autobus objeto = new Autobus();
        plazas = objeto.pedirPlazas("Introduce las plazas del autobus: ", 0);
        copiaPlazas = plazas;
        billetes = objeto.pedirBilletes("¿Cuántos billetes quieres comprar? ", 0);
        while (billetes != 0||copiaPlazas>0) {
            while (copiaPlazas > 0) {
                if (billetes > copiaPlazas) {
                    System.out.println("NO HAY PLAZAS DISPONIBLES");
                } else {
                    edad = objeto.pedirEdad("Introduce edad: ", 0, 120);
                    billetes = objeto.pedirBilletes("¿Cuántos billetes quieres comprar? ", 0);
                }

                if (edad <= 6) {
                    contMenosK6 = contMenosK6 + billetes;
                } else if (edad > 6 && edad < 18) {
                    contMenosK18 = contMenosK18 + billetes;
                    suma2 = (float) (suma2 + (0.5 * billetes));
                } else if (edad >= 18 && edad <= 65) {
                    contMenosK65 = contMenosK65 + billetes;
                    suma3 = suma3 + (1 * billetes);
                } else {
                    contMasK65 = contMasK65 + billetes;
                    suma4 = (float) (suma4 + (0.25 * billetes));
                }
                copiaPlazas = copiaPlazas - billetes;
                conTotal = conTotal + billetes;
                billetes = 0;
            }
        }
        if (conTotal > 0) {
            sumaTotal = (float) (suma2 + suma3 + suma4);
            porcentaje = ((float) conTotal / plazas) * 100;
            System.out.println("EDADES" + "\t" + "\t" + "Nº DE BILLETES" + "\t" + "RECAUDACIÓN");
            System.out.println("0-6 años" + "\t" + "\t" + contMenosK6 + "\t" + suma1);
            System.out.println("6-18 años" + "\t" + "\t" + contMenosK18 + "\t" + suma2);
            System.out.println("18-65 años" + "\t" + "\t" + contMenosK65 + "\t" + suma3);
            System.out.println("Más de 65 años" + "\t" + "\t" + contMasK65 + "\t" + suma4);
            System.out.println("Porcentaje del autobus: " + porcentaje);
        } else {
            System.out.println("ERROR. NO HAY DATOS");
        }
    }
}
