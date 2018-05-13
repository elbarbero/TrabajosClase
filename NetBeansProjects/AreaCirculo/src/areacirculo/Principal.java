/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package areacirculo;

/**
 *
 * @author 203pc19
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Circulo c;//estoy definiendo un dato de la otra clase
        c=new Circulo();
        float area;
        c.radio=2;
        area=c.calculoArea();
        System.out.print("Area="+area);//sirve para que no cambie de linea en el siguiente system
        System.out.println("cm");
    }
    
}
