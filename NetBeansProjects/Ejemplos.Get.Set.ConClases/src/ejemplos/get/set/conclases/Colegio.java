package ejemplos.get.set.conclases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Mario
 */
public class Colegio {

    private Alumnos miAlumno;
    float notaMayor = -1, notaMenor = 10;

    public Colegio() {
        miAlumno = new Alumnos("", 0, 0);
    }

    public Alumnos getMiAlumno() {
        return miAlumno;
    }

    private String pedirNombre() throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        String nombre = "";
        System.out.print("Introducir Nombre del alumno: ");
        nombre = teclado.readLine();
        while (nombre.compareTo("") == 0) {
            System.out.print("Vuelve a introducir nombre: ");
            nombre = teclado.readLine();
        }
        return nombre;
    }

    public float pedirNota() throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        float nota = 0;
        boolean correcto = false;
        while (!correcto) {
            try {
                System.out.print("Introducir nota del alumno: ");
                nota = Integer.parseInt(teclado.readLine());
                if (nota < 0 || nota > 10) {
                    System.out.println("ERROR");
                } else {
                    correcto = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR. NO ES UN NÚMERO " + e.getMessage());
            } catch (IOException e) {
            }
        }
        return nota;
    }

    public int pedirEdad() throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        int edad = 0;
        try {
            System.out.print("Introduce edad: ");
            edad = Integer.parseInt(teclado.readLine());
            while (edad < 0 || edad > 100) {
                System.out.println("ERROR");
                System.out.print("Vuelve a introducir edad: ");
                edad = Integer.parseInt(teclado.readLine());
            }
        } catch (NumberFormatException e) {
            System.out.println("ERROR. NO ES UN NÚMERO " + e.getMessage());
        } catch (IOException e) {
        }
        return edad;
    }

    public void pedirDatos() throws IOException {
        String nombre;
        float nota;
        int edad;
        nombre = pedirNombre();
        while (nombre.compareTo("-1") != 0) {
            miAlumno.setNombre(nombre);
            edad = pedirEdad();
            miAlumno.setEdad(edad);
            nota = pedirNota();
            miAlumno.setNota(nota);
            if (miAlumno.getNota() < 5) {
                miAlumno.actualizarConMenos5();
            } else if (miAlumno.getNota() >= 5 && miAlumno.getNota() <= 8) {
                miAlumno.actualizarConMenos8();
            } else {
                miAlumno.actualizarConMas8();
            }
            if (miAlumno.getNota() < notaMenor) {
                miAlumno.getNombreMenor();
                miAlumno.setNombreMenor(nombre);
                notaMenor = miAlumno.getNota();
            } else {
                miAlumno.getNombreMayor();
                miAlumno.setNombreMayor(nombre);
                notaMayor = miAlumno.getNota();
            }
            miAlumno.SumarNota();
            nombre = pedirNombre();
        }
    }

    public void informe() {
        if(miAlumno.SumarNota()>0){
        float porcMenos5, porcMenos8, porcMas8,media;
        porcMenos5 = (float) miAlumno.getConMenos5() / (miAlumno.getConMenos5() + miAlumno.getConMenos8() + miAlumno.getConMas8()) * 100;
        porcMenos8 = (float) miAlumno.getConMenos8() / (miAlumno.getConMenos5() + miAlumno.getConMenos8() + miAlumno.getConMas8()) * 100;
        porcMas8 = (float) miAlumno.getConMas8() / (miAlumno.getConMenos5() + miAlumno.getConMenos8() + miAlumno.getConMas8()) * 100;
        media=(float)miAlumno.totalNotas()/(miAlumno.getConMenos5()+miAlumno.getConMenos8()+miAlumno.getConMas8());
        System.out.println("\t" + "NOTA" + "\t" + "\t" + "TOTAL" + "\t" + "\t" + "PORCENTAJE");
        System.out.println("--------------------------------------------------------");
        System.out.println("Menor que 5" + "\t" + "\t" + miAlumno.getConMenos5() + "\t" + "\t" + porcMenos5);
        System.out.println("Menor que 8" + "\t" + "\t" + miAlumno.getConMenos8() + "\t" + "\t" + porcMenos8);
        System.out.println("Más que 8" + "\t" + "\t" + miAlumno.getConMas8() + "\t" + "\t" + porcMas8);
        System.out.println("El alumno con mayor calificación es "+miAlumno.getNombreMayor()+" con un "+notaMayor);
        System.out.println("El alumno con menor calificación es "+miAlumno.getNombreMenor()+" con un "+notaMenor);
        System.out.println("La nota media de los alumnos es "+media);
        }else{
            System.out.println("ERROR. NO HAY DATOS");
        }
    }
}
/*Siempre me suma la ultima nota introducida al pedir la nota media. Revisar*/