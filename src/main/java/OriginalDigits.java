//https://leetcode.com/problems/reconstruct-original-digits-from-english/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class OriginalDigits {


    public static void main(String... args) {

        System.out.println(originalDigits("owoztneoer"));
        System.out.println(originalDigits("fviefuro"));

    }

    public static String originalDigits(String s) {

        ArrayList result = new ArrayList();
        Map<Character, Integer> letters = new TreeMap();

        String[][] numbers = {
                {"z0", "zero"},
                {"w2", "two"},
                {"u4", "four"},
                {"x6", "six"},
                {"s7", "seven"},
                {"g8", "eight"},
                {"o1", "one"},
                {"t3", "three"},
                {"f5", "five"},
                {"n9", "nine"}
        };
        for (Character c : s.toCharArray()) letters.put(c, letters.getOrDefault(c, 0) + 1);

        for (int i = 0; i < numbers.length; i++) {

            char letter = numbers[i][0].charAt(0);
            char number = numbers[i][0].charAt(1);
            String word = numbers[i][1];

            int qtd = letters.getOrDefault(letter, 0);
            if (qtd > 0) {
                for (int j = 0; j < qtd; j++) result.add("" + number);
                for (char c : word.toCharArray()) letters.put(c, letters.getOrDefault(c, 0) - qtd);
            }
        }
        Collections.sort(result);
        return String.join("", result);
    }


}
