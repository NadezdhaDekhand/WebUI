package HomeWork4;


import io.qameta.allure.Epic;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
@Epic("Площадь треугольника")
class TriangleTest {

    @Test

    void test1() {
        double result;
        result = Triangle.getArea(5, 6, 5);
        assertEquals(result, 12);
    }

    @Test
    void test2() {
        double result;
        result = Triangle.getArea(1, 2, 0);
        assertEquals(result, 0);
    }

    @Test
    void test3() {
        double result;
        result = Triangle.getArea(1, 2, 1);
        assertEquals(result, 0);
    }

    @Test
    void test4() {
        double result;
        result = Triangle.getArea(1, 2, -3);
        assertEquals(result, 0);
    }



}
