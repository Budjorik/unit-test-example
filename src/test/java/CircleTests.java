import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CircleTests {
    private static long suiteStartTime;
    private long testStartTime;
    Circle sut;

    @BeforeAll
    public static void initSuite() {
        suiteStartTime = System.nanoTime();
        System.out.println("suite of tests started");
    }

    @AfterAll
    public static void finalizeSuite() {
        System.out.println("suite of tests complete: " + (System.nanoTime() - suiteStartTime));
    }

    @BeforeEach
    public void initTest() {
        sut = new Circle();
        testStartTime = System.nanoTime();
        System.out.println("test started");
    }

    @AfterEach
    public void finalizeTest() {
        System.out.println("test complete: " + (System.nanoTime() - testStartTime));
    }

    @Test
    // Тест метода определения площади окружности
    public void testCalculateAreaOfCircle() {
        // arrange
        double radius = 5.0;
        double expected = 78.54;

        // act
        double result = sut.calculateAreaOfCircle(radius);

        // assert
        assertEquals(expected, result);
    }

    @Test
    // Тест метода определения длины окружности
    public void testCalculateLengthOfCircle() {
        // arrange
        double radius = 7.0;
        double expected = 43.99;

        // act
        double result = sut.calculateLengthOfCircle(radius);

        // assert
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("sourceOne")
    // Тест метода определения радиуса вписанной в квадрат окружности
    public void testCalculateRadiusOfInnerCircle(double sideOfExternalSquare, double expected) {
        // act
        double result = sut.calculateRadiusOfInnerCircle(sideOfExternalSquare);

        // assert
        assertEquals(expected, result);
    }

    private static Stream<Arguments> sourceOne() {
        return Stream.of(Arguments.of(6.0, 3.00),
                Arguments.of(9.0, 4.50));
    }

    @ParameterizedTest
    @MethodSource("sourceTwo")
    // Тест метода определения радиуса описанной около квадрата окружности
    public void testCalculateRadiusOfExternalCircle(double sideOfInnerSquare, double expected) {
        // act
        double result = sut.calculateRadiusOfExternalCircle(sideOfInnerSquare);

        // assert
        assertEquals(expected, result);
    }

    private static Stream<Arguments> sourceTwo() {
        return Stream.of(Arguments.of(10.0, 7.08),
                Arguments.of(13.0, 9.20));
    }

}
