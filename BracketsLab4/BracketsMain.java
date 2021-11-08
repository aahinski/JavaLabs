/*
Агинский Антон 8 группа
Лаба 4 Скобки

В текстовом файле input.txt в записаны строки, в которых есть скобки.
Удалить в каждой строке текст в одинарных скобках и эти скобки.
Если есть вложенность, текст не изменять. Использовать  String,  StringBuffer и StringTokenizer.

Тест:

Файл:
a ( b ( c ) d ) e ( f )
(a b) c (d e) f
(a (b (c)))

Вывод:
a ( c ) e
 c  f
(b (c))

 */

package BracketsLab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BracketsMain {
    public static void main(String[] args) {
        File file = new File("Скобки.txt");
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                StringBuilder str = new StringBuilder(sc.nextLine());
                ArrayList<String> bracketsStrings =
                        new ArrayList<String>(BracketsFunctions.firstBracketsStringsSelection(str));
                System.out.println(BracketsFunctions.secondBracketsStringsSelection(str, bracketsStrings));
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
