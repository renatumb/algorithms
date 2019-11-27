// https://leetcode.com/problems/repeated-substring-pattern/

import java.util.TreeSet;

public class RepeatedSubstringPattern {

    public static void main(String[] args) {

        System.out.println(repeatedSubstringPattern("abab"));
        System.out.println(repeatedSubstringPattern("aba"));
        System.out.println(repeatedSubstringPattern("abcabcabcabc"));

        System.out.println(repeatedSubstringPattern("abaababaab"));


    }

    public static boolean repeatedSubstringPattern(String s) {

        for (int i = 1; i < s.length(); i++) {

            String seed = s.substring(0, i);
            TreeSet group = new TreeSet();
            group.add(seed);

            int j;
            for (j = i; j < s.length(); j += seed.length()) {
                int end = j + seed.length();
                if (end > s.length())
                    break;

                String tmp = s.substring(j, end);

                group.add(tmp);
                if (group.size() > 1)
                    break;
            }
            if (group.size() == 1 && s.length() % seed.length() == 0)
                return true;
        }
        return false;
    }
}
