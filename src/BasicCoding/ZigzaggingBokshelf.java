package BasicCoding;

import java.util.ArrayList;

public class ZigzaggingBokshelf {
    public static void main(String[] args) {
        int[][] library = {
                {1, 3, 5, 7},
                {2, 4, 6, 8},
                {9, 11, 13, 15}
        };

        // Starting from the bottom right corner of the bookshelf
        int row = library.length - 1;
        int col = library[0].length - 1;
        boolean goingUp = true;

        ArrayList<Integer> result = new ArrayList<>();

        while (col >= 0) {
            result.add(library[row][col]); // start point (bottom and right corner)
            if (goingUp) {
                if (row == 0) {
                    goingUp = false;
                    col -= 1; // continue go left
                } else {
                    row -= 1; // continue go up
                }
            } else {
                if (row == library.length - 1) {
                    goingUp = true;
                    col -= 1; // continue go left
                } else {
                    row += 1; // continue go down
                }
            }
        }

        System.out.println(result);
    }
}
