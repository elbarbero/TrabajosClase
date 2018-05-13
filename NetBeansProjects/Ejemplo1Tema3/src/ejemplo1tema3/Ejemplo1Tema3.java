/*
 * Clase que calcula la división de cociente de dos úmeros
 */
package ejemplo1tema3;

/**
 *
 * MARIO BARBERO
 */
public class Ejemplo1Tema3 {

    //DECLARACION DE VARIABLES
    public static void main(String[] args) {
    int cociente, resto;
    int dividendo;
    int divisor;
    float cociente2;
    
   //INICIALIZAR
    dividendo=9;
    divisor=2;
    //OPERACIONES
    cociente= dividendo/divisor;
    resto=dividendo%divisor;
    cociente2=(float)dividendo/divisor;
    //lo que va entre comillas en el println es lo que apracera en el programa al ejecutarlo
    System.out.println("el resultado real es " +cociente2);
    System.out.println(dividendo +"/"+divisor+"="+cociente);
    System.out.println("Resultado= "+cociente);
    System.out.println("Resto= "+resto);
    }
    
}
