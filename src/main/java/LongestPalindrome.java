//https://leetcode.com/problems/longest-palindromic-substring/

public class LongestPalindrome {

    public static void main(String... args) {

        System.out.println(longestPalindrome("babad"));


    }

    public static String longestPalindrome(String s) {

        String result = "";


        for (int i = 0; i < s.length() - 1; i++) {

            String p1 = generatePalindrome(s, i, i);
            String p2 = generatePalindrome(s, i, i + 1);

            result = result.length() > p1.length() ? result : p1;
            result = result.length() > p2.length() ? result : p2;

        }
        return result;
    }

    private static String generatePalindrome(String s, int ini, int end) {

        for (; ; ) {
            if (ini < 0 || end >= s.length()) break;
            if (s.charAt(ini) != s.charAt(end)) break;
            ini--;
            end++;
        }
        ini++;
        end--;
        return s.substring(ini, end + 1);
    }
}
