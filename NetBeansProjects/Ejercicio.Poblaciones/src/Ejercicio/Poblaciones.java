package Ejercicio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Poblaciones {

    public static void main(String[] args) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        int habitantes, contador1 = 0, contador2 = 0, contador3 = 0, total = 0;
        float porcentaje;
        System.out.print("Introduce poblacion: ");
        habitantes = Integer.parseInt(teclado.readLine());
        while (habitantes < -1) {
            System.out.print("Vuelve a introducir población: ");
            habitantes = Integer.parseInt(teclado.readLine());
        }
        while (habitantes != -1) {
            if (habitantes < 2000) {
                contador1++;
            } else if (habitantes < 300000) {
                contador2++;
            } else {
                contador3++;
            }
            total++;
            System.out.print("Introduce población: ");
            habitantes = Integer.parseInt(teclado.readLine());
        }
        System.out.println("Total de poblaciones encuestadas: " + total);
        if (total == 0) {
            System.out.println("ERROR. No hay datos");
        } else {
            porcentaje = (float) contador1 / total;
            porcentaje = porcentaje * 100;
            System.out.println("Con menos de 2000 habitantes un " + porcentaje + "% del total");
            porcentaje = (float) contador2 / total;
            porcentaje = porcentaje * 100;
            System.out.println("Entre 2000 y 300000 habitantes un " + porcentaje + "% del total");
            porcentaje = (float) contador3 / total;
            porcentaje = porcentaje * 100;
            System.out.println("Con más de 300000 habitantes un " + porcentaje + "% del total");
        }
    }
}
