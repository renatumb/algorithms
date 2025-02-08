import java.util.LinkedList;
import java.util.Random;
import java.util.TreeMap;

//https://leetcode.com/problems/random-pick-index/
public class RandomPickIndex {

    public static void main(String[] args) {
        Solution2 obj = new Solution2(new int[]{1, 2, 3, 3, 3});
        System.out.println(obj.pick(3));
    }
}


class Solution2 {

    TreeMap<Integer, LinkedList> numbers;

    public Solution2(int[] nums) {

        this.numbers = new TreeMap<>();

        for (int i = 0; i < nums.length; i++) {
            LinkedList<Integer> indexes = numbers.getOrDefault(nums[i], new LinkedList());
            indexes.add(i);
            numbers.put(nums[i], indexes);
        }

    }

    public int pick(int target) {
        LinkedList<Integer> indexes = numbers.get(target);
        return indexes.get(new Random().nextInt(indexes.size()));
    }
}