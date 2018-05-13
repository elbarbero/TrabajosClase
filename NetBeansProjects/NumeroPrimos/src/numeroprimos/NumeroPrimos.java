/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numeroprimos;

/**
 *
 * @author Mario
 */
public class NumeroPrimos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int contador = 2;
        boolean primo = true;
        int numero=5;

        while ((primo) && (contador != numero)) {
            if (numero % contador == 0) {
                primo = false;
            }
            contador++;
        }
        System.out.println("¿Es primo?--> " + primo);
    }

    /**
     * Te calcula si un numero es primo o no
     *
     * @param numero es el numero que nosotros le pasamos
     * @return si es primo o no
     */
    public static boolean esPrimo(int numero) {
        int contador = 2;
        boolean primo = true;
        while ((primo) && (contador != numero)) {
            if (numero % contador == 0) {
                primo = false;
            }
            contador++;
        }
        return primo;
    }

}
