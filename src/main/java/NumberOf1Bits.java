//https://leetcode.com/problems/number-of-1-bits/

public class NumberOf1Bits {

    public static void main(String[] args) {

        System.out.println(hammingWeight(7));
    }

    public static int hammingWeight(int n) {

        int mask = 1;
        int result = 0;

        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) result++;
            mask <<= 1;
        }
        return result;
    }

    public int[] countBits(int num) {

        return new int[]{};

    }

}
