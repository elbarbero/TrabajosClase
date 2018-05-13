
package areacirculo;

/**
 *
 * @author 203pc19
 */
public class Circulo {//hay que cerrar la llave al funal de cada bloque
    float radio;
    public float calculoArea(){//entre parentesis se ponen aquellos datos que no sean atributos de la clase pero lo necesuto para hacer los calculos
       //el "public" se pone para que pueda ver en todas las carpetas
        float area;//se llama local porque solo se conoce en el boque en el que está
        area=3.14f*radio*radio;//con "f" minuscula para que sea un numero real de simple precision
        return area;//para sacarlo fuera e ir fuera del metodo
   }
}