package ejercicio.calculadora;

public class Calculadora {

    private int numero1;//solo lo puede ver el programador en la clase que se declara.
    int numero2;

    public Calculadora(int numero1, int numero2) {
        /*Se pone this. para que coga el dato de fuera del metodo.
         el this. trabaja con una propiedad de esa clase.*/
        this.numero1 = numero1;
        this.numero2 = numero2;
    }

    public int suma() {
        int resultado;
        resultado = numero1 + numero2;
        return resultado;
    }

    public int dividir() {
        int resultado;
        resultado = numero1 / numero2;
        return resultado;
    }

    public int resta() {
        int resultado;
        /*En el siguiente if se llama al public boolean resta2().
        resta2 engloba la condicion si es una cosa uotra.*/
        if (resta2()) {
            resultado = numero1 - numero2;
        } else {
            resultado = numero2 - numero1;
        }
        return resultado;
    }

    public boolean resta2() {
        boolean result;
        if (numero1 > numero2) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    public int getNumero1() {
        return numero1;
    }

    public int setNumero1(int numero1) {
        this.numero1 = numero1;
        return numero1;
    }

    
}
