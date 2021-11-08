/*
Агинский Антон 8 группа
Лаба 5
Свое решение задачи "Контакты"

а) разработать класс Контакт, определяющий запись в электронной книге мобильного
телефона и содержащий по меньшей мере следующие поля:
- *Наименование (имя человека или организации)
- *Номер телефона мобильного
- Номер телефона рабочего
- Номер телефона (домашнего)
- Адрес электронной почты
- Адрес веб-страницы
- Адрес

Обязательными является поля помеченные *, остальные поля могут быть пустыми

б) класс Контакт должен реализовать:
-интерфейс Comparable и Comparator с возможностью выбора одного из полей для сравнения
-интерфейс Iterator - индексатор по всем полям объекта Контакт
-метод для сохранения значений всех полей в строке текста (переопределить toString())
-конструктор или метод для инициализации объекта из строки текста

в) Для тестирования класса Контакт, создать консольное приложение позволяющее
создать небольшой массив контактов и напечатать отсортированными по
выбранному полю.

Тест:

Sorted by Name :
name='Ann', cellPhone='+375298765432', workPhone='', homePhone='', email='nann@gmail.com', webpage=''
name='Empty', cellPhone='+375449090907', workPhone='', homePhone='', email='', webpage=''
name='Joahn', cellPhone='+375447626615', workPhone='', homePhone='', email='joahn@gmail.com', webpage=''
name='Mary', cellPhone='80297890654', workPhone='', homePhone='', email='', webpage=''
Sorted by CellPhone :
name='Ann', cellPhone='+375298765432', workPhone='', homePhone='', email='nann@gmail.com', webpage=''
name='Joahn', cellPhone='+375447626615', workPhone='', homePhone='', email='joahn@gmail.com', webpage=''
name='Empty', cellPhone='+375449090907', workPhone='', homePhone='', email='', webpage=''
name='Mary', cellPhone='80297890654', workPhone='', homePhone='', email='', webpage=''
Sorted by WorkPhone :
name='Ann', cellPhone='+375298765432', workPhone='', homePhone='', email='nann@gmail.com', webpage=''
name='Joahn', cellPhone='+375447626615', workPhone='', homePhone='', email='joahn@gmail.com', webpage=''
name='Empty', cellPhone='+375449090907', workPhone='', homePhone='', email='', webpage=''
name='Mary', cellPhone='80297890654', workPhone='', homePhone='', email='', webpage=''
Sorted by HomePhone :
name='Ann', cellPhone='+375298765432', workPhone='', homePhone='', email='nann@gmail.com', webpage=''
name='Joahn', cellPhone='+375447626615', workPhone='', homePhone='', email='joahn@gmail.com', webpage=''
name='Empty', cellPhone='+375449090907', workPhone='', homePhone='', email='', webpage=''
name='Mary', cellPhone='80297890654', workPhone='', homePhone='', email='', webpage=''

*/

package ContactsTask;

public class Main {
    public static void main(String[] args) {
        Contacts[] users = new Contacts[4];
        users[0] = new Contacts("Joahn,+375447626615,+375292345678,,joahn@gmail.com,,");
        users[1] = new Contacts("Ann,+375298765432,8765432,,nann@gmail.com");
        users[2] = new Contacts("Mary","80297890654","+375291234567","","","", "");
        users[3] = new Contacts("Empty,+375449090907,");
        Contacts.printSorted(users, 0);
        Contacts.printSorted(users, 1);
        Contacts.printSorted(users, 2);
    }
}
