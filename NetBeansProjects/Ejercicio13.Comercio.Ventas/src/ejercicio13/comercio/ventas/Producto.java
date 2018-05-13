package ejercicio13.comercio.ventas;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Producto {

    public String pedirNombre(String mensaje) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        String nombre = "";
        System.out.print(mensaje);
        nombre = teclado.readLine();
        while (nombre.compareTo("") == 0) {
            System.out.println("NO SE HA INTRODUCIDO NUNGÚN PRODUCTO");
            System.out.print(mensaje);
            nombre = teclado.readLine();
        }
        return nombre;
    }

    public int pedirPrecio(String mensaje, int limiteInferior) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        int precio = 0;
        boolean correcto = false;
        while (!correcto) {
            try {
                System.out.print(mensaje);
                precio = Integer.parseInt(teclado.readLine());
                if (precio <= limiteInferior) {
                    System.out.println("ERROR");
                } else {
                    correcto = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("NO ES UN NÚMERO" + e.getMessage());
            } catch (IOException e) {
            }
        }
        return precio;
    }

    public int pedirCantidad(String mensaje, int limiteInferior) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        int cantidad = 0;
        boolean correcto = false;
        while (!correcto) {
            try {
                System.out.print(mensaje);
                cantidad = Integer.parseInt(teclado.readLine());
                if (cantidad <= limiteInferior) {
                    System.out.println("ERROR");
                } else {
                    correcto = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("NO ES UN NÚMERO" + e.getMessage());
            } catch (IOException e) {
            }
        }
        return cantidad;
    }
}
