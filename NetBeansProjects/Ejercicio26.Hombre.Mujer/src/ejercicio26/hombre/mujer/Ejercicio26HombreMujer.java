/*26.	Realiza un programa que introduzca la estatura y
 el sexo (Hombre-Mujer) de los alumnos de una clase hasta
 que el operador introduzca * como sexo.
 Finalizada la entrada de datos se mostrará en
 pantalla la siguiente información:
 */
package ejercicio26.hombre.mujer;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Ejercicio26HombreMujer {

    public static void main(String[] args) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        String sexo;
        float estatura = 0, porcentaje, media, sumaEstHombres = 0, estHombres;
        int contHombMenos150 = 0, contMujMenos150 = 0, contHombMenos170 = 0, contMujMenos170 = 0;
        int contHombMas170 = 0, contMujMas170 = 0, conTotal = 0;
        float sumaEstMujeres = 0, estMujeres;
        boolean correcto = false;
        System.out.print("Introduce sexo del alumno (V o M): ");
        sexo = teclado.readLine();
        while (sexo.compareTo("*") != 0 && (sexo.compareToIgnoreCase("V") != 0 && sexo.compareToIgnoreCase("M") != 0)) {
            System.out.print("Vuelve a introducir sexo del alumno (V o M): ");
            sexo = teclado.readLine();
        }

        while (sexo.compareTo("*") != 0) {

            System.out.print("Introducir estatura: ");
            estatura = Float.parseFloat(teclado.readLine());
            while (estatura < 0 || estatura > 2.80) {
                System.out.print("Vuelve a introducir estatura: ");
                estatura = Float.parseFloat(teclado.readLine());
            }

            if (estatura <= 1.50 && sexo.compareToIgnoreCase("V") == 0) {//hombres menores de 1.50
                estHombres = estatura;
                sumaEstHombres = sumaEstHombres + estHombres;
                contHombMenos150++;
            }
            if (estatura <= 1.50 && sexo.compareToIgnoreCase("M") == 0) {//mujeres menores de 1.50
                estMujeres = estatura;
                sumaEstMujeres = sumaEstMujeres + estMujeres;
                contMujMenos150++;
            }
            if (estatura < 1.70 && sexo.compareToIgnoreCase("V") == 0) {//hombres menores de 1.70
                estHombres = estatura;
                sumaEstHombres = sumaEstHombres + estHombres;
                contHombMenos170++;
            }
            if (estatura < 1.70 && sexo.compareToIgnoreCase("M") == 0) {//mujeres menores de 1.70
                estMujeres = estatura;
                sumaEstMujeres = sumaEstMujeres + estMujeres;
                contMujMenos170++;
            }
            if (estatura > 1.70 && sexo.compareToIgnoreCase("V") == 0) {//hombres mayores de 1.70
                estHombres = estatura;
                sumaEstHombres = sumaEstHombres + estHombres;
                contHombMas170++;
            }
            if (estatura > 1.70 && sexo.compareToIgnoreCase("M") == 0) {//mujeres mayores de 1.70
                estMujeres = estatura;
                sumaEstMujeres = sumaEstMujeres + estMujeres;
                contMujMas170++;
            }
            conTotal++;
            System.out.print("Introduce sexo del alumno (V o M): ");
            sexo = teclado.readLine();
            while (sexo.compareTo("*") != 0 && (sexo.compareToIgnoreCase("V") != 0 && sexo.compareToIgnoreCase("M") != 0)) {
                System.out.print("Vuelve a introducir sexo del alumno (V o M): ");
                sexo = teclado.readLine();
            }
        }
        if (conTotal > 0) {
            media = (float) sumaEstHombres / (contHombMenos150 + contHombMenos170 + contHombMas170);
            System.out.println("La estatura media de los hombres es " + media + " m");
            media = (float) sumaEstMujeres / (contMujMenos150 + contMujMenos170 + contMujMas170);
            System.out.println("La estatura media de las mujers es " + media + " m");
            porcentaje = ((float) (contHombMenos150 + contMujMenos150) / conTotal) * 100;
            System.out.println("El porcentaje total de alumnos menores de 1.50m es del " + porcentaje + " %");
            porcentaje = ((float) (contHombMenos170 + contMujMenos170) / conTotal) * 100;
            System.out.println("El porcentaje total de alumnos entre 1.50m y 1.70m es del " + porcentaje + " %");
            porcentaje = ((float) (contHombMas170 + contMujMas170) / conTotal) * 100;
            System.out.println("El porcentaje total de alumnos mayores de 1.70m es del " + porcentaje + " %");
        } else {
            System.out.println("ERROR. No hay datos");
        }
    }

}
