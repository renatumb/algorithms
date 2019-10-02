import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {


        rotate2(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
        rotate2(new int[]{1, 2}, 3);
    }


    public static void rotate(int[] nums, int k) {

        if (k % nums.length == 0) return;

        k = k % nums.length;

        int[] other = Arrays.copyOf(nums, nums.length);
        int insert = k;

        for (int i = 0; i < other.length; i++) {
            nums[insert] = other[i];
            insert++;
            insert = insert == nums.length ? 0 : insert;
        }
        System.out.println(Arrays.toString(nums));
    }


    public static void rotate2(int[] nums, int k) {

        k = k % nums.length;
        reverseArray(nums, 0, nums.length - 1);
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private static void reverseArray(int[] nums, int ini, int end) {
        while (ini < end) {

            int t = nums[ini];
            nums[ini] = nums[end];
            nums[end] = t;

            ini++;
            end--;
        }
    }
}



