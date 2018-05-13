/*Examen de Programación el 04/11/2016*/
package examen.pkg04.pkg11.pkg16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Examen041116 {

    public static void main(String[] args) throws IOException {
        int nAlu, notas, suma = 0, contadorTotal = 0, contador2 = 0;
        int contador3 = 0, contador4 = 0;
        float media, porcentaje;
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        Examen041116 objeto;
        objeto = new Examen041116();
        nAlu = objeto.pedirNumeroAlumnos();
        while (nAlu != contadorTotal) {
            notas = objeto.pedirNotas();
            if (notas >= 0 && notas < 5) {
                contador2++;
            }
            if (notas >= 5 && notas < 8) {
                contador3++;
            }
            if (notas >= 8 && notas <= 10) {
                contador4++;
            }
            contadorTotal++;
            suma = suma + notas;
        }
        if (nAlu > 0) {
            System.out.println("Alumnos totales= " + contadorTotal);
            media = (float) suma / contadorTotal;
            System.out.println("La media de todas las notas es " + media);
            porcentaje = (float) (contador3 + contador4) / contadorTotal * 100;
            System.out.println("Porcentaje total de aprobados es un " + porcentaje + " %");
            porcentaje = (float) contador2 / contadorTotal * 100;
            System.out.println("Porcentaje total de suspensos es un " + porcentaje + " %");
            porcentaje = (float) contador4 / contadorTotal * 100;
            System.out.println("Porcentaje total de sobresalientes es un " + porcentaje + " %");
            System.out.println("Notas menores de 5 \t"+contador2+"\t");
            System.out.println("Notas entre 5 y 8 \t"+contador3+"\t");
            System.out.println("Notas mayor de 8 \t"+contador4+"\t");
        } else {
            System.out.println("ERROR. No hay datos");
        }
    }

    public int pedirNumeroAlumnos() throws IOException {
        int alumnos;
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        System.out.print("Número de alumnos: ");
        alumnos = Integer.parseInt(teclado.readLine());
        while (alumnos < 0) {
            System.out.print("Vuelve a introducir alumnos: ");
            alumnos = Integer.parseInt(teclado.readLine());
        }
        return alumnos;
    }

    public int pedirNotas() throws IOException {
        int notas;
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        System.out.print("Introduceir Nota: ");
        notas = Integer.parseInt(teclado.readLine());
        while (notas < 0 || notas > 10) {
            System.out.print("Vuelve a introducir nota: ");
            notas = Integer.parseInt(teclado.readLine());
        }
        return notas;
    }
}
