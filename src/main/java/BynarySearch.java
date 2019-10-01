import java.util.Arrays;

public class BynarySearch {

    //https://www.educative.io/courses/visual-introduction-to-algorithms/m791p

    public static void main(String[] args) {


        int[] x = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};

        System.out.println(doSearch(x, 74));

        System.out.println(doSearch(x, 74, 0, x.length / 2, x.length - 1));
    }

    // Returns either the index of the location in the array,
    // or -1 if the array did not contain the targetValue
    public static int doSearch(int[] array, int targetValue) {
        System.out.println(Arrays.toString(array));
        int min = 0;
        int max = array.length - 1;
        int middle = (min + max) / 2;


        while (min < max) {
            if (array[min] == targetValue) return min;
            else if (array[max] == targetValue) return max;

            if (targetValue > array[middle])
                min = middle + 1;
            else
                max = middle;

            middle = (min + max) / 2;
        }
        return -1;
    }

    public static int doSearch(int[] array, int targetValue, int min, int middle, int max) {

        if (min >= max) return -1;
        else if (array[min] == targetValue) return min;
        else if (array[max] == targetValue) return max;

        if (targetValue > array[middle])
            return doSearch(array, targetValue, middle + 1, (middle + 1 + max) / 2, max);
        else
            return doSearch(array, targetValue, min, (middle + min) / 2, middle);


    }

}

