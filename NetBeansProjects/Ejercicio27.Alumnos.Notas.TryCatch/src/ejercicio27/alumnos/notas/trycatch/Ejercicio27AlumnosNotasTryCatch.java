/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio27.alumnos.notas.trycatch;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Ejercicio27AlumnosNotasTryCatch {

    public static void main(String[] args) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        String nombre = "";
        String copiaNombre = "";
        float nota = 0, media, suma = 0, copiaNota = -1;
        int conTotal = 0, contSuspensos = 0, contAprobados = 0, contSobresalientes = 0;
        int numAlumnos = 0;
        boolean correcto = false, correcto2 = false;
        while (correcto == false) {
            try {
                System.out.print("Número de alumnos: ");
                numAlumnos = Integer.parseInt(teclado.readLine());
                if(numAlumnos<0){
                    System.out.print("ERROR");
                }else{
                correcto=true;
                }
            } catch (NumberFormatException e) {
                System.out.println("NO ES UN NÚMERO ");
                correcto = false;
            }
        }
        while (conTotal != numAlumnos) {
            correcto2=false;
                    System.out.print("Nombre del alumno: ");
                    nombre = teclado.readLine();
                    while (!correcto2) {//este while controla la nota
                        try {//este try controla la nota
                            System.out.print("Introduce nota: ");
                            nota = Float.parseFloat(teclado.readLine());
                            while (nota < 0 || nota > 10) {
                                System.out.print("Vuelve a introducir nota: ");
                                nota = Float.parseFloat(teclado.readLine());
                            }
                            correcto2 = true;
                        } catch (NumberFormatException e) {
                            System.out.println("NO ES UN NÚMERO "+e.getMessage());
                            correcto2 = false;
                        } catch (IOException e) {
                            correcto2 = false;
                        }
                    }
                    if (nota < 5) {
                        contSuspensos++;
                    } else if (nota >= 5 && nota <= 8) {
                        contAprobados++;
                    } else {
                        contSobresalientes++;
                    }
                    if (nota > copiaNota) {
                        copiaNombre = nombre;
                        copiaNota = nota;
                    }
                    conTotal++;
                    suma = suma + nota;
                
           
        
        }
        if (conTotal > 0) {
            media = (float) suma / conTotal;
            System.out.println("La nota media de los alumnos es " + media);
            System.out.println("El alumno con mayor nota ha sido " + copiaNombre + " con una nota de " + copiaNota);
            System.out.println("Alumnos supensos: " + contSuspensos);
            System.out.println("Alumnos entre un 5 y un 8: " + contAprobados);
            System.out.println("Alumnos con más de un 8: " + contSobresalientes);
        } else {
            System.out.println("ERROR. NO HAY DATOS");
        }
    
    }
}
