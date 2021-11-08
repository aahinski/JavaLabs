/*

Агинский Антон 8 группа
Лаба 4 Регулярные выражения

Тесты:

3
3) Введите URL адрес
http://tut.by
Это URL адрес

6
6) Введите e-mail
ahinski.inc@gmail.com
Это e-mail

9
9) Введите шестизначное число
2716480194
Это не шестизначное число

8
8) Введите пароль
Wh1te_Red_Wh1te
Хороший пароль
*/

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(
                "Введите 1, если хотите проверить, является ли строка GUID\n" +
                "Введите 2, если хотите проверить, является ли строка MAC-адресом\n" +
                "Введите 3, если хотите проверить, является ли строка URL-адресом\n" +
                "Введите 4, если хотите проверить, является ли строка цветом HTML\n" +
                "Введите 5, если хотите проверить, является ли строка датой\n" +
                "Введите 6, если хотите проверить, является ли строка эмейлом\n" +
                "Введите 7, если хотите проверить, является ли строка IP-адресом\n" +
                "Введите 8, если хотите проверить, является ли строка хорошим паролем\n" +
                "Введите 9, если хотите проверить, является ли строка шестизначным числом"
        );
        int caseNumber = in.nextInt();
        switch(caseNumber) {
            case 1:
                Scanner in1 = new Scanner(System.in);
                System.out.println("1) Введите GUID");
                String str1 = in1.nextLine();
                Pattern pattern1 = Pattern.compile(
                    "^(([[0-9][a-f]]+-)*[[0-9][a-f]]+)|(\\{([[0-9][a-f]]+-)*[[0-9][a-f]]+})$"
                    , Pattern.CASE_INSENSITIVE);
                Matcher matcher1 = pattern1.matcher(str1);
                if (matcher1.find()) {
                    System.out.println("Это GUID");
                } else {
                    System.out.println("Это не GUID");
                }
                break;

            case 2:
                Scanner in2 = new Scanner(System.in);
                System.out.println("2) Введите MAC адрес");
                String str2 = in2.nextLine();
                Pattern pattern2 = Pattern.compile("^([[0-9][a-f]]{2}:){5}([[0-9][a-f]]){2}$", Pattern.CASE_INSENSITIVE);
                Matcher matcher2 = pattern2.matcher(str2);
                if (matcher2.find()) {
                    System.out.println("Это MAC адрес");
                } else {
                    System.out.println("Это не MAC адрес");
                }
                break;

            case 3:
                Scanner in3 = new Scanner(System.in);
                System.out.println("3) Введите URL адрес");
                String str3 = in3.nextLine();
                Pattern pattern3 = Pattern.compile(
                    "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]$"
                    , Pattern.CASE_INSENSITIVE);
                Matcher matcher3 = pattern3.matcher(str3);
                if (matcher3.find()) {
                    System.out.println("Это URL адрес");
                } else {
                    System.out.println("Это не URL адрес");
                }
                break;

            case 4:
                Scanner in4 = new Scanner(System.in);
                System.out.println("4) Введите код цвета в шестнадцатиричном формате");
                String str4 = in4.nextLine();
                Pattern pattern4 = Pattern.compile("^#[0-9a-fA-F]{6}$");
                Matcher matcher4 = pattern4.matcher(str4);
                if (matcher4.find()) {
                    System.out.println("Это цвет");
                } else {
                    System.out.println("Это не цвет");
                }
                break;

            case 5:
                Scanner in5 = new Scanner(System.in);
                System.out.println("5) Введите дату в форматке dd/mm/yyyy");
                String str5 = in5.nextLine();
                Pattern pattern5 = Pattern.compile(
                    "^((([12][0-9]|3[01]|[0-9])/(1|3|5|7|8|(10)|(12)))|(([12][0-9]|30|[0-9])"
                            + "/(4|6|9|(11)))|((1[0-9]|2[0-8]|[0-9])/(2)))/[0-9]{4}$",
                    Pattern.CASE_INSENSITIVE);
                Matcher matcher5 = pattern5.matcher(str5);
                if (matcher5.find()) {
                    System.out.println("Это дата");
                } else {
                    System.out.println("Это не дата");
                }
                break;

            case 6:
                Scanner in6 = new Scanner(System.in);
                System.out.println("6) Введите e-mail");
                String str6 = in6.nextLine();
                Pattern pattern6 = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$"
                    , Pattern.CASE_INSENSITIVE);
                Matcher matcher6 = pattern6.matcher(str6);
                if (matcher6.find()) {
                    System.out.println("Это e-mail");
                } else {
                    System.out.println("Это не e-mail");
                }
                break;

            case 7:
                Scanner in7 = new Scanner(System.in);
                System.out.println("7) Введите IP-адрес");
                String str7 = in7.nextLine();
                Pattern pattern7 = Pattern.compile(
                    "(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}"
                            + "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])"
                    , Pattern.CASE_INSENSITIVE);
                Matcher matcher7 = pattern7.matcher(str7);
                if (matcher7.find()) {
                    System.out.println("Это IP-адрес");
                } else {
                    System.out.println("Это не IP-адрес");
                }
                break;

            case 8:
                Scanner in8 = new Scanner(System.in);
                System.out.println("8) Введите пароль");
                String str8 = in8.nextLine();
                Pattern pattern8 = Pattern.compile("[(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(*_)]{8,}");
                Matcher matcher8 = pattern8.matcher(str8);
                if (matcher8.find()) {
                    System.out.println("Хороший пароль");
                } else {
                    System.out.println("Плохой пароль");
                }
                break;

            case 9:
                Scanner in9 = new Scanner(System.in);
                System.out.println("9) Введите шестизначное число");
                String str9 = in9.nextLine();
                Pattern pattern9 = Pattern.compile("^[1-9][0-9]{5}$");
                Matcher matcher9 = pattern9.matcher(str9);
                if (matcher9.find()) {
                    System.out.println("Это шестизначное число");
                } else {
                    System.out.println("Это не шестизначное число");
                }
                break;

            default:
                System.out.println("Введите правильное число");
                break;
        }
    }
}