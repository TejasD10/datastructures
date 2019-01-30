package com.zzz.tutorial.firecode;

public class RotateMatrixCCW {
    public static void rotateSquareImageCCW(int[][] matrix) {
        // Assuming the matrix is square
        assert (isSquare(matrix)) : "Not a square matrix";
        int first, last, temp, offset = 0;
        // Rotate the matrix layer wise
        for (int layer = 0; layer < matrix.length / 2; layer++) {
            first = layer;
            last = matrix.length - 1 - first;
            for (int i = first; i < last; i++) {
                // Pick the first corner
                temp = matrix[first][first + offset];
                matrix[first][first + offset] = matrix[first + offset][last];
                matrix[first + offset][last] = matrix[last][last - offset];
                matrix[last][last - offset] = matrix[last - offset][first];
                matrix[last - offset][first] = temp;
                offset++;
            }
        }
    }

    private static boolean isSquare(int[][] matrix) {
        return (matrix.length == matrix[0].length);
    }
}
