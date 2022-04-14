
package implement;

import entity.Consola;
import entity.Propulsor;
import entity.Repulsor;
import entity.Sintetizador;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class AccionesImplementServiceTest {
    
    public AccionesImplementServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testCaminar() {
        System.out.println("caminar");
        Propulsor p = new Propulsor(1d);
        Integer minutos = 10;
        AccionesImplementService instance = new AccionesImplementService();
        Double expResult = 20d;
        Double result = instance.caminar(p, minutos);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!expResult.equals(result)) {
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testCorrer() {
        System.out.println("correr");
        Propulsor p = new Propulsor(1d);
        Integer minutos = 10;
        AccionesImplementService instance = new AccionesImplementService();
        Double expResult = 40d;
        Double result = instance.correr(p, minutos);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!expResult.equals(result)) {
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testPropulsar() {
        System.out.println("propulsar");
        Propulsor p = new Propulsor(1d);
        Integer minutos = 10;
        AccionesImplementService instance = new AccionesImplementService();
        Double expResult = 60d;
        Double result = instance.propulsar(p, minutos);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!expResult.equals(result)) {
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testVolar() {
        System.out.println("volar");
        Propulsor p = new Propulsor(1d);
        Repulsor r = new Repulsor(1d);
        Integer minutos = 2;
        AccionesImplementService instance = new AccionesImplementService();
        Double expResult = 20d;
        Double result = instance.volar(p, r, minutos);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!expResult.equals(result)) {
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testDisparar() {
        System.out.println("disparar");
        Repulsor r = new Repulsor(1d);
        Integer minutos = 3;
        AccionesImplementService instance = new AccionesImplementService();
        Double expResult = 18d;
        Double result = instance.disparar(r, minutos);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!expResult.equals(result)) {
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testEscribir() {
        System.out.println("escribir");
        Consola c = new Consola(1d);
        Integer minutos = 2;
        AccionesImplementService instance = new AccionesImplementService();
        Double expResult = 2d;
        Double result = instance.escribir(c, minutos);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!expResult.equals(result)) {
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testHablar() {
        System.out.println("hablar");
        Sintetizador s = new Sintetizador(1d);
        Integer minutos = 20;
        AccionesImplementService instance = new AccionesImplementService();
        Double expResult = 20d;
        Double result = instance.hablar(s, minutos);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!expResult.equals(result)) {
            fail("The test case is a prototype.");
        }
    }
}
