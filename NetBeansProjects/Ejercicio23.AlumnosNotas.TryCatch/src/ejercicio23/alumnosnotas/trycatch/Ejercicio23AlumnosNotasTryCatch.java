/*23. Realiza un programa que introduzca los  nombres y la
 calificaciones de los alumnos de una clase hasta que el
 operador introduzca * como nombre.
 Finalizada la entrada de datos se mostrará
 en pantalla la siguiente información:
 */
package ejercicio23.alumnosnotas.trycatch;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Ejercicio23AlumnosNotasTryCatch {

    public static void main(String[] args) throws IOException{
        InputStreamReader flujo=new InputStreamReader(System.in);
        BufferedReader teclado=new BufferedReader (flujo);
        int nota=0,menorK5=0,menorK8=0,mayorK8=0,totalAlumnos=0,suma=0;
        int notaMenor=10,notaMayor=-1;
        String nombre="";
        String nombreMenor="",nombreMayor="";
        float porcentaje, media;
        boolean correcto=false;
        System.out.print("Nombre del Alumno: ");
        nombre=teclado.readLine();
        while(nombre.compareTo("*")!=0){
            correcto=false;
            while(!correcto){
                try{
                    System.out.print("Introduce nota: ");
                    nota=Integer.parseInt(teclado.readLine());
                    if(nota<0||nota>10){
                        System.out.println("ERROR");
                    }else{
                        correcto=true;
                    }
                }catch(NumberFormatException e){
                    System.out.println("ERROR. NO ES UN NÚMERO "+e.getMessage());
                }catch(IOException e){}
            }
            if(nota<5){
                menorK5++;
            }else if(nota>=5&&nota<=8){
                menorK8++;
            }else if(nota>8&&nota<=10){
                mayorK8++;
            }
            if(nota>notaMayor){
                nombreMayor=nombre;
                notaMayor=nota;
            }else if(nota<notaMenor){
                nombreMenor=nombre;
                notaMenor=nota;
            }
            totalAlumnos++;
            suma=suma+nota;
            System.out.print("Introduce nombre: ");
            nombre=teclado.readLine();
        }
        if(totalAlumnos>0){
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
        }else{
            System.out.println("ERROR. NO HAY DATOS");
        }
    }
    
}
