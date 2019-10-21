// https://leetcode.com/problems/minimum-falling-path-sum/
public class MinimumFallingPathSum {


    public static void main(String... args) {

/*
        int [][] a = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
*/
        int[][] a = {
                {3, 9, 2, 1},
                {4, 2, 7, 6},
                {3, 8, 2, 5},
                {9, 6, 3, 7}
        };
        System.out.println(minFallingPathSum(a));
        System.out.println(minFallingPathSum2(a));

    }

    public static int minFallingPathSum(int[][] a) {

        Integer min = null;
        Integer[][] results = new Integer[a.length][a[0].length];

        for (int i = 0; i < a[0].length; i++) {
            int tmp = calculate(0, i, a, results);
            min = (min == null || tmp < min) ? tmp : min;
        }
        return min;
    }

    private static int calculate(int row, int col, int[][] source, Integer[][] results) {

        if (col < 0 || col >= source[0].length) return Integer.MAX_VALUE;

        if (results[row][col] != null) return results[row][col];

        if (row + 1 >= source.length) {
            results[row][col] = source[row][col];
            return source[row][col];
        }
        Integer left = calculate(row + 1, col - 1, source, results);
        Integer middle = calculate(row + 1, col + 0, source, results);
        Integer right = calculate(row + 1, col + 1, source, results);

        if (left < right && left < middle) results[row][col] = source[row][col] + left;
        else if (right < left && right < middle) results[row][col] = source[row][col] + right;
        else results[row][col] = source[row][col] + middle;

        return results[row][col];
    }

    public static int minFallingPathSum2(int[][] a) {

        int min = Integer.MAX_VALUE;

        if (a.length == 1) return a[0][0];

        for (int l = a.length - 2; l >= 0; l--) {
            for (int c = 0; c < a.length; c++) {

                if (c == 0) a[l][c] += Math.min(a[l + 1][c], a[l + 1][c + 1]);
                else if (c == a.length - 1) a[l][c] += Math.min(a[l + 1][c], a[l + 1][c - 1]);
                else a[l][c] += Math.min(a[l + 1][c], Math.min(a[l + 1][c + 1], a[l + 1][c - 1]));

                if (l == 0) min = min < a[l][c] ? min : a[l][c];
            }
        }
        return min;
    }
}
