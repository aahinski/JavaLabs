package MatrixLab4;

import java.util.Random;
public class Matrix {
    private final int rows;
    private final int columns;
    private final int[][] M;

    public Matrix(int _rows, int _columns) {
        rows = _rows;
        columns = _columns;
        M = new int[_rows][_columns];
    }

    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(M[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void setRandom() {
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                M[i][j] = random.nextInt(10);
            }
        }
    }

    public int getMinRow(int _column) {
        int min = M[0][_column];
        int minRow = 0;
        for (int i = 0; i < rows; i++) {
            if (M[i][_column] < min) {
                min = M[i][_column];
                minRow = i;
            }
        }
        return minRow + 1;
    }

    public int getMaxRow(int _column) {
        int max = M[0][_column];
        int maxRow = 0;
        for (int i = 0; i < rows; i++) {
            if (M[i][_column] > max) {
                max = M[i][_column];
                maxRow = i;
            }
        }
        return maxRow + 1;
    }

    public void swapRows(int row1, int row2) {
        int tmp;
        for (int i = 0; i < columns; i++) {
            tmp = M[row1][i];
            M[row1][i] = M[row2][i];
            M[row2][i] = tmp;
        }
    }

    public static void printMinItems(Matrix[] matrixArray, int _column) {
        for (int i = 0; i < matrixArray.length; i++) {
            System.out.println("Строка, в которой находится наименьший элемент " + (_column + 1)
                    + " столбца " + (i + 1) + " матрицы массива - " + matrixArray[i].getMinRow(_column));
        }
    }
}