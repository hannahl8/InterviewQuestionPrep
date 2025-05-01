package assessmentProblems.tests;

import assessmentProblems.code.TwoPower;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TwoPowerTest {
    private final int[] numbers = {1, -1, 2, 3};
    private final int[] numbers2 = {2};
    private final int[] numbers3 = {-2, -1, 0, 1, 2};

    @Test
    public void testSolution() {
        assertEquals(5, TwoPower.solution(numbers));
        assertEquals(1, TwoPower.solution(numbers2));
        assertEquals(5, TwoPower.solution(numbers3));
    }

    @Test
    public void testMySolution() {
        assertEquals(5, TwoPower.mySolution(numbers));
        assertEquals(1, TwoPower.mySolution(numbers2));
        assertEquals(5, TwoPower.mySolution(numbers3));
    }

}