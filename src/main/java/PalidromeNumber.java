import java.util.ArrayList;

// https://leetcode.com/problems/palindrome-number/
public class PalidromeNumber {


    public static void main(String[] args) {

        System.out.println(isPalindrome(3456));
        System.out.println(isPalindrome(121));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 9) return true;

        int aux = x;
        int other = 0;

        ArrayList<Integer> digits = new ArrayList<>();

        while (aux > 0) {
            digits.add(aux % 10);
            aux /= 10;
        }

        for (int i = 0; i < digits.size() - 1; i++)
            other += (int) Math.pow(10, (digits.size() - 1 - i)) * digits.get(i);

        other += digits.get(digits.size() - 1);
        return other == x;
    }
}
