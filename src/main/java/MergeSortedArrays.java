import java.util.Arrays;

//https://www.interviewcake.com/question/java/merge-sorted-arrays?course=fc1&section=array-and-string-manipulation
public class MergeSortedArrays {


    public static void main(String... a) {

        System.out.println(Arrays.toString(
                mergeArrays(
                        new int[]{3, 4, 6, 10, 11, 15},
                        new int[]{1, 5, 8, 12, 14, 19}
                )
        ));

    }

    public static int[] mergeArrays(int[] a, int[] b) {

        int[] result;

        int ai = 0, bi = 0, ri = -1;

        result = new int[a.length + b.length];

        if (result.length == 0) return result;

        while (ai < a.length || bi < b.length) {
            ri++;
            if (ai >= a.length) {
                result[ri] = b[bi];
                bi++;
                continue;
            }
            if (bi >= b.length) {
                result[ri] = a[ai];
                ai++;
                continue;
            }

            if (a[ai] < b[bi]) {
                result[ri] = a[ai];
                ai++;
            } else {
                result[ri] = b[bi];
                bi++;
            }
        }
        return result;
    }
}
