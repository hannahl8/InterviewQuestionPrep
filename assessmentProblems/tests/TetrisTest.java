package assessmentProblems.tests;

import assessmentProblems.code.Tetris;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TetrisTest {
    int[][] field = {
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {1, 1, 0, 1, 0},
            {1, 0, 1, 0, 1}
    };
    int[][] figure = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 0, 1}
    };

    int[][] field2 = {
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0},
            {1, 1, 0, 0, 0, 1},
            {1, 1, 0, 0, 0, 1},
            {1, 1, 1, 0, 1, 1}
    };
    int[][] figure2 = {
            {1, 1, 1},
            {0, 1, 1},
            {0, 1, 0}
    };

    int[][] field3 = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0},
            {1, 0, 0},
            {1, 1, 0},
    };

    int[][] figure3 = {
            {0, 0, 1},
            {0, 1, 1},
            {0, 0, 1}
    };

    @Test
    public void testCanPlaceFigure() {
        assertEquals(2, Tetris.solution(field, figure));
        assertEquals(2, Tetris.solution(field2, figure2));
        assertEquals(0, Tetris.solution(field3, figure3));
    }
}