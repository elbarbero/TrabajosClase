package junit.explicacion;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 *
 * @author Mario
 */
@RunWith(Parameterized.class)
public class PrincipalTest {
//DECLARAMOS LAS VARIABLES QUE NOS VAN A HACER FALTA PARA REALIZAR LAS PRUEBAS

    int num1;
    int num2;
    boolean correcto;
    int result;
    long a;
    long b;
    long c;
    int d;
    int e;
    long total;
    Principal objeto;

    public PrincipalTest(int num1, int num2, boolean correcto, int result, long a, long b, long c, int d, int e, long total) {
        //CONSTRUCTOR CON LAS VARIABLES QUE VAMOS A UTILIZAR EN LAS PRUEBAS PARAMETIZADAS
        //SIEMPRE HAY QUE CREAR UN CONSTRUCTOR EN LA CLASE TEST PARA HACER LAS PRUEBAS PARAMETIZADAS
        this.num1 = num1;
        this.num2 = num2;
        this.correcto = correcto;
        this.result = result;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.total = total;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> Incializar() {
        /*ASIGNAMOS UN VALOR A CADA UNA DE LAS VARIABLES DEL CONSTRUCTOR ANTEIOR.
        TIENEN QUE IR EN EL MISMO ORDEN EL QUE FUERON DECLARADAS EN EL CONSTRUCTOR*/
        return Arrays.asList(new Object[][]{{11, 23, false, 41, 5, 13, 16, 13, 61, 34}, {6, 37, false, 35, 5, 8, 127, 10, 27, 140}, {17, 6, true, 18, 3, 26, 74, 1, 9, 103}});
    }

    @Before
    public void AntesDe() {//ESTE MÉTODO SIEMPRE SE EJECUTA ANTES DE LOS @TEST
        //TODO LO QUE VAYA DENTRO SE EJECUTARÁ ANTES
        System.out.println("Se Ejecuta Antes De...");
        objeto = new Principal();

    }

    @After
    public void DespuesDe() {//ESTE MÉTODO SE EJECUTA DESPUES DE LOS @TEST
        System.out.println("Se Ejecuta Despues De Los @TEST");
    }

    @Test
    public void TestCalculoSuma() {
        System.out.println("...TestCalculoSuma");
        Principal instance = new Principal();//EL CONSTRUCTOR VACIO CREADO EN LA CLASE PRINCIPAL SIRVE PARA QUE NOS PERMITA DEJAR ESTOS PARENTESIS VACIOS.
        //SI NO TUVIESEMOS UN CONSTRUCTOR VACIO ESTARIAMOS OBLIGADOS A PONER ENTRE ESOS PARENTESIS LAS VARIABLES DEL CONSTRUCTOR DE LA CLASE PRINCIPAL
        int esperado = 36;
        instance.CalculoSuma(12, 29, 11);//PONEMOS LAS VARIABLES ENTRE LOS PARENTESIS DEL MÉTODO PORQUE ASÍ LAS DECLARAMOS EN LA CASE PRINCIPAL
        assertEquals("MAL", esperado, instance.estado(), 0.0);
        //ESPERADO=RESULTADO QUE CREEMOS QUE VAMOS A OBTENER
        //INSTANCE.ESTADO=EL RESULTADO CORRECTO. LO PONEMOS ASÍ PORQUE ASÍ LO HEMOS PUESTO EN LA CLASE PRINCIPAL
    }

    @Test
    public void TestPreguntar() {
        System.out.println("...TestPreguntar");
        Principal instance = new Principal(11, 22, false, 33);//PONEMOS LAS VARIABLES ENTRE ESTOS PARENTESIS PORQUE HEMOS PUESTO LAS VARIABLES EN EL CONSTRUCTOR EN LA CLASE PRINCIPAL
        float esperado = 11;
        int resultado = instance.Prenguntar();
        assertEquals("MAL", esperado, resultado, 0.0);
    }

    @Test
    public void TestCalculandoCalculos() {
        System.out.println("...TestCalculandoCalculos");
        int esperado = 73;
        int resultado = objeto.CalculandoCalculos(51, 22);//PONEMOS LAS VARIABLES ENTRE LOS PARENTESIS DEL MÉTODO PORQUE ASÍ LAS DECLARAMOS EN LA CASE PRINCIPAL
        assertEquals("MAL", esperado, resultado, 0.0);
    }

    @Test
    public void TestCuestionario() {
        System.out.println("...TestCuestionario");
        Principal instance = new Principal();
        num1 = 6;
        num2 = 8;
        boolean resultadoReal = instance.Cuestionario();
        assertFalse("SI", resultadoReal);
    }

    @Test
    public void CalculoSumaParametizado() {//ESTE MÉTODO ES PARAMETIZADO. VA A RECIBIR LOS VALORES DE LAS VARIABLES DEL @Parameterized.Parameters
        System.out.println("...CalculoSumaParametizado");
        Principal instance = new Principal();
        instance.CalculoSuma(a, b, c);//COMO VEIS SOLO HAY QUE PONER EL NOMBRE DE LAS VARIABLES, NUNCA HAY QUE PONER SU VALOR
        assertEquals("PEOR", total, instance.estado());
    }

    @Test
    public void PreguntarParametizado() {
        System.out.println("...PreguntarParametizado");
        Principal instance = new Principal();
        int resultadoReal = instance.Prenguntar();
        assertEquals("PEOR", result, resultadoReal);
    }

    @Test
    public void CalculandoCalculosParametizado() {
        System.out.println("...CalculandoCalculosParametizado");
        float resultadoReal = objeto.CalculandoCalculos(d, e);
        assertEquals("PEOR", result, resultadoReal, 0.0);
    }

    @Test
    public void TestCuestionarioParametizado() {
        System.out.println("...TestCuestionarioParametizado");
        Principal instance = new Principal();
        boolean resultadoReal = instance.Cuestionario();
        assertTrue("NO", resultadoReal);
    }

    @Test
    public void TestCuestionarioParametizado2() {//COMPARAMOS DOS BOOLEAN, POR ESO PONEMOS UN ASSERTEQUALS
        System.out.println("...TestCuestionarioParametizado2");
        Principal instance = new Principal();
        boolean resultadoReal = instance.Cuestionario();
        assertEquals("NO ES IGUAL", resultadoReal, correcto);
    }
}
