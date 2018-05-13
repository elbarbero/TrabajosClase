/*23. Realiza un programa que introduzca los  nombres y la
 calificaciones de los alumnos de una clase hasta que el
 operador introduzca * como nombre.
 Finalizada la entrada de datos se mostrará
 en pantalla la siguiente información:
 */
package ejercicio23.alumnoscalificaciones2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio23AlumnosCalificaciones2 {

    public static void main(String[] args) throws IOException {
        InputStreamReader flujo=new InputStreamReader(System.in);
        BufferedReader teclado=new BufferedReader(flujo);
        String dato1="",nombreMenor="",nombreMayor="";
        int dato2=0;
        int totalAlumnos=0, menorK5=0, menorK8=0,mayorK8=0;
        int notaMayor=-1,notaMenor=10;
        float suma=0,porcentaje,media;
        Ejercicio23AlumnosCalificaciones2 objeto;
        objeto=new Ejercicio23AlumnosCalificaciones2();
        dato1=objeto.pedirNombre("Introduce nombre: ");
        while(dato1.compareTo("*")!=0){
            dato2=objeto.pedirNota("Introduce nota: ",0,10);
                if(dato2<5){
                menorK5++;
            }else if(dato2>=5&&dato2<8){
                menorK8++;
            }else {
                mayorK8++;
            }
            if(dato2>notaMayor){
                nombreMayor=dato1;
                notaMayor=dato2;
            }else if(dato2<notaMenor){
                nombreMenor=dato1;
                notaMenor=dato2;
            }
            totalAlumnos++;
            suma=suma+dato2;
            dato1=objeto.pedirNombre("Introduce nombre: ");
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
    public String pedirNombre(String mensaje)throws IOException{
        InputStreamReader flujo=new InputStreamReader(System.in);
        BufferedReader teclado=new BufferedReader(flujo);
        String nombre="";
        System.out.print(mensaje);
        nombre=teclado.readLine();
        while(nombre.compareTo("")==0){
            System.out.print("Vuelve a meter nombre: ");
            nombre=teclado.readLine();
        }
        return nombre;
    }
    public int pedirNota(String mensaje, int limiteInferior,int limiteSuperior)throws IOException{
        InputStreamReader flujo=new InputStreamReader(System.in);
        BufferedReader teclado=new BufferedReader(flujo);
        int nota=0;
        boolean correcto=false;
        while(!correcto){
            try{
                System.out.print(mensaje);
                nota=Integer.parseInt(teclado.readLine());
                if(nota<limiteInferior||nota>limiteSuperior){
                    System.out.println("ERROR");
                }else{
                correcto=true;
                }
            }catch(NumberFormatException e){
                System.out.println("ERROR. NO ES UN NÚMERO "+e.getMessage());
            }catch(IOException e){}
        }
        return nota;
    }
}
