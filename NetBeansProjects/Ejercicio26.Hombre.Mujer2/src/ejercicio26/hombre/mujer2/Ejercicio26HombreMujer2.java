/*26.	Realiza un programa que introduzca la estatura y
 el sexo (Hombre-Mujer) de los alumnos de una clase hasta
 que el operador introduzca * como sexo.
 Finalizada la entrada de datos se mostrará en
 pantalla la siguiente información:
 */
package ejercicio26.hombre.mujer2;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Ejercicio26HombreMujer2 {

    public static void main(String[] args) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        int menorK150H = 0, menorK150M = 0, menorK170H = 0, menorK170M = 0, mayorK170H = 0, mayorK170M = 0;
        int conTotal = 0, conTotalHombres = 0, conTotalMujer = 0;
        float sumaEstH = 0, sumaEstM = 0, media, porcentaje;
        float dato1 = 0;
        String dato2 = "";
        Ejercicio26HombreMujer2 objeto;
        objeto = new Ejercicio26HombreMujer2();
        dato2 = objeto.pedirSexo("Introduce sexo (H o M): ");
        while (dato2.compareTo("*") != 0) {
            dato1 = objeto.pedirEstatura("Introducir estatura: ", 0, 2.80f);
            if (dato2.compareToIgnoreCase("H") == 0 && dato1 < 1.50) {
                menorK150H++;
                conTotalHombres++;
                sumaEstH = sumaEstH + dato1;
            } else if (dato2.compareToIgnoreCase("H") == 0 && dato1 > 1.50 && dato1 <= 1.70) {
                menorK170H++;
                conTotalHombres++;
                sumaEstH = sumaEstH + dato1;
            } else if (dato2.compareToIgnoreCase("H") == 0 && dato1 > 1.70) {
                mayorK170H++;
                conTotalHombres++;
                sumaEstH = sumaEstH + dato1;
            }
            if (dato2.compareToIgnoreCase("M") == 0 && dato1 < 1.50) {
                menorK150M++;
                conTotalMujer++;
                sumaEstM = sumaEstM + dato1;
            } else if (dato2.compareToIgnoreCase("M") == 0 && dato1 > 1.50 && dato1 <= 1.70) {
                menorK170M++;
                conTotalMujer++;
                sumaEstM = sumaEstM + dato1;
            } else if (dato2.compareToIgnoreCase("M") == 0 && dato1 > 1.70) {
                mayorK170M++;
                conTotalMujer++;
                sumaEstM = sumaEstM + dato1;
            }
            conTotal++;
            dato2 = objeto.pedirSexo("Introduce sexo: ");
        }
        if (conTotal > 0) {
            media = (float) sumaEstH / conTotalHombres;
            System.out.println("La estatura media de los hombres es " + media + " cm");
            media = (float) sumaEstM / conTotalMujer;
            System.out.println("La estatura media de las mujeres es " + media + " cm");
            System.out.println("Hombres menores de 1.50cm: " + menorK150H);
            System.out.println("Hombres entre 1.50 y 1.70cm: " + menorK170H);
            System.out.println("Hombres mayores de 1.70cm: " + mayorK170H);
            System.out.println("Mujeres menores de 1.50cm: " + menorK150M);
            System.out.println("Mujeres entre 1.50 y 1.70cm: " + menorK170M);
            System.out.println("Mujeres mayores de 1.70cm: " + mayorK170M);
            porcentaje = ((float) (menorK150H + menorK150M) / conTotal) * 100;
            System.out.println("Personas menores de 1.50cm: " + porcentaje + " %");
        }
    }

    public String pedirSexo(String mensaje) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        String sexo = "";
        boolean correcto = false;
        while (!correcto) {
            try {
                System.out.print(mensaje);
                sexo = teclado.readLine();
                while (sexo.compareToIgnoreCase("H") != 0 && sexo.compareToIgnoreCase("M") != 0 && sexo.compareTo("*") != 0) {
                    System.out.print("Vuelve a introducir sexo: ");
                    sexo = teclado.readLine();
                }
                correcto = true;
            } catch (IOException e) {
                correcto = false;
            }
        }
        return sexo;
    }

    public float pedirEstatura(String mensaje, float limiteInferior, float limiteSuperior) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        float estatura = 0;
        boolean correcto = false;
        while (!correcto) {
            try {
                System.out.print(mensaje);
                estatura = Float.parseFloat(teclado.readLine());
                if (estatura < limiteInferior || estatura > limiteSuperior) {
                    System.out.println("ERROR");
                }else{
                correcto = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR. NO ES UN NÚMERO" + e.getMessage());
            } catch (IOException e) {
            }
        }
        return estatura;
    }
}
