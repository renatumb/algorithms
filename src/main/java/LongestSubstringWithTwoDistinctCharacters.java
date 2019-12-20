//https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/

public class LongestSubstringWithTwoDistinctCharacters {


    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstringTwoDistinct("eceba"));
        System.out.println(lengthOfLongestSubstringTwoDistinct("ccaabbb"));
        System.out.println(lengthOfLongestSubstringTwoDistinct("abaccc"));
    }

    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int result = 0;

        Integer p1 = 0;
        Integer p2 = null;

        for (int i = 0; i < s.length(); i++) {
            if (p2 == null && s.charAt(p1) != s.charAt(i))
                p2 = i;

            if (s.charAt(i) != s.charAt(p1) && s.charAt(i) != s.charAt(p2)) {
                result = Math.max(result, i - p1);
                p1 = i = p2;
                p2 = null;
            }
        }
        result = Math.max(result, s.length() - p1);
        return result;
    }
}
