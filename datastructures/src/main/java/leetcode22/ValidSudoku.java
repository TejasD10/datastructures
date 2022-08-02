package leetcode22;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku {
    /*
    Given a sudoku puzzle, determine if it is valid in its current state
     */
    public boolean isValidSudoku(char[][] board) {
        // hashmap to store the values seen in the row, col and 9x9 sub-matrix
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<SquareValue, Set<Character>> square = new HashMap<>();

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                // continue in case of empty value
                char value = board[row][col];
                if (value == '.') continue;
                SquareValue squareVal = new SquareValue(row / 3, col / 3);
                // Initialize if empty
                rows.putIfAbsent(row, new HashSet<>());
                cols.putIfAbsent(col, new HashSet<>());
                square.putIfAbsent(squareVal, new HashSet<>());
                if (!rows.get(row).add(value) ||
                        !cols.get(col).add(value) ||
                        !square.get(squareVal).add(value)) return false;
            }
        }
        return true;
    }

    record SquareValue(int row, int col) {
    }

    public boolean isValidSudokuSmart(char[][] board) {
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                char number = board[i][j];
                if (number != '.')
                    if (!seen.add(number + " in row " + i) ||
                            !seen.add(number + " in col " + j) ||
                            !seen.add(number + " in square " + i / 3 + "-" + j / 3))
                        return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] validMatrix = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        char[][] invalidMatrix = {{'8', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
//        System.out.println(new ValidSudoku().isValidSudoku(validMatrix));
        System.out.println(new ValidSudoku().isValidSudokuSmart(invalidMatrix));
    }
}

