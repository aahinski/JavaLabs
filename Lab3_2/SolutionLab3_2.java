/*
Агинский Антон Лаба 32 Задание 1

1.	Строки текстового файла input.txt состоят из слов, разделенных одним или несколькими пробелами.
Перед первым, а также после последнего слова строки пробелы могут отсутствовать.
Требуется определить слово, которое чаще всего встречается в файле.
Результат вывести на консоль в форме, удобной для чтения.

Тест:

Входные данные из файла:

Книга лежит на столе
На кухне есть соль
Соль лежит в ящике
Мама позвала есть

Результат:

The most frequent words are:
лежит
соль
на
есть

 */

package Lab3_2;

import java.io.*;

public class SolutionLab3_2 {
    public static void main(String[] args) {

        StringBuilder str = new StringBuilder();
        try(FileReader reader = new FileReader("D:\\3 сем\\прога\\лаб3\\FileLab3_2.txt"))
        {
            int c;
            while((c=reader.read())!=-1) {
                str.append((char)c);
            }
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }

        FunctionsLab3_2.solution(FunctionsLab3_2.stringBuilderToHashMap(str));
    }
}
