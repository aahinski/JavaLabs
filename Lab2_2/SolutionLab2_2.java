/*

Агинский Антон Лаба 2 Задание 15

Для заданной целочисленной матрицы найти максимум среди сумм элементов
диагоналей, параллельных главной диагонали матрицы.

Тест:

n = 4

2 4 2 4
7 6 9 5
0 2 8 7
8 9 3 3

The maximum sum on the diagonals is 20

 */




package Lab2_2;

import java.util.Scanner;

public class SolutionLab2_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input n");
        int n = in.nextInt();
        VectorMatrix matrix = new VectorMatrix(n, n);
        System.out.println();

        matrix.random_fill();
        matrix.output();
        System.out.println();

        System.out.println("The maximum sum on the diagonals is " + matrix.diagonal_sums());
    }
}
