package assessmentProblems.tests;

import assessmentProblems.code.ArrayTransformation;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayTransformationTest {

    private final int[] a = {4, 0, 1, -2, 3};

    @Test
    public void testArrayTransformation() {
        int[] expected = {4, 5, -1, 2, 1};
        int[] actual = ArrayTransformation.transformArray(a);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testMySolution() {
        int[] expected = {4, 5, -1, 2, 1};
        int[] actual = ArrayTransformation.mySolution(a);
        assertArrayEquals(expected, actual);
    }
}