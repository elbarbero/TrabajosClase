/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleadosarray;

/**
 *
 * @author 203pc19
 */
public class Empleado {

    String nombre;
    int horas;
    int CodCategoria;

    public Empleado() {

    }

    public Empleado(String nombre, int horas, int CodCategoria) {
        this.nombre = nombre;
        this.horas = horas;
        this.CodCategoria = CodCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public int getHoras() {
        return horas;
    }

    public int getCodCategoria() {
        return CodCategoria;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public void setCodCategoria(int CodCategoria) {
        this.CodCategoria = CodCategoria;
    }

    public void Empleado() {

    }

    public void Empleado(String n, int c, int h) {
        nombre = n;
        horas = h;
        CodCategoria = c;
    }

    public float CalculoSueldoBruto(float precioHora) {
        float salarioBruto;
        if (horas <= 40) {
            salarioBruto = horas * precioHora;
        } else {
            // SI ES MAS DE 40H, LAS 40 PRIMERAS SE PAGA A PRECIO TARIFA Y LUEGO SE RESTA PARA EL SOBRANTE MULTIMPLICARLO POR EL PLUS 1.8 DE LA TARIFA
            salarioBruto = 40 * precioHora + (horas - 40) * precioHora * 1.8f;
        }
        return salarioBruto;
    }

    public float CalculoDescuento(float salarioBruto) {
        float descuento;
        if (salarioBruto < 300) {//SI EL SALARIO ES MENOR O IGUAL A 300 --> 5%
            descuento = salarioBruto * 0.05f;
        } else {
            if (salarioBruto <= 600) {// SI EL SALARIO ES MAYOR A 300 Y MENOR A 600 --> 10%
                descuento = salarioBruto * 0.1f;
            } else {// SI ES MAYOR DE 600 --> 15%
                descuento = salarioBruto * 0.15f;
            }
        }
        return descuento;
    }
/*Si se pone algo entre los parentesis del método es que esas propiedades no perntenecen a la clase
    Si no se pone nada, es que si que pertenecen*/
    public float CalculoSueldoNeto(float salarioBruto, float descuento) {
        float salarioNeto;
        salarioNeto = salarioBruto - descuento;
        return salarioNeto;
    }
}
