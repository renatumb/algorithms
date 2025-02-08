//https://leetcode.com/problems/find-all-duplicates-in-an-array/

import java.util.ArrayList;
import java.util.List;

public class DuplicateInArray {


    public static void main(String[] args) {

        //System.out.println( findDuplicates( new int []{4,3,2,7,8,2,3,1} ));


        char x;

        x = 'd';
        x ^= 'e';
        x ^= 'a';
        x ^= 'b';
        x ^= 'e';
        x ^= 'd';
        x ^= 'b';


        System.out.println(x);
    }

    public static List<Integer> findDuplicates(int[] nums) {

        List result = new ArrayList();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0)
                result.add(index + 1);
            else
                nums[index] *= -1;
        }
        return result;
    }
}
