/*13.En un determinado comercio se realiza un descuento dependiendo
del precio de cada producto. Si el precio es inferior a 6€, no se
hace descuento; si es mayor o igual a 6€ y menor que 52€,
se hace un 5% de descuento, y si es mayor o igual a 52€,
se hace un  10% de descuento.
Por cada venta se introduce el nombre del producto, cantidad y precio
por unidad, se repetirá  el proceso hasta dar como nombre del producto *.
Por cada venta se debe visualizar el importe de dicha compra y el
descuento si tiene. Finalizado el proceso de venta se visualizará
el número de ventas efectuadas y el importe total de las mismas (neto).

 */
package ejercicio13.comercio.ventas;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Principal {

    public static void main(String[] args) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        String nomProducto = "";
        int precioUnidad = 0, cantidad = 0;

        int precioFinal, nVentas = 0, importeTotal = 0;
        Producto nombre = new Producto();
        Producto precio = new Producto();
        Producto unidades = new Producto();

        nomProducto = nombre.pedirNombre("Introducir producto: ");
        while (nomProducto.compareTo("*") != 0) {
            precioUnidad = precio.pedirPrecio("¿Cuánto cuesta la unidad?", 0);
            cantidad = unidades.pedirCantidad("¿Cuántos quiere? ", 0);
            if (precioUnidad < 6) {
                System.out.println("No tiene descuente");
                precioFinal = precioUnidad * cantidad;
                System.out.println("Importe total de la compra: " + precioFinal + " €");
            } else if (precioUnidad >= 6 && precioUnidad <= 52) {
                System.out.println("Tiene un descuento del 5%");
                precioFinal = ((precioUnidad * cantidad) * 5) / 100;
                System.out.print("El precio con el descuento aplicado es " + precioFinal + " €");
                System.out.println("Importe total de la compra: " + precioFinal + " €");
            } else {
                System.out.println("Tiene un descuento del 10%");
                precioFinal = ((precioUnidad * cantidad) * 10) / 100;
                System.out.print("El precio con el descuento aplicado es " + precioFinal + " €");
                System.out.println("Importe total de la compra: " + precioFinal + " €");
            }
            nVentas++;
            importeTotal = importeTotal + precioFinal;
            nomProducto = nombre.pedirNombre("Introducir producto: ");
        }
        if (nVentas > 0) {
            System.out.println("TOTAL DE VENTAS: " + nVentas);
            System.out.println("IMPORTE TOTAL DE TODAS LAS VENTAS: " + importeTotal + " €");
        } else {
            System.out.println("ERROR. NO HAY DATOS");
        }
    }

}
