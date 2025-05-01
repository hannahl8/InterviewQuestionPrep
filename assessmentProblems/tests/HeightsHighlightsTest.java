package assessmentProblems.tests;

import assessmentProblems.code.HeightsHighlights;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HeightsHighlightsTest {

    private final int[] heights = {2, 7, 8, 5, 1, 6, 3, 9, 4};

    private final int[] ascendingHeights = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    private final int[] descendingHeights = {9, 8, 7, 6, 5, 4, 3, 2, 1};

    private final int[] randomHeights = {5, 3, 8, 6, 2, 7, 4, 1, 9};

    @Test
    public void testHeightsHighlights() {
        int[] expected = {6, 8, 7, 5, 2, 9, 4, 3, 1};
        int[] actual = HeightsHighlights.heightsHighlights(heights);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testAscendingHighlights() {
        int[] expected = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] actual = HeightsHighlights.heightsHighlights(ascendingHeights);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testDescendingHighlights() {
        int[] actual = HeightsHighlights.heightsHighlights(descendingHeights);
        assertArrayEquals(descendingHeights, actual);
    }

    @Test
    public void testEmptyArray() {
        int[] empty = {};
        int[] actual = HeightsHighlights.heightsHighlights(empty);
        assertArrayEquals(empty, actual);
    }

    @Test
    public void testRandomHeights() {
        int[] expected = {5, 7, 4, 8, 6, 3, 2, 9, 1};
        int[] actual = HeightsHighlights.heightsHighlights(randomHeights);
        assertArrayEquals(expected, actual);
    }

}