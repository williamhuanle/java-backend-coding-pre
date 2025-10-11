package BasicCoding;

import java.util.ArrayList;
import java.util.List;

public class TraverseVerticalArrays  {

    /**
     * Your task is to create a function that performs a vertical traverse on a 2D matrix (represented as an int[][] array) starting from the bottom right corner. The function should start from the bottom-right cell (the last element of the last row), move vertically upwards to the top (the top row is the row with index 0), then move one column to the left and continue the process until all columns have been traversed. The function should return a list containing the values of the matrix elements in the order they were visited.
     *
     * For example, given the following 3 x 4 matrix:
     *
     * {
     *     {1, 2, 3, 4},
     *     {5, 6, 7, 8},
     *     {9, 10, 11, 12}
     * }
     * The function should return a list with values: [12, 8, 4, 11, 7, 3, 10, 6, 2, 9, 5, 1].
     */

    public static List<Integer> verticalTraverse(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int row = rows-1; // start row
        int col = cols-1; // start col
        List<Integer> result = new ArrayList<>();
        int index = 0;
        while (index < rows * cols) {
            result.add(matrix[row][col]);
            index++;
            if (row == 0) { // going up to top
                col--;
                row = rows-1;
            } else {
                row --;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] data = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        List<Integer> traversal = verticalTraverse(data);
        for (int num : traversal) {
            System.out.print(num + " ");
        }
    }
}
