//https://leetcode.com/problems/minimum-size-subarray-sum/

public class SubarraySum {

    public static void main(String[] args) {


        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }


    public static int minSubArrayLen(int s, int[] nums) {

        int result = 0;

        for (int i = 0; i < nums.length; i++) {

            int sum = 0;
            int min = 0;

            for (int j = i; j < nums.length; j++) {

                sum += nums[j];
                min++;

                if (sum >= s) {
                    if (result == 0)
                        result = min;
                    else
                        result = min < result ? min : result;
                    break;
                }
            }
        }
        return result;

    }

}
