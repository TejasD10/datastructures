package com.zzz.tutorial.firecode;

import java.util.ArrayList;

public class PrintPaths {
    public static ArrayList<String> printPaths(char[][] board) {
        return printfromIndex(board, 0, 0, "");
    }

    private static ArrayList<String> printfromIndex(char[][] board, int i, int j, String current) {
        ArrayList<String> response = new ArrayList<>();
        if (isOffLimit(board, i, j)) {
            return response;
        }
        if (isAtLimit(board, i, j)) {
            // Reached the end
            current += String.valueOf(board[i][j]);

            response.add(current);
            return response;
        }
        response.addAll(printfromIndex(board, i + 1, j, current + String.valueOf(board[i][j])));
        response.addAll(printfromIndex(board, i, j + 1, current + String.valueOf(board[i][j])));
        return response;
    }

    private static boolean isOffLimit(char[][] board, int i, int j) {
        return (i == board.length || j == board[i].length);
    }

    private static boolean isAtLimit(char[][] board, int i, int j) {
        return (i == board.length - 1 && j == board[i].length - 1);
    }

    public static void main(String[] args) {
//        char[][] board = {{'A','B','C','D'},
//                {'E','F','G','H'},
//                {'I','J','K','L'}};
        char [][] board = {{'A','B','C'},
                {'D','E','F'}};
        System.out.println(printPaths(board));
    }
}
