/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio23.alumnos.calificaciones3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Mario
 */
public class Notas {

    private Alumnos alumno1;
    int menorK5 = 0, menorK8 = 0, mayorK8 = 0, totalAlumnos = 0;
    String nombreMayor = "", nombreMenor = "";
    int notaMayor = -1, notaMenor = 10;
    float suma = 0, porcentaje, media;

    public Notas() {
        /*Declaramos al objeto alumno1.
        Este public es un constructor y siempre se tiene que llamar como la clase.*/
        alumno1 = new Alumnos();
    }

    public void IntroducirNotas() throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        String nombre;
        int nota = 0;

        System.out.print("Nombre del alumno: ");
        nombre = teclado.readLine();

        while (nombre.compareTo("*") != 0) {
            System.out.print("Introduce nota: ");
            nota = Integer.parseInt(teclado.readLine());
            while (nota < 0 && nota > 10) {
                System.out.print("Vuelve a introducir nota: ");
                nota = Integer.parseInt(teclado.readLine());
            }
            if (nota < 5) {
                menorK5++;
            } else if (nota >= 5 && nota <= 8) {
                menorK8++;
            } else if (nota > 8 && nota <= 10) {
                mayorK8++;
            }
            if (nota > notaMayor) {
                nombreMayor = nombre;
                notaMayor = nota;
            } else if (nota < notaMenor) {
                nombreMenor = nombre;
                notaMenor = nota;
            }
            totalAlumnos++;
            suma = suma + nota;
            alumno1.DatosAlumnos(nombre, nota);
            /*Esta última instrucción modifica las variables de nombre y nota de alumno1.
        Alumno1 ha sido declarado en la clase donde meteran los datos por teclado.*/
            System.out.print("Nombre del alumno: ");
            nombre = teclado.readLine();
        }

    }

    /*Ahora creamos un método para visualizar las variables nombreAlumno
    y notaAlumno que se han declarado en la clase Alumnos*/
    public void visualizarNotas() {
        if (totalAlumnos > 0) {
            System.out.println("El alumno " + nombreMenor + " ha sacado la menor nota, un " + notaMenor);
            System.out.println("El alumno " + nombreMayor + " ha sacado la mayor nota, un " + notaMayor);
            media = (float) suma / totalAlumnos;
            System.out.println("La media total de todas las notas es: " + media);
            System.out.println("Con una nota menor de 5 ha habido un total de " + menorK5 + " alumnos");
            System.out.println("Con una nota entre de 5 y 8 ha habido un total de " + menorK8 + " alumnos");
            System.out.println("Con una nota mayor de 8 ha habido un total de " + mayorK8 + " alumnos");
            porcentaje = ((float) menorK5 / totalAlumnos) * 100;
            System.out.println("Con menos de un 4 en la nota un " + porcentaje + "%");
            porcentaje = ((float) menorK8 / totalAlumnos) * 100;
            System.out.println("Entre 5 y 8 en la nota un " + porcentaje + "%");
            porcentaje = ((float) mayorK8 / totalAlumnos) * 100;
            System.out.println("Con más de un 8 en la nota un " + porcentaje + "%");
        } else {
            System.out.println("ERROR. NO HAY DATOS");
        }
        //System.out.println(alumno1.getNombreAlumno() + " ha sacado un " + alumno1.getNotaAlumno());
    }
}
