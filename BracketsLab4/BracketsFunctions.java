package BracketsLab4;


import java.util.ArrayList;

public class BracketsFunctions {
    public static StringBuilder multipleBracketsSolution(String str) {
        String regex1 = "\\(.*?\\(";
        String regex2 = "\\).*?\\)";
        StringBuilder sb = new StringBuilder(str.replaceFirst(regex1, "("));
        str = sb
                .reverse()
                .toString()
                .replaceFirst(regex2, ")");
        StringBuilder sb2 = new StringBuilder(str);
        return sb2.reverse();
    }

    public static ArrayList<String> firstBracketsStringsSelection(StringBuilder str) {
        int i = 0;
        int lCount = 0;
        int rCount = 0;
        int begin = 0;
        ArrayList<String> bracketsStrings = new ArrayList<String>();
        while(i < str.length()) {
            if(str.charAt(i) == '(') {
                if(lCount == 0)
                    begin = i;
                lCount++;
            }
            if(str.charAt(i) == ')') {
                rCount++;
                if(lCount == rCount) {
                    bracketsStrings.add(str.substring(begin + 1, i));
                    lCount = rCount = 0;
                }
            }
            i++;
        }
        return bracketsStrings;
    }

    public static StringBuilder
    secondBracketsStringsSelection(StringBuilder str, ArrayList<String> bracketsStrings) {
        int i = 0;
        int lCount = 0;
        int rCount = 0;
        int begin = 0;
        ArrayList<String> tmpBracketsStrings = new ArrayList<String>();
        for(int j = 0; j < bracketsStrings.size(); j++) {
            while(i < bracketsStrings.get(j).length()) {
                if(bracketsStrings.get(j).charAt(i) == '(') {
                    if(lCount == 0)
                        begin = i;
                    lCount++;
                }
                if(bracketsStrings.get(j).charAt(i) == ')') {
                    rCount++;
                    if(lCount == rCount) {
                        tmpBracketsStrings.add(bracketsStrings.get(j).substring(begin, i + 1));
                        lCount = rCount = 0;
                    }
                }
                i++;
            }
            if(tmpBracketsStrings.size() != 1) {
                str = new StringBuilder(str.toString().replace(
                        '(' + bracketsStrings.get(j) + ')', ""));
            }
            else {
                str = new StringBuilder(str.toString().replace('(' + bracketsStrings.get(j) + ')',
                        BracketsFunctions.multipleBracketsSolution('(' + bracketsStrings.get(j) + ')')));
            }
            tmpBracketsStrings.clear();
        }
        return str;
    }

}
