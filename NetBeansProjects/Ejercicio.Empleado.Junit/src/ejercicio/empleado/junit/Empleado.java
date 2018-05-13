/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio.empleado.junit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Mario
 */
public class Empleado {

    public static void main(String[] args) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        String tipoEmpleado = "", horasExtra;
        float salarioBruto, salarioNeto, numHorasExtras, totalHorasExtras = 0, ventasMes = 0;
        Empleado miEmpleado = new Empleado();
        System.out.print("Introduce categoría de trabajo: ");
        tipoEmpleado = teclado.readLine();
        while (tipoEmpleado.compareToIgnoreCase("vendedor") != 0 && tipoEmpleado.compareToIgnoreCase("encargado") != 0) {
            System.out.println("Esa categoría no existe");
            System.out.print("Vuelve a introducir categoría: ");
            tipoEmpleado = teclado.readLine();
        }
        System.out.print("¿Quiere hacer horas extra?: ");
        horasExtra = teclado.readLine();
        if (horasExtra.compareToIgnoreCase("si") == 0) {
            System.out.print("¿Cuántas horas quiere hacer?: ");
            numHorasExtras = Float.parseFloat(teclado.readLine());
            totalHorasExtras = numHorasExtras * 20;
        }
        System.out.print("Introduce las ventas del mes: ");
        ventasMes = Float.parseFloat(teclado.readLine());
        salarioBruto = miEmpleado.CalculaSalarioBruto(tipoEmpleado, totalHorasExtras, ventasMes);
        salarioNeto = miEmpleado.CalculaSalarioNeto(salarioBruto);

    }//FIN DEL MAIN

    float CalculaSalarioBruto(String tipoEmpleado, float totalHorasExtras, float ventasMes) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        float bruto = 0, salarioBase;

        if (tipoEmpleado.compareToIgnoreCase("vendedor") == 0) {
            salarioBase = 800;
        } else {
            salarioBase = 1500;
        }
        if (totalHorasExtras > 0) {
            bruto = salarioBase + totalHorasExtras;
        } else {
            bruto = salarioBase;
        }
        if (ventasMes > 1500) {
            bruto = bruto + 100;
        }
        return bruto;
    }

    float CalculaSalarioNeto(float salarioBruto) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        float neto = 0, retencion;
        if (salarioBruto < 1000) {
            neto = salarioBruto;
        } else if (salarioBruto > 1000 && salarioBruto < 1500) {
            retencion = (float) salarioBruto * 16 / 100;
            neto = salarioBruto - retencion;
        } else if (salarioBruto > 1500) {
            retencion = (float) salarioBruto * 18 / 100;
            neto = salarioBruto - retencion;
        }
        System.out.println("Total de nomina: " + neto + "€");
        return neto;
    }
}
