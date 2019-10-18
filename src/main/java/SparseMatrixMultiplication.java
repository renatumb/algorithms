//https://leetcode.com/problems/sparse-matrix-multiplication/

public class SparseMatrixMultiplication {

    public static void main(String... args) {


/*        multiply(
                new int[][]{
                        {1,0,0},
                        {-1,0,3}
                },
                new int[][]{
                        {7,0,0},
                        {0,0,0},
                        {0,0,1}
                }
        );*/
/*
                multiply(
                new int[][]{
                        {1,2,3},
                        {4,5,6}
                },
                new int[][]{
                        {7,8,9},
                        {10,11,12},
                        {13,14,15}
                }
        );*/

        /*multiply(
                new int[][]{
                        {4,8},
                        {0,2},
                        {1,6},
                },
                new int[][]{
                        {5,2},
                        {9,4}
                }
        );*/

        multiply(
                new int[][]{
                        {1, -5}
                },
                new int[][]{
                        {12},
                        {-1}
                });

    }

    public static int[][] multiply(int[][] a, int[][] b) {
        int[][] result = null;

        if (a[0].length != b.length)
            return result;

        result = new int[a.length][b[0].length];

        for (int la = 0; la < a.length; la++) {
            for (int ca = 0; ca < a[0].length; ca++) {

                if (a[la][ca] == 0) continue;

                for (int cb = 0; cb < b[0].length; cb++) {
                    int tmp = a[la][ca] * b[ca][cb];
                    result[la][cb] += tmp;
                }
            }
        }
        return result;
    }

}
