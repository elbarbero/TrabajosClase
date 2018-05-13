package junit.explicacion;

/**
 *
 * @author Mario
 */
public class Principal {

    int num1;
    int num2;
    boolean correcto;
    int result;
    long total;

    public Principal(int num1, int num2, boolean correcto,int result) {//OTRO CONSTRUCTOR
        this.num1 = num1;
        this.num2 = num2;
        this.correcto = correcto;
        this.result=result;
    }

    public Principal() {//CONSTRUCTOR VACIO QUE NOS HARÁ FALTA EN EL TEST

    }

    public void CalculoSuma(long a, long b, long c) {//DECLARAMOS LAS VARIABLES ENTRE LOS PARENTESIS DEL MÉTODO
/*ESTE MÉTODO NO DEVUELVE NADA (VOID) POR LO TANTO NO HAY QUE PONER UN "RETURN"*/
        total = a + b + c;
    }

    public long estado() {//ESTE MÉTODO DEVUELVE SOLO EL VALOR DE LA VARIABLE "TOTAL"
        return total;
    }

    public int Prenguntar() {//DEVUELVE UN VALOR, POR LO TANTO HAY QUE PONER UN "RETURN"
        correcto = false;
        if (num1 >= 10) {
            correcto = true;
            result = num2 - num1;
        } else if (num2 > 20) {
            result = num1 + num2;
        }
        return result;
    }

    public boolean Cuestionario() {
        correcto = false;
        if (num1 > 5 && num2 > 5) {
            correcto = true;
        }
        return correcto;
    }

    public int CalculandoCalculos(int d, int e) {
        result = e + d;
        return result;
    }

}
