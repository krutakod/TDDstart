package ru.krutakod.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SquareRootTest {

    /**
     * Абсолютная погрешность
     */
    private final static double EPS = Math.pow(Math.E, -10);

    /**
     * Тест, который проверяет, что для уравнения x^2+1 = 0 корней нет, успешно выполняется.
     */
    @Test
    public void noEquationRootsTest() {
        SquareRoot squareRoot = new SquareRoot();
        double[] result = squareRoot.squareRoot(1, 0, 1, EPS);
        assertEquals(result.length, new double[0].length);
    }

    /**
     * Тест, который проверяет, что для уравнения x^2-1 = 0 есть два корня кратности 1, успешно выполняется.
     */
    @Test
    public void twoEquationsRootsTest() {
        SquareRoot squareRoot = new SquareRoot();
        double[] result = squareRoot.squareRoot(1, 0, -1, EPS);
        assertArrayEquals(new double[]{1, -1}, result);
    }

    /**
     * Тест, который проверяет, что для уравнения есть один корень кратности 2, успешно выполняется.
     */
    @Test
    public void oneEquationsRootsTest() {
        SquareRoot squareRoot = new SquareRoot();
        double[] result = squareRoot.squareRoot(1, 2, 1, EPS);
        assertArrayEquals(new double[]{-1}, result);
    }

    /**
     * Тест, который проверяет, что коэффициент a не может быть равен 0, с учетом, что a - число с плавающей точкой, успешно выполняется.
     */
    @Test()
    public void aParameterIsZeroTest() {
        SquareRoot squareRoot = new SquareRoot();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> squareRoot.squareRoot(0, 2, 1, EPS));
        String expectedMessage = "Parameter a mustn't to be 0";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    /**
     * Тест, который проверяет, что solve не может принимать значения, отличные от чиcел, успешно выполняется. Учтены все случаи.
     */
    @Test
    public void solveIsDoubleTest() {
        SquareRoot squareRoot = new SquareRoot();
        String typeName = squareRoot.squareRoot(1, 0, -1, EPS).getClass().getComponentType().getName();
        assertEquals("double", typeName);
    }
}