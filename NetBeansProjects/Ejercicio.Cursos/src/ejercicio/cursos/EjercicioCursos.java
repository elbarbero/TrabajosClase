/*Una academia oferta 3 cursos. (Curso1, Curso 2, Curso 3)
ofertando en cada uno de los cursos 30 plazas.
Se pide:

 */
package ejercicio.cursos;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class EjercicioCursos {

    public static void main(String[] args) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        int curso1 = 0, curso2 = 0, curso3 = 0, edad1 = 0, edad2 = 0, edad3 = 0;
        int edad, total = 0, clases, edadtotal = 0, edadmedia;
        float porcentaje;

        System.out.print("Introduce edad: ");
        edad = Integer.parseInt(teclado.readLine());
        while (edad < 0) {
            System.out.print("Vuelve a introducir edad: ");
            edad = Integer.parseInt(teclado.readLine());
        }
        System.out.print("Introduce curso(del 1 al 3): ");
        clases = Integer.parseInt(teclado.readLine());
        while ((clases > 3 && clases != -1)||clases==0) {
            System.out.print("Vuelve a introducir curso(del 1 al 3): ");
            clases = Integer.parseInt(teclado.readLine());
        }
        while (clases != -1 && (curso1 != 3 || curso2 != 30 || curso3 != 30)) {
            if (clases == 1&&curso1>=3) {
                
                System.out.println("No ha plazas en CURSO1");
            }else {
                curso1++;
                edad1 = edad1 + edad;
            } 
            if (clases == 2 && edad > 0) {
                curso2++;
                edad2 = edad2 + edad;
            } else if (clases == 3 && edad > 0) {
                curso3++;
                edad3 = edad3 + edad;
            }
            total++;//numero total de alumnos
            edadtotal = edadtotal + edad;
            System.out.print("Introduce edad: ");
            edad = Integer.parseInt(teclado.readLine());
            while (edad < 0) {
                System.out.print("Vuelve a introducir edad: ");
                edad = Integer.parseInt(teclado.readLine());
            }
            System.out.print("Introduce curso(del 1 al 3): ");
            clases = Integer.parseInt(teclado.readLine());
            while ((clases > 3 && clases != -1)||clases==0) {
                System.out.print("Vuelve a introducir curso(del 1 al 3): ");
                clases = Integer.parseInt(teclado.readLine());
            }
        }
        System.out.println("Hay un total de " + total + " alumnos matriculados");
        if (total == 0) {
            System.out.println("ERROR. No hay datos.");
        } else {
            edadmedia = edad1 / curso1;
            System.out.println("La edad media del CURSO1 es de " + edadmedia + " años");
            edadmedia = edad2 / curso2;
            System.out.println("La edad media del CURSO2 es de " + edadmedia + " años");
            edadmedia = edad3 / curso3;
            System.out.println("La edad media del CURSO3 es de " + edadmedia + " años");
            System.out.println(curso1 + " alumnos en el CURSO1");
            System.out.println(curso2 + " alumnos en el CURSO2");
            System.out.println(curso3 + " alumnos en el CURSO3");
            porcentaje = (float) curso1 / 30;
            porcentaje = porcentaje * 100;
            System.out.println(porcentaje + "% de plazas ocupadas en el CURSO1");
            porcentaje = (float) curso2 / 30;
            porcentaje = porcentaje * 100;
            System.out.println(porcentaje + "% de plazas ocupadas en el CURSO2");
            porcentaje = (float) curso3 / 30;
            porcentaje = porcentaje * 100;
            System.out.println(porcentaje + "% de plazas ocupadas en el CURSO3");
        }
    }

}
