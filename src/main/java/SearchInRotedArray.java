//https://leetcode.com/articles/search-in-rotated-sorted-array/

public class SearchInRotedArray {


    public static void main(String[] args) {
        //System.out.println( search( new int []{4,5,6,7,0,1,2,3} , 0) );
        //System.out.println( search( new int []{4,5,6,7,0,1,2} , 3) );
        //System.out.println( search( new int []{1} , 1) );
        //System.out.println( search( new int []{1} , 0) );
        //System.out.println( search( new int []{3,1} , 3) );
        //System.out.println( search( new int []{4,5,6,7,0,1,2} , 0) );

        testXOR();
    }

    private static void testXOR() {


        char x = 'a';

        x ^= 'e';
        x ^= 't';
        x ^= 'a';
        x ^= 't';


    }

    public static int search(int[] nums, int target) {
        int ini = 0;
        int end = nums.length - 1;
        int middle = (ini + end) / 2;

        while (ini != middle) {
            if (nums[middle] > nums[ini])
                ini = middle;
            else
                end = middle;
            middle = (ini + end) / 2;
        }
        int rotedIndex = end;

        if (target >= nums[rotedIndex]) {
            ini = rotedIndex;
            end = nums.length - 1;
        } else {
            ini = 0;
            end = rotedIndex;
        }
        if (target == nums[middle]) return middle;

        middle = (ini + end) / 2;
        while (ini <= end) {
            if (target == nums[middle]) {
                return middle;
            } else if (target > nums[middle]) {
                ini = middle + 1;
            } else {
                end = middle - 1;
            }
            middle = (ini + end) / 2;
        }
        return -1;
    }
}
