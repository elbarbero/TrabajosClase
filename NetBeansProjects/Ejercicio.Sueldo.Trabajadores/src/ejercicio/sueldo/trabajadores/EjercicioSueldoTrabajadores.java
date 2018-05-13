/*22. Realiza un programa que introduzca el nombre
 y el sueldo de los trabajadores de una empresa
 hasta que el operador   * como nombre.
 Finalizada la entrada de datos se mostrará en
 pantalla la siguiente información:
 */
package ejercicio.sueldo.trabajadores;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class EjercicioSueldoTrabajadores {

    public static void main(String[] args) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        String nombre = "", copiaNombre = "";
        int contadorTotal = 0, contMil = 0, contDosMil = 0, contMasDosMil = 0;
        float suma = 0, sueldo = 0, copiaSueldo = -1, media, porcentaje;
        System.out.print("Introduce trabajador: ");
        nombre = teclado.readLine();
        while (nombre.compareTo("*") != 0) {//para decir que salga del while cuando se introduzca lo que esta entre parentesis
            contadorTotal++;
            System.out.print("Introduce sueldo del trabajador: ");
            sueldo = Float.parseFloat(teclado.readLine());
            while (sueldo < 0) {
                System.out.print("Vuelve a introducir sueldo del trabajador: ");
                sueldo = Float.parseFloat(teclado.readLine());
            }
            if (sueldo <= 1000) {
                contMil++;
            } else if (sueldo <= 2000) {
                contDosMil++;
            }
            if (sueldo > 2000) {
                contMasDosMil++;
            }
            if (sueldo > copiaSueldo) {//para saber quien es el que más cobra
                copiaNombre = nombre;
                copiaSueldo = sueldo;//que me guarde sueldo en otra variable
            }
            suma = suma + sueldo;
            System.out.print("Introduce trabajador: ");
            nombre = teclado.readLine();
        }
        if (contadorTotal > 0) {
            media = (float) suma / contadorTotal;
            System.out.println("El sueldo medio es " + media + "€");
            porcentaje = ((float) contMil / contadorTotal) * 100;
            System.out.println("El porcentaje con menos de 1000€ es " + porcentaje + "%");
            porcentaje = ((float) contDosMil / contadorTotal) * 100;
            System.out.println("El porcentaje entre 1000€ y 2000€ es " + porcentaje + "%");
            porcentaje = ((float) contMasDosMil / contadorTotal) * 100;
            System.out.println("El porcentaje con más de 2000€ es " + porcentaje + "%");
            System.out.println("Sueldos menores de 1000€ --> \t" + contMil + "\t");
            System.out.println("Sueldos entre 1000€ y 2000€ --> \t" + contDosMil + "\t");//La "/t" es para hacer tabulaciones
            System.out.println("Sueldos mayores de 2000€ --> \t" + contMasDosMil + "\t");
            System.out.println("El trabajador con más sueldo es " + copiaNombre);//que me muestre el que mas a cobrado
        } else {
            System.out.println("ERROR. No hay datos");
        }
    }

}
