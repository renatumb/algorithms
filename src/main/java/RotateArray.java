import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {


        //rotate( new  int [] {1,2,3,4,5,6,7},7 ) ;
        rotate(new int[]{1, 2}, 3);
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
}



