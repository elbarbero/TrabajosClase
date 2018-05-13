/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlnoviembre;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author ADMINMJ
 */
public class ControlNoviembre {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ControlNoviembre objeto = new ControlNoviembre();
        int nHab;
        String nombre;
        int menor = 0;
        int medio = 0;
        int mayor = 0;
        int total=0;
        float p1, p2, p3;
        int mayorHab = Integer.MIN_VALUE;
        String nombreMay = "";
        int menorHab = Integer.MAX_VALUE;
        String nombreMen = "";
        nombre = objeto.nombrePoblacion();
        while (nombre.compareToIgnoreCase("FIN") != 0) {
            nHab = objeto.numeroHabitantes();
            if (nHab < 2000) {
                menor++;
            } else if (nHab < 300000) {
                medio++;
            } else {
                mayor++;
            }
            if (nHab < menorHab){
                menorHab=nHab;
                nombreMen=nombre;
            }
            if (nHab>mayorHab){
                mayorHab=nHab;
                nombreMay=nombre;
            }
            nombre = objeto.nombrePoblacion();
        }
        total=menor+medio+mayor;
        if (total !=0){
            p1=(float)menor/total*100;
            p2=(float)medio/total*100;
            p3=(float)mayor/total*100;
            System.out.println ("INFORME POBLACIONES");
            System.out.println ("MENOR DE 2OO0\t\t"+menor+"\t"+p1);
            System.out.println ("ENTRE DE 2OO0 Y 300000\t"+medio+"\t"+p2);
            System.out.println ("MAS DE 300000\t\t"+mayor+"\t"+p3);
            System.out.println ("POBLACIÓN COM MAYOR NÚMERO DE HABITANTES"+ 
                    nombreMay+"\t"+mayorHab);
             System.out.println ("POBLACIÓN COM MENOR NÚMERO DE HABITANTES"+ 
                    nombreMen+"\t"+menorHab);
        }
        else
        {
            System.out.println ("SIN DATOS");
        }
    }

    public String nombrePoblacion() {
        String nombre = "";
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        try {
            System.out.print("NOMBRE POBLACIÓN: ");
            nombre = teclado.readLine();
            while (nombre.equals("")) {// nombre.compareTo("")==0
                System.out.print("NOMBRE POBLACIÓN: ");
                nombre = teclado.readLine();
            }
        } catch (IOException ex) {
        }
        return nombre;
    }

    public int numeroHabitantes() {
        int nhabitantes = 0;

        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        boolean mal = true;
        while (mal) {
            try {
                System.out.println("NÚMERO HABITANTES: ");
                nhabitantes = Integer.parseInt(teclado.readLine());
                if (nhabitantes < 0) {
                    System.out.println("El nº de habitantes no puede ser negativo");
                } else {
                    mal = false;
                }
            } catch (NumberFormatException ex) {
                System.out.println("Dato no numérico");
            } catch (IOException ex) {
            }
        }
        return nhabitantes;
    }
}
