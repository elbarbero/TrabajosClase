/*21.- Se va a realizar un estudio para saber que cadena de televisión
ve la población española. Para ello se está realizando una encuesta
en el que se preguntará cual es la cadena que ve y que terminará cuando
el operador pulse FIN como nombre de cadena.
Finalizado el proceso de entrada de datos se quiere
visualizar el siguiente informe:
 */
package ejercicio21.cadenas.tv;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class PrincipalTV {

    public static void main(String[] args) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        String cadenas = "";
        int cont1 = 0, cont2 = 0, cont3 = 0, cont4 = 0, cont5 = 0, conTotal = 0;
        float porcentaje = 0;
        String cadMasVista = "", cadMenosVista = "";
        CadenasTV objeto = new CadenasTV();
        cadenas = objeto.pedirCadena("Introduce canal de TV (DEL 1 AL 5): ");
        while (cadenas.compareToIgnoreCase("fin") != 0) {
            if (cadenas.compareTo("1") == 0) {
                cont1++;
            } else if (cadenas.compareTo("2") == 0) {
                /*cuando se compara un String hay que hacerlo
                con el compareTo. Cuando los datos sean de tipo numerico(int,float...),
                se utilizan los signos de comparación(>,<,...)*/
                cont2++;
            } else if (cadenas.compareTo("3") == 0) {
                cont3++;
            } else if (cadenas.compareTo("4") == 0) {
                cont4++;
            } else {
                cont5++;
            }
            conTotal++;
            cadenas = objeto.pedirCadena("Introduce canal de TV (DEL 1 AL 5): ");
        }
        if (conTotal > 0) {
            System.out.println("CADENAS" + "\t" + "\t" + "AUDIENCIA" + "\t" + "PORCENTAJE");
            porcentaje = (float) cont1 / conTotal * 100;
            System.out.println("TVE1" + "\t" + "\t" + cont1 + "\t" + "\t" + porcentaje);
            porcentaje = (float) cont2 / conTotal * 100;
            System.out.println("TVE2" + "\t" + "\t" + cont2 + "\t" + "\t" + porcentaje);
            porcentaje = (float) cont3 / conTotal * 100;
            System.out.println("A3" + "\t" + "\t" + cont3 + "\t" + "\t" + porcentaje);
            porcentaje = (float) cont4 / conTotal * 100;
            System.out.println("CANAL4" + "\t" + "\t" + cont4 + "\t" + "\t" + porcentaje);
            porcentaje = (float) cont5 / conTotal * 100;
            System.out.println("TELE5" + "\t" + "\t" + cont5 + "\t" + "\t" + porcentaje);
            System.out.println("Nombre de la cadena más vista: ");
        } else {
            System.out.println("ERROR. NO HAY DATOS");
        }
    }

}
