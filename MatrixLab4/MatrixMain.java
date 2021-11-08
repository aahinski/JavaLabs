/*
Агинский Антон 8 группа
Лаба 4 Матрицы

Разработать проект для использования класса Matrix.
Поменять  в к-том столбце матрицы строки с мах и мин элементами.
Вывести на экран исходную и полученную матрицы.
Создать  массив объектов матриц для обработки
Основные методы класса:
    public Matrix(int _rows, int _columns)
    public void print()
    public void setRandom(int n){
    public int getMaxRow( int k
    public int getMinRow(int k
    public void swapRows(int row1, int row2
    public void printMinItems

Класс находится в отдельном файле.

printMinItems() выводит строки, в которых находятся
минимальные элементы указанного столбца во всех матрицах массива

Тест:
Введите размер матрицы
3
3
1 0 0
7 5 2
6 3 0
Введите номер столбца, где вы хотите найти минимальный и максимальный элементы
2
Строка с минимальным элементом столбца: 1, строка с максимальным элементом столбца: 2
7 5 2
1 0 0
6 3 0

Создан массив из 3 матриц размера, который вы ввели.Будет выведены строки, в которых находятся минимальные элементы каждой матрицы в том столбце, который вы указали.
7 4 4
7 3 4
3 4 2

0 7 4
3 2 5
1 9 4

8 5 4
9 9 3
3 2 0

Строка, в которой находится наименьший элемент 2 столбца 1матрицы массива - 2
Строка, в которой находится наименьший элемент 2 столбца 2матрицы массива - 2
Строка, в которой находится наименьший элемент 2 столбца 3матрицы массива - 3

 */

package MatrixLab4;

import java.util.Scanner;

public class MatrixMain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите размер матрицы");
        int _rows = in.nextInt();
        int _columns = in.nextInt();
        Matrix M = new Matrix(_columns, _rows);
        M.setRandom();
        M.print();
        System.out.println("Введите номер столбца, где вы хотите найти минимальный и максимальный элементы");
        int min_column = in.nextInt() - 1;
        System.out.println("Строка с минимальным элементом столбца: " + M.getMinRow(min_column) +
                ", строка с максимальным элементом столбца: " + M.getMaxRow(min_column));
        M.swapRows(M.getMaxRow(min_column) - 1, M.getMinRow(min_column) - 1);
        M.print();
        System.out.println();
        System.out.println("Создан массив из 3 матриц размера, который вы ввели." +
                "Будет выведены строки, в которых находятся минимальные элементы " +
                "каждой матрицы в том столбце, " + "который вы указали.");
        Matrix [] matrixArray = new Matrix[3];
        for (int i = 0; i < matrixArray.length; i++) {
            matrixArray[i] = new Matrix(_columns, _rows);
            matrixArray[i].setRandom();
            matrixArray[i].print();
            System.out.println();
        }
        Matrix.printMinItems(matrixArray, min_column);
    }
}
