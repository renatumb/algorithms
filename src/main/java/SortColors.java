//https://leetcode.com/problems/sort-colors/

import java.util.Arrays;

public class SortColors {

    public static void main(String... args) {
        sortColors(new int[]{1, 1, 0, 1, 2, 1, 0});
        sortColors(new int[]{2, 0, 2, 1, 1, 0});
        sortColors(new int[]{2, 1, 2, 1, 2, 1, 0, 1, 2, 0});
        sortColors(new int[]{1, 2, 1, 2, 0, 1, 2, 0, 2, 1, 0, 2, 1, 1, 0, 2,});
    }

    public static void sortColors(int[] nums) {
        System.out.println("-------- \n " + Arrays.toString(nums));

        int cur = 0;
        int p0 = 0;
        int p2 = nums.length - 1;

        while (cur <= p2) {

            int tmp = nums[cur];

            if (nums[cur] == 0) {
                nums[cur] = nums[p0];
                nums[p0] = tmp;
                p0++;
                cur++;
            } else if (nums[cur] == 2) {
                nums[cur] = nums[p2];
                nums[p2] = tmp;

                p2--;
            } else {
                cur++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
