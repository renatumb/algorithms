import java.util.ArrayList;
import java.util.Arrays;

//https://leetcode.com/problems/perfect-squares/
public class PerfectSquares {

    public static void main(String[] args) {
        System.out.println(numSquares(12));
        System.out.println(numSquares(13));
        System.out.println(numSquares(23));

    }

    public static int numSquares(int n) {

        int[] result = new int[n + 1];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[0] = 0;

        ArrayList<Integer> squares = new ArrayList();

        for (int i = 1; i * i <= n; i++)
            squares.add(i * i);


        for (int i = 0; i < result.length; i++)
            for (int square : squares) {
                if (square > i) break;

                int a = result[i];
                int b = result[i - square] + 1;
                result[i] = Math.min(a, b);
            }
        return result[n];
    }
}
