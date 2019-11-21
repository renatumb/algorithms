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

            // For every list created so far, it adds a item at every position, example
            // current Lists {1,2} {2,1}, element to be inserted 3, the following list will be
            // {1,2} ->> {3,1,2} {1,3,2} {1,2,3}
            // {2,1} ->> {3,2,1} {2,3,1} {2,1,3}
            //
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
