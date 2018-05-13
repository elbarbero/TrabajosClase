/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen2.pkg1eval;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Examen21Eval {

    public static void main(String[] args) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        String dato1 = "";
        int dato2 = 0;
        int contMenos2000 = 0, contMas2000 = 0, contMas300000 = 0, conTotal = 0;
        String nombreMayor = "", nombreMenor = "";
        int habitMayor = -1, habitMenor = 300000;
        float porcentaje;

        Examen21Eval objeto;
        objeto = new Examen21Eval();
        dato1 = objeto.pedirNombre("Nombre de la población: ");
        while (dato1.compareToIgnoreCase("fin") != 0) {
            dato2 = objeto.pedirPoblacion("Número de habitantes: ", 0);
            if (dato2 < 2000) {
                contMenos2000++;
            } else if (dato2 >= 2000 && dato2 <= 300000) {
                contMas2000++;
            } else if (dato2 > 300000) {
                contMas300000++;
            }
            if (dato2 > habitMayor) {
                nombreMayor = dato1;
                habitMayor = dato2;
            }
            if (dato2 < habitMenor) {
                nombreMenor = dato1;
                habitMenor = dato2;
            }
            conTotal++;
            dato1 = objeto.pedirNombre("nombre de la población: ");
        }
        if (conTotal > 0) {
            System.out.println("La población con más habitantes es " + nombreMayor + " con " + habitMayor + " habitantes");
            System.out.println("La población con menos habitantes es " + nombreMenor + " con " + habitMenor + " habitantes");
            System.out.println("Poblaciones con menos de 2000 habitantes: " + contMenos2000);
            System.out.println("Poblaciones entre 2000 y 300000 habitantes: " + contMas2000);
            System.out.println("Poblaciones con más de 300000 habitantes: " + contMas300000);
            porcentaje = ((float) contMenos2000 / conTotal) * 100;
            System.out.println("Porcentaje de poblaciones con menos de 2000: " + porcentaje);
            porcentaje = ((float) contMas2000 / conTotal) * 100;
            System.out.println("Porcentaje de poblaciones entre 2000 y 300000: " + porcentaje);
            porcentaje = ((float) contMas300000 / conTotal) * 100;
            System.out.println("Porcentaje de poblaciones con más de 300000: " + porcentaje);
            System.out.println("TOTAL DE POBLACIONES ENCUESTADAS: " + conTotal);
        } else {
            System.out.println("ERROR. NO HAY DATOS");
        }
    }

    public String pedirNombre(String mensaje) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        String nombre = "";
        System.out.print(mensaje);
        nombre = teclado.readLine();
        while (nombre.compareTo("") == 0) {
            System.out.println("ERROR");
            System.out.print(mensaje);
            nombre = teclado.readLine();
        }
        return nombre;//con esto le decimo que vuelva a la variable nombre
    }

    public int pedirPoblacion(String mensaje, int limiteInferior) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        int habitantes = 0;
        boolean correcto = false;
        while (!correcto) {
            try {
                System.out.print(mensaje);
                habitantes = Integer.parseInt(teclado.readLine());
                if (habitantes < limiteInferior) {
                    System.out.println("ERROR");
                } else {
                    correcto = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("NO ES UN NÚMERO" + e.getMessage());
                correcto = false;
            } catch (IOException e) {
            }
        }
        return habitantes;
    }

}
