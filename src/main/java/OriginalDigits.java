//https://leetcode.com/problems/reconstruct-original-digits-from-english/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class OriginalDigits {


    public static void main(String... args) {

        System.out.println(originalDigits3("owoztneoer"));
        System.out.println(originalDigits3("fviefuro"));

    }

    public static String originalDigits3(String s) {
        StringBuilder result = new StringBuilder();

        char[] qtdEachChar = new char[1 + (int) 'z'];
        int[] digits = new int[10];

        for (char c : s.toCharArray()) qtdEachChar[c]++;

        digits[0] = qtdEachChar['z'];
        digits[2] = qtdEachChar['w'];
        digits[4] = qtdEachChar['u'];
        digits[6] = qtdEachChar['x'];
        digits[8] = qtdEachChar['g'];
        digits[7] = qtdEachChar['s'] - digits[6];
        digits[3] = qtdEachChar['h'] - digits[8];
        digits[5] = qtdEachChar['v'] - digits[7];
        digits[9] = qtdEachChar['i'] - digits[5] - digits[6];
        digits[1] = qtdEachChar['o'] - digits[0] - digits[2] - digits[4];

        for (int i = 0; i < digits.length; i++)
            for (int j = 0; j < digits[i]; j++)
                result.append(i);

        return result.toString();
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

    public static String originalDigits2(String s) {
        // building hashmap letter -> its frequency
        char[] count = new char[26 + (int) 'a'];
        for (char letter : s.toCharArray()) {
            count[letter]++;
        }

        // building hashmap digit -> its frequency
        int[] out = new int[10];
        // letter "z" is present only in "zero"
        out[0] = count['z'];
        // letter "w" is present only in "two"
        out[2] = count['w'];
        // letter "u" is present only in "four"
        out[4] = count['u'];
        // letter "x" is present only in "six"
        out[6] = count['x'];
        // letter "g" is present only in "eight"
        out[8] = count['g'];
        // letter "h" is present only in "three" and "eight"
        out[3] = count['h'] - out[8];
        // letter "f" is present only in "five" and "four"
        out[5] = count['f'] - out[4];
        // letter "s" is present only in "seven" and "six"
        out[7] = count['s'] - out[6];
        // letter "i" is present in "nine", "five", "six", and "eight"
        out[9] = count['i'] - out[5] - out[6] - out[8];
        // letter "n" is present in "one", "nine", and "seven"
        out[1] = count['n'] - out[7] - 2 * out[9];

        // building output string
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < out[i]; j++)
                output.append(i);
        return output.toString();
    }

}
