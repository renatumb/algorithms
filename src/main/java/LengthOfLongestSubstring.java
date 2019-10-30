import java.util.Set;
import java.util.TreeSet;

public class LengthOfLongestSubstring {

    public static void main(String... args) {


        System.out.println(lengthOfLongestSubstring("jkllivrooa"));
        System.out.println(lengthOfLongestSubstring("livroovo"));
        System.out.println(lengthOfLongestSubstring("ovolivro"));

        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));

        System.out.println(lengthOfLongestSubstring("dvdf"));
    }


    public static int lengthOfLongestSubstring(String s) {
        int size = 0;

        Set<Character> letters = new TreeSet<Character>();

        int b = 0, end = 0;

        letters.add(s.charAt(b));
        size = letters.size();

        for (end = 1; end < s.length(); end++) {
            if (letters.contains(s.charAt(end))) {
                letters = new TreeSet<>();
                b++;
                end = b;

            }
            letters.add(s.charAt(end));
            size = letters.size() > size ? letters.size() : size;
        }
        return size;
    }
}
