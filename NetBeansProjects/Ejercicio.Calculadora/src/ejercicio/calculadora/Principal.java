package ejercicio.calculadora;

public class Principal {

    public static void main(String[] args) {
        Calculadora c;
        Calculadora c1;
        int dato1, resultado2;
        int dato2;
        //c=new Calculadora();//igual que la clase secundaria
        //dato1=c.suma();
        /*En los parentesis del c1 se pone dos números porque en el
        método "Calculadora" la otra clase se han declarado dos
        numeros entre los parentesis del mismo.
        Si se quitan los datos de los parentesis de alguno los dos, del metodo
        o del c1, daría error.*/
        c1 = new Calculadora(101, 202);
        //resultado2=suma.resultado;
        //System.out.print(c1.resultado());
        //System.out.print(c1.numero2());
        dato2 = c1.setNumero1(5);
        /*Para modificar un número o un dato se pone el objeto.getNombre_de_la_variable.
         Entre los parentesis se pone el dato que queremos dar*/
        System.out.println(c1.getNumero1());
        /*Para leer un número o un dato se pone el objeto.setNombre_de_la_variable*/
    }

}
