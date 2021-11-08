package Lab3_2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Collections;

public class FunctionsLab3_2 {
    public static Map<String, Integer> stringBuilderToHashMap(StringBuilder str) {
        String[] arr_words = str.toString().toLowerCase().split("\\s+");
        Map<String, Integer> hs_words = new HashMap<String, Integer>();
        for (int i = 0; i < arr_words.length; i++) {
            if (hs_words.containsKey(arr_words[i])) {
                hs_words.put(arr_words[i], hs_words.get(arr_words[i]) + 1);
            } else hs_words.put(arr_words[i], 1);
        }
        return hs_words;
    }

    public static void solution(Map<String, Integer> hs_words) {
        int val = Collections.max(hs_words.values());
        System.out.println("The most frequent words are: ");
        Iterator <Map.Entry< String, Integer >> iterator = hs_words.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry< String, Integer > entry = iterator.next();
            if(entry.getValue() == val) {
                System.out.println(entry.getKey());
            }
        }
    }
}
