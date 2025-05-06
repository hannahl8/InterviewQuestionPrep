package codeSignalLearning;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StandardMathAlgorithmsTest {

    StandardMathAlgorithms solution = new StandardMathAlgorithms();

    @Test
    public void testIsPerfectSquare() {
        assertFalse(solution.isPerfectSquare(2));
        assertTrue(solution.isPerfectSquare(16));
        assertTrue(solution.isPerfectSquare(144));
        assertTrue(solution.isPerfectSquare(1521));
        assertFalse(solution.isPerfectSquare(1458));
        assertTrue(solution.isPerfectSquare(9801));
        assertTrue(solution.isPerfectSquare(1000000000000L));
        assertFalse(solution.isPerfectSquare(99999998320036L));
    }

    @Test
    public void testNextPrime() {
        assertEquals(11, solution.nextPrime(7));
        assertEquals(59, solution.nextPrime(57));
        assertEquals(31, solution.nextPrime(29));
        assertEquals(3, solution.nextPrime(2));
        assertEquals(101, solution.nextPrime(97));
        assertEquals(1000003, solution.nextPrime(999983));
        assertEquals(2, solution.nextPrime(1));
        assertEquals(1000003, solution.nextPrime(999991));
    }

    @Test
    public void testGetPrimeFactors() {
        assertEquals(Arrays.asList(3, 5), solution.getPrimeFactors(45));
        assertEquals(List.of(2), solution.getPrimeFactors(2));
        assertEquals(Arrays.asList(2, 5), solution.getPrimeFactors(1000000));
        assertEquals(List.of(37), solution.getPrimeFactors(37));
        assertEquals(Arrays.asList(2, 7), solution.getPrimeFactors(56));
        assertEquals(List.of(1223), solution.getPrimeFactors(1223));
        assertEquals(Arrays.asList(59, 97), solution.getPrimeFactors(5723));
        assertEquals(List.of(391939), solution.getPrimeFactors(391939));
        assertEquals(Arrays.asList(2, 3, 5), solution.getPrimeFactors(60));
        assertEquals(Arrays.asList(2, 3), solution.getPrimeFactors(18));
        assertEquals(Arrays.asList(2, 3, 7), solution.getPrimeFactors(84));
        assertEquals(List.of(101), solution.getPrimeFactors(101));
        assertEquals(Arrays.asList(2, 3), solution.getPrimeFactors(144));
        assertEquals(Arrays.asList(2, 3, 5, 7), solution.getPrimeFactors(210));
        assertEquals(List.of(2), solution.getPrimeFactors(65536));
        assertEquals(List.of(999983), solution.getPrimeFactors(999983));
        assertEquals(Arrays.asList(2, 17), solution.getPrimeFactors(8912896));
        assertEquals(Arrays.asList(3, 5, 7, 11, 13), solution.getPrimeFactors(15015));
        assertEquals(Arrays.asList(2, 3, 643), solution.getPrimeFactors(123456));
        assertEquals(Arrays.asList(2, 3, 643), solution.getPrimeFactors(123456));
        assertEquals(Arrays.asList(2, 3, 97, 1697), solution.getPrimeFactors(987654));
    }

    @Test
    public void testAreCoprime() {
        assertTrue(solution.areCoprime(15, 28));
        assertFalse(solution.areCoprime(12, 18));
        assertTrue(solution.areCoprime(1, 1));
        assertFalse(solution.areCoprime(35, 49));
        assertFalse(solution.areCoprime(35, 49));
        assertTrue(solution.areCoprime(8, 25));
        assertTrue(solution.areCoprime(10000, 9999));
        assertTrue(solution.areCoprime(6389, 3762));
        assertTrue(solution.areCoprime(4638, 4799));
        assertTrue(solution.areCoprime(5785, 9186));
        assertTrue(solution.areCoprime(2167, 2183));
        assertFalse(solution.areCoprime(14, 49));
        assertFalse(solution.areCoprime(30, 45));
        assertFalse(solution.areCoprime(22, 77));
        assertFalse(solution.areCoprime(42, 56));
        assertFalse(solution.areCoprime(60, 90));
        assertFalse(solution.areCoprime(17, 51));
    }

    @Test
    public void testNthPrime() {
        assertEquals(2, solution.nthPrime(1));
        assertEquals(5, solution.nthPrime(3));
        assertEquals(13, solution.nthPrime(6));
        assertEquals(29, solution.nthPrime(10));
        assertEquals(71, solution.nthPrime(20));
        assertEquals(229, solution.nthPrime(50));
        assertEquals(349, solution.nthPrime(70));
        assertEquals(541, solution.nthPrime(100));
        assertEquals(3571, solution.nthPrime(500));
        assertEquals(7919, solution.nthPrime(1000));
    }

}