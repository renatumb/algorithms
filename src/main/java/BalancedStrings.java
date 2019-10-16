import java.util.Stack;

//https://leetcode.com/problems/split-a-string-in-balanced-strings/
public class BalancedStrings {


    public static void main(String... args) {


        System.out.println(balancedStringSplit("RLRRLLRLRL"));
        System.out.println(balancedStringSplit("RLLLLRRRLR"));
        System.out.println(balancedStringSplit("LLLLRRRR"));
        System.out.println(balancedStringSplit("RRL"));

    }

    public static int balancedStringSplit(String s) {
        Stack<Character> stack = new Stack();
        int res = 0;
        //going over string chars
        for (char ch : s.toCharArray()) {
            //check if char doesn't balance the previous one, or the stack is empty
            if (stack.isEmpty() || stack.peek() == ch)
                stack.push(ch);
                //if chars are balanced - remove the pair
            else
                stack.pop();
            //if stack is empty - all pairs are balanced and we have a balanced substring
            if (stack.isEmpty())
                res++;
        }
        return res;
    }
}
