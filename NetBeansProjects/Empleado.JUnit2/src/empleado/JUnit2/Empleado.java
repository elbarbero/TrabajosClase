/*HECHO POR LA PROFESORA
 */
package Empleado.JUnit2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * HECHO POR LA PROFESORA
 */
public class Empleado {

    /**
     * @param args the command line arguments
     */
    public float calcularSalarioBruto(String tipoEmpleado, float ventasMes, float horasExtra) throws IOException {
        float salarioB = 0;
        if (tipoEmpleado.compareToIgnoreCase("vendedor") == 0) {
            salarioB = 800;
        } else {
            salarioB = 1500;
        }
        if (ventasMes > 1500) {
            salarioB = salarioB + 100;
        }
        salarioB = salarioB + 20 * horasExtra;
        return salarioB;
    }

    public float calcularSalarioNeto(float salarioB) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        float neto = 0, retencion;
        if (salarioB < 1000) {
            neto = salarioB;
        } else if (salarioB > 1000 && salarioB < 1500) {
            retencion = (float) salarioB * 16 / 100;
            neto = salarioB - retencion;
        } else if (salarioB > 1500) {
            retencion = (float) salarioB * 18 / 100;
            neto = salarioB - retencion;
        }
        System.out.println("Total de nomina: " + neto + "€");
        return neto;
    }

    public void pedirDatos() throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        String tipoEmpleado;
        System.out.print("Introduce categoría de trabajo: ");
        tipoEmpleado = teclado.readLine();

    }

}
