/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplosuma;

/**
 *
 * MARIO BARBERO
 */
public class EjemploSuma {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int numero1;  //para numeros enteros
        double numero2;  //para resultados con muchos decimales
        double resultado1;
        float numero3;  //para numeros con decimales
        int numero4;
        float resultado2;
        double resultado3;
        double resultado4;
      
        numero1=-4;
        numero2=2.3;
        numero3=12.34f;
        numero4=11;
        resultado1=numero1/numero2;
        resultado2=numero3+numero4;
        resultado3=resultado2*resultado1;
        resultado4=numero1/resultado3+numero3;
        System.out.println("Resultado1= "+resultado1);
        System.out.println("Resultado2= "+resultado2);
        System.out.println("Resultado3= "+resultado3);
        System.out.println("resultado4= "+resultado4);
    }
    
}
