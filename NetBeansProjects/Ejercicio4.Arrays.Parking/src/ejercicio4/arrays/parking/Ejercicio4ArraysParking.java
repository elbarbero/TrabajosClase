/* 4.- En un parking de 100 plazas se quiere realizar un programa para
 gestionar el control de dichas plazas. Para ello cuando llega un nuevo
 automóvil se le asignará la primera plaza que se encuentre libre.
 En cambio cuando sale del parking se le preguntará qué plaza es la que
 está quedando libre. También cuando lo desee el operador se visualizara
 el estado del parking.
 */
package ejercicio4.arrays.parking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Clase Principal
 *
 * @author 203pc19
 */
public class Ejercicio4ArraysParking {

    /**
     * Método principal
     *
     * @param args argumentos de entrada
     * @throws IOException excepción de E/S
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        int plaza = 0;
        /* System.out.print("Número de plazas: ");
         plaza = Integer.parseInt(teclado.readLine());*/

        /*Creamos el garaje que le hemos llamado "ParkingDam" que si no ponemos nada entre
         los parentesis, tendrá 100 plazas como le hemos definido en 
         la clase Garaje.
         Si entre los parentesis ponemos, por ejemplo, un 5, el parking tendrá solo 5 plazas.*/
        Garaje ParkingDam = new Garaje(5);
        while (plaza < 10) {
                ParkingDam.BusquedaSecuencial();
                ParkingDam.entrada();
                ParkingDam.verSituacion();
                plaza++;
        }

    }

}
