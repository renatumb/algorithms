// https://leetcode.com/problems/reverse-vowels-of-a-string/
public class ReverseVowels {

    public static void main(String[] args) {
        System.out.println(reverseVowels2("leetcode"));
    }

    public static String reverseVowels(String s) {

        if (s == null) return null;

        String aux = String.join("", s.split("[^aeiouAEIOU]"));

        StringBuilder result = new StringBuilder(s.replaceAll("[aeiouAEIOU]", "_"));

        for (int i = aux.length() - 1; i >= 0; i--)
            result = new StringBuilder(result.toString().replaceFirst("_", aux.charAt(i) + ""));

        return result.toString();

    }

    public static String reverseVowels2(String s) {
        // The main ideia is to use 2 pointers( one from ini other from end ) than switch vowels when both poiters find a vowel
        if (s == null) return "";
        if (s.length() <= 1) return s;

        int ini = 0;
        int end = s.length() - 1;
        char[] content = s.toCharArray();
        String vowels = "aeiouAEIOU";

        while (ini <= end) {

            if (vowels.indexOf(content[ini]) > -1 && vowels.indexOf(content[end]) > -1) {
                char temp = content[ini];
                content[ini] = content[end];
                content[end] = temp;

                ini++;
                end--;
            } else if (vowels.indexOf(content[ini]) > -1) end--;
            else if (vowels.indexOf(content[end]) > -1) ini++;
            else {
                ini++;
                end--;
            }
        }
        return new StringBuilder().append(content).toString();
    }

}
