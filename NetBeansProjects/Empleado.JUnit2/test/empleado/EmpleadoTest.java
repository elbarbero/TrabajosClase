package empleado;

import Empleado.JUnit2.Empleado;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 *
 * @author 203pc19
 */
@RunWith(Parameterized.class)
public class EmpleadoTest {

    String tipoEmpleado;
    float ventasMes;
    int horasExtras;
    float resultadoSueldoBruto;
    float resultadoSueldoNeto;

    public EmpleadoTest(String tipoEmpleado, float ventasMes, int horasExtras, float resultadoSueldoBruto, float resultadoSueldoNeto) {
        this.tipoEmpleado = tipoEmpleado;
        this.ventasMes = ventasMes;
        this.horasExtras = horasExtras;
        this.resultadoSueldoBruto = resultadoSueldoBruto;
        this.resultadoSueldoNeto = resultadoSueldoNeto;
    }

    @Parameters
    /*Es una colección de datos que van a ser un conjuntos de objetos.
     Inicializar es un nombre cualquiera que queremaos poner.*/
    public static Collection<Object[]> inicializar() {
        /*Un array que es de tipo objeto (Object) y ponemos unos corchetes[][] para
         indicar que es un conunto de empleados y cada empleado tendrá una información
         determinada, por eso ponemos dos corchetes seguidos.*/
        return Arrays.asList(new Object[][]{{"vendedor", 1700, 10, 1100, 921},
        {"encargado", 800, 2, 1540, 1262.8f}, {"vendedor", 500, 1, 1700, 1001}, {"encargado", 2000, 10, 1800, 1476}});
    }

    @Test
   /* public void testCalcularSalarioBruto()throws IOException{
        System.out.println("dhghhdt");
        Empleado instance=new Empleado();
        tipoEmpleado="vendedor";
        ventasMes=1521;     PRUEBA PARA EL EXAMEN
        horasExtras=10;     HECHA POR MARIO 
        float esperado=1254F;
        float resultado=instance.calcularSalarioBruto(tipoEmpleado, ventasMes, horasExtras);
        assertEquals("MAL",esperado,resultado,0.0);
    }*/
    public void testCalcularSalarioBruto() throws Exception {
        System.out.println("calcularSalarioBruto");
        String tipoEmpleado = "vendedor";
        float ventasMes = 1600f;
        float horasExtra = 20;
        Empleado instance = new Empleado();
        float expResult = 1300f;
        float result = instance.calcularSalarioBruto(tipoEmpleado, ventasMes, horasExtra);
        assertEquals("ERROR EN EL CALCULO DEL SALARIO BRUTO",expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void testCalcularSalarioNeto() throws Exception {
        System.out.print("CALCULO DEL SALARIO NETO");
        float salarioB = 2000f;
        Empleado objeto = new Empleado();
        /*salarioB se tiene que llamar igual que en la clase Empleado*/
        float resultado = objeto.calcularSalarioNeto(salarioB);
        assertEquals("ERROR EN EL CALCULO DEL SALARIO NETO", 1640, resultado, 0.0);
        /*1640 es lo que creemos que va a ser ell resultado*/
        /*0.0 indica que nos calcule todos los decimales*/
    }

    /**
     * Test of calcularSalarioBruto method, of class Empleado.
     */
    @Test
    public void testCalcularSalarioBrutoParametizado() throws Exception {
        System.out.println("calcularSalarioBruto");
        Empleado instance = new Empleado();
        float result = instance.calcularSalarioBruto(tipoEmpleado, ventasMes, horasExtras);
        assertEquals(resultadoSueldoBruto, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void testCalcularSalarioNetoParametizado()throws Exception  {
        System.out.print("CALCULO DEL SALARIO NETO");
        Empleado objeto = new Empleado();
        /*salarioB se tiene que llamar igual que en la clase Empleado*/
        float resultado = objeto.calcularSalarioNeto(resultadoSueldoBruto);
        assertEquals("ERROR EN EL CALCULO DEL SALARIO NETO", resultadoSueldoNeto, resultado, 0.0);
        /*0.0 indica que nos calcule todos los decimales*/
    }
    @Test
    public void calcularAmbos()throws Exception{
        System.out.println("Parametizados Ambos");
        Empleado instance=new Empleado();
        float resultado1=instance.calcularSalarioBruto(tipoEmpleado, ventasMes, horasExtras);
        float resultado2=instance.calcularSalarioNeto(resultadoSueldoBruto);
        assertEquals("SI",resultadoSueldoBruto,resultado1,0.0);
        assertEquals("SI",resultadoSueldoNeto,resultado2,0.0);
    }
}
