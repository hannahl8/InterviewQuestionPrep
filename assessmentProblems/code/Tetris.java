package assessmentProblems.code;
/**
 * Module 3 – Implementation Efficiency
 * <p>
 * Given a game field represented by a {@code height x width} matrix of integers and a figure represented
 * by a {@code 3 x 3} matrix, determine the column index in the game field from which to drop the figure
 * so that at least one fully occupied row is formed after the figure comes to rest.
 * </p>
 *
 * <p>
 * Both {@code field} and {@code figure} contain only {@code 0}s and {@code 1}s, where:
 * <ul>
 *   <li>{@code 1} represents an occupied cell</li>
 *   <li>{@code 0} represents a free cell</li>
 * </ul>
 * </p>
 *
 * <p>
 * You can drop the figure at any column such that the entire {@code 3 x 3} figure matrix fits within
 * the width of the field. The figure falls downward until:
 * <ul>
 *   <li>It reaches the bottom of the field</li>
 *   <li>Or lands on an occupied cell in the field that blocks further descent</li>
 * </ul>
 * </p>
 *
 * <p>
 * After the figure has landed, check if any row in the resulting field is fully occupied
 * (i.e., all cells in that row are {@code 1}). If such a row exists, return the leftmost column index
 * from which the figure can be dropped to produce that result. If there are multiple valid positions,
 * you may return any one of them. If no such position exists, return {@code -1}.
 * </p>
 *
 * <p><b>Note:</b> The figure must be dropped such that its entire {@code 3 x 3} shape fits within the field bounds,
 * even if some parts of the figure matrix are empty (i.e., contain {@code 0}s).</p>
 *
 * <p>Examples:</p>
 *
 * <pre>
 * Example 1:
 * field = [
 *   [0, 0, 0],
 *   [0, 0, 0],
 *   [0, 0, 0],
 *   [1, 0, 0],
 *   [1, 1, 0]
 * ]
 * figure = [
 *   [0, 0, 1],
 *   [0, 1, 1],
 *   [0, 0, 1]
 * ]
 * Output: 0
 * Explanation: Dropping the figure at column index 0 results in two full rows.
 *
 * Example 2:
 * field = [
 *   [0, 0, 0, 0, 0],
 *   [0, 0, 0, 0, 0],
 *   [0, 0, 0, 0, 0],
 *   [1, 1, 0, 1, 0],
 *   [1, 0, 1, 0, 1]
 * ]
 * figure = [
 *   [1, 1, 1],
 *   [1, 0, 1],
 *   [1, 0, 1]
 * ]
 * Output: 2
 * Explanation: Only by dropping the figure at column index 2 is a full row formed.
 * </pre>
 */
public class Tetris {
    /**
     * This method finds the leftmost column index in the game field from which to drop the figure
     * so that at least one fully occupied row is formed after the figure comes to rest.
     *
     * @param field  The game field represented as a 2D array of integers.
     * @param figure The figure represented as a 2D array of integers.
     * @return The leftmost column index from which to drop the figure, or -1 if no such position exists.
     */
    public static int solution(int[][] field, int[][] figure) {
        int height = field.length;
        int width = field[0].length;
        int figureSize = figure.length;

        for (int column = 0; column < width - figureSize + 1; column++) {
            int row = 1;
            while (row < height - figureSize + 1) {
                boolean canFit = true;
                for (int dx = 0; dx < figureSize; dx++) {
                    for (int dy = 0; dy < figureSize; dy++) {
                        if (field[row + dx][column + dy] == 1 && figure[dx][dy] == 1) {
                            canFit = false;
                        }
                    }
                }
                if (!canFit) {
                    break;
                }
                row++;
            }
            row--; // adjust row after overshooting!

            for (int dx = 0; dx < figureSize; dx++) {
                boolean rowFilled = true;
                for (int colIndex = 0; colIndex < width; colIndex++) {
                    if (!(field[row + dx][colIndex] == 1 ||
                            (column <= colIndex && colIndex < column + figureSize
                                    && figure[dx][colIndex - column] == 1))) {
                        rowFilled = false;

                    }
                }
                if (rowFilled) {
                    return column;
                }
            }
        }
        return -1;
    }
}
