package com.company;

import java.util.Random;

public class Main {

    public static void  create(int[][] a, int col, int row, int l, int h) {
        Random rn = new Random();
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                a[i][j] = l + rn.nextInt() % (h - l + 1);
            }
        }
    }

    public static void print(int[][] a, int row, int col ) {
        for (int i = 0; i < row; i++) {
            System.out.print("|");
            for (int j = 0; j < col; j++) {
                System.out.printf("%4d" ,a[i][j]);

            }
            System.out.print( "|");
            System.out.println();
        }
        System.out.println();
    }

    public static void change(int[][] a, int row, int col) {
        int i_max;
        int i_min;
        int tmp;
        for (int j = 1; j <= col; j+=2) {
            i_max = max(a, row, j-1);
            i_min = min(a, row, j);
            tmp = a[i_max][j - 1];
            a[i_max][j - 1] = a[i_min][j];
            a[i_min][j] = tmp;
        }
    }

    public static int max(int[][] a, int row, int j) {
        int i_max = 0;
        int a_max = a[0][j];
        for (int i = 0; i < row; i++) {
            if (a[i][j] > a_max) {
                a_max = a[i][j];
                i_max = i;
            }
        }
        return i_max;
    }

    public static int min(int[][] a, int row, int j) {
        int i_min = 0;
        int a_min = a[0][0];
        for (int i = 0; i < row; i++) {
            if (a[i][j] < a_min) {
                a_min = a[i][j];
                i_min = i;
            }
        }
        return i_min;
    }

    public static void main(String[] args) {
        int k = 4;
        int n = 6;

        int l = -15;
        int h = 15;

        int[][] a = new int[k][n];

        create(a, n, k, l, h);

        print(a, k, n);

        change(a, k, n);

        print(a, k, n);
    }
}
