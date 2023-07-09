package org.example;

import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        String[] myArray = {"Воша шила саван на вас а лиша шов", "мама", "абраккддабра", "ффббввррррбббб", "П'ять курей випікають пиріжки"};
        HashSet<Character> uniqueSymbols = findLines(myArray);
        System.out.println(uniqueSymbols);
    }

    public static HashSet<Character> findLines(String[] strArray) {
        int countEvenLines = 0;
        HashSet<Character> uniqueSymbols = new HashSet<>();
        for (int i = 0; i < strArray.length; i++) {
            HashMap<Character, Integer> charCount = new HashMap<>();
            String line = strArray[i];
            for (int j = 0; j < line.length(); j++) {
                char ch = line.charAt(j);
                if (charCount.containsKey(ch))
                    charCount.put(ch, charCount.get(ch) + 1);
                else
                    charCount.put(ch, 1);
            }
            boolean isItEven = false;
            for (int count : charCount.values()) {
                isItEven = count % 2 == 0;
                if (!isItEven) break;
            }
            if (isItEven && countEvenLines < 2) {
                for (char ch : line.toCharArray()) {
                    if (!uniqueSymbols.contains(ch)) {
                        uniqueSymbols.add(ch);
                    }
                }
                countEvenLines++;
            }
        }
        return uniqueSymbols;
    }
}
