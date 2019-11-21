import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/permutations/
public class Permutations {

    public static void main(String[] arg) {
        System.out.println(permute(new int[]{1}));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> tmpList = new LinkedList();
        tmpList.add(nums[0]);

        result.add(tmpList);

        for (int i = 1; i < nums.length; i++) {
            List<List<Integer>> aux = new LinkedList<>();
            for (List<Integer> tmpListRet : result) {
                for (int j = 0; j <= tmpListRet.size(); j++) {
                    LinkedList<Integer> t = new LinkedList<>(tmpListRet);
                    t.add(j, nums[i]);
                    aux.add(t);
                }
            }
            result = aux;
        }
        return result;
    }
}
