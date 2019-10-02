//https://leetcode.com/problems/remove-vowels-from-a-string/
public class RemoveVowels {


    public static void main(String[] args) {

        System.out.println(removeVowels("this is just a test with lots of vowels"));
    }

    public static String removeVowels(String s) {

        return String.join("", s.split("[aeiou]"));
    }

}
