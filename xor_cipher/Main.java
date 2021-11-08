//Агинский Антон 8 группа 6 лаба
//Доп.задание

//Разработать программу для шифрования файла путем выполнения операции “исключающее или”
// с 16 битным ключом. Использовать только байтовые потоки.

//Класс с функциями шифрования и дешифрования в отдельном файле.

package xor_cipher;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        XOR_Cipher.encrypteFile("data.txt", "1010110001011100");
        XOR_Cipher.decrypteFile("encryptedData.txt", "1010110001011100");
    }
}
