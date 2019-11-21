//https://leetcode.com/problems/container-with-most-water/


public class ContainerWithMostWater {

    public static void main(String[] args) {


        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(maxArea(new int[]{3, 9, 3, 4, 7, 2, 12, 6}));

        System.out.println(maxArea2(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(maxArea2(new int[]{3, 9, 3, 4, 7, 2, 12, 6}));
    }

    public static int maxArea(int[] height) {

        int result = 0;

        for (int i = 0; i < height.length; i++) {
            for (int j = 0; j < height.length; j++) {
                int min = height[j] <= height[i] ? j : i;
                int tmp = (j - i) * height[min];
                result = result > tmp ? result : tmp;
            }
        }
        return result;
    }

    public static int maxArea2(int[] height) {
        int result = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            result = Math.max(result, (r - l) * Math.min(height[l], height[r]));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return result;
    }
}
