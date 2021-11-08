/*
Агинский Антон Лаба 2 Задание 29
Упорядочить ее строки по неубыванию их наибольших элементов.

Тест:
n = 5
n = 4

7 4 9 7
6 8 6 2
9 4 2 5
3 9 8 3
0 5 3 7

Упорядоченная матрица:

0 5 3 7
6 8 6 2
7 4 9 7
9 4 2 5
3 9 8 3

 */

package Lab2_3;

import java.util.Scanner;

public class SolutionLab2_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input n and m");
        int n = in.nextInt();
        int m = in.nextInt();
        ArrayListMatrix matrix = new ArrayListMatrix(n, m);
        System.out.println();

        matrix.random_fill();
        matrix.output();
        System.out.println();

        matrix.solution();
        matrix.output();
    }
}
