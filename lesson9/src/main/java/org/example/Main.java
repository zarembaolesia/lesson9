package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String[] myArray = {"Воша шила саван на вас а лиша шов", "мама", "абраккддабра", "ффббввррррбббб", "П'ять курей випікають пиріжки"};
        ArrayList<Character> uniqueSymbols = findLines(myArray);
        System.out.println(uniqueSymbols);
    }

    public static ArrayList<Character> findLines(String[] strArray) {
        int countEvenLines = 0;
        HashMap<Character, Integer> printedSymbols = new HashMap<>();
        ArrayList<Character> uniqueSymbols = new ArrayList<>();
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
            boolean isItEven = true;
            for (int count : charCount.values()) {
                if (count % 2 != 0) {
                    isItEven = false;
                }
            }
            if (isItEven && countEvenLines < 2) {
                for (char ch : line.toCharArray()) {
                    if (!printedSymbols.containsKey(ch)) {
                        uniqueSymbols.add(ch);
                        printedSymbols.put(ch, 1);
                    }
                }
                countEvenLines++;
            }
        }
        return uniqueSymbols;
    }
}
