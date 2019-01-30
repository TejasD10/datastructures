package com.zzz.tutorial.firecode;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RotateMatrixCWTest {
    @Test
    public void test_matrix_rotation_ccw() {
        int[][] inputMatrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] outputMatrix = {{3, 6, 9}, {2, 5, 8}, {1, 4, 7}};

        RotateMatrixCCW.rotateSquareImageCCW(inputMatrix);
        assertThat(outputMatrix).hasSameElementsAs(Arrays.asList(inputMatrix));
    }

    @Test
    public void test_non_square_matrix_rotation() {
        RotateMatrixCCW.rotateSquareImageCCW(new int[][]{{1, 2}, {3, 4}, {5, 6}});
    }
}
