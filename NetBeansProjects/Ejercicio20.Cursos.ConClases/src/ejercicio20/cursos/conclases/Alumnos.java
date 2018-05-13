/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio20.cursos.conclases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @Mario Barbero
 */
public class Alumnos {

    private Curso curso1;
    private Curso curso2;
    private Curso curso3;
    int total1 = 0, total2 = 0, total3 = 0;

    public Alumnos() {
        /*Ponemos las plazas disponibles a cero por defecto.
         Despues las meto por teclado.*/
        curso1 = new Curso("Informatica", 0);
        curso2 = new Curso("Programacion", 0);
        curso3 = new Curso("Ingles", 0);
    }

    public Curso getcurso1() {
        return curso1;
    }

    public Curso getcurso2() {
        return curso2;
    }

    public Curso getcurso3() {
        return curso3;
    }

    public int pedirPlazas() throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        int nPlazas = 0;
        boolean correcto = false;
        while (!correcto) {
            try {
                System.out.print("Introducir el número de plazas del curso: ");
                nPlazas = Integer.parseInt(teclado.readLine());
                if (nPlazas < 0) {
                    System.out.println("ERROR");
                } else {
                    correcto = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR. NO ES UN NÚMERO" + e.getMessage());
            } catch (IOException e) {
            }
        }
        return nPlazas;
    }

    public String pedirNombre() throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        String nombre = "";
        try {
            System.out.print("Nombre del alumno: ");
            nombre = teclado.readLine();
            while (nombre.compareTo("") == 0) {
                System.out.println("ERROR");
                System.out.print("Vuelve a introducir nombre: ");
                nombre = teclado.readLine();
            }
        } catch (IOException e) {
        }
        return nombre;
    }

    public int pedirEdad() throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        int edad = 0;
        boolean correcto = false;
        while (!correcto) {
            try {
                System.out.print("Introduce edad del alumno: ");
                edad = Integer.parseInt(teclado.readLine());
                if (edad < 0) {
                    System.out.println("ERROR.");
                } else {
                    correcto = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR. NO ES UN NÚMERO" + e.getMessage());
            } catch (IOException e) {
            }
        }
        return edad;
    }

    public String pedirCurso() throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        String nomCursos = "";
        try {
            System.out.print("Nombre del curso: ");
            nomCursos = teclado.readLine();
            while (nomCursos.compareTo("-1") != 0 && (nomCursos.compareToIgnoreCase(curso1.getNombre()) != 0
                    && nomCursos.compareToIgnoreCase(curso2.getNombre()) != 0
                    && nomCursos.compareToIgnoreCase(curso3.getNombre()) != 0)) {
                System.out.print("Vuelve a introducir nombre del curso: ");
                nomCursos = teclado.readLine();
            }
        } catch (IOException e) {
        }
        return nomCursos;
    }

    public void pedirDatos() throws IOException {
        String nombre, nomCurso = "";
        int edad, nPlazas = 0, total = 0;
        while (curso1.getnPlazas() == 0 || curso2.getnPlazas() == 0 || curso3.getnPlazas() == 0) {
            if (curso1.getnPlazas() == 0) {
                System.out.println("Introduce las plazas para Informatica");
                nPlazas = pedirPlazas();
                curso1.setnPlazas(nPlazas);
            } else if (curso2.getnPlazas() == 0) {
                System.out.println("Introduce las plazas para Programación");
                nPlazas = pedirPlazas();
                curso2.setnPlazas(nPlazas);
            } else if (curso3.getnPlazas() == 0) {
                System.out.println("Introduce las plazas para Ingles");
                nPlazas = pedirPlazas();
                curso3.setnPlazas(nPlazas);
            }
        }

        nomCurso = pedirCurso();
        /*En el while seguimos metiendo mientras haya plazas disponibles*/
        while (nomCurso.compareTo("-1") != 0 && (curso1.plazasDisponibles() > 0
                || curso2.plazasDisponibles() > 0 || curso3.plazasDisponibles() > 0)) {
            nombre = pedirNombre();
            edad = pedirEdad();
            if (nomCurso.compareToIgnoreCase(curso1.getNombre()) == 0 && (curso1.getPlazasOcupadas() + 1) <= curso1.getnPlazas()) {
                curso1.SumarAlumnos();
                total1 = total1 + edad;
            } else if (curso1.getPlazasOcupadas() == curso1.getnPlazas() && curso1.getPlazasOcupadas() == curso1.getnPlazas()) {
                System.out.print("ERROR. NO HAY PLAZAS PARA " + curso1.getNombre());
            }
            if (nomCurso.compareToIgnoreCase(curso2.getNombre()) == 0 && (curso2.getPlazasOcupadas() + 1) <= curso2.getnPlazas()) {
                curso2.SumarAlumnos();
                total2 = total2 + edad;
            } else if (nomCurso.compareToIgnoreCase(curso2.getNombre()) == 0 && curso2.getPlazasOcupadas() == curso2.getnPlazas()) {
                System.out.println("ERROR. NO HAY PLAZAS PARA " + curso2.getNombre());
            }
            if (nomCurso.compareToIgnoreCase(curso3.getNombre()) == 0 && (curso3.getPlazasOcupadas() + 1) <= curso3.getnPlazas()) {
                curso3.SumarAlumnos();
                total3 = total3 + edad;
            } else if (nomCurso.compareToIgnoreCase(curso3.getNombre()) == 0 && curso3.getPlazasOcupadas() == curso3.getnPlazas()) {
                System.out.println("ERROR. NO HAY PLAZAS PARA " + curso3.getNombre());
            }
            if (curso1.plazasDisponibles() > 0 || curso2.plazasDisponibles() > 0 || curso3.plazasDisponibles() > 0) {
                nomCurso = pedirCurso();
            }
        }
    }

    public void informe() {
        if (curso1.getPlazasOcupadas() != 0 || curso2.getPlazasOcupadas() != 0 || curso3.getPlazasOcupadas() != 0) {
            float porcCurso1, porcCurso2, porcCurso3;
            float media1 = 0, media2 = 0, media3 = 0;
            media1 = (float) total1 / curso1.getPlazasOcupadas();
            media2 = (float) total2 / curso2.getPlazasOcupadas();
            media3 = (float) total3 / curso3.getPlazasOcupadas();
            porcCurso1 = (float) curso1.getPlazasOcupadas() / curso1.getnPlazas() * 100;
            porcCurso2 = (float) curso2.getPlazasOcupadas() / curso2.getnPlazas() * 100;
            porcCurso3 = (float) curso3.getPlazasOcupadas() / curso3.getnPlazas() * 100;
            System.out.println("\t" + "\t" + "NºALUMNOS" + "\t" + "\t" + "EDAD MEDIA" + "\t" + "\t" + "PORCENTAJE");
            System.out.println(curso1.getNombre() + "\t" + curso1.getPlazasOcupadas() + "\t" + "\t" + "\t" + media1 + "\t" + "\t" + "\t" + porcCurso1);
            System.out.println(curso2.getNombre() + "\t" + curso2.getPlazasOcupadas() + "\t" + "\t" + "\t" + media2 + "\t" + "\t" + "\t" + porcCurso2);
            System.out.println(curso3.getNombre() + "\t" + "\t" + curso3.getPlazasOcupadas() + "\t" + "\t" + "\t" + media3 + "\t" + "\t" + "\t" + porcCurso3);
            System.out.println("Total de alumnos matriculados: " + (curso1.getPlazasOcupadas() + curso2.getPlazasOcupadas() + curso3.getPlazasOcupadas()));
        } else {
            System.out.println("ERROR. NO HAY DATOS");
        }
    }
}
