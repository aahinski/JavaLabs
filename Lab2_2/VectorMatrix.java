package Lab2_2;

import java.util.Random;
import java.util.*;

public class VectorMatrix {
    private int rows;
    private int columns;
    private Vector<Vector<Integer>> matrix;
    private Vector<Integer> tmp;

    public VectorMatrix(int a, int b) {
        rows = a;
        columns = b;
    }

    public void random_fill() {
        Random random = new Random();
        matrix = new Vector();
        tmp = new Vector();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                tmp.add(random.nextInt(10));
            }
            matrix.add(tmp);
            tmp = new Vector();
        }
    }

    public void output() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public int diagonal_sums()
    {
        int max = 0;
        int sum = 0;

        int j = 0;
        for(int i = 1;i < rows - 1;i++) {
            int temp = i;
            while(i != rows) {
                sum = matrix.get(i).get(j) + sum;
                if (sum > max)
                    max = sum;
                i++;
                j++;
            }
            i = temp;
            sum = 0;
            j = 0;
        }

        for(int i = 1;i < columns - 1;i++) {
            int temp = i;
            while(i != columns) {
                sum = matrix.get(j).get(i) + sum;
                if (sum > max)
                    max = sum;
                i++;
                j++;
            }
            i = temp;
            sum = 0;
            j = 0;
        }

        return max;
    }

}
