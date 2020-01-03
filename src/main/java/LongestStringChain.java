//https://leetcode.com/problems/longest-string-chain/

import java.util.Arrays;
import java.util.TreeMap;

public class LongestStringChain {


    public static void main(String[] args) {

        longestStrChain(new String[]{"a", "e", "ab", "ae", "abc", "aef", "abcd", "abcde", "abcdef"});
        longestStrChain(new String[]{"a", "b", "ba", "bca", "bda", "bdca"});
    }

    public static int longestStrChain(String[] words) {
        int longest = 0;

        Arrays.sort(words, 0, words.length, (x, y) -> {
            return x.length() - y.length();
        });

        TreeMap<String, Integer> wordLenght = new TreeMap();

        for (String word : words) {

            StringBuffer sbword = new StringBuffer(word);

            int length = 0;

            for (int i = 0; i < sbword.length(); i++) {
                StringBuffer nword = sbword.deleteCharAt(i);
                length = Math.max(wordLenght.getOrDefault(nword.toString(), 0) + 1, length);
                sbword = new StringBuffer(word);
            }
            wordLenght.put(word, length);
            longest = Math.max(longest, length);
        }
        return longest;
    }

}
