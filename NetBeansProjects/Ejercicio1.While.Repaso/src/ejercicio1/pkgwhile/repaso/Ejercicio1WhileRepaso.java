package ejercicio1.pkgwhile.repaso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio1WhileRepaso {

    public static void main(String[] args) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        float numero = 0, suma = 0;
        float media, porcentaje;
        int contador = 0, contador2 = 0;

        while (numero != -1) {
            suma = numero + suma;
            System.out.print("Introduce nota: ");
            numero = Integer.parseInt(teclado.readLine());
            while (numero < -1 || numero > 10) {
                System.out.print("Vuelve a introducir nota: ");
                numero = Integer.parseInt(teclado.readLine());
            }
            if (numero >= 0 && numero <= 10) {
                contador++;//numero total de notas de alumnos
            }
            if (numero >= 5 && numero <= 10) {
                contador2++;//Numero de aprobados
            }
        }

        System.out.println("Han aprobado un total de " + contador2 + " alumnos");
        if (contador > 0) {
            media = suma / contador;
            System.out.println("La nota media es " + media);

            porcentaje = (float) contador2 / contador;
            porcentaje = porcentaje * 100;
            System.out.println("El porcentaje de aprobados es del " + porcentaje + "%");
        } else {
            System.out.println("No hay datos");
        }
    }
}
