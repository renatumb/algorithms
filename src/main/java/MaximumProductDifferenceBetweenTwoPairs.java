import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-product-difference-between-two-pairs/
 */
public class MaximumProductDifferenceBetweenTwoPairs {

    public static void main(String[] args) {

        System.out.println(new MaximumProductDifferenceBetweenTwoPairs().maxProductDifference(new int[]{5, 6, 2, 7, 4}));
        System.out.println(new MaximumProductDifferenceBetweenTwoPairs().maxProductDifference(new int[]{4, 2, 5, 9, 7, 4, 8}));
    }

    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length - 1] * nums[nums.length - 2]) - (nums[0] * nums[1]);
    }

}
