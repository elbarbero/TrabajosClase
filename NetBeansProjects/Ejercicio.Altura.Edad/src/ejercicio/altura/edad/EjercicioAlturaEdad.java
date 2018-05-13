package ejercicio.altura.edad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EjercicioAlturaEdad {

    public static void main(String[] args) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        double estatura;
        double mediaest, mediaed, sumaed = 0, sumaest = 0;
        int contador = 0, contador2 = 0, contador3 = 0, contador4 = 0, edad;
        float porcentaje;
        System.out.print("Introduzca estatura: ");
        estatura = Double.parseDouble(teclado.readLine());
        System.out.print("Introduzca edad: ");
        edad = Integer.parseInt(teclado.readLine());

        while (estatura != -1) {
            while (estatura > -1 && estatura > 2.30 || estatura == 0) {
                System.out.print("Vuelve a introducir estatura: ");
                estatura = Double.parseDouble(teclado.readLine());
            }
            while (edad<0) {
                System.out.print("Vuelve a introducir edad: ");
                edad = Integer.parseInt(teclado.readLine());
            }
            if (estatura < 1.50 && estatura != -1) {
                contador++;
            }
            if (estatura >= 1.50 && estatura <= 1.70) {
                contador2++;
            }
            if (estatura > 1.70) {
                contador3++;
            }
            contador4++;
            sumaest = sumaest + estatura;
            sumaed = sumaed + edad;
            System.out.print("Introduzca estatura: ");
            estatura = Double.parseDouble(teclado.readLine());
            if(estatura!=-1){
            System.out.print("Introduzca edad: ");
            edad = Integer.parseInt(teclado.readLine());
            }
        }
        mediaest = sumaest / (contador + contador2 + contador3);
        System.out.println("La estatura media es " + mediaest + "m");
        mediaed = sumaed / contador4;
        System.out.println("La edad media es " + mediaed + " años");
        System.out.println("Hay " + contador + " alumnos que mide menos de 1.50m");
        porcentaje = (float) contador / contador4;//porcentaje estatura 1.50
        porcentaje = porcentaje * 100;
        System.out.println("Con un porcentaje del " + porcentaje + "% sobre el total");
        System.out.println("Hay " + contador2 + " alumnos entre 1.50m y 1.70m");
        porcentaje = (float) contador2 / contador4;//porcentaje estatura entre 1.50 y 1.70
        porcentaje = porcentaje * 100;
        System.out.println("Con un porcentaje del " + porcentaje + "% sobre el total");
        System.out.println("Hay " + contador3 + " alumnos que mide mas de 1.70m");
        porcentaje = (float) contador3 / contador4;//porcentaje estatura mayor de 1.70
        porcentaje = porcentaje * 100;
        System.out.println("Con un porcentaje del " + porcentaje + "% sobre el total");

    }

}
