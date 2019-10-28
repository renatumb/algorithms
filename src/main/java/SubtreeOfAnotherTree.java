//https://leetcode.com/problems/subtree-of-another-tree/

import java.util.LinkedList;
import java.util.Queue;

public class SubtreeOfAnotherTree {

    public static void main(String... args) {

    }

    public static boolean isSubtree(TreeNode s, TreeNode t) {

        Queue<TreeNode> qs = new LinkedList<>();
        qs.add(s);

        while (!qs.isEmpty()) {

            TreeNode current = qs.poll();

            if (current.val == t.val) {
                Queue<TreeNode> qs2 = new LinkedList<>();
                Queue<TreeNode> qt = new LinkedList<>();
                boolean answer = true;

                qs2.add(current);
                qt.add(t);

                while (!qs2.isEmpty() || !qt.isEmpty()) {
                    TreeNode tmp_t = qt.poll();
                    TreeNode tmp_s = qs2.poll();

                    if (tmp_t.val != tmp_s.val) {
                        answer = false;
                        break;
                    }

                    if (tmp_s.left != null) qs2.add(tmp_s.left);
                    if (tmp_s.right != null) qs2.add(tmp_s.right);

                    if (tmp_t.left != null) qt.add(tmp_t.left);
                    if (tmp_t.right != null) qt.add(tmp_t.right);

                    if (qs2.size() != qt.size()) {
                        answer = false;
                        break;
                    }
                }
                if (answer) return true;
            }
            if (current.left != null) qs.add(current.left);
            if (current.right != null) qs.add(current.right);
        }
        return false;
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
