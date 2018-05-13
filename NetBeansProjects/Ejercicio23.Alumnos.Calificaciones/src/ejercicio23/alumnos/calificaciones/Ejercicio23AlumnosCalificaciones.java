/*23. Realiza un programa que introduzca los  nombres y la
 calificaciones de los alumnos de una clase hasta que el
 operador introduzca * como nombre.
 Finalizada la entrada de datos se mostrará
 en pantalla la siguiente información:
 */
package ejercicio23.alumnos.calificaciones;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Ejercicio23AlumnosCalificaciones {

    public static void main(String[] args) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        String nombre, nombreMenor = "", nombreMayor = "";
        int nota = 0, menorK5 = 0, mayorK5 = 0, mayorK8 = 0;
        int suma = 0, notaMenor = 10, notaMayor = 0, conTotal = 0;
        float media, porcentaje;

        System.out.print("Introduce alumno: ");
        nombre = teclado.readLine();

        while (nombre.compareTo("*") != 0) {
            suma = suma + nota;
            System.out.print("Introduce nota: ");
            nota = Integer.parseInt(teclado.readLine());
            while (nota < 0 || nota > 10) {
                System.out.print("Vuelve a introducir nota: ");
                nota = Integer.parseInt(teclado.readLine());
            }
            if (nota < notaMenor) {
                nombreMenor = nombre;
                notaMenor = nota;
            }
            if (nota > notaMayor) {
                nombreMayor = nombre;
                notaMayor = nota;
            }
            if (nota < 5) {
                menorK5++;
            } else if (nota <= 8) {
                mayorK5++;
            } else {
                mayorK8++;
            }
            conTotal++;
            System.out.print("Introducir alumno: ");
            nombre = teclado.readLine();
        }
        if (conTotal > 0) {
            System.out.println("El alumno " + nombreMenor + " ha sacado la menor nota, un " + notaMenor);
            System.out.println("El alumno " + nombreMayor + " ha sacado la menor nota, un " + notaMayor);
            media = (float) suma / conTotal;
            System.out.println("La media total de todas las notas es: " + media);
            System.out.println("Con una nota menor de 5 ha habido un total de " + menorK5 + " alumnos");
            System.out.println("Con una nota entre de 5 y 8 ha habido un total de " + mayorK5 + " alumnos");
            System.out.println("Con una nota mayor de 8 ha habido un total de " + mayorK8 + " alumnos");
            porcentaje = ((float) menorK5 / conTotal) * 100;
            System.out.println("Con menos de un 4 en la nota un " + porcentaje + "%");
            porcentaje = ((float) mayorK5 / conTotal) * 100;
            System.out.println("Entre 5 y 8 en la nota un " + porcentaje + "%");
            porcentaje = ((float) mayorK8 / conTotal) * 100;
            System.out.println("Con más de un 8 en la nota un " + porcentaje + "%");
        } else {
            System.out.println("ERROR. No hay datos");
        }
    }

}
