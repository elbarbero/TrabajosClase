/*Un autobús dispone de 60 plazas. El precio del billete depende de la edad. Las tarifas actuales son:
 Niños de 0 a 6 años: gratis
 Jóvenes de 6 hasta 18 años: 	0,5 euros
 Adultos de 18 hasta 65 años	1 euro
 Jubilados de 65 en adelante	0.25 euros
 Se trata de hacer un programa que permita realizar la venta de tickets hasta que el autobús este completo o el operador de 0 como número de billetes a vender.
 Finalizada la entrada de datos visualizar el siguiente resumen:
 */
package ejercicio15.billetes.autobus;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Autobus {

    int plazasTotales;
    private int plazasOcu1;
    private int plazasOcu2;
    private int plazasOcu3;
    private int plazasOcu4;
    private float tarifa1, tarifa2, tarifa3, tarifa4;

    public int PedirNumAutobus() throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        int numAutobus = 0;
        boolean correcto = false;
        while (!correcto) {
            try {
                System.out.print("Número de autobus: ");
                numAutobus = Integer.parseInt(teclado.readLine());
                if (numAutobus < 0) {
                    System.out.print("ERROR");
                } else {
                    correcto = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("NO ES UN NÚMERO");
                correcto = false;
            } catch (IOException e) {
            }
        }
        return numAutobus;
    }

    /**
     *
     * @param plazasTotales Plazas totales
     * @param t1 preco tarifa1
     * @param tarifa2 preco tarifa2
     * @param tarifa3 preco tarifa3
     * @param tarifa4 preco tarifa4
     */
    //para meter estos comentarios se pone la barra con los dos asteriscos y enter y se crea solo
    public Autobus(int plazasTotales, float t1, float tarifa2, float tarifa3, float tarifa4) {
        this.plazasTotales = plazasTotales;
        tarifa1 = t1;
        this.tarifa2 = tarifa2;
        this.tarifa3 = tarifa3;
        this.tarifa4 = tarifa4;
    }

    /**
     * @return the plazasOcu1
     */
    public int getPlazasOcu1() {
        return plazasOcu1;
    }

    /**
     * @param plazasOcu1 the plazasOcu1 to set
     */
    public void setPlazasOcu1(int plazasOcu1) {
        this.plazasOcu1 = plazasOcu1;
    }

    /**
     * @return the plazasOcu2
     */
    public int getPlazasOcu2() {
        return plazasOcu2;
    }

    /**
     * @param plazasOcu2 the plazasOcu2 to set
     */
    public void setPlazasOcu2(int plazasOcu2) {//el set me modifica el valor con el valor que esta recibiendo
        this.plazasOcu2 = plazasOcu2;
    }

    /**
     * @return the plazasOcu3
     */
    public int getPlazasOcu3() {
        return plazasOcu3;
    }

    /**
     * @param plazasOcu3 the plazasOcu3 to set
     */
    public void setPlazasOcu3(int plazasOcu3) {
        this.plazasOcu3 = plazasOcu3;
    }

    /**
     * @return the plazasOcu4
     */
    public int getPlazasOcu4() {
        return plazasOcu4;
    }

    /**
     * @param plazasOcu4 the plazasOcu4 to set
     */
    public void setPlazasOcu4(int plazasOcu4) {
        this.plazasOcu4 = plazasOcu4;
    }

    /**
     * Métdo que devuelve el número de plazas disponibles
     *
     * @return plazas disponibles
     */
    public int plazasDisponibles() {
        int disponibles;
        disponibles = plazasTotales - plazasOcu1 - plazasOcu2 - plazasOcu3 - plazasOcu4;
        /*no hace falta poner el this delante de plazas ocupadas
         porque no está entre los parentesis del método. Sirve para los datos del que me ha llamado
         Contiene los datos del objeto que has utilizado en el método.*/
        return disponibles;
    }

    /**
     * Método para la venta de billetes
     * @param numBilletes número de billetes que quiere el cliente
     * @param tipoBillete tipo de tarifa que quiere para esos billetes
     * @return importe de la venta de esos billetes
     */
    public float ventaBilletes(int numBilletes, int tipoBillete) {
        float importe = 0;

        switch (tipoBillete) {

            case 1:
                plazasOcu1 = plazasOcu1 + numBilletes;
                importe = numBilletes * tarifa1;
                break;
            case 2:
                plazasOcu2 = plazasOcu2 + numBilletes;
                importe = numBilletes * tarifa2;
                break;
            case 3:
                plazasOcu3 = plazasOcu3 + numBilletes;
                importe = numBilletes * tarifa3;
                break;
            case 4:
                plazasOcu4 = plazasOcu4 + numBilletes;
                importe = numBilletes * tarifa4;
                break;
        }
        return importe;
    }
    public float recaudacion1(){
    return tarifa1*plazasOcu1;
}
}
