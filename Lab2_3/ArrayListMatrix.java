package Lab2_3;

import java.util.Random;
import java.util.*;
import java.util.Collections;
import java.util.Comparator;

public class ArrayListMatrix {
    private int rows;
    private int columns;
    private ArrayList<ArrayList<Integer>> matrix;
    private ArrayList<Integer> tmp;

    public ArrayListMatrix(int a, int b) {
        rows = a;
        columns = b;
    }

    public void random_fill() {
        Random random = new Random();
        matrix = new ArrayList();
        tmp = new ArrayList();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                tmp.add(random.nextInt(10));
            }
            matrix.add(tmp);
            tmp = new ArrayList();
        }
    }

    public void output() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix.get(i).get(j) + " ");
            }
            System.out.println("");
        }
    }

    public void solution()
    {
        Collections.sort(matrix, new Comparator<ArrayList<Integer>>() {
                    @Override
                    public int compare(ArrayList<Integer> first, ArrayList<Integer> second) {
                        return (Collections.max(first) - Collections.max(second));
                    }
                }
        );
    }

}