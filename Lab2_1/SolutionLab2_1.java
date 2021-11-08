/*
Агинский Антон Лаба 2 Задание 1
1)Поменять местами строку, содержащую элемент с наибольшим значением в матрице со строкой,
  содержащей элемент с наименьшим значением. Вывести на экран получен¬ную матрицу.
2)Для каждой строки с нулевым элементом на главной диагонали
  вывести ее номер и значение наибольшего из элементов этой строки.

Примечания: Матрица вводится два раза потому что для решения
второго пункта нужна квадратная матрица.

Тест:
1)
n = 4
m = 3

2 3 1
2 9 4
6 6 8
2 7 3

Полученная матрица:

2 9 4
2 3 1
6 6 8
2 7 3

2)
n = m = 3

2 6 7
4 0 3
6 0 5

The maximum in the row number 2 is 4

*/


package Lab2_1;

import java.util.Scanner;

public class SolutionLab2_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input n and m");
        int n = in.nextInt();
        int m = in.nextInt();
        Matrix matr1 = new Matrix(n,m);
        System.out.println();

        matr1.random_fill();
        matr1.output();
        System.out.println();

        int row_max = matr1.max_row();
        int row_min = matr1.min_row();
        matr1.switch_rows(row_max, row_min);
        matr1.output();
        System.out.println();

        System.out.println("Input n");
        int a = in.nextInt();
        Matrix matr2 = new Matrix(a,a);
        matr2.random_fill();
        System.out.println();
        matr2.output();
        System.out.println();

        matr2.diagonal_nules();
    }
}
