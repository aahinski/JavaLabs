package Lab2_1;

import java.util.Random;

public class Matrix {
    private final int rows;
    private final int columns;
    private final int[][] M;

    public Matrix(int a, int b) {
        rows = a;
        columns = b;
        M = new int[a][b];
    }

    public int min_row() {
        int min = M[0][0];
        int row_min = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (M[i][j] < min) {
                    min = M[i][j];
                    row_min = i;
                }
            }
        }
        return row_min;
    }

    public int max_row() {
        int max = M[0][0];
        int row_max = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (M[i][j] > max) {
                    max = M[i][j];
                    row_max = i;
                }
            }
        }
        return row_max;
    }

    public void switch_rows(int a, int b) {
        int tmp;
        for (int i = 0; i < columns; i++) {
            tmp = M[a][i];
            M[a][i] = M[b][i];
            M[b][i] = tmp;
        }
    }

    public void output() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(M[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void random_fill() {
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                M[i][j] = random.nextInt(10);
            }
        }
    }

    public void diagonal_nules()
    {
        int max;
        int tmp = 0;
        if(rows != columns) {
            System.out.println("ERROR. Columns and rows must be equal" +
                    " to find nules on the main diagonal");
        }
        for (int i = 0; i < rows; i++) {
            if (M[i][i] == 0) {
                tmp++;
                max = 0;
                for(int j = 0; j < rows; j++) {
                    if(M[i][j] > max)
                    {
                        max = M[i][j];
                    }
                }
                System.out.println("The maximum in the row number " + (i+1) + " is " + max);
            }
        }
        if(tmp == 0) {
            System.out.print("There's no nules in this matrix's main diagonal");
        }
        System.out.println();
    }
}
