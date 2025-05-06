package codeSignalLearning;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class ListOperationsTest {
    ListOperations solution = new ListOperations();

    @Test
    public void testSolution() {
        assertEquals(4, solution.solution(Arrays.asList(1, 2, 3, 4, 5), 5));
        assertEquals(0, solution.solution(Arrays.asList(1, 2, 3, 4, 5), 1));
        assertEquals(-1, solution.solution(Arrays.asList(1, 2, 3, 4), 10));
        assertEquals(1, solution.solution(Arrays.asList(1, 2, 3, 4), 2));
        assertEquals(0, solution.solution(List.of(1), 1));
        assertEquals(1, solution.solution(Arrays.asList(1, 2, 2, 2, 2), 2));
        assertEquals(0, solution.solution(Arrays.asList(-1, -2, -3, -4, -5), -1));
        assertEquals(-1, solution.solution(Arrays.asList(-1, -2, -3, -4, -5), -10));

    }

    @Test
    public void testCountUniqueElements() {
        assertEquals(3, solution.countUniqueElements(Arrays.asList(1, 2, 3, 2, 4)));
        assertEquals(0, solution.countUniqueElements(Arrays.asList(1, 1)));
        assertEquals(2, solution.countUniqueElements(Arrays.asList(1, 2)));
        assertEquals(2, solution.countUniqueElements(Arrays.asList(1, 2, 3, 3, 3, 4, 4, 4, 4)));
        assertEquals(0, solution.countUniqueElements(Arrays.asList(1, 1, 1, 2, 2, 2)));
        assertEquals(0, solution.countUniqueElements(Arrays.asList(-1000, -1000, -1000, 1000, 1000, 1000)));
        assertEquals(200, solution.countUniqueElements(java.util.stream.IntStream.rangeClosed(1, 200).boxed().collect(Collectors.toList())));
        assertEquals(2000, solution.countUniqueElements(java.util.stream.IntStream.rangeClosed(-999, 1000).boxed().collect(Collectors.toList())));
        assertEquals(0, solution.countUniqueElements(Arrays.asList(1000, 1000, 1000, 1000, 1000, -1000, -1000, -1000)));
        assertEquals(10, solution.countUniqueElements(Arrays.asList(100, 200, 300, 400, 500, 600, 700, 800, 900, 1000)));
        assertEquals(0, solution.countUniqueElements(List.of()));
    }

    @Test
    public void testReverseList() {
        assertEquals(Arrays.asList(5, 4, 3, 2, 1), solution.reverseList(Arrays.asList(1, 2, 3, 4, 5)));
        assertEquals(List.of(1), solution.reverseList(List.of(1)));
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), solution.reverseList(Arrays.asList(5, 4, 3, 2, 1)));
        assertEquals(Arrays.asList(4, 8, 9, -7), solution.reverseList(Arrays.asList(-7, 9, 8, 4)));
        assertEquals(Arrays.asList(0, -1000, 1000), solution.reverseList(Arrays.asList(1000, -1000, 0)));
        assertEquals(Arrays.asList(0, 0, 0, 0, 0), solution.reverseList(Arrays.asList(0, 0, 0, 0, 0)));
        assertEquals(Arrays.asList(-439438, -123, 913, 2397, 92387, -202, 54398, 323, 3498), solution.reverseList(Arrays.asList(3498, 323, 54398, -202, 92387, 2397, 913, -123, -439438)));
        assertEquals(List.of(), solution.reverseList(List.of()));
        List<Integer> expected = IntStream.rangeClosed(1, 100)
                .boxed()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());

        List<Integer> actual = solution.reverseList(IntStream.rangeClosed(1, 100)
                .boxed()
                .collect(Collectors.toList()));

        assertEquals(expected, actual);
    }


}