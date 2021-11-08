package Lab3_1;

import java.util.*;

public class FunctionsLab3_1 {
    public static void solution(String line) {
        ArrayList<String> criteriaWords = new ArrayList<>();
        String[] words = line.split("[!.?:;, ]");
        int criteriaWordsMaxLength = words[0].length();
        for (int i = 0; i < words.length;) {
            if(words[i].length() < criteriaWordsMaxLength) {
                if(i < (words.length - 1))
                    i++;
                else break;
            }
            char[] letters = words[i].toCharArray();
            int characterCode = (int)letters[0];
            for(int j = 1; j < (words[i].length() + 1); j++) {
                if(j == words[i].length()) {
                    if(words[i].length() == criteriaWordsMaxLength)
                        criteriaWords.add(words[i]);
                    if(words[i].length() > criteriaWordsMaxLength) {
                        criteriaWords.clear();
                        criteriaWords.add(words[i]);
                    }
                    break;
                }
                if ((int)letters[j] > characterCode)
                    characterCode = (int)letters[j];
                else break;
            }
            i++;
        }
        for (String criteriaWord : criteriaWords)
            System.out.println(criteriaWord);
    }
}