package xor_cipher;

import java.io.*;
import java.util.Vector;

public class XOR_Cipher {
    public static void encrypteFile(String txt, String key) throws FileNotFoundException, IOException {
        String keyBase2 = new String(key);
        int keyBase10 = Integer.parseInt(keyBase2, 2);
        Vector<Integer> vectorOfHTMLcodes = new Vector<>();
        Vector<Integer> vectorOfEncryptedSymbols = new Vector<>();
        int b = 0;
        FileInputStream input = null;

        File file = new File(txt);
        try {
            input = new FileInputStream(file);
            while ((b = input.read()) != -1) {
                vectorOfHTMLcodes.add((int)(char)b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Integer HTMLcode : vectorOfHTMLcodes) {
            vectorOfEncryptedSymbols.add((HTMLcode ^ keyBase10));
        }

        try (FileOutputStream fout = new FileOutputStream("encryptedData.txt")) {
            for (Integer encryptedSymbol : vectorOfEncryptedSymbols) {
                byte[] bytes = Integer.toBinaryString(encryptedSymbol).getBytes();
                fout.write(bytes);
            }
        }
    }

    public static void decrypteFile(String txt, String key) throws FileNotFoundException, IOException {
        String keyBase2 = new String(key);
        int keyBase10 = Integer.parseInt(keyBase2, 2);
        Vector<StringBuilder> vectorOfEncryptedSymbols = new Vector<>();
        Vector<Integer> vectorOfHTMLcodes = new Vector<>();
        int b = 0;
        FileInputStream input = null;
        StringBuilder sb = new StringBuilder("");

        int count = 0;
        File file = new File(txt);
        try {
            input = new FileInputStream(file);
            while ((b = input.read()) != -1) {
                sb.append((char) b);
                count++;
                if (count == 16) {
                    vectorOfEncryptedSymbols.add(sb);
                    count = 0;
                    sb = new StringBuilder("");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (StringBuilder encryptedSymbol : vectorOfEncryptedSymbols) {
            int encryptedBase10 = Integer.parseInt(encryptedSymbol.toString(), 2);
            vectorOfHTMLcodes.add((int) (encryptedBase10 ^ keyBase10));
        }

        try (FileOutputStream fout = new FileOutputStream("decryptedData.txt")) {
            for (Integer HTMLcode : vectorOfHTMLcodes) {
                fout.write((byte)((char)(HTMLcode.intValue())));
            }
        }
    }
}