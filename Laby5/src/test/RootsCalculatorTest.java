package test;

import main.RootsCalculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.*;

class RootsCalculatorTest {
    @Test
    @DisplayName("Delta dodatnia, 2 rozwiazania")
    void test_1() {
        ArrayList<Double> roots = new ArrayList<Double>(RootsCalculator.calculate_roots(1, -5, -6));
        assertEquals(roots.size(), 2);
        assertEquals(roots.get(0), 6.0);
        assertEquals(roots.get(1), -1.0);
    }

    @Test
    @DisplayName("Delta  = 0, 1 rozwiazanie")
    void test_2() {
        ArrayList<Double> roots = new ArrayList<Double>(RootsCalculator.calculate_roots(1, -4, 4));
        assertEquals(roots.size(), 1);
        assertEquals(roots.get(0), 2.0);
    }

    @Test
    @DisplayName("Delta ujemna, nie ma rozwiazan")
    void test_3() {
        ArrayList<Double> roots = new ArrayList<Double>(RootsCalculator.calculate_roots(1, 1, 6));
        assertEquals(roots.size(), 0);
    }

    @Test
    @DisplayName("rownanie liniowe, 1 rozwiazanie")
    void test_4() {
        ArrayList<Double> roots = new ArrayList<Double>(RootsCalculator.calculate_roots(0, 1, 6));
        assertEquals(roots.size(), 1);
        assertEquals(roots.get(0), -6.0);
    }

    @Test
    @DisplayName("funkcja liniowa, nie ma rozwiazan")
    void test_5() {
        ArrayList<Double> roots = new ArrayList<Double>(RootsCalculator.calculate_roots(0, 0, 7));
        assertEquals(roots.size(), 0);
    }

    @Test
    @DisplayName("funkcja zera (rownanie liniowe), nieskonczenie wiele rozwiazan")
    void test_6() {
        ArrayList<Double> roots = new ArrayList<Double>(RootsCalculator.calculate_roots(0, 0, 0));
        assertEquals(roots.size(), 1);
        assertEquals(roots.get(0), Double.POSITIVE_INFINITY);

    }
}