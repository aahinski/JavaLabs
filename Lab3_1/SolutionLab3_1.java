/*
Агинский Антон Лаба 31 Задание 1

1.	Строка состоит из слов. За один просмотр символов строки найти все самые длинные слова,
символы в которых идут в строгом возрастании кодов, и занести их в новую строку.
Слова в исходной строке разделяются некоторым множеством разделителей.
Слова в новой строке должны разделяться ровно одним пробелом.

Тест:

Входные данные:
abcdef abcd kslfasdfka

Результат:
abcdef

*/

package Lab3_1;

import java.util.Scanner;

public class SolutionLab3_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        FunctionsLab3_1.solution(line);
    }
}

